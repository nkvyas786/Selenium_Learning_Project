package com.sfd.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage extends TestBase {


    @FindBy(css = ".col-lg-4")
    List<WebElement> productList;

    @FindBy(xpath = "//input[@type='checkbox']")
    List<WebElement> checkBoxes;


    public HomePage() {

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



}
