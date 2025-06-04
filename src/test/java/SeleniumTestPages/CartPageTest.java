package SeleniumTestPages;
import com.nar.qa.base.TestBase;
import com.sfd.qa.pages.CartPage;
import com.sfd.qa.pages.HomePage;
import com.sfd.qa.pages.LoginPage;
import com.sfd.qa.pages.OrdersPage;
import com.sfd.qa.pages.PaymentPage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import java.time.Duration;
import org.openqa.selenium.By;
import java.io.IOException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

public class CartPageTest extends TestBase {

    WebDriverWait wait;//  W
    LoginPage loginPage;
    HomePage homePage;
    CartPage cartPage;
    OrdersPage ordersPage;
    PaymentPage paymentPage;

//    public CartPageTest() {
//        super();
//
//    }

    @BeforeMethod
    public void setUp() throws IOException, InterruptedException {
        initialization();
        loginPage = new LoginPage();
        homePage = loginPage.loginApplication(prop.getProperty("username"), prop.getProperty("password"));
        //cartPage = homePage.clickOnCartLink();
        //Thread.sleep(2000);



    }

    @Test(priority = 1)
    public void getMyCartText() throws InterruptedException {
        cartPage = homePage.clickOnCartLink();
        String myCartText = cartPage.verifyMyCartText();
        Thread.sleep(2000);
        Assert.assertEquals(cartPage.verifyMyCartText(), "My Cart");
        System.out.println(myCartText);
    }

    @Test(priority=2)
    public void getNoProductsInCartText() {
        try {
            cartPage = homePage.clickOnCartLink();
            Thread.sleep(2000);
            String noProductsInCartText = cartPage.verifyNoProductsInCartText();

            Thread.sleep(2000);
            Assert.assertEquals(noProductsInCartText, "No Products in Your Cart !", "No Products in Your Cart Text is not displayed");
            System.out.println(noProductsInCartText);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Test(priority = 3)
    public void actionContinueShoppingButton() {
        try {
            cartPage = homePage.clickOnCartLink();
            Thread.sleep(2000);
            homePage = cartPage.clickContinueShoppingButton();
            Thread.sleep(2000);
            Assert.assertEquals(homePage.verifyHomePageTitle(), "Let's Shop");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

//    @Test
//    public void addIphoneToCart() {
//
//        try {
//            homePage.selectElectronics();
//            Thread.sleep(2000);
//            homePageTest.selectIphoneToCart();
//            Thread.sleep(2000);
//            cartPage = homePage.clickOnCartLink();
//            cartPage.actionCheckOutButton();
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//    }

    @Test(priority = 4)
    public void actionCheckOutButton() throws InterruptedException {

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
