package com.sfd.qa.pages;

import com.nar.qa.base.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage extends TestBase {


    @FindBy(xpath=("//h1[normalize-space()='My Cart'][1]"))
    WebElement MyCartText;

    @FindBy(xpath = ("//h1[normalize-space()='No Products in Your Cart !']"))
    WebElement NoProductsInCartText;

    @FindBy(xpath=("//button[@type='button']"))
    WebElement ContinueShoppingButton;

    @FindBy(xpath=("//button[normalize-space()='Checkout']"))
    WebElement CheckOutButton;

    public CartPage() {

    PageFactory.initElements(driver, this);

    }

    public String verifyMyCartText() {
        return MyCartText.getText();
    }

    public String verifyNoProductsInCartText() {
        if (NoProductsInCartText.isDisplayed() && NoProductsInCartText.isEnabled()) {
            return NoProductsInCartText.getText();
        }
        return NoProductsInCartText.getText();
    }

    public HomePage clickContinueShoppingButton() {
        ContinueShoppingButton.click();

        return new HomePage();
    }

    public OrdersPage actionCheckOutButton() {
        if (CheckOutButton.isDisplayed() && CheckOutButton.isEnabled()) {
         CheckOutButton.click();
     }
        return  new OrdersPage();








}}
