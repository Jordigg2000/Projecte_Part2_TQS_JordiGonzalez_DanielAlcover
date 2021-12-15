package io.cucumber.skeleton;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Animations {

    private static WebDriver driver;

    @Given("access to the main page8")
    public void accessToTheMainPage8() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver(options);
        driver.get("https://www.caprabo.com/ca/home/");
    }


    @When("sliding 4 times")
    public void slidingTimes() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"onetrust-accept-btn-handler\"]")).click();
        for(int i = 0; i<4; i++) {
            driver.findElement(By.xpath("//*[@class=\"glyphicon glyphicon-chevron-right\"]")).click();
            Thread.sleep(1000);
        }

    }

    @Then("check 5th slide")
    public void checkThSlide() {
        WebElement aux = driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div[1]/div/div/div[1]/div[1]/div/div/div/div[5]/div/div/div/div/div/a"));
        assert aux.getText().contains("veure més");
    }

    @When("click on 3 bars")
    public void clickOnBars() {
        driver.findElement(By.xpath("//*[@id=\"onetrust-accept-btn-handler\"]")).click();
        driver.findElement(By.xpath("//*[@class=\"navbar-toggle collapsed principal\"]")).click();
    }

    @Then("its opened")
    public void itsOpened() throws InterruptedException {
        Thread.sleep(1000);
        WebElement aux = driver.findElement(By.xpath("//*[@title=\"Ofertes i promocions\"]"));
        assert aux.getText().contains("Ofertes i promocions");
    }

    @When("open 3 bars")
    public void openBars() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"onetrust-accept-btn-handler\"]")).click();
        driver.findElement(By.xpath("//*[@class=\"navbar-toggle collapsed principal\"]")).click();
        Thread.sleep(1000);
    }

    @When("close menu")
    public void closeMenu() {
        driver.findElement(By.xpath("//*[@class=\"glyphicon glyphicon-remove\"]")).click();
    }

    @Then("its closed")
    public void itsClosed() throws InterruptedException {
        Thread.sleep(1000);
        WebElement aux = driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div[1]/div/div/div[2]/div[1]/div[1]/h2"));
        assert aux.getText().contains("Ofertes de Nadal");
    }
}
