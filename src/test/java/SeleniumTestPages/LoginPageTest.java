package SeleniumTestPages;
import com.nar.qa.base.TestBase;
import com.sfd.qa.pages.HomePage;
import com.sfd.qa.pages.LoginPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

import static junit.framework.Assert.assertEquals;

public class LoginPageTest extends TestBase {

    LoginPage loginPage;
    HomePage homePage;

    public LoginPageTest() {
        super();
    }

    @BeforeMethod
    public void setUp() {
        initialization();
        loginPage = new LoginPage();
    }

    @Test(priority=3)
    public void currentURLValidation(){
        String URL = loginPage.validateCurrentURL();
        assertEquals( "https://rahulshettyacademy.com/client/auth/login", URL);
        System.out.println("Login Page URL is: " + URL);

    }
    @Test(priority=2)
    public void loginTitleValidateMethod() {
        String title = loginPage.PageTitle();
        assertEquals("Login Page title is not matching", "Let's Shop", title);
        System.out.println("Login Page Title is: " + title);
    }

    @Test(priority=4)
    public void loginTest() throws IOException {

        homePage = loginPage.loginApplication(prop.getProperty("username"), prop.getProperty("password"));

    }

    @Test(priority = -1)
    public void getLinkCount(){

        loginPage.GetAllLinks();

    }

    @AfterMethod
    public void closeBrw() {
        if (driver != null) {
            driver.quit();
        } else {
            System.out.println("Driver is not initialized.");

        }}



    }
