package com.sfd.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.nar.qa.base.TestBase.driver;

public class ConfirmationPage {


    @FindBy(xpath = "//label[@routerlink= '/dashboard/myorders']")
    WebElement orderHistory;

    @FindBy(xpath = "//button[normalize-space()= 'Click To Download Order Details in CSV']")
    WebElement downloadButton;

    @FindBy(xpath = "//h1[normalize-space()= 'Thankyou for the order.']']")
    WebElement OrderConfirmationText;

    public ConfirmationPage() {
        PageFactory.initElements(driver, this);
    }

    public String getConfirmationText() {
        return OrderConfirmationText.getText();
    }

    public OrdersPage clickOnOrderHistory() {
        if (!orderHistory.isEnabled() && !orderHistory.isDisplayed()) {
            throw new RuntimeException("Order History button is not enabled or displayed");
        }
        orderHistory.click();
        return new OrdersPage();
    }



    public void clickOnDownloadButton() {
        downloadButton.click();
    }






}
