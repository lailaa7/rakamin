package StepDef;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class CartPage {
    WebDriver driver;
    public CartPage(){
        this.driver = WebDriverSetting.getDriver();
    }

    @And("User move to cart page")
    public void userMoveToCartPage(){
        driver.findElement(By.xpath("//*[@class='shopping_cart_link']")).click();
        driver.findElement(By.id("checkout")).isDisplayed();
    }

    @When("User click remove button")
    public void userClickRemoveButton() {
        driver.findElement(By.xpath("//*[starts-with(@name,'remove')]")).click();
    }

    @Then("Item cart will decrease")
    public void itemCartWillDecrease() {
        boolean itemcart;
        try {
            driver.findElement(By.xpath("//*[@class='shopping_cart_badge']"));
            itemcart = true;
        } catch (NoSuchElementException e){
            itemcart = false;
        }
        Assert.assertFalse(itemcart);
    }
    @After("@CartPage")
    public void closeDriver() throws InterruptedException {
        Thread.sleep(3000);
        WebDriverSetting.closeDriver();
    }
}
