package com.sfd.qa.pages;

import com.nar.qa.base.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.util.List;

public class HomePage extends TestBase {

    WebDriver driver;

    @FindBy(css = ".col-lg-4")
    List<WebElement> productList;

    @FindBy(xpath = "//input[@type='checkbox']")
    List<WebElement> checkBoxes;

    @FindBy(linkText = "QA Meetup with Rahul Shetty @Pune - Limited Seats! Book Now!")
    WebElement QAMeetupLink;


    public HomePage() throws IOException {
        super();

        PageFactory.initElements(driver, this);

    }

    public void getProductList() {

        for (WebElement product : productList) {

            System.out.println(product.getText());
        }
        //productList.stream().filter(product ->product.getText().equals("ZARA COAT 3"));
    }

    public void getCheckBoxes(){

        for(WebElement checkBox : checkBoxes){

            System.out.println(checkBox.getText());
            System.out.println(checkBox.isSelected());
            System.out.println(checkBoxes.size());
        }


      }

      public void clickOnQAMeetupLink(){
          if(QAMeetupLink.isDisplayed()){
              QAMeetupLink.click();
          }





      }}



