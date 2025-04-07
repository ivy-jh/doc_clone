/* Mocking an element that doesn't require nor return anything */
bpmClient.mock()
        .element(INVOICE_PROCESS.elementName("check order"))
        .withNoAction();

/* Mocking without prior setup */
bpmClient.mock()
        .element(INVOICE_PROCESS.elementName("check order"))
        .with(Order.class, (in, out) -> out.setValid(Boolean.TRUE));

/* Mocking by defining the data beforehand */
Order myOrderData = new Order();
myOrderData.setValid(Boolean.TRUE);

bpmClient.mock()
        .element(INVOICE_PROCESS.elementName("check order"))
        .with(in -> myOrderData);

/* Mocking only the UI part of the element */
bpmClient.mock()
        .uiOf(INVOICE_PROCESS.elementName("check order"))
        .with((params, results) -> results.set("total", 935));
