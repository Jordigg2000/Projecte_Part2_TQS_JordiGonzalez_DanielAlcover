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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class basket {

  private static WebDriver driver;

  @Given("access to the main page4")
  public void accessToTheMainPage4() {
    ChromeOptions options = new ChromeOptions();
    options.addArguments("start-maximized");
    options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
    System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
    driver = new ChromeDriver(options);
    driver.get("https://www.caprabo.com/ca/home/");
  }

  @When("click on capraboacasa button")
  public void clickoncapraboacasabutton(){
    driver.findElement(By.xpath("//*[@id=\"onetrust-accept-btn-handler\"]")).click();
    driver.findElement(By.xpath("//nav[@id='navbar-sites']//a[@class='text'][normalize-space()='Capraboacasa']")).click();
    List<String> browserTabs = new ArrayList<>(driver.getWindowHandles());
    driver.switchTo().window(browserTabs.get(1));
  }

  //water
  @When("click on water")
  public void clickOnWater() {
    WebDriverWait wait = new WebDriverWait(driver, 5);
    By element = By.xpath("/html/body/div[4]/div/div/nav[3]/div[2]/div/a[6]/span");
    wait.until(ExpectedConditions.visibilityOfElementLocated(element));

    driver.findElement(element).click();
    driver.findElement(By.xpath("/html/body/div[4]/div/div/nav[3]/div[3]/div[2]/div[1]/div/ul/li[1]/a")).click();
  }

  @When("add water to the basket")
  public void addWaterToTheBasket() {
    WebDriverWait wait = new WebDriverWait(driver, 10);
    driver.findElement(By.xpath("/html/body/div[9]/div[3]/div[1]/div[2]/ul/li[1]/a")).click();
    By element = By.xpath("/html[1]/body[1]/div[9]/div[3]/div[2]/div[3]/div[1]/div[3]/div[4]/div[1]/div[1]/a[1]");
    wait.until(ExpectedConditions.presenceOfElementLocated(element));
    driver.findElement(element).click();
  }

  @Then("the total price increases 3,6")
  public void theTotalPriceIncreases36() throws InterruptedException {
    WebElement aux = driver.findElement(By.xpath("//div[@class='nav-wrapper container']//a[2]//span[1]"));
    Thread.sleep(3000);
    assert aux.getText().contains("3,60");
  }

  //oil
  @When("click on oil")
  public void clickOnOil() {
    WebDriverWait wait = new WebDriverWait(driver, 5);
    By element = By.xpath("/html/body/div[4]/div/div/nav[3]/div[2]/div/a[4]/span"); //main section
    wait.until(ExpectedConditions.visibilityOfElementLocated(element));

    driver.findElement(element).click();
    driver.findElement(By.xpath("/html/body/div[4]/div/div/nav[3]/div[3]/div[2]/div[1]/div/ul/li[1]/a")).click(); //section in displayed menu
  }

  @When("add oil to the basket")
  public void addOilToTheBasket() {
    WebDriverWait wait = new WebDriverWait(driver, 10);
    driver.findElement(By.xpath("/html/body/div[9]/div[3]/div[1]/div[2]/ul/li[1]/a")).click(); //relevancia button
    By element = By.xpath("//*[@id=\"121428\"]"); //add button
    wait.until(ExpectedConditions.presenceOfElementLocated(element));
    driver.findElement(element).click();
  }

  @Then("the total price increases 4,99")
  public void theTotalPriceIncreases499() throws InterruptedException {
    WebElement aux = driver.findElement(By.xpath("//div[@class='nav-wrapper container']//a[2]//span[1]"));
    Thread.sleep(3000);
    assert aux.getText().contains("4,99");

  }

  //ribs
  @When("click on fet a la botiga")
  public void clickOnFetALaBotiga() {
    WebDriverWait wait = new WebDriverWait(driver, 5);
    By element = By.xpath("/html/body/div[4]/div/div/nav[3]/div[2]/div/a[8]/span"); //main section
    wait.until(ExpectedConditions.visibilityOfElementLocated(element));

    driver.findElement(element).click();
    driver.findElement(By.xpath("/html/body/div[4]/div/div/nav[3]/div[3]/div[2]/div[1]/div/ul/li[1]/a")).click(); //section in displayed menu
  }

  @When("add ribs to the basket")
  public void addRibsToTheBasket() {
    WebDriverWait wait = new WebDriverWait(driver, 10);
    driver.findElement(By.xpath("/html/body/div[9]/div[3]/div[1]/div[2]/ul/li[1]/a")).click(); //relevancia button
    By element = By.xpath("//*[@id=\"338297\"]"); //add button
    wait.until(ExpectedConditions.presenceOfElementLocated(element));
    driver.findElement(element).click();

  }

  @Then("the total price increases 4,00")
  public void theTotalPriceIncreases400() throws InterruptedException {
    WebElement aux = driver.findElement(By.xpath("//div[@class='nav-wrapper container']//a[2]//span[1]"));
    Thread.sleep(3000);
    assert aux.getText().contains("4,00");

  }
}
