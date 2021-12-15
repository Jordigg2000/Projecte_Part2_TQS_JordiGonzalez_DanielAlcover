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


public class filters {

  private static WebDriver driver;

  @Given("access to the main page5")
  public void accessToTheMainPage5() {
    ChromeOptions options = new ChromeOptions();
    options.addArguments("start-maximized");
    options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
    System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
    driver = new ChromeDriver(options);
    driver.get("https://www.caprabo.com/ca/home/");
  }

  @When("click on capraboacasa button2")
  public void clickoncapraboacasabutton2(){
    driver.findElement(By.xpath("//*[@id=\"onetrust-accept-btn-handler\"]")).click();
    driver.findElement(By.xpath("//nav[@id='navbar-sites']//a[@class='text'][normalize-space()='Capraboacasa']")).click();
    List<String> browserTabs = new ArrayList<>(driver.getWindowHandles());
    driver.switchTo().window(browserTabs.get(1));
  }

  //filters 1
  @When("click on oferta")
  public void clickOnOferta() {
    WebDriverWait wait = new WebDriverWait(driver, 5);
    By element = By.xpath("/html/body/div[4]/div/div/nav[3]/div[2]/div/a[2]/span"); //ofertas button
    wait.until(ExpectedConditions.visibilityOfElementLocated(element));

    driver.findElement(element).click();
    driver.findElement(By.xpath("/html/body/div[4]/div/div/nav[3]/div[3]/div[2]/div[1]/div/ul/li[1]/a")).click(); //oferta subbutton
  }

  @When("select 3x2")
  public void select3X2() throws InterruptedException {
    driver.findElement(By.xpath("/html/body/div[9]/div[3]/div[1]/div[1]/ul/li[8]/a")).click(); //compra 3 y paga 2 filter
    Thread.sleep(1000);
  }

  @When("select order ZA")
  public void selectOrderZA() {
    driver.findElement(By.xpath("/html/body/div[9]/div[3]/div[1]/div[2]/ul/li[3]/a")).click(); //alfabeticamente ZA filter
  }

  @Then("check first product")
  public void checkFirstProduct() throws InterruptedException {
    Thread.sleep(1000);
    WebElement aux = driver.findElement(By.xpath("/html/body/div[9]/div[3]/div[2]/div[3]/div[1]/div[3]/div[1]/a/div"));
    System.out.println(aux.getText());
    assert aux.getText().contains("Taquitos de jamón curado EROSKI, pack 2x75 g");
  }

  //filters 2
  @When("click on de la nostra terra")
  public void clickOnDeLaNostraTerra() {
    WebDriverWait wait = new WebDriverWait(driver, 5);
    By element = By.xpath("/html/body/div[4]/div/div/nav[3]/div[2]/div/a[3]/span"); //de la nostra terra button
    wait.until(ExpectedConditions.visibilityOfElementLocated(element));

    driver.findElement(element).click();
    driver.findElement(By.xpath("/html/body/div[4]/div/div/nav[3]/div[3]/div[2]/div[1]/div/ul/li[1]/a")).click(); //despensa button
  }

  @When("select order AZ")
  public void selectOrderAZ() throws InterruptedException {
    driver.findElement(By.xpath("/html/body/div[9]/div[3]/div[1]/div[2]/ul/li[2]/a")).click(); //alfabeticamente AZ filter
    Thread.sleep(1000);
  }

  @When("select oferta")
  public void selectOferta() {
    driver.findElement(By.xpath("/html/body/div[9]/div[3]/div[1]/div[3]/ul[1]/li[1]/a")).click(); //oferta filter
  }

  @Then("check first product2")
  public void checkFirstProduct2() throws InterruptedException {
    Thread.sleep(1000);
    WebElement aux = driver.findElement(By.xpath("/html/body/div[9]/div[3]/div[2]/div[3]/div[1]/div[3]/div[1]/a/div"));
    System.out.println(aux.getText());
    assert aux.getText().contains("Aceite de oliva virgen extra OLI DE CASTELLO, 2 l");
  }

  //filters 3
  @When("click on mon nado")
  public void clickOnMonNado() {
    WebDriverWait wait = new WebDriverWait(driver, 5);
    By element = By.xpath("/html/body/div[4]/div/div/nav[3]/div[2]/div/a[10]/span"); //de la nostra terra button
    wait.until(ExpectedConditions.visibilityOfElementLocated(element));

    driver.findElement(element).click();
    driver.findElement(By.xpath("/html/body/div[4]/div/div/nav[3]/div[3]/div[2]/div[1]/div/ul/li[1]/a")).click(); //despensa button
  }

  @When("select ALMIRON")
  public void selectALMIRON() {
    driver.findElement(By.xpath("/html/body/div[9]/div[3]/div[1]/div[3]/ul[2]/li[1]/a")).click(); //ALMIRON filter
  }

  @Then("check first product3")
  public void checkFirstProduct3() throws InterruptedException {
    Thread.sleep(1000);
    WebElement aux = driver.findElement(By.xpath("/html/body/div[9]/div[3]/div[2]/div[3]/div[1]/div[3]/div[1]/a/div"));
    System.out.println(aux.getText());
    assert aux.getText().contains("Multicereals ecològics ALMIRON 200 g");
  }
}
