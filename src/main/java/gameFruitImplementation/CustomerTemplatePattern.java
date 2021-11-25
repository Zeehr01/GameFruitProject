package gameFruitImplementation;

public class CustomerTemplatePattern {
  public void customerTemplate() {
    Customer c = new Player();
    c.purchaser();
    c = new Seller();
    c.purchaser();
  }
}
