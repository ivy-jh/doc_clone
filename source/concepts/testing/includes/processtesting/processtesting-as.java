/* Execution with the role everybody */
ExecutionResult result = bpmClient.start()
        .process(WRITE_INVOICE_START)
        .as().everybody()
        .execute();

/* Execution with a specific user */
result = bpmClient.start()
        .process(WRITE_INVOICE_START)
        .as().user("James Bond")
        .execute();

/* Execution by selecting a specific role */
result = bpmClient.start()
        .process(WRITE_INVOICE_START)
        .as().role("Everybody")
        .execute();
