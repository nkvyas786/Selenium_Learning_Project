package com.sfd.qa.pages;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class TestBase {

    public static WebDriver driver;
    public static Properties prop;

    public static void initialization() throws IOException
    {
//            prop = new Properties();
//            FileInputStream fis = new FileInputStream(System.getProperty("user.dir")
//                    + "//src//main//java//resources//GlobalData.properties");
//            prop.load(fis);
//            String browserName = System.getProperty("browser")!=null ? System.getProperty("browser") : prop.getProperty("browser");
//
//            if (browserName.equalsIgnoreCase("chrome")) {
//                WebDriverManager.chromedriver().setup();
//                driver = new ChromeDriver();
//            }
//            else if (browserName.equalsIgnoreCase("firefox")) {
//            }
//            else if (browserName.equalsIgnoreCase("edge")) {
//
//            }

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        //driver.navigate().to(prop.getProperty("url"));
        driver.navigate().to("https://rahulshettyacademy.com/client");
        //Navigation to App URL
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();


    }
}


