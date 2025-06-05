package com.sfd.qa.pages;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import com.nar.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.util.List;

public class LoginPage {

    WebDriver driver;

    //PageFactoryConfiguration
    @FindBy(id = "userEmail")
    WebElement username;

    @FindBy(id = "userPassword")
    WebElement password;

    @FindBy(id = "login")
    WebElement loginButton;

    @FindBy(tagName = "a")
    List<WebElement> links;


    //initializing the Page Objects:
    public LoginPage(WebDriver driver){
        //super();
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @Step("Login with username & password")
    public HomePage loginApplication(String email, String passWord) throws IOException {
        try {
            username.sendKeys(email);
            password.sendKeys(passWord);
            loginButton.click();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return new HomePage(driver);
        }

    public String PageTitle() {
       return driver.getTitle();
    }

    public String validateCurrentURL() {
        return driver.getCurrentUrl();
    }

    public int GetAllLinks() {
//        for (WebElement link : links) {
//            System.out.println(link.getText());
//        }
        System.out.println("------in page----"+links.size());
        return links.size();
    }
}
