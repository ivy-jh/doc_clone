@Test
void products_variable(AppFixture fixture) {
  /* The AppFixture can manipulate variables. */
  fixture.var("table", "799.95");

  assertThat(OrderUtil.getProducts()).hasSize(2);
  Product table = OrderUtil.getProducts().get(0);

  /* Normally the price of a table would be 375.50 */
  assertThat(table.getSinglePrice()).isEqualTo(799.95);
}
