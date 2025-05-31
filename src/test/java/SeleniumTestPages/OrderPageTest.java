package SeleniumTestPages;
import com.nar.qa.base.TestBase;
import com.sfd.qa.pages.CartPage;
import com.sfd.qa.pages.HomePage;
import com.sfd.qa.pages.LoginPage;
import com.sfd.qa.pages.OrdersPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class OrderPageTest extends TestBase {


    LoginPage loginPage;
    HomePage homePage;
    LoginPageTest loginPageTest;
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
        ordersPage = homePage.clickOnOrdersLink();
    }

    @Test
    public void verifyNoOrdersText() {

       String noOrderText = ordersPage.getNoOrderText();
       Assert.assertEquals(noOrderText, " You have No Orders to show at this time.", "No order text is not matching");
//        WebDriverWait wait = new WebDriverWait(driver, 10);
//        WebElement element = wait.until(ExpectedConditions.elementToBeVisible(NoOrderText)));
    }









}
