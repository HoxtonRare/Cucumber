package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class AddToCartSteps {
    private static final String XPATH_FOR_ADD_TO_CART = "//div[@class = 'product-page__order-buttons']";
    private static final String XPATH_FOR_GO_TO_CART = "//span[@class = 'navbar-pc__icon navbar-pc__icon--basket']";
    private static final String XPATH_FOR_CHECK_PRODUCT_NAME = "//div[@class = 'accordion__list-item list-item j-b-basket-item']//span[@class = 'good-info__good-name']";

    @Given("Пользователь открыл карточку товара {string}")
    public void openProductCard(String url) {
        open(url);
    }

    @When("Пользователь добавляет товар в корзину")
    public void addToCart() {
        $(By.xpath(XPATH_FOR_ADD_TO_CART)).shouldBe(clickable).click();
    }

    @Then("В корзине пользователя находится добавленный товар {string}")
    public void checkForAdded(String product) {
        $(By.xpath(XPATH_FOR_GO_TO_CART)).shouldBe(clickable).click();
        $(By.xpath(XPATH_FOR_CHECK_PRODUCT_NAME)).shouldHave(text(product));
    }
}
