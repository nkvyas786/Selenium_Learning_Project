package SeleniumTestPages;
import com.nar.qa.base.TestBase;
import com.sfd.qa.pages.CartPage;
import com.sfd.qa.pages.HomePage;
import com.sfd.qa.pages.LoginPage;
import com.sfd.qa.pages.OrdersPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.TestUtil;

import java.io.IOException;

public class OrderPageTest extends TestBase {

    LoginPage loginPage;
    HomePage homePage;
    OrdersPage ordersPage;
    CartPage cartPage;

    public OrderPageTest() {
        super();
    }

    @BeforeMethod
    public void setUp() throws IOException {
        initialization();
        loginPage = new LoginPage();
        homePage = loginPage.loginApplication(prop.getProperty("username"), prop.getProperty("password"));


    }

    @Test
    public void verifyNoOrdersText() {

        try {
            ordersPage = homePage.clickOnOrdersLink();
            Thread.sleep(2000);
            ordersPage.getNoOrderText();
            //Assert.assertEquals(noOrderText, " You have No Orders to show at this time. Please Visit Back Us", "No order text is not matching");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }





    @AfterMethod
    public void closeBrw () {
        if (driver != null) {
            driver.quit();
        } else {
            System.out.println("Driver is not initialized.");

        }
    }



}
