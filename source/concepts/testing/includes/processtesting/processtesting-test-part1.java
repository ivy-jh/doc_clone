@IvyProcessTest
public class TestInvoiceProcess {
  private static final BpmProcess INVOICE_PROCESS = BpmProcess.name("invoice");
  private static final BpmElement WRITE_INVOICE = INVOICE_PROCESS.elementName("write invoice");
  private static final BpmElement WRITE_INVOICE_START = INVOICE_PROCESS.elementName("writeInvoice.ivp");

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
  }

}
