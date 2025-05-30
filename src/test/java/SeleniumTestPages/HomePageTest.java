package SeleniumTestPages;

import com.google.gson.JsonArray;
import com.listeners.Retry;
import com.sfd.qa.pages.HomePage;
import com.sfd.qa.pages.LoginPage;
import com.sfd.qa.pages.TestBase;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import utils.ExtentReportUtility;
import utils.TestUtil;

import java.io.IOException;


public class HomePageTest extends TestBase {

   private WebDriver driver;
    LoginPage loginPage;
    HomePage homePage;
    LoginPageTest loginPageTest;
    public static ExtentReportUtility extentReportUtility;


    //constructor
    public HomePageTest() {
        super();
       this.loginPageTest = new LoginPageTest();

    }

    @BeforeMethod
    public void setUp() throws IOException {
        initialization();
        loginPage = new LoginPage();
       loginPage.loginApplication("nkvyas786@gmail.com", "Garvi@1234");
        homePage = new HomePage();
    }

    @Test(priority=1, retryAnalyzer = Retry.class)
    public void productListCount() {

        homePage.getProductList();

    }
    @Test(priority=2)
    public void getCheckBoxDetail(){

        homePage.getCheckBoxes();
    }

//    public void selectAllCheckBoxes(){
//
//        homePage.getCheckBoxes();
//        for (int i=0; i<=checkBoxes.size(); i++){
//            checkBoxes.get(i).click();
//        }
 //   }



    @AfterMethod
    public void closeBrw() {
        if (driver != null){
            driver.quit();
    } else{
        System.out.println("Driver is not initialized.");

    }}
}


