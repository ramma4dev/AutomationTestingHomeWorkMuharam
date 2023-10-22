package StepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static java.time.Duration.ofSeconds;
import static org.openqa.selenium.Keys.ENTER;

public class Login {
    WebDriver driver;
    String baseUrl = "https://www.saucedemo.com/";

    @Given("I open browser")
    public void i_open_browser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.get(baseUrl);

        String loginPageAssert = driver.findElement(By.className("login_logo")).getText();
        Assert.assertEquals(loginPageAssert, "Swag Labs");

//        final String dir = System.getProperty("user.dir");
//        System.out.println("current dir = "+ dir);
//        System.setProperty("webdriver.chrome.driver", dir+"/driver/chromedriver.exe");
//        driver = new ChromeDriver();
    }

    @And("Open website saucedemo")
    public void open_website_saucedemo() throws InterruptedException {
        driver.get(baseUrl);
        Thread.sleep(1000);
    }

    @And("Located on saucedemo website")
    public void located_on_saucedemo_website() {
        driver.findElement(By.name("login-button")).isDisplayed();
    }

    @When("I input empty username")
    public void i_input_empty_username() throws InterruptedException {
        driver.findElement(By.name("user-name")).sendKeys("");
        Thread.sleep(2000);
    }

    @And("I input valid password")
    public void i_input_valid_password() {
         driver.findElement(By.name("password")).sendKeys("secret_sauce");
         driver.findElement(By.name("password")).sendKeys(ENTER);
    }

    @Then("I should see error message {string}")
    public void i_should_see_error_message(String errorMessage) {
        WebElement errorElement = driver.findElement(By.cssSelector(".error-message-container.error"));
        assert(errorElement.getText().contains(errorMessage));
        driver.close();
        driver.quit();
    }

    @When("I input valid username")
    public void i_input_valid_username() {
        driver.findElement(By.name("user-name")).sendKeys("standard_user");
    }

    @And("And I input valid password")
    public void and_i_input_valid_password() {
        driver.findElement(By.name("password")).sendKeys("secret_sauce");
        driver.findElement(By.name("password")).sendKeys(ENTER);
    }

    @Then("I go to homepage")
    public void i_go_to_homepage() {
        WebDriverWait wait = new WebDriverWait(driver, ofSeconds(10));
        //WebDriverWait wait = new WebDriverWait(driver, 10); // Maximum wait time of 10 seconds
        WebElement MyElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".app_logo")));
        String expectedText = MyElement.getText();
        Assert.assertEquals(expectedText, "Swag Labs" );
//        WebElement errorElement = driver.findElement(By.className(".app_logo"));
        driver.close();
        driver.quit();
    }
}

