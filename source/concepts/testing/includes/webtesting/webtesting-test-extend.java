@Test
public void registerNewCustomer() {
  // valid links can be copied from the start page of the internal web-browser
  open(EngineUrl.createProcessUrl("myWorkflow/154616078A1D629D/start.ivp"));

  // fill new customer form
  $(By.id("form:firstname")).sendKeys("Unit");
  $(By.id("form:lastname")).sendKeys("Test");

  // verify that the submit button is enabled, before clicking it.
  $(By.id("form:submit")).shouldBe(enabled).click();

  // verify that the registration was successful.
  $(By.id("form:newCustomer")).shouldBe(visible, text("Unit Test"));
}
