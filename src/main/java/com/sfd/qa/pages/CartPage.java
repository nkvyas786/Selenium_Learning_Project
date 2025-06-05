package com.sfd.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class CartPage {
  WebDriver driver;
  LoginPage loginPage;
  HomePage homePage;

  //initializing the Page Objects:
  public CartPage(WebDriver driver){
    this.driver = driver;
    PageFactory.initElements(driver, this);
  }

  @FindBy(xpath = "//button[@routerlink='/dashboard/cart']")
  WebElement cartLink;

  @FindBy(xpath=("//button[normalize-space()='Checkout']"))
  WebElement checkOutBtn;

  public CartPage clickOnCartLink() {
    if (cartLink.isDisplayed()) {
      cartLink.click();
    }
    return new CartPage(driver);
  }

  public void clickOnCheckoutBtn() {
    if (checkOutBtn.isDisplayed() && checkOutBtn.isEnabled()) {
      checkOutBtn.click();
    }
  }

}
