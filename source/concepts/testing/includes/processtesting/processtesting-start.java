ExecutionResult result = bpmClient.start()
        .process(WRITE_INVOICE_START)
        .execute();

/* Execute any active task after the previous result */
bpmClient.start()
        .anyActiveTask(result)
        .as().everybody()
        .execute();

/* Execute the desired task */
bpmClient.start()
        .task(result.workflow().anyActiveTask())
        .as().everybody()
        .execute();
