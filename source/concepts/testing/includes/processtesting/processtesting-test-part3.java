  @Test
  void writeInvoice(BpmClient bpmClient) {
    ExecutionResult result = bpmClient
            .start()
            .process(WRITE_INVOICE_START)
            .execute();

    History history = result.history();
    assertThat(history.elementNames()).containsExactly("writeInvoice.ivp", "write invoice");

    Workflow workflow = result.workflow();
    assertThat(workflow.executedTask().getName()).isEqualTo("start write invoice");

    bpmClient
            .mock()
            .uiOf(WRITE_INVOICE)
            .with((params, results) -> results.set("total", 935));

    result = bpmClient
            .start()
            .anyActiveTask(result)
            .as().everybody()
            .execute();

    history = result.history();
    assertThat(history.elementNames()).containsExactly("write invoice", "end");

    Order orderData = result.data().last();
    assertThat(orderData.getTotal()).isEqualTo(935);
  }
