package com.sfd.qa.pages;
import com.nar.qa.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class OrdersPage extends TestBase {

    @FindBy(xpath = "(//div[@class='container table-responsive py-5']/div")
    WebElement NoOrderText;

    @FindBy(xpath="//button[@routerlink='/dashboard']")
    public WebElement homeButton;

    @FindBy(xpath="//button[@routerlink='/dashboard/myorders']")
    WebElement cartButton;

    @FindBy(xpath="//th[@scope='row']")
    List<WebElement>listOfOrderIds;


    public OrdersPage() {

        PageFactory.initElements(driver, this);
    }

    public void getNoOrderText() {

        NoOrderText.getText();
    }

    public HomePage clickOnHomeButton() {
    	homeButton.click();
        return new HomePage();
    }

    public CartPage clickOnCartButton() {
    	cartButton.click();

        return new CartPage();
    }
    public void getAllOrderIds() {

        for (WebElement orderId : listOfOrderIds) {
            //System.out.println(orderId.getSize());
            System.out.println(orderId.getText());
        }

    }



    }




