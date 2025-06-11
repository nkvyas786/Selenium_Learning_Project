package SeleniumTestPages;
import com.nar.qa.base.TestBase;
import com.sfd.qa.pages.CartPage;
import com.sfd.qa.pages.HomePage;
import com.sfd.qa.pages.LoginPage;
import com.sfd.qa.pages.OrdersPage;
import com.sfd.qa.pages.PaymentPage;
import com.sfd.qa.pages.ConfirmationPage;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class PaymentPageTest extends TestBase {

    WebDriverWait wait;//  W
    LoginPage loginPage;
    HomePage homePage;
    CartPage cartPage;
    OrdersPage ordersPage;
    PaymentPage paymentPage;
    ConfirmationPage confirmationPage;


    @BeforeMethod
    public void setUp() throws IOException, InterruptedException {
        initialization();
        loginPage = new LoginPage();
        homePage = loginPage.loginApplication(prop.getProperty("username"), prop.getProperty("password"));
        //cartPage = homePage.clickOnCartLink();
        //Thread.sleep(2000);

    }


    @Test
    public void clickOnCreditCardButton() throws InterruptedException {

        homePage.selectElectronics();
        Thread.sleep(2000);
        homePage.addToCartIphone();
        Thread.sleep(2000);
        homePage.clickOnCartLink();
        Thread.sleep(2000);
        cartPage = homePage.clickOnCartLink();
        Thread.sleep(2000);

        paymentPage = cartPage.actionCheckOutButton();
        Thread.sleep(2000);

        confirmationPage = paymentPage.placeOrder();
        Thread.sleep(4000);

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
