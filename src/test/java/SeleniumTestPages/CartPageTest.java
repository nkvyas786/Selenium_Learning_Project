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

import java.io.IOException;

public class CartPageTest extends TestBase {

    LoginPage loginPage;
    HomePage homePage;
    LoginPageTest loginPageTest;
    OrdersPage ordersPage;
    CartPage cartPage;
    HomePageTest homePageTest;


    public CartPageTest() {
        super();
        //this.homePageTest = homePageTest;

    }

    @BeforeMethod
    public void setUp() throws IOException {
        initialization();
        loginPage = new LoginPage();
        homePage = new HomePage();
        loginPageTest = new LoginPageTest();
        ordersPage = new OrdersPage();
        cartPage = new CartPage();
        homePage = loginPage.loginApplication(prop.getProperty("username"), prop.getProperty("password"));
        cartPage = homePage.clickOnCartLink();
        homePageTest = new HomePageTest();

    }

    @Test
    public void getMyCartText() throws InterruptedException {
        String myCartText = cartPage.verifyMyCartText();
        Thread.sleep(2000);
        Assert.assertEquals(cartPage.verifyMyCartText(), "My Cart");
        System.out.println(myCartText);
    }

    @Test
    public void getNoProductsInCartText() {
        try {

            String noProductsInCartText = cartPage.verifyNoProductsInCartText();

            Thread.sleep(2000);
            Assert.assertEquals(noProductsInCartText, "No Products in Your Cart !", "No Products in Your Cart Text is not displayed");
            System.out.println(noProductsInCartText);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void actionContinueShoppingButton() throws InterruptedException {

        homePage = cartPage.clickContinueShoppingButton();
        Thread.sleep(2000);
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


    @Test
    public void actionCheckOutButton() throws InterruptedException {
        ordersPage = cartPage.actionCheckOutButton();
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
