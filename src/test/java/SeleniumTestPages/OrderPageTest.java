package SeleniumTestPages;
import com.nar.qa.base.TestBase;
import com.sfd.qa.pages.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.TestUtil;

import java.io.IOException;
import java.time.Duration;

public class OrderPageTest extends TestBase {

    LoginPage loginPage;
    HomePage homePage;
    OrdersPage ordersPage;
    CartPage cartPage;
    ConfirmationPage confirmationPage;
    PaymentPage paymentPage;
    ConfirmationPage confirmationPageTest;
    OrderPageTest orderPageTest;



    public OrderPageTest() {
        super();
    }

    @BeforeMethod
    public void setUp() throws IOException {
        initialization();
        loginPage = new LoginPage();
        homePage = loginPage.loginApplication(prop.getProperty("username"), prop.getProperty("password"));

    }

    @Test(priority = 1)
    public void homePageNavigation() throws InterruptedException {
        homePage.selectElectronics();
        Thread.sleep(2000);
        homePage.addToCartIphone();
        Thread.sleep(2000);
        cartPage = homePage.clickOnCartLink();
        Thread.sleep(2000);
        paymentPage = cartPage.actionCheckOutButton();
        Thread.sleep(2000);
        confirmationPage = paymentPage.placeOrder();
        Thread.sleep(4000);
        ordersPage=confirmationPage.clickOnOrderHistory();
        Thread.sleep(2000);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        TestUtil.scrollPageDown(driver);
        wait.until(ExpectedConditions.elementToBeClickable(ordersPage.homeButton));
        if (ordersPage.homeButton.isDisplayed()) {
            Thread.sleep(2000);
            ordersPage.clickOnHomeButton();
        } else {
            System.out.println("Home button is not displayed.");
        }
        Thread.sleep(2000);
        Assert.assertTrue(homePage.verifyHomePageTitle().contains("Let's Shop"));


    }

    @Test(priority = 2)
    public void cartPageNavigation() throws InterruptedException {
        homePage.selectElectronics();
        Thread.sleep(2000);
        homePage.addToCartIphone();
        Thread.sleep(2000);
        cartPage = homePage.clickOnCartLink();
        Thread.sleep(2000);
        paymentPage = cartPage.actionCheckOutButton();
        Thread.sleep(2000);
        confirmationPage = paymentPage.placeOrder();
        Thread.sleep(4000);

        ordersPage=confirmationPage.clickOnOrderHistory();
        Thread.sleep(2000);
        cartPage = ordersPage.clickOnCartButton();
        Thread.sleep(2000);

    }


    @Test(priority = 4)
    public void validateLastItemDeleted() throws InterruptedException {

        ordersPage = homePage.clickOnOrdersLink();

        System.out.println("Order list before deleting last item: ");

        ordersPage.getAllOrderIds();
        WebElement lastItem = driver.findElement(By.xpath("(//th[@scope='row'])[7]"));
        Assert.assertTrue(lastItem.isDisplayed());
        String firstText = lastItem.getText();
        System.out.println("Last Item: " + lastItem.getText());
        Thread.sleep(2000);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        TestUtil.scrollPageDown(driver);
        wait.until(ExpectedConditions.elementToBeClickable(ordersPage.homeButton));
        if (ordersPage.homeButton.isDisplayed()) {
            Thread.sleep(2000);
            System.out.println("Home button is displayed.");
            ordersPage.clickOnHomeButton();

        } else {
            System.out.println("Home button is not displayed.");
        }

          TestUtil.scrollPageUp(driver);
         Thread.sleep(2000);

          homePage.selectElectronics();
          Thread.sleep(2000);
          homePage.addToCartIphone();
          Thread.sleep(2000);
          cartPage = homePage.clickOnCartLink();
          Thread.sleep(2000);
          paymentPage = cartPage.actionCheckOutButton();
          Thread.sleep(2000);
          confirmationPage = paymentPage.placeOrder();
          Thread.sleep(4000);
          ordersPage=confirmationPage.clickOnOrderHistory();
          Thread.sleep(2000);

          System.out.println("Order list after deleting last item: ");
          ordersPage.getAllOrderIds();
          Thread.sleep(2000);
          WebElement updatedLastItem = driver.findElement(By.xpath("(//th[@scope='row'])[7]"));
          Assert.assertTrue(updatedLastItem.isDisplayed());
          String updatedText = updatedLastItem.getText();
          System.out.println("Updated Last Item: " + updatedLastItem.getText());
          Thread.sleep(2000);

          Assert.assertNotEquals(firstText, updatedText);

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
