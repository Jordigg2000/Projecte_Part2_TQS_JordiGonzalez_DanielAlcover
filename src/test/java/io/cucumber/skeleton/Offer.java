package io.cucumber.skeleton;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Objects;

public class Offer {


    private static WebDriver driver;


    @Given("access to the main page3")
    public void accessToTheMainPage3() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver(options);
        driver.get("https://www.caprabo.com/ca/home/");
    }


    @When("click on ofertes i promocions")
    public void clickOnOfertesIPromocions() {
        driver.findElement(By.xpath("//*[@id=\"onetrust-accept-btn-handler\"]")).click();
        driver.findElement(By.xpath("//*[@title=\"Ofertes i promocions\"]")).click();
    }

    @When("click on ofertes")
    public void clickOnOfertes() {
        driver.findElement(By.xpath("//*[@href=\"/ca/ofertas-y-promociones/ofertas/\" and @class=\"call-to-action\"]")).click();
    }

    @When("write postal code")
    public void writePostalCode() {
        driver.findElement(By.xpath("//input[@placeholder=\"Ej.: Ciudad, Código Postal, ...\"]")).sendKeys("08033");
        driver.findElement(By.xpath("//*[@id=\"big-search-button\"]")).click();
    }

    @Then("it is written correctly")
    public void itIsWrittenCorrectly() {

       WebElement aux = driver.findElement(By.xpath("//*[@id=\"modal-location-grid\"]"));
        assert (aux != null);

    }
}
