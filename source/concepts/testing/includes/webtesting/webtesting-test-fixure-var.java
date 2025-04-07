@Test
void variable(WebAppFixture fixture) {
  /* The WebAppFixture can change the value of a variable. */
  fixture.var("myVar", "hello");
  open(EngineUrl.createProcessUrl("a-process-url/start.ivp"));
  $(By.id("form:variable")).shouldBe(exactText("hello"));

  /* Or reset it to the default value. */
  fixture.resetVar("myVar");
  Selenide.refresh();
  $(By.id("form:variable")).shouldBe(exactText("init"));
}
