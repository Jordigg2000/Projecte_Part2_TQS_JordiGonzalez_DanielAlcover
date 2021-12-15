package io.cucumber.skeleton;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class search {

  private static WebDriver driver;

  @Given("access to the main page6")
  public void accessToTheMainPage6() {
    ChromeOptions options = new ChromeOptions();
    options.addArguments("start-maximized");
    System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
    driver = new ChromeDriver(options);
    driver.get("https://www.caprabo.com/ca/home/");
  }

  @When("click on capraboacasa button3")
  public void clickoncapraboacasabutton3(){
    driver.findElement(By.xpath("//*[@id=\"onetrust-accept-btn-handler\"]")).click();
    driver.findElement(By.xpath("//nav[@id='navbar-sites']//a[@class='text'][normalize-space()='Capraboacasa']")).click();
    List<String> browserTabs = new ArrayList<>(driver.getWindowHandles());
    driver.switchTo().window(browserTabs.get(1));
  }

  //search llet
  @When("search leche")
  public void searchLeche() {
    WebElement aux = driver.findElement(By.xpath("//*[@id=\"search-input\"]"));
    aux.sendKeys("leche");
    aux.sendKeys(Keys.ENTER);
  }

  @Then("check first product4")
  public void checkFirstProduct() {
    WebDriverWait wait = new WebDriverWait(driver, 5);
    By element = By.xpath("/html/body/div[9]/div[3]/div[2]/div[3]/div[1]/div[3]/div[1]/a/div"); //ofertas button
    wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    WebElement aux = driver.findElement(element);
    assert aux.getText().contains("Leche uht semidesnatada LLET NOSTRA, brik 1 litro");
  }

  @When("search carne")
  public void searchCarne() {
    WebElement aux = driver.findElement(By.xpath("//*[@id=\"search-input\"]"));
    aux.sendKeys("carne");
    aux.sendKeys(Keys.ENTER);
  }

  @Then("check first product5")
  public void checkFirstProduct5() {
    WebDriverWait wait = new WebDriverWait(driver, 5);
    By element = By.xpath("/html/body/div[9]/div[3]/div[2]/div[3]/div[1]/div[3]/div[1]/a/div"); //ofertas button
    wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    WebElement aux = driver.findElement(element);
    System.out.println(aux.getText());
    assert aux.getText().contains("Eroski Carne picada cerdo 400g");
  }

  //search huevos
  @When("search huevos")
  public void searchHuevos() {
    WebElement aux = driver.findElement(By.xpath("//*[@id=\"search-input\"]"));
    aux.sendKeys("huevos");
    aux.sendKeys(Keys.ENTER);
  }

  @Then("check first product6")
  public void checkFirstProduct6() {
    WebDriverWait wait = new WebDriverWait(driver, 5);
    By element = By.xpath("/html/body/div[9]/div[3]/div[2]/div[3]/div[1]/div[3]/div[1]/a/div"); //ofertas button
    wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    WebElement aux = driver.findElement(element);
    System.out.println(aux.getText());
    assert aux.getText().contains("Huevo fresco L campero vall mestral ROIG, cartón 6 uds.");
  }
}