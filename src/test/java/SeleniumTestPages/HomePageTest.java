package SeleniumTestPages;

import com.listeners.Retry;
import com.nar.qa.base.TestBase;
import com.sfd.qa.pages.CartPage;
import com.sfd.qa.pages.HomePage;
import com.sfd.qa.pages.LoginPage;
import com.sfd.qa.pages.OrdersPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;
import java.io.IOException;
import java.util.Set;

import static junit.framework.Assert.assertEquals;

public class HomePageTest extends TestBase {

    LoginPage loginPage;
    HomePage homePage;
    OrdersPage ordersPage;
    CartPage cartPage;

    //constructor
    public HomePageTest() {
        super();
    }

    @BeforeMethod
    public void setUpPageObjects() throws IOException {
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        ordersPage = new OrdersPage(driver);
        cartPage = new CartPage(driver);
    }

    @Test(priority=0)
    public void getTitle() {
        String HomePagTitle =   homePage.verifyHomePageTitle();
        assertEquals("Home Page title is not matching", "Let's Shop", HomePagTitle);
        System.out.println("Home Page Title is: " + HomePagTitle);
    }

    @Test(priority=1, retryAnalyzer = Retry.class)
    public void productListCount() {
        homePage.getProductList();
    }

    @Test(priority=2)
    public void getCheckBoxDetailThenClick(){
        homePage.getCheckBoxesAndClick();
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

    @Test
    public void clickOnOrderPageLink() {
        ordersPage = homePage.clickOnOrdersLink();
        System.out.println("Orders Page is clicked");
    }

    @Test
    public void clickOnCartPageLink() {
        cartPage =  homePage.clickOnCartLink();
        System.out.println("Cart Page is clicked");

    }



//@Test
//    public void selectAllCheckBoxes(){
//
//        homePage.getCheckBoxesAndClick();

    //        for (int i=0; i<=checkBoxes.size(); i++){
//            checkBoxes.get(i).click();
//        }
//    }
//

    @AfterMethod
    public void closeBrw() {
        if (driver != null){
            driver.quit();
    } else{
        System.out.println("Driver is not initialized.");

    }}
}


