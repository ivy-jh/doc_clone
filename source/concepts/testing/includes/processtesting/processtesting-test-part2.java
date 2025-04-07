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

  result = bpmClient
          .start()
          .anyActiveTask(result)
          .as().everybody()
          .execute();

  history = result.history();
  assertThat(history.elementNames())
          .containsExactly("write invoice", "end");
}
