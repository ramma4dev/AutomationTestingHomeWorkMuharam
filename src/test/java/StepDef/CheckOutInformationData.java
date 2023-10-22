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

public class CheckOutInformationData {
    WebDriver driver = new ChromeDriver();;
    String baseUrl = "https://www.saucedemo.com/";

    @Given("I open browser for information data scenario")
    public void iOpenBrowserForInformationDataScenario() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.get(baseUrl);

        String loginPageAssert = driver.findElement(By.className("login_logo")).getText();
        Assert.assertEquals(loginPageAssert, "Swag Labs");
    }

    @And("Open web saucedemo for information data scenario")
    public void openWebSaucedemoForInformationDataScenario() throws InterruptedException {
        driver.get(baseUrl);
        Thread.sleep(1000);
    }

    @And("Located on saucedemo website for information data scenario")
    public void locatedOnSaucedemoWebsiteForInformationDataScenario() {
        driver.findElement(By.name("login-button")).isDisplayed();
    }

    @And("I input valid username for information data scenario")
    public void iInputValidUsernameForInformationDataScenario() {
        driver.findElement(By.name("user-name")).sendKeys("standard_user");
    }

    @And("And I input valid password for information data scenario")
    public void andIInputValidPasswordForInformationDataScenario() {
        driver.findElement(By.name("password")).sendKeys("secret_sauce");
        driver.findElement(By.name("password")).sendKeys(ENTER);
    }

    @Given("I catalog product page")
    public void iCatalogProductPage() {
        WebDriverWait wait = new WebDriverWait(driver, ofSeconds(10));

        String titlePageProduct = driver.findElement(By.className("title")).getText();
        Assert.assertEquals("Products", titlePageProduct );

        String expectedCatalogURL = "https://www.saucedemo.com/inventory.html";
        String currentCatalogURL = driver.getCurrentUrl();
        Assert.assertEquals(expectedCatalogURL, currentCatalogURL);
    }

    @And("And I add one product to cart")
    public void andIAddOneProductToCart() {
        WebElement buttonSecond = driver.findElement(By.name("add-to-cart-sauce-labs-bike-light"));
        buttonSecond.sendKeys(ENTER);
    }

    @And("I click icon cart")
    public void iClickIconCart() {
        WebElement cartIcon = driver.findElement(By.cssSelector(".shopping_cart_link"));
        //WebElement cartIcon = driver.findElement(By.className("shopping_cart_link"));
        cartIcon.click();
    }

    @And("I click checkout button")
    public void iClickCheckoutButton() {
        WebElement buttonCheckout = driver.findElement(By.name("checkout"));
        buttonCheckout.sendKeys(ENTER);
    }

    @And("I see form information data")
    public void iSeeFormInformationData() {
        String titlePageProduct = driver.findElement(By.className("title")).getText();
        Assert.assertEquals("Checkout: Your Information", titlePageProduct );
    }

    @And("I input valid first name")
    public void iInputValidFirstName() {
        driver.findElement(By.name("firstName")).sendKeys("Muharam");
    }

    @And("I input valid last name")
    public void iInputValidLastName() {
        driver.findElement(By.name("lastName")).sendKeys("Aram");
    }

    @And("I input valid postal code")
    public void iInputValidPostalCode() {
        driver.findElement(By.name("postalCode")).sendKeys("13835");
    }

    @And("I click button continue")
    public void iClickButtonContinue() {
        WebElement buttonContinue = driver.findElement(By.name("continue"));
        buttonContinue.sendKeys(ENTER);
    }

    @Then("I should see check out over view page")
    public void iShouldSeeCheckOutOverViewPage() {
        String titleOverview = driver.findElement(By.className("title")).getText();
        Assert.assertEquals("Checkout: Overview", titleOverview );
        driver.close();
        driver.quit();
    }


    @And("I input valid first name again")
    public void iInputValidFirstNameAgain() {
        driver.findElement(By.name("firstName")).sendKeys("Muharam");
    }

    @And("I input valid last name again")
    public void iInputValidLastNameAgain() {
        driver.findElement(By.name("lastName")).sendKeys("Aram");
    }

    @And("I input invalid format data postal code")
    public void iInputInvalidFormatDataPostalCode() {
        driver.findElement(By.name("postalCode")).sendKeys("!XY23@");
    }

    @Then("Button must be cannot clicked")
    public void ButtonCannotClick() {
        WebElement buttonContinues = driver.findElement(By.name("continue"));
        boolean isButtonDisabled = buttonContinues.getAttribute("disabled") != null;
        Assert.assertTrue(isButtonDisabled);
    }
















}
