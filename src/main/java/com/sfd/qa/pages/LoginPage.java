package com.sfd.qa.pages;
import org.openqa.selenium.WebDriver;
import com.nar.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.util.List;

public class LoginPage extends TestBase{


    //PageFactoryConfiguration
    @FindBy(id = "userEmail")
    @CacheLookup  // Will pick that element from cache memory instead of DOM but in this case
            // element got refreshed on DOM that CacheLookUp will be failed as it's directly picking from cache
            //instead of DOM but it will make our execution fast
    WebElement username;

    @FindBy(id = "userPassword")
    WebElement password;

    @FindBy(id = "login")
    WebElement loginButton;

    @FindBy(tagName = "a")
    List<WebElement> links;


    //initializing the Page Objects:
    public LoginPage(){
        //super();

        PageFactory.initElements(driver, this);
    }

    public HomePage loginApplication(String email, String passWord) throws IOException {

        try {
            username.sendKeys(email);
            Thread.sleep(2000);
            password.sendKeys(passWord);
            Thread.sleep(2000);
            loginButton.click();
            Thread.sleep(2000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new HomePage();

        }

    public String PageTitle() {

       return driver.getTitle();
    }
    public String validateCurrentURL() {

        return driver.getCurrentUrl();

    }
    public void GetAllLinks() {
        for (WebElement link : links) {
            System.out.println(link.getText());
        }
    }

}
