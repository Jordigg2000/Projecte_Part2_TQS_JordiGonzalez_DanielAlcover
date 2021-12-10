package io.cucumber.skeleton;

import io.cucumber.java.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Objects;

public class Login {

  private static WebDriver driver;
  private Scenario scenario;

  @BeforeAll
  public static void setUp() {
    // This property is optional.
    // If not specified, WebDriver searches the path for chromedriver in your environment variables
    // Example path for Linux or Mac:
    ChromeOptions options = new ChromeOptions();
    options.addArguments("start-maximized");
    System.setProperty("webdriver.chrome.driver", "\\Users\\dania\\Documents\\uni 3\\TQS\\Practica2\\chromedriver.exe");
    driver = new ChromeDriver(options);
  }

  @Before
  public void init(){
    driver.get("https://www.caprabo.com/ca/home/");
  }

  @When("we make login with right user and password")
  public void weMakeLoginWithRightUserAndPassword() {

  }

  @Then("the login is successful")
  public void theLoginIsSuccessful() {
  }


  //wrong user
  @Given("being in the login page")
  public void beingInTheLoginPage() {

    driver.findElement(By.xpath("//*[@id=\"onetrust-accept-btn-handler\"]")).click();
    driver.findElement(By.xpath("//*[@class=\"zu-derecha\"]")).click();
    driver.findElement(By.xpath("//*[@id=\"zu_header_boton_login\"]")).click();
    driver.findElement(By.xpath("//*[@id=\"onetrust-accept-btn-handler\"]")).click();
    String winHandle = driver.getWindowHandle();
    driver.switchTo().window(winHandle);
  }

  @When("login with wrong user and right password")
  public void loginWithWrongUserAndRightPassword() {
    driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("danialcover001@gmail.com");
    driver.findElement(By.xpath("//*[@id=\"clave1\"]")).sendKeys("passworderronia");
  }

  @Then("the login is not successful")
  public void theLoginIsNotSuccessful() {
    String actualURL = driver.getCurrentUrl();
    System.out.println(actualURL);
    assert Objects.equals(actualURL, "https://club.caprabo.com/areacliente/ca/nlrLogin");
  }
}
