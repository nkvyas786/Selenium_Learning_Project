package SeleniumTestPages;

import com.nar.qa.base.TestBase;
import com.sfd.qa.pages.HomePage;
import com.sfd.qa.pages.LoginPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.*;

import java.io.IOException;

import static org.testng.Assert.*;

public class LoginPageTest extends TestBase {

    LoginPage loginPage;
    HomePage homePage;

    public LoginPageTest() {
        super();
    }

    @BeforeMethod
    public void setUpPageObjects() throws IOException {
        loginPage = new LoginPage(driver);
//        homePage = new HomePage(driver);
    }

    @Test(priority = 3)
    public void currentURLValidation() {
        String URL = loginPage.validateCurrentURL();
        assertEquals(URL, "https://rahulshettyacademy.com/client/auth/login");
        System.out.println("Login Page URL is: " + URL);

    }

    @Test(priority = 2)
    public void verifyLoginTitle() {
        String title = loginPage.PageTitle();
        assertEquals(loginPage.PageTitle(), "Let's Shop", "Login Page title is not matching");
        System.out.println("Login Page Title is: " + title);
    }

    @Test(priority = 1)
    public void verifyLoginTest() throws IOException {
        String username = ConfigReader.getProp("username");
        System.out.println("Trying to login with user: "+username);
        LogUtils.info("Trying to login with user: "+username);
//        assertTrue(homePage.isSignOutBtnDisplayed(),"Sign Out Button is not displayed");
    }

    @Test(priority = 4)
    public int verifyLinksCount() {
        System.out.println("------in test----");
        return loginPage.GetAllLinks();
    }
}
