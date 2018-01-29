package com.javastaff.azure.functions;

import java.util.UUID;

import com.microsoft.azure.serverless.functions.ExecutionContext;
import com.microsoft.azure.serverless.functions.annotation.*;

public class TimerFunction {
    @FunctionName("timerFunction")
    @QueueOutput(name = "queueItem", queueName = "codaMessaggiInArrivo", connection = "AzureWebJobsStorage")
    public String functionHandler(
    		@TimerTrigger(name = "timerInfo", schedule = "*/30 * * * * *") String timerInfo, 
    		final ExecutionContext executionContext) {
    	String randomString=UUID.randomUUID().toString();
        executionContext.getLogger().info("Funzione attivata dal trigger: " + timerInfo);
        executionContext.getLogger().info("Inserisco messaggio random nella coda: " + randomString);
        return randomString;
    }
}
