package utils;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestUtil {

    public static long PAGE_LOAD_TIMEOUT = 20;
    public static long IMPLICIT_WAIT = 10;

    @DataProvider
    public Object[][] data() {
        return new Object[][] {
                new Object[] { "" },
                new Object[] { "data2" }
        };
    }


    public static void report(){

        ExtentReportUtility.config();

    }



    @Test(dataProvider = "data")
    public void test(String data) {
        Assert.assertEquals(data, "data1"); // Example assertion
    }



}
