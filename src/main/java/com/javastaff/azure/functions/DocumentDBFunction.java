package com.javastaff.azure.functions;

import java.util.Calendar;
import java.util.UUID;

import com.microsoft.azure.documentdb.Document;
import com.microsoft.azure.serverless.functions.ExecutionContext;
import com.microsoft.azure.serverless.functions.annotation.*;

public class DocumentDBFunction {
    @FunctionName("documentDBFunction")
    @DocumentDBOutput(name = "documentDb", 
                      databaseName = "functionDb", 
                      collectionName="functionMessage", 
                      connection = "CosmosDBConnectionString")
    public Document functionHandler(
    		@TimerTrigger(name = "timerInfo", schedule = "*/30 * * * * *") String timerInfo, 
    		final ExecutionContext executionContext) {
    	String randomString=UUID.randomUUID().toString();
        executionContext.getLogger().info("Funzione attivata dal trigger: " + timerInfo);
        executionContext.getLogger().info("Inserisco oggetto in documentDB: " + randomString);
        Document document=new Document();
        document.set("uuid", randomString);
        document.set("timestamp", Calendar.getInstance().getTime());
        return document;
    }
}
