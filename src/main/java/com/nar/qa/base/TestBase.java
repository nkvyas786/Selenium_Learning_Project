package com.nar.qa.base;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.TestUtil;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {

    public static WebDriver driver;
    public static Properties prop;

    public TestBase(){
    try {
        prop = new Properties();
        FileInputStream fis;
        fis = new FileInputStream("/Users/nivivyas/Documents/UI_Projects/src/main/java/resources/GlobalData.properties");
        prop.load(fis);

    } catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }
    }

    public static void initialization() {
//            prop = new Properties();
//            FileInputStream fis = new FileInputStream(System.getProperty("user.dir")
//                    + "//src//main//java//resources//GlobalData.properties");
//            prop.load(fis);
        //String browserName = prop.getProperty("browser");
        String browserName = System.getProperty("browser")!=null ? System.getProperty("browser") : prop.getProperty("browser");

            if (browserName.equalsIgnoreCase("chrome")) {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
            }
            else if (browserName.equalsIgnoreCase("firefox")) {
            }
            else if (browserName.equalsIgnoreCase("edge")) {
            }

        //headless browser setup
        //ChromeOptions options = new ChromeOptions();
        //WebDriverManager.chromedriver().setup();
        // driver = new ChromeDriver(options);
        // options.addArguments("headless");

        //driver.manage().window().setSize(new Dimension(1920, 1080));


//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();

        driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        //Navigation to App URL
        driver.navigate().to(prop.getProperty("url"));
        //driver.get(prop.getProperty("url"));
        //driver.navigate().to("https://rahulshettyacademy.com/client");
        //driver.get("https://rahulshettyacademy.com/client");


    }
}


