package io.cucumber.skeleton;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SocialNetworks {

    private static WebDriver driver;
    @Given("access to the main page7")
    public void accessToTheMainPage7() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver(options);
        driver.get("https://www.caprabo.com/ca/home/");
    }

    @When("click on facebook button")
    public void clickOnFacebookButton() {
        driver.findElement(By.xpath("//*[@id=\"onetrust-accept-btn-handler\"]")).click();
        driver.findElement(By.xpath("//*[@href=\"https://www.facebook.com/Caprabo\"]")).click();
    }

    @Then("it is in caprabo's facebook page")
    public void itIsInCapraboSFacebookPage() {
        List<String> browserTabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(browserTabs.get(1));
        String actualURL = driver.getCurrentUrl();
        System.out.println(actualURL);
        assert Objects.equals(actualURL, "https://www.facebook.com/Caprabo");
    }
    @When("click on instagram button")
    public void clickOnInstagramButton() {
        driver.findElement(By.xpath("//*[@id=\"onetrust-accept-btn-handler\"]")).click();
        driver.findElement(By.xpath("//*[@href=\"https://www.instagram.com/caprabo_supermercats/\"]")).click();
    }

    @Then("it is in caprabo's instagram page")
    public void itIsInCapraboSInstagramPage() {
        List<String> browserTabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(browserTabs.get(1));
        String actualURL = driver.getCurrentUrl();
        System.out.println(actualURL);
        assert Objects.equals(actualURL, "https://www.instagram.com/caprabo_supermercats/");
    }
    @When("click on twitter button")
    public void clickOnTwitterButton() {
        driver.findElement(By.xpath("//*[@id=\"onetrust-accept-btn-handler\"]")).click();
        driver.findElement(By.xpath("//*[@href=\"https://twitter.com/caprabo\"]")).click();
    }

    @Then("it is in caprabo's twitter page")
    public void itIsInCapraboSTwitterPage() {
        List<String> browserTabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(browserTabs.get(1));
        String actualURL = driver.getCurrentUrl();
        System.out.println(actualURL);
        assert Objects.equals(actualURL, "https://twitter.com/caprabo");
    }
}
