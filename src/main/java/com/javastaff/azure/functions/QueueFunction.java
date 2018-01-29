package com.javastaff.azure.functions;

import com.microsoft.azure.serverless.functions.ExecutionContext;
import com.microsoft.azure.serverless.functions.annotation.*;

public class QueueFunction {
    @FunctionName("queueFunction")
    public void functionHandler(
    		@QueueTrigger(name = "queueItem", 
    					  queueName = "codaMessaggiInArrivo", 
    					  connection = "AzureWebJobsStorage") String queueItem, 
    		final ExecutionContext executionContext) {
        executionContext.getLogger().info("Arrivato il seguente messaggio in coda: " + queueItem);
    }
}