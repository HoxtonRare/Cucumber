package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class CategorySteps {
private static final String XPATH_FOR_FIRST_PRODUCT = "//div[@class='main-page__content']/descendant::article[1]/div/a";
private static final String XPATH_FOR_OPEN_CATALOG = "//button[@aria-label = 'Навигация по сайту']";
private static final String XPATH_FOR_OPEN_CATEGORY = "//span[text() = '";
private static final String XPATH_FOR_CHECK_CATEGORY = "//span[@class = 'menu-burger__title-name'][text() = 'Электроника']";
    @Given("Пользователь открыл главную страницу {string}")
    public void openMainPage(String url) {
        open(url);
        $(By.xpath(XPATH_FOR_FIRST_PRODUCT)).shouldBe(enabled);
    }

    @When("Пользователь переходит в категорию {string}")
    public void openCategory(String category) {
        $(By.xpath(XPATH_FOR_OPEN_CATALOG)).shouldBe(clickable).click();
        $(By.xpath( XPATH_FOR_OPEN_CATEGORY + category + "']")).shouldBe(visible).hover();
    }

    @Then("Пользователь видит список товаров этой категории")
    public void checkForCategory() {
        $(By.xpath(XPATH_FOR_CHECK_CATEGORY)).shouldBe(visible);
    }
}
