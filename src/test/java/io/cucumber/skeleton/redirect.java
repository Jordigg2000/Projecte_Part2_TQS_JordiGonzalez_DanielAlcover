package io.cucumber.skeleton;

import io.cucumber.java.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class redirect {

  private static WebDriver driver;

  @Given("access to the main page2")
  public void accessToTheMainPage2() {
    ChromeOptions options = new ChromeOptions();
    options.addArguments("start-maximized");
    options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
    System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
    driver = new ChromeDriver(options);
    driver.get("https://www.caprabo.com/ca/home/");
  }

  @When("click on caprabo info button")
  public void clickOnCapraboSInfoButton() {
    driver.findElement(By.xpath("//*[@id=\"onetrust-accept-btn-handler\"]")).click();
    driver.findElement(By.xpath("//*[@href=\"/ca/conoce-caprabo/sala-de-prensa/caprabo-corporativo/\"]")).click();
    driver.findElement(By.xpath("//*[@data-link=\"#principalesdatos\" and @class=\"btn btn-brand-light btn-lg pl-30 pr-30 lower\"]")).click();
  }

  @When("click on main data")
  public void clickOnMainData() {
    driver.findElement(By.xpath("//*[@data-link=\"#principalesdatos\"]")).click();
  }

  @Then("it is in the right page")
  public void itIsInTheRightPage() {
    String actualURL = driver.getCurrentUrl();
    assert Objects.equals(actualURL, "https://www.caprabo.com/ca/conoce-caprabo/sala-de-prensa/caprabo-corporativo/#principalesdatos");
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

  @When("click on productores")
  public void clickOnProductores() {
    driver.findElement(By.xpath("//*[@id=\"onetrust-accept-btn-handler\"]")).click();
    Actions builder = new Actions(driver);
    driver.findElement(By.xpath("//*[@title=\"La Nostra Terra\"]")).click();
  }

  @When("click on dulces y desayunos")
  public void clickOnDulcesYDesayunos() {
    driver.findElement(By.xpath("//*[@class=\"btnAzul\" and @href=\"https://www.capraboacasa.com/portal/es/super/de-la-nostra-terra/bebidas/8281\"]")).click();
  }

  @Then("it is in the capraboacasa page")
  public void itIsInTheCapraboacasaPage() {
    List<String> browserTabs = new ArrayList<>(driver.getWindowHandles());
    driver.switchTo().window(browserTabs.get(1));
    String actualURL = driver.getCurrentUrl();
    System.out.println(actualURL);
    assert Objects.equals(actualURL, "https://www.capraboacasa.com/portal/es/super/de-la-nostra-terra/bebidas/"); //genera url distinto cada vez. Nuscar forma de comparar solo la primera parte
  }
}
