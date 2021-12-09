package io.cucumber.skeleton;

import io.cucumber.java.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
public class Login {

  private static WebDriver driver;
  private Scenario scenario;

  @BeforeAll
  public static void setUp() {
    // This property is optional.
    // If not specified, WebDriver searches the path for chromedriver in your environment variables
    // Example path for Linux or Mac:
    System.setProperty("webdriver.chrome.driver", "\\Users\\dania\\Documents\\uni 3\\TQS\\Practica2\\chromedriver.exe");
    driver = new ChromeDriver();
  }

  @Given("we enter to the web")
  public void weEnterToTheWeb() {
    driver.get("https://www.tesla.com");
  }

  @When("we make login with right user and password")
  public void weMakeLoginWithRightUserAndPassword() {

  }

  @Then("the login is successful")
  public void theLoginIsSuccessful() {
  }
}
