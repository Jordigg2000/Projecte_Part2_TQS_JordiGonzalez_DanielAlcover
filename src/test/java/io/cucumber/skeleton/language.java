package io.cucumber.skeleton;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class language {

  private static WebDriver driver;

  @Given("access to the main page9")
  public void accessToTheMainPage9() {
    ChromeOptions options = new ChromeOptions();
    options.addArguments("start-maximized");
    System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
    driver = new ChromeDriver(options);
    driver.get("https://www.caprabo.com/ca/home/");
  }

  @When("click on capraboacasa button4")
  public void clickoncapraboacasabutton4(){
    driver.findElement(By.xpath("//*[@id=\"onetrust-accept-btn-handler\"]")).click(); //cookies
    driver.findElement(By.xpath("//nav[@id='navbar-sites']//a[@class='text'][normalize-space()='Capraboacasa']")).click();
    List<String> browserTabs = new ArrayList<>(driver.getWindowHandles());
    driver.switchTo().window(browserTabs.get(1));
  }


  //caprabo
  @When("select castellano in caprabo")
  public void selectCastellano() {
    By element1 = By.xpath("//*[@id=\"onetrust-accept-btn-handler\"]"); //cookies

    WebDriverWait wait = new WebDriverWait(driver, 5);
    wait.until(ExpectedConditions.visibilityOfElementLocated(element1));
    driver.findElement(element1).click();
    driver.findElement(By.xpath("/html/body/div[1]/div/header/div/div[2]/div/nav/div/ul/li[5]/a")).click();
  }

  @Then("caprabo is in castellano")
  public void webIsInCastellano() {
    WebElement aux = driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div[1]/div/div/div[2]/div[1]/div[1]/h2"));
    assert aux.getText().contains("Ofertas de Navidad");
  }

  //capraboacasa
  @When("select catalan in capraboacasa")
  public void selectCatalanInCapraboacasa() throws InterruptedException {
    driver.findElement(By.xpath("//a[@id='header-laguage']")).click();
    WebDriverWait wait = new WebDriverWait(driver, 5);
    By element = By.xpath("/html/body/div[4]/div/div/nav[1]/div/ul/li[2]/ul/li[3]/a");
    wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    driver.findElement(element).click();
    Thread.sleep(3000);
  }

  @Then("capraboacasa is in catalan")
  public void capraboacasaIsInCatalan(){
    WebElement aux = driver.findElement(By.xpath("/html/body/div[9]/div[1]/div/div[1]/h2"));
    assert aux.getText().contains("Benvingut al teu súper online");
  }

  //xefcaprabo
  @When("click on xefcaprabo button")
  public void clickOnXefcapraboButton() {
    driver.findElement(By.xpath("//*[@id=\"onetrust-accept-btn-handler\"]")).click(); //cookies
    driver.findElement(By.xpath("/html/body/div[1]/div/header/div/div[1]/nav/ul/li[2]/a[2]")).click(); //xefcaprabo button
    List<String> browserTabs = new ArrayList<>(driver.getWindowHandles());
    driver.switchTo().window(browserTabs.get(1));
  }

  @When("select castellano in xefcaprabo")
  public void selectCastellanoInXefcaprabo() throws InterruptedException {
    driver.findElement(By.xpath("//*[@id=\"onetrust-accept-btn-handler\"]")).click(); //cookies
    driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div/ol/li[2]/a")).click(); //castellano button
    Thread.sleep(3000);
  }

  @Then("xefcaprabo is in castellano")
  public void xefcapraboIsInCastellano() {
    WebElement aux = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[6]/div/div[2]/center/h1[1]")); //title to check the language
    System.out.println(aux.getText());
    assert aux.getText().contains("DESCUBRE UN MUNDO");
  }
}