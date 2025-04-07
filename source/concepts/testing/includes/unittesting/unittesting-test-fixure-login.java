@Test
void products_userLogin(AppFixture fixture, @Named("M") IUser user) {
  /* Login with a username */
  fixture.loginUser("James Bond");
  var products = OrderUtil.getProductsWithClearance();

  /* James Bond can only order chairs */
  assertThat(products).hasSize(1);
  assertThat(products.get(0).getName()).isEqualTo("Chair");

  /* Login with an IUser object that we injected as a parameter */
  fixture.loginUser(user);
  products = OrderUtil.getProductsWithClearance();

  /* M can order tables and chairs */
  assertThat(products).hasSize(2);
  assertThat(products.get(0).getName()).isEqualTo("Table");
  assertThat(products.get(1).getName()).isEqualTo("Chair");
}
