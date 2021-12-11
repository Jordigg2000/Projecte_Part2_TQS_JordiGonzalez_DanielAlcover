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

import java.util.Objects;
import java.util.concurrent.TimeUnit;

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

  @When("we make login with right user and password")
  public void weMakeLoginWithRightUserAndPassword() {
    driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("danialcover001@gmail.com");
    driver.findElement(By.xpath("//*[@id=\"clave1\"]")).sendKeys("kM~1O2?2");
    driver.findElement(By.xpath("//*[@id=\"continue\"]")).click();

  }

  @Then("the login is successful")
  public void theLoginIsSuccessful() {
    String actualURL = driver.getCurrentUrl();
    System.out.println(actualURL);
    assert Objects.equals(actualURL, "https://club.caprabo.com/areacliente/ca/nlr/nlrVerificarSmsView");
  }


  @Given("being in the login page")
  public void beingInTheLoginPage() {
    driver.findElement(By.xpath("//*[@id=\"onetrust-accept-btn-handler\"]")).click();
    driver.findElement(By.xpath("//*[@class=\"zu-derecha\"]")).click();
    driver.findElement(By.xpath("//*[@id=\"zu_header_boton_login\"]")).click();
    driver.findElement(By.xpath("//*[@id=\"onetrust-accept-btn-handler\"]")).click();
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
}
