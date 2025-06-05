package SeleniumTestPages;

import com.nar.qa.base.TestBase;
import com.sfd.qa.pages.CartPage;
import com.sfd.qa.pages.HomePage;
import com.sfd.qa.pages.LoginPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.ConfigReader;

import java.io.IOException;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class CartPageTest extends TestBase {

  LoginPage loginPage;
  HomePage homePage;
  CartPage cartPage;

  public CartPageTest() {
    super();
  }

  @BeforeMethod
  public void setUpPageObjects() throws IOException {
    loginPage = new LoginPage(driver);
    homePage = new HomePage(driver);
    cartPage = new CartPage(driver);
    loginPage.loginApplication(ConfigReader.getProp("username"), ConfigReader.getProp("password"));
  }

  @Test
  public void verfiyCheckoutButtonFunctionality() throws InterruptedException {
    homePage.selectElectronics();
    homePage.addToCartIphone();
    Thread.sleep(2000);
    cartPage.clickOnCartLink();
    Thread.sleep(2000);
    cartPage.clickOnCheckoutBtn();
    Thread.sleep(2000);
  }
}
