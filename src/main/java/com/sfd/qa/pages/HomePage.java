package com.sfd.qa.pages;

import com.nar.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage extends TestBase {

  @FindBy(css = ".col-lg-4")
  List<WebElement> productList;

  @FindBy(xpath = "//input[@type='checkbox']")
  List<WebElement> checkBoxes;

  @FindBy(linkText = "QA Meetup with Rahul Shetty @Pune - Limited Seats! Book Now!")
  WebElement QAMeetupLink;

  @FindBy(xpath = "//button[@routerlink='/dashboard/myorders']")
  WebElement ordersLink;

  @FindBy(xpath = "//button[@routerlink='/dashboard/cart']")
  WebElement cartLink;

  @FindBy(xpath = "//button[text()=' Sign Out ']")
  WebElement signOutBtn;

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

  public void getCheckBoxesAndClick() {
    for (WebElement checkBox : checkBoxes) {
      System.out.println(checkBox.getText());
      System.out.println(checkBox.isSelected());
      System.out.println(checkBoxes.size());

      checkBox.click();
      System.out.println(checkBox.isSelected());
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

  public boolean isSignOutBtnDisplayed() {
    return signOutBtn.isDisplayed();
  }

  public void clickOnSignOutBtn() {
    if (isSignOutBtnDisplayed()) {
      signOutBtn.click();
    }
  }

}



