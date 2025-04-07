@Test
void products_config(AppFixture fixture) {
  assertThat(Ivy.rest().client("jsonPlaceholder").getUri().toString()).isEqualTo("https://jsonplaceholder.typicode.com/");
  /* The AppFixture can manipulate app configurations. */
  fixture.config("RestClients.jsonPlaceholder.Url", "${ivy.app.baseurl}/api/testMock");
  assertThat(Ivy.rest().client("jsonPlaceholder").getUri().toString()).isEqualTo("http://localhost:8080/test/api/testMock");
}
