package testing;

import java.util.regex.Pattern;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;

import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class SauceTest {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  private JavascriptExecutor js;

  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
	  WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
    baseUrl = "https://www.google.com/";
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    js = (JavascriptExecutor) driver;
  }

  @Test
  public void testSauce() throws Exception {
    driver.get(baseUrl + "chrome://newtab/");
    driver.get("https://www.saucedemo.com/");
    driver.findElement(By.id("user-name")).click();
    driver.findElement(By.id("user-name")).clear();
    driver.findElement(By.id("user-name")).sendKeys("standard_user");
    driver.findElement(By.id("password")).click();
    driver.findElement(By.id("password")).clear();
    driver.findElement(By.id("password")).sendKeys("secret_sauce");
    driver.findElement(By.id("login-button")).click();
    driver.findElement(By.xpath("//div[@id='header_container']/div[2]/div/span/select")).click();
    driver.findElement(By.id("add-to-cart-sauce-labs-onesie")).click();
    driver.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();
    driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt")).click();
    driver.findElement(By.id("add-to-cart-test.allthethings()-t-shirt-(red)")).click();
    driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
    driver.findElement(By.id("add-to-cart-sauce-labs-fleece-jacket")).click();
    driver.findElement(By.xpath("//div[@id='shopping_cart_container']/a/span")).click();
    driver.findElement(By.id("remove-sauce-labs-onesie")).click();
    driver.findElement(By.id("remove-sauce-labs-bike-light")).click();
    driver.findElement(By.id("checkout")).click();
    driver.findElement(By.id("first-name")).click();
    driver.findElement(By.id("first-name")).clear();
    driver.findElement(By.id("first-name")).sendKeys("sree");
    driver.findElement(By.id("last-name")).click();
    driver.findElement(By.id("last-name")).clear();
    driver.findElement(By.id("last-name")).sendKeys("renjini");
    driver.findElement(By.id("postal-code")).click();
    driver.findElement(By.id("postal-code")).clear();
    driver.findElement(By.id("postal-code")).sendKeys("691510");
    driver.findElement(By.id("continue")).click();
    driver.findElement(By.id("finish")).click();
    driver.findElement(By.id("back-to-products")).click();
    driver.findElement(By.id("react-burger-menu-btn")).click();
    driver.findElement(By.id("logout_sidebar_link")).click();
  }

  @AfterClass(alwaysRun = true)
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}

