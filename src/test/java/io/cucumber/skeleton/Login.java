package io.cucumber.skeleton;

import io.cucumber.java.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Login {

  private static WebDriver driver;
  private Scenario scenario;

  @Given("access to the main page")
  public void accessToTheMainPage() {
    ChromeOptions options = new ChromeOptions();
    options.addArguments("start-maximized");
    options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
    System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
    driver = new ChromeDriver(options);
    driver.get("https://www.caprabo.com/ca/home/");
  }

  @Given("being in the login page")
  public void beingInTheLoginPage() {
    WebDriverWait wait = new WebDriverWait(driver, 5);
    By element1 = By.xpath("//*[@id=\"onetrust-accept-btn-handler\"]");
    wait.until(ExpectedConditions.visibilityOfElementLocated(element1));
    driver.findElement(element1).click();
    driver.findElement(By.xpath("//*[@class=\"zu-derecha\"]")).click();
    driver.findElement(By.xpath("//*[@id=\"zu_header_boton_login\"]")).click();
    wait.until(ExpectedConditions.visibilityOfElementLocated(element1));
    driver.findElement(element1).click();
  }


  //wrong user
  @When("login with wrong user and right password")
  public void loginWithWrongUserAndRightPassword() {

    driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("correuerroni@gmail.com");
    driver.findElement(By.xpath("//*[@id=\"clave1\"]")).sendKeys("kM~1O2?2");
    driver.findElement(By.xpath("//*[@id=\"continue\"]")).click();
  }

  //wrong password
  @When("login with right user and wrong password")
  public void loginWithRightUserAndWrongPassword() {
    driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("danialcover001@gmail.com");
    driver.findElement(By.xpath("//*[@id=\"clave1\"]")).sendKeys("passowrderronia");
    driver.findElement(By.xpath("//*[@id=\"continue\"]")).click();
  }

  @Then("the login is not successful")
  public void theLoginIsNotSuccessful() {
    String actualURL = driver.getCurrentUrl();
    assert Objects.equals(actualURL, "https://club.caprabo.com/areacliente/ca/nlrLogin#");
  }

  //right login
  @When("we make login with right user and password")
  public void weMakeLoginWithRightUserAndPassword() {
    driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("danialcover001@gmail.com");
    driver.findElement(By.xpath("//*[@id=\"clave1\"]")).sendKeys("kM~1O2?2");
    driver.findElement(By.xpath("//*[@id=\"continue\"]")).click();
  }

  @Then("the login is successful")
  public void theLoginIsSuccessful() throws InterruptedException {
    WebDriverWait wait = new WebDriverWait(driver, 5);
    By element = By.xpath("//*[@id=\"continue\"]");
    wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    Thread.sleep(5000);
    String actualURL = driver.getCurrentUrl();
    System.out.println("actualURL " + actualURL);
    assert Objects.equals(actualURL, "https://club.caprabo.com/areacliente/ca/nlr/nlrVerificarSmsView");
  }

}
