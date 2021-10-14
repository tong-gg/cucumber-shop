package ku.shop;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BuyStepdefs {

    private ProductCatalog catalog;
    private Order order;
    private OrderItem orderItem;

    @Before
    public void setup() {
        catalog = new ProductCatalog();
        order = new Order();
    }

    @Given("สินค้า {string} with price {float} exists")
    public void a_product_with_price_exists(String name, double price) {
        catalog.addProduct(name, price);
    }

    @When("ฉันซื้อ {string} with quantity {int}")
    public void i_buy_with_quantity(String name, int quantity) {
        Product prod = catalog.getProduct(name);
        order.addItem(prod, quantity);
    }

    @Then("total should be {float}")
    public void total_should_be(double total) {
        assertEquals(total, order.getTotal());
    }

    // optional, checking stocks
    @Given("product {string} with price {float}, and quantity {int}")
    public void a_product_with_quantity(String name, double price, int quantity) {
        catalog.addProduct(name, price, quantity);
    }

    // exceed quantity
    @When("a customer buy {string} with {int} quantity")
    public void customer_buy_with_quantity(String name, int quantity) {
        Product prod = catalog.getProduct(name);
        assertThrows(NotEnoughQuantityException.class,
                () -> order.addItem(prod, quantity));
    }

    @Then("{string} should have {int} left")
    public void product_must_have_more_than_or_equal_to(String name, int quantity) {
        assertEquals(quantity, catalog.getProduct(name).getQuantity());
    }

}

