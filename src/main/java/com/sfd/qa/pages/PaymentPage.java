package com.sfd.qa.pages;

import com.nar.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PaymentPage extends TestBase {

    @FindBy(xpath="//div[@class='payment__type payment__type--cc active']")
    WebElement creditCardButton;


    @FindBy(xpath="//div[normalize-space()='Expiry Date']//parent::div//child::select[1]")
    WebElement monthDropdown;

    @FindBy(xpath="//div[normalize-space()='Expiry Date']//parent::div//child::select[2]")
    WebElement yearDropdown;


    @FindBy(xpath="//div[@class='field small']//child::input[@class='input txt']")
    WebElement cvvField;

    @FindBy(xpath="//div[@class='field']//child::div[@class='title']//following-sibling::input[@class='input txt']")
    WebElement customerNameField;

    @FindBy(xpath="//div[@class='form-group']/input[@class='input txt text-validated']")
    WebElement countryField;

    @FindBy(xpath="//span[normalize-space()='India']")
    WebElement optionIndia;

    @FindBy(xpath="//a[@class='btnn action__submit ng-star-inserted']")
    WebElement placeOrderButton;



    public PaymentPage() {
        PageFactory.initElements(driver, this);

    }


    public ConfirmationPage placeOrder() {

        if (creditCardButton.isDisplayed() && !creditCardButton.isEnabled()) {
           creditCardButton.click();
    }

    if (monthDropdown.isDisplayed() && monthDropdown.isEnabled()) {
        Select select = new Select(monthDropdown);
        select.selectByVisibleText("09");

    }

    if (yearDropdown.isDisplayed() && yearDropdown.isEnabled()) {
        Select select = new Select(yearDropdown);
        select.selectByVisibleText("25");

    }

    if (cvvField.isDisplayed() && cvvField.isEnabled()) {
        cvvField.sendKeys("123");
    }

    if (customerNameField.isDisplayed() && customerNameField.isEnabled()) {
        customerNameField.sendKeys("Narayanan");
    }

    if (countryField.isDisplayed() && countryField.isEnabled()) {

        countryField.sendKeys("India");

        if (optionIndia.isDisplayed() && optionIndia.isEnabled()) {
            optionIndia.click();
        }

    }

    placeOrderButton.click();

    return new ConfirmationPage();

    }}
