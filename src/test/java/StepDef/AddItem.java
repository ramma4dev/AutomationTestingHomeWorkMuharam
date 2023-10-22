package StepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

import static java.time.Duration.ofSeconds;
import static org.openqa.selenium.Keys.ENTER;

public class AddItem {
    WebDriver driver = new ChromeDriver();;
    String baseUrl = "https://www.saucedemo.com/";

    @Given("I open browser for cart scenario")
    public void i_open_browser_for_cart_scenario() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.get(baseUrl);

        String loginPageAssert = driver.findElement(By.className("login_logo")).getText();
        Assert.assertEquals(loginPageAssert, "Swag Labs");
    }

    @And("Open website saucedemo for cart scenario")
    public void open_website_saucedemo_for_cart_scenario() throws InterruptedException {
        driver.get(baseUrl);
        Thread.sleep(1000);
    }

    @And("Located on saucedemo website for cart scenario")
    public void located_on_saucedemo_website_for_cart_scenario() {
        driver.findElement(By.name("login-button")).isDisplayed();
    }

    @And("I input valid username for cart scenario")
    public void i_input_valid_username_for_cart_scenario() {
        driver.findElement(By.name("user-name")).sendKeys("problem_user");
    }

    @And("And I input valid password for cart scenario")
    public void and_i_input_valid_password_for_cart_scenario() {
        driver.findElement(By.name("password")).sendKeys("secret_sauce");
        driver.findElement(By.name("password")).sendKeys(ENTER);
    }

    @Given("I catalog product")
    public void i_catalog_product() {
        WebDriverWait wait = new WebDriverWait(driver, ofSeconds(10));

        String titlePageProduct = driver.findElement(By.className("title")).getText();
        Assert.assertEquals("Products", titlePageProduct );

        String expectedCatalogURL = "https://www.saucedemo.com/inventory.html";
        String currentCatalogURL = driver.getCurrentUrl();
        Assert.assertEquals(expectedCatalogURL, currentCatalogURL);
    }

    @Given("I add first product to cart")
    public void i_add_first_product_to_cart() {
        WebElement buttonFirst = driver.findElement(By.name("add-to-cart-sauce-labs-backpack"));
        buttonFirst.sendKeys(ENTER);
    }

    @Given("I add second product to cart")
    public void i_add_second_product_to_cart() {
        WebElement buttonSecond = driver.findElement(By.name("add-to-cart-sauce-labs-bike-light"));
        buttonSecond.sendKeys(ENTER);
    }

    @Then("I should see amount items on cart icon {string}")
    public void i_should_see_amount_items_on_cart_icon(String string) {
        String cartBadge = driver.findElement(By.className("shopping_cart_badge")).getText();
        Assert.assertEquals("2", cartBadge);
        driver.close();
        driver.quit();
    }

    @Given("I add first product again to cart")
    public void i_add_first_product_again_to_cart() {
        WebElement buttonFirst = driver.findElement(By.name("add-to-cart-sauce-labs-backpack"));
        buttonFirst.sendKeys(ENTER);
    }

    @Given("I add second product again to cart")
    public void i_add_second_product_again_to_cart() {
        WebElement buttonSecond = driver.findElement(By.name("add-to-cart-sauce-labs-bike-light"));
        buttonSecond.sendKeys(ENTER);
    }

    @Given("I add third product to cart")
    public void i_add_third_product_to_cart() {
        WebElement buttonThird = driver.findElement(By.name("add-to-cart-sauce-labs-onesie"));
        buttonThird.sendKeys(ENTER);
    }

    @Given("I add fourth product to cart")
    public void i_add_fourth_product_to_cart() {
        WebElement buttonFourth = driver.findElement(By.name("add-to-cart-test.allthethings()-t-shirt-(red)"));
        buttonFourth.sendKeys(ENTER);
    }

    @Then("I should see amount items on cart icon after i add 2 items {string}")
    public void i_should_see_amount_items_on_cart_icon_after_i_add_2_items(String string) {
        String cartBadges = driver.findElement(By.className("shopping_cart_badge")).getText();
        Assert.assertEquals("4", cartBadges);
    }

}
