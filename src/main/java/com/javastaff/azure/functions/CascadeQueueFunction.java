package com.javastaff.azure.functions;

import com.microsoft.azure.serverless.functions.ExecutionContext;
import com.microsoft.azure.serverless.functions.annotation.*;

public class CascadeQueueFunction {
     @FunctionName("cascadeQueueFunction")
     @QueueOutput(name = "myQueueItemOut", 
                  queueName = "codaMessaggiInArrivo", 
                  connection = "AzureWebJobsStorage")
    public String functionHandler(
    		@QueueTrigger(name = "myQueueItem", 
    					  queueName = "codaMessaggiInTransito", 
    					  connection = "AzureWebJobsStorage") String myQueueItem, 
    		final ExecutionContext executionContext) {
        executionContext.getLogger().info("Queue trigger input: " + myQueueItem);
        return myQueueItem.toUpperCase();
    }
}