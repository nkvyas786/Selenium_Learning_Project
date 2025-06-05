package com.sfd.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CartPage {
  WebDriver driver;

  //initializing the Page Objects:
  public CartPage(WebDriver driver){
    //super();
    this.driver = driver;
    PageFactory.initElements(driver, this);
  }

}
