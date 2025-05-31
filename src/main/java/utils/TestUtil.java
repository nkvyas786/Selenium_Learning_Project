package utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;



public class TestUtil {

    public static long PAGE_LOAD_TIMEOUT = 20;
    public static long IMPLICIT_WAIT = 10;

    WebDriver driver;


    public void waitForElement(By findBy){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));

    }

    public static void report(){

        ExtentReportUtility.config();

    }



    @Test(dataProvider = "data")
    public void test(String data) {
        Assert.assertEquals(data, "data1"); // Example assertion
    }

    @DataProvider
    public Object[][] data() {
        return new Object[][] {
                new Object[] { "" },
                new Object[] { "data2" }
        };
    }



}
