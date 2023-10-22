package StepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static java.time.Duration.ofSeconds;
import static org.openqa.selenium.Keys.ENTER;

public class CheckOut {
    WebDriver driver = new ChromeDriver();;
    String baseUrl = "https://www.saucedemo.com/";

    @Given("I open browser for checkout scenario")
    public void i_open_browser_for_checkout_scenario() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.get(baseUrl);

        String loginPageAssert = driver.findElement(By.className("login_logo")).getText();
        Assert.assertEquals(loginPageAssert, "Swag Labs");
    }

    @And("Open web saucedemo for checkout scenario")
    public void open_web_saucedemo_for_checkout_scenario() throws InterruptedException {
        driver.get(baseUrl);
        Thread.sleep(1000);
    }

    @And("Located on saucedemo website for checkout scenario")
    public void located_on_saucedemo_website_for_checkout_scenario() {
        driver.findElement(By.name("login-button")).isDisplayed();
    }

    @And("I input valid username for checkout scenario")
    public void i_input_valid_username_for_checkout_scenario() {
        driver.findElement(By.name("user-name")).sendKeys("standard_user");
    }

    @And("And I input valid password for checkout scenario")
    public void and_i_input_valid_password_for_checkout_scenario() {
        driver.findElement(By.name("password")).sendKeys("secret_sauce");
        driver.findElement(By.name("password")).sendKeys(ENTER);
    }

    @Given("Page catalog product")
    public void page_catalog_product() {
        WebDriverWait wait = new WebDriverWait(driver, ofSeconds(10));

        String titlePageProduct = driver.findElement(By.className("title")).getText();
        Assert.assertEquals("Products", titlePageProduct );

        String expectedCatalogURL = "https://www.saucedemo.com/inventory.html";
        String currentCatalogURL = driver.getCurrentUrl();
        Assert.assertEquals(expectedCatalogURL, currentCatalogURL);
    }

    @And("And I select one product to cart")
    public void and_i_select_one_product_to_cart() {
        WebElement buttonSecond = driver.findElement(By.name("add-to-cart-sauce-labs-bike-light"));
        buttonSecond.sendKeys(ENTER);
    }

    @And("And I click icon cart")
    public void and_i_click_icon_cart() {
        WebElement cartIcon = driver.findElement(By.cssSelector(".shopping_cart_link"));
        cartIcon.click();
    }

    @And("And I click checkout button")
    public void and_i_click_checkout_button() {
        WebElement buttonCheckout = driver.findElement(By.name("checkout"));
        buttonCheckout.sendKeys(ENTER);
    }

    @Then("I should see form information data")
    public void i_should_see_form_information_data() {
        String titlePageProduct = driver.findElement(By.className("title")).getText();
        Assert.assertEquals("Checkout: Your Information", titlePageProduct );
        driver.close();
        driver.quit();
    }

    @Then("Button checkout must be cannot clicked")
    public void button_checkout_must_be_cannot_clicked() {
        WebElement buttonCheckout = driver.findElement(By.name("checkout"));
        boolean isButtonCheckoutDisabled = buttonCheckout.getAttribute("disabled") != null;
        Assert.assertTrue(isButtonCheckoutDisabled);
    }




}
