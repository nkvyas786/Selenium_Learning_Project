package com.sfd.qa.pages;
import com.nar.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class HomePage extends TestBase {

    @FindBy(css = ".col-lg-4")
    List<WebElement> productList;

    //@FindBy(xpath = "//input[@type='checkbox']")
    //@FindBy(xpath="//input[@type='checkbox']/parent::div[@class='form-group ng-star-inserted']/parent::div/h6/parent::div/parent::form/preceding-sibling::div[@class='border-bottom pb-2 ml-2 p-4']")
    @FindBy(xpath="//div[@class='py-2 border-bottom ml-3']//label[@for='cat']/preceding-sibling::input[@type='checkbox']")
    List<WebElement> checkBoxes;

    @FindBy(xpath="//div[@class='py-2 border-bottom ml-3 p-4']/h6/parent::div/child::div[@class='form-group ng-star-inserted']/label[@for='cat']")
    WebElement categoryDropdown;

    @FindBy(xpath = "//a[@class='blinkingText']")
    WebElement QAMeetupLink;

    //@FindBy(xpath = "//button[@routerlink='/dashboard/myorders']")
    @FindBy(xpath = "//i[@class='fa fa-handshake-o']")
    WebElement ordersLink;

    @FindBy(xpath = "//button[@routerlink='/dashboard/cart']")
    WebElement cartLink;

    @FindBy(xpath=("//button[normalize-space()='Continue Shopping']"))
    WebElement CheckOutButton;


    //@FindBy(xpath="//div[@class='py-2 border-bottom ml-3 p-4']//div[@class='form-group ng-star-inserted']//input[@type='checkbox']//following-sibling::label[normalize-space()='electronics']")
    @FindBy(xpath = "(//input[@type='checkbox'])[13]")
    //@FindBy(xpath="//div[@class='py-2 border-bottom ml-3 p-4']//input[@type='checkbox']//following-sibling::label[text()[normalize-space() = 'electronics']]")
    WebElement electronicsCheckBox;

   @FindBy(xpath= "//b[normalize-space()='IPHONE 13 PRO']//parent::h5//following-sibling::button[2]//child::i[@class='fa fa-shopping-cart']")
   WebElement addToCartButton;


    //initializing the Page Objects:
    public HomePage() {
        PageFactory.initElements(driver, this);

    }

    public String verifyHomePageTitle() {
        return driver.getTitle();
    }

    public void getProductList() {

        for (WebElement product : productList) {

            System.out.println(product.getText());
        }
        //productList.stream().filter(product ->product.getText().equals("ZARA COAT 3"));
    }

    public void getCheckBoxesAndClick(){

        //for(WebElement checkBox : checkBoxes){
        for (int i = 0; i < checkBoxes.size(); i++) {
            if (checkBoxes.get(i).isDisplayed() && checkBoxes.get(i).isEnabled()) {
                System.out.println("Checkbox is displayed at index : " + i + " Clicking on it now");

                checkBoxes.get(i).click();
            }

            //System.out.println(checkBoxes.getText());
            //System.out.println(checkBoxes.isSelected());
            System.out.println(checkBoxes.size());

//            checkBox.click();
//            System.out.println(checkBox.isSelected());

        }

    }

      public void clickOnQAMeetupLink() {
          if (QAMeetupLink.isDisplayed()) {
              QAMeetupLink.click();
          }
    }

    public OrdersPage clickOnOrdersLink() {
        if (ordersLink.isDisplayed()) {
            ordersLink.click();
        }
        return new OrdersPage();

    }

    public CartPage clickOnCartLink() {
        if (cartLink.isDisplayed()) {
            cartLink.click();
        }

        return new CartPage();
    }


    public void selectElectronics () {
        if (electronicsCheckBox.isDisplayed() && electronicsCheckBox.isEnabled() && !electronicsCheckBox.isSelected()) {
            electronicsCheckBox.click();
        }}


    public void addToCartIphone () {
            if (addToCartButton.isDisplayed() && addToCartButton.isEnabled()) {
                addToCartButton.click();
            }




    }}



