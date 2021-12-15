package io.cucumber.skeleton;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class filter_blog {

  private static WebDriver driver;

  @Given("access to the main page10")
  public void accessToTheMainPage10() {
    ChromeOptions options = new ChromeOptions();
    options.addArguments("start-maximized");
    System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
    driver = new ChromeDriver(options);
    driver.get("https://www.caprabo.com/ca/home/");
  }

  @Given("go to blog page")
  public void goToBlogPage() {
    driver.findElement(By.xpath("//*[@id=\"onetrust-accept-btn-handler\"]")).click(); //cookies
    driver.findElement(By.xpath("/html/body/div[1]/div/header/div/div[1]/nav/ul/li[4]/a[2]")).click();
  }

  //december
  @When("choose date")
  public void chooseDate() {
    driver.findElement(By.xpath("//input[@id='datefrom']")).sendKeys("01/12/2021");
    driver.findElement(By.xpath("//input[@id='dateto']")).sendKeys("31/12/2021");
    driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div[1]/div/div/div/div[2]/div/form/div[1]/div/div[5]/button")).click();
  }

  @Then("check first entrance")
  public void checkFirstEntrance() throws InterruptedException {
    JavascriptExecutor js = ((JavascriptExecutor) driver);
    js.executeScript("window.scrollTo(0, 700)");
    Thread.sleep(3000);
    WebElement aux = driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div[1]/div/div/div/div[2]/div/form/div[2]/div/div[1]/em"));
    System.out.println(aux.getText());
    assert aux.getText().contains("Resultat de la recerca");
  }

  //september
  @When("choose date2")
  public void chooseDate2() throws InterruptedException {
    driver.findElement(By.xpath("//input[@id='datefrom']")).sendKeys("01/09/2021");
    driver.findElement(By.xpath("//input[@id='dateto']")).sendKeys("31/09/2021");
    driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div[1]/div/div/div/div[2]/div/form/div[1]/div/div[5]/button")).click();
  }

  @Then("check first entrance2")
  public void checkFirstEntrance2() throws InterruptedException {
    JavascriptExecutor js = ((JavascriptExecutor) driver);
    js.executeScript("window.scrollTo(0, 700)");
    Thread.sleep(3000);
    WebElement aux = driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div[1]/div/div/div/div[2]/div/form/div[2]/div/div[1]/em"));
    System.out.println(aux.getText());
    assert aux.getText().contains("Resultat de la recerca");

  }

  //may
  @When("choose date3")
  public void chooseDate3(){
    driver.findElement(By.xpath("//input[@id='datefrom']")).sendKeys("01/05/2021");
    driver.findElement(By.xpath("//input[@id='dateto']")).sendKeys("31/05/2021");
    driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div[1]/div/div/div/div[2]/div/form/div[1]/div/div[5]/button")).click();

  }

  @Then("check first entrance3")
  public void checkFirstEntrance3() throws InterruptedException {
    JavascriptExecutor js = ((JavascriptExecutor) driver);
    js.executeScript("window.scrollTo(0, 700)");
    Thread.sleep(3000);
    WebElement aux = driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div[1]/div/div/div/div[2]/div/form/div[2]/div/div[1]/em"));
    System.out.println(aux.getText());
    assert aux.getText().contains("Resultat de la recerca");

  }

}
