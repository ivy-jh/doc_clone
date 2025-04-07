@Test
void products() {
  /* OrderUtil should return two products */
  assertThat(OrderUtil.getProducts()).hasSize(2);
  Product table = OrderUtil.getProducts().get(0);
  Product chair = OrderUtil.getProducts().get(1);

  /* The first product is a table and costs 375.50 */
  assertThat(table.getName()).isEqualTo("Table");
  assertThat(table.getSinglePrice()).isEqualTo(375.5);

  /* The second product is a chair and costs 89.60 */
  assertThat(chair.getName()).isEqualTo("Chair");
  assertThat(chair.getSinglePrice()).isEqualTo(89.60);
}
