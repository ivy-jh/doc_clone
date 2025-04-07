@Test
void config(WebAppFixture fixture) {
  /* The WebAppFixture can change the value of an app configuration. */
  fixture.config("RestClients.myClient.Url", "${ivy.app.baseurl}/api/myCoolMockService");
  open(EngineUrl.createProcessUrl("a-process-url/18AF06DD4E1A49B8/start.ivp"));
  $(By.id("rest:result")).shouldBe(exactText("hello from mock service"));

  /* Or reset it to the default value. */
  fixture.resetConfig("RestClients.myClient.Url");
  Selenide.refresh();
  $(By.id("rest:result")).shouldBe(exactText("hello from real service"));
}
