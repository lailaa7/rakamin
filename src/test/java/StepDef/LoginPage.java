package StepDef;

import Config.Env;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.openqa.selenium.By.xpath;

public class LoginPage {
    WebDriver driver;
    Env env = new Env();

    public LoginPage(){
        this.driver = WebDriverSetting.getDriver();
    }
    @Given("User in the sauce demo login page")
    public void userInTheSauceDemoLoginPage(){
        driver.findElement(By.id("user-name")).isDisplayed();
    }

    @When("User input valid username")
    public void userInputValidUsername() {
        driver.findElement(By.id("user-name")).sendKeys(env.getValidUsername());
    }
    @When("User input invalid username")
    public void userInputInvalidUsername() {
        driver.findElement(By.id("user-name")).sendKeys(env.getInvalidUsername());
    }
    @And("User input valid password")
    public void userInputValidPassword() {
        driver.findElement(By.id("password")).sendKeys(env.getValidPassword());
    }
    @And("User click login button")
    public void userClickLoginButton() {
        driver.findElement(By.id("login-button")).click();
    }
    @Then("User success login")
    public void userSuccessLogin() throws InterruptedException {
        driver.findElement(By.xpath("//*[starts-with(@id,\"add-to-cart\")]")).isDisplayed();
        Thread.sleep(3000);
    }

    @Then("User will see error invalid username password message")
    public void userWillSeeErrorInvalidUsernamePasswordMessage() throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[text()='Username and password do not valid in this service']")).isDisplayed();
    }
    @After("@LoginPage")
    public void closeDriver() throws InterruptedException {
        Thread.sleep(3000);
        WebDriverSetting.closeDriver();
    }
}
