package StepDef;

import Config.Env;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InventoryPage {

    WebDriver driver;
    Env env = new Env();

    public InventoryPage(){
        this.driver = WebDriverSetting.getDriver();
    }

    @Given("User on inventory page")
    public void userOnInventoryPage() throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"user-name\"]")).sendKeys(env.getValidUsername());
        driver.findElement(By.id("password")).sendKeys(env.getValidPassword());
        driver.findElement(By.id("login-button")).click();
        driver.findElement(By.xpath("//*[starts-with(@id,\"add-to-cart\")]")).isDisplayed();

    }

    @When("User click add to cart button")
    public void userClickAddToCartButton() throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(By.name("add-to-cart-sauce-labs-backpack")).click();
    }

    @Then("Item cart will increase")
    public void itemCartWillIncrease() {
        String itemCart = driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a/span")).getText();
        Assert.assertEquals("1", itemCart);
        WebDriverSetting.closeDriver();
    }

    @After("@InventoryPage")
    public void closeDriver() throws InterruptedException {
        Thread.sleep(3000);
        WebDriverSetting.closeDriver();
    }
}
