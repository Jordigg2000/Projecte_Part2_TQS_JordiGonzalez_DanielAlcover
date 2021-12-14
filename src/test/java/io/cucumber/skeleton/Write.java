package io.cucumber.skeleton;

import io.cucumber.java.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Write {

    private static WebDriver driver;

    @Given("access to the main page3")
    public void accessToTheMainPage3() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver(options);
        driver.get("https://www.caprabo.com/ca/home/");
    }

    @When("click on Caprabo a casa")
    public void clickOnCapraboACasa() {
        driver.findElement(By.xpath("//*[@id=\"onetrust-accept-btn-handler\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"onetrust-accept-btn-handler\"]")).click();
    }

    @When("write vodka on Cercador")
    public void writeVodkaOnCercador() {
        List<String> browserTabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(browserTabs.get(1));
    }

    @Then("check url")
    public void checkUrl() {
        String actualURL = driver.getCurrentUrl();
        System.out.println(actualURL);
        assert actualURL.contains("https://www.capraboacasa.com/portal/es?utm_source=caprabo&utm_medium=home&utm_campaign=menu_capraboacasa_&_ga");
    }

    @When("clink on supermarket localizer")
    public void clinkOnSupermarketLocalizer() {
        driver.findElement(By.xpath("//*[@id=\"onetrust-accept-btn-handler\"]")).click();
        driver.findElement(By.xpath("//a[@class='txt-localizador']")).click();
    }

    @When("choose city")
    public void chooseCity() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        By element1 = By.xpath("//option[@value='Sant Quirze del Vallès']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(element1));
        Select menu = new Select(driver.findElement(By.xpath("//select[@id='supermarket']")));
        menu.selectByVisibleText("Sant Quirze del Vallès");
    }

    @Then("right supermarket appears")
    public void rightSupermarketAppears() {
        assert driver.findElement(By.xpath("//option[@value='Sant Quirze del Vallès']")).isDisplayed();
    }
}
