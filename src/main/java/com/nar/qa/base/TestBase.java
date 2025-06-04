package com.nar.qa.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import jdk.jpackage.internal.Log;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import utils.ConfigReader;
import utils.TestUtil;

import java.util.concurrent.TimeUnit;

public abstract class TestBase {

  protected static WebDriver driver;

  public TestBase() {
    ConfigReader.loadConfig();
  }

  public static WebDriver initialization() {
    String browserName = System.getProperty("browser") != null ? System.getProperty("browser") : ConfigReader.getProp("browser");

    switch (browserName.toLowerCase()) {
      case "firefox":
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        break;
      case "edge":
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        break;
      case "chrome":
      default:
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    return driver;
  }

//            if (browserName.equalsIgnoreCase("chrome")) {
//                WebDriverManager.chromedriver().setup();
//                driver = new ChromeDriver();
//            }
//            else if (browserName.equalsIgnoreCase("firefox")) {
//            }
//            else if (browserName.equalsIgnoreCase("edge")) {
//            }

  //headless browser setup
  //ChromeOptions options = new ChromeOptions();
  //WebDriverManager.chromedriver().setup();
  // driver = new ChromeDriver(options);
  // options.addArguments("headless");

  //driver.manage().window().setSize(new Dimension(1920, 1080));

  @BeforeClass
  public void setUp() {

    initialization();
    driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
    driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
    driver.manage().window().maximize();
    driver.manage().deleteAllCookies();

//    Navigation to App URL
    driver.navigate().to(ConfigReader.getProp("url"));
    driver.get(ConfigReader.getProp("url"));
  }

  @AfterClass
  public void tearDown() {
    if (driver != null) {
      driver.quit();
    }
  }
}


