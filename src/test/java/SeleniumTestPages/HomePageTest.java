package SeleniumTestPages;
import com.listeners.Retry;
import com.nar.qa.base.TestBase;
import com.sfd.qa.pages.CartPage;
import com.sfd.qa.pages.HomePage;
import com.sfd.qa.pages.LoginPage;
import com.sfd.qa.pages.OrdersPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;
import java.io.IOException;
import java.util.Set;
import static junit.framework.Assert.assertEquals;


public class HomePageTest extends TestBase {
    LoginPage loginPage;
    HomePage homePage;
    OrdersPage ordersPage;
    CartPage cartPage;

    //constructor
//    public HomePageTest() {
//        super();
//        //this.loginPageTest = new LoginPageTest();
//
//    }

    @BeforeMethod
    public void setUp() throws IOException {
        initialization();
        loginPage = new LoginPage();
        homePage = loginPage.loginApplication(prop.getProperty("username"), prop.getProperty("password"));
    }

    @Test(priority = -1)
    public void getTitle() {
        String HomePagTitle = homePage.verifyHomePageTitle();
        assertEquals("Home Page title is not matching", "Let's Shop", HomePagTitle);
        System.out.println("Home Page Title is: " + HomePagTitle);
    }

    @Test(priority = 1, retryAnalyzer = Retry.class)
    public void productListCount() {
        homePage.getProductList();
    }

    @Test(priority = 2)
    public void getCheckBoxDetailThenClick() {
        try {
            homePage.getCheckBoxesAndClick();

            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    @Test(priority = 3)
    public void clickQAMeetupLink() throws InterruptedException {

        String parentWindow = driver.getWindowHandle();

        homePage.clickOnQAMeetupLink();

        Set<String> allWindows = driver.getWindowHandles();

        // 4. Switch to the new window
        for (String windowId : allWindows) {
            if (!windowId.equals(parentWindow)) {
                driver.switchTo().window(windowId);
                break;
            }
        }

        WebElement newWindowElement = driver.findElement(By.className("menu_item"));
        System.out.println(newWindowElement.getText());
        Thread.sleep(2000);
        WebElement registerButton = driver.findElement(By.xpath("//a[@class='hero_register_btn']"));
        System.out.println(registerButton.getText());
        registerButton.click();
        Thread.sleep(2000);

        // 6. (Optional) Switch back to the original window
        driver.switchTo().window(parentWindow);
        Thread.sleep(3000);

        homePage.clickOnQAMeetupLink();
        Thread.sleep(2000);
    }

    @Test(  priority = 4)
    public void clickOnOrderPageLink() {
        ordersPage = homePage.clickOnOrdersLink();
        System.out.println("Orders Page is clicked");
    }

    @Test(priority = 5)
    public void clickOnCartPageLink() throws InterruptedException {
        cartPage = homePage.clickOnCartLink();
        System.out.println("Cart Page is clicked");
        Thread.sleep(5000);

    }

    @Test(priority = 6)
    public void checkElectronics() throws InterruptedException {
        homePage.selectElectronics();
        Thread.sleep(2000);
    }

    @Test(priority = 7)
    public CartPage selectIphoneToCart() throws InterruptedException {
        homePage.selectElectronics();
        Thread.sleep(2000);
        homePage.addToCartIphone();
        Thread.sleep(2000);
        homePage.clickOnCartLink();
        Thread.sleep(2000);

        return new CartPage();

//        driver.findElement(By.xpath("//button[normalize-space()='Checkout']")).click();
//        Thread.sleep(2000);
//        driver.findElement(By.xpath("//input[@class='input txt'][1]")).sendKeys("123");
//        Thread.sleep(2000);
//        driver.findElement(By.xpath("//div[normalize-space()='Name on Card']/input")).sendKeys("Rajendra");
//        Thread.sleep(2000);
//        driver.findElement(By.xpath("//input[@placeholder='Select Country']")).sendKeys("India");
//        Thread.sleep(2000);
//        driver.findElement(By.xpath("//button[normalize-space()='Place Order']")).click();
//.   Thread.sleep(2000);
    }
    // public void addToCartIphone () {
//        By addToCartButton = By.xpath("//b[normalize-space()='IPHONE 13 PRO']//parent::h5//following-sibling::button[2]//child::i[@class='fa fa-shopping-cart']");
//
//        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.visibilityOfElementLocated(addToCartButton));
//        //homePage.addToCartIphone();// }

    @AfterMethod
    public void closeBrw() {
        if (driver != null){
            driver.quit();
    } else{
        System.out.println("Driver is not initialized.");

    }}}






