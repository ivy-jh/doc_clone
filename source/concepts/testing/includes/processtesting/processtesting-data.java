/* Process data at last executed element */
assertThat(((Order)result.data().last()).getValid()).isFalse();

/* Process data at elements last execution */
assertThat(((Order)result.data().lastOnElement(writeInvoiceElement)).getValid()).isFalse();

/* Process data for each execution of the element */
assertThat(((Order)result.data().onElement(writeInvoiceElement).get(0)).getValid()).isFalse();
