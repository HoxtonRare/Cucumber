package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SearchSteps {
    private static final String XPATH_FOR_FIRST_PRODUCT = "//div[@class='main-page__content']/descendant::article[1]/div/a";
    private static final String ID_FOR_SEARCH_INPUT = "searchInput";
    private static final String XPATH_FOR_FIRST_PRODUCT_OF_SEARCH = "//div[@class = 'catalog-page__content']//span[@class = 'product-card__name'][1]";

    @Given("Пользователь открыл сайт {string}")
    public void openMainPage(String url) {
        open(url);
        $(By.xpath(XPATH_FOR_FIRST_PRODUCT)).shouldBe(enabled);
    }

    @When("Пользователь вводит {string} в строку поиска")
    public void applySearch(String request) {
        $(By.id(ID_FOR_SEARCH_INPUT)).setValue(request).shouldBe(visible).pressEnter();
    }

    @Then("Пользователь видит товар {string} в результатах поиска")
    public void checkResultSearch(String expected) {
        $(By.xpath(XPATH_FOR_FIRST_PRODUCT_OF_SEARCH)).shouldHave(text(expected));
    }
}
