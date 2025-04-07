@Test
void user(WebAppFixture fixture) {
  /* The WebAppFixture can login to another user. */
  fixture.login("test", "test");
  open(EngineUrl.createProcessUrl("a-process-url/start.ivp"));

  /* Or it can logout the user to an anonymous session. */
  fixture.logout();
  open(EngineUrl.createProcessUrl("a-process-url/start.ivp"));
}
