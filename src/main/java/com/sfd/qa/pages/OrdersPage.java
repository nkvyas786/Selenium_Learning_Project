package com.sfd.qa.pages;
import com.nar.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrdersPage extends TestBase {

    @FindBy(xpath = "(//div[@class='mt-4 ng-star-inserted'])[1]")
    WebElement NoOrderText;


    public OrdersPage() {
        PageFactory.initElements(driver, this);
    }

    public String getNoOrderText() {
        return NoOrderText.getText();
    }









}
