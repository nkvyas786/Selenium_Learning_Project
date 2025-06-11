package SeleniumTestPages;
import com.nar.qa.base.TestBase;
import com.sfd.qa.pages.CartPage;
import com.sfd.qa.pages.HomePage;
import com.sfd.qa.pages.LoginPage;
import com.sfd.qa.pages.OrdersPage;
import com.sfd.qa.pages.PaymentPage;
import com.sfd.qa.pages.ConfirmationPage;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import com.nar.qa.base.TestBase;

public class ConfirmationPageTest extends TestBase {

    WebDriverWait wait;//  W
    LoginPage loginPage;
    HomePage homePage;
    CartPage cartPage;
    OrdersPage ordersPage;
    PaymentPage paymentPage;
    ConfirmationPage confirmationPage;

    public ConfirmationPageTest() {
        super();
    }

    @BeforeMethod
    public void setUp() throws IOException, InterruptedException {
        initialization();
        loginPage = new LoginPage();
        homePage = loginPage.loginApplication(prop.getProperty("username"), prop.getProperty("password"));
        //cartPage = homePage.clickOnCartLink();
        //Thread.sleep(2000);
    }

    @Test(priority = 1)
    public void navigateToOrderHistoryPage() throws InterruptedException {
        confirmationPage = paymentPage.placeOrder();
        ordersPage = confirmationPage.clickOnOrderHistory();
        Thread.sleep(3000);
    }

    @Test(priority = 2)
    public void clickOnDownloadButton() {
        confirmationPage.clickOnDownloadButton();
    }

    @Test(priority = 3)
    public void getConfirmationText() {
        String confirmationText = confirmationPage.getConfirmationText();
        Assert.assertEquals(confirmationText, "Thankyou for the order.", "Confirmation text is not matching");
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
