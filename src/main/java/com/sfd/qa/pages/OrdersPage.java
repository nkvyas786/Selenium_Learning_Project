package com.sfd.qa.pages;
import com.nar.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrdersPage extends TestBase {

    @FindBy(xpath = "(//div[@class='container table-responsive py-5']/div")
    WebElement NoOrderText;

    public OrdersPage() {
        PageFactory.initElements(driver, this);
    }

    public void getNoOrderText() {

        NoOrderText.getText();
    }









}
