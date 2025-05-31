package SeleniumTestPages;

import com.listeners.Retry;
import com.nar.qa.base.TestBase;
import com.sfd.qa.pages.HomePage;
import com.sfd.qa.pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;
import utils.ExtentReportUtility;

import java.io.IOException;
import java.util.Set;


public class HomePageTest extends TestBase {

    WebDriver driver;
    LoginPage loginPage;
    HomePage homePage;
    LoginPageTest loginPageTest;
    public static ExtentReportUtility extentReportUtility;


    //constructor
    public HomePageTest() throws IOException {
        super();
        //this.driver = driver;
       // super();
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

    @Test(priority=3)
    public void clickQAMeetupLink(){

        String parentWindow = driver.getWindowHandle();

        homePage.clickOnQAMeetupLink();

        Set<String> allWindows = driver.getWindowHandles();

        // 4. Switch to the new window
        for (String windowId : allWindows) {
            if (!windowId.equals(parentWindow)) {
                driver.switchTo().window(windowId);
                break;
            }
        }

        WebElement newWindowElement = driver.findElement(By.className("menu_item"));
        System.out.println(newWindowElement.getText());

        // 6. (Optional) Switch back to the original window
        driver.switchTo().window(parentWindow);







    }




//    public void selectAllCheckBoxes(){
//
//        homePage.getCheckBoxes();
//        for (int i=0; i<=checkBoxes.size(); i++){
//            checkBoxes.get(i).click();
//        }
//    }





    @AfterMethod
    public void closeBrw() {
        if (driver != null){
            driver.quit();
    } else{
        System.out.println("Driver is not initialized.");

    }}
}


