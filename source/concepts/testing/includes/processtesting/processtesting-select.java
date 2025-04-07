/* Selecting processes */
BpmProcess.name("invoice");
BpmProcess.name().startsWith("invo");

/* Selecting process elements */
INVOICE_PROCESS.elementName("write invoice");
INVOICE_PROCESS.element().name().contains("write");
