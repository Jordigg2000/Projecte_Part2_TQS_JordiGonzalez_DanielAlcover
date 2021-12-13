package io.cucumber.skeleton;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Objects;

public class Offer {


    private static WebDriver driver;


    @Given("access to the main page3")
    public void accessToTheMainPage3() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        //options.setPageLoadStrategy(PageLoadStrategy.EAGER);
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver(options);
        driver.get("https://www.caprabo.com/ca/home/");
    }


    @When("click on ofertes i promocions")
    public void clickOnOfertesIPromocions() {
        driver.findElement(By.xpath("//*[@id='onetrust-accept-btn-handler']")).click(); //cookies
        driver.findElement(By.xpath("//*[@title=\"Ofertes i promocions\"]")).click();
    }

    @When("click on ofertes")
    public void clickOnOfertes() {
        driver.findElement(By.xpath("//*[@href=\"/ca/ofertas-y-promociones/ofertas/\" and @class=\"call-to-action\"]")).click();
    }

    @When("write postal code")
    public void writePostalCode() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        By element1 = By.xpath("//input[@class='js-big-search-autocomplete' and type='text']");
        wait.until(ExpectedConditions.presenceOfElementLocated(element1));
        driver.findElement(element1).sendKeys("08033");
        driver.findElement(By.xpath("//*[@id=\"big-search-button\"]")).click();
    }

    @Then("it is written correctly")
    public void itIsWrittenCorrectly() {

       WebElement aux = driver.findElement(By.xpath("//*[@id=\"modal-location-grid\"]"));
        assert (aux != null);

    }
}
