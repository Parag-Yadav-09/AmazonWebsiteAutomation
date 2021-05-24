package pageClass;

import utilities.SeleniumUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.TestBase;

public class CartPage extends TestBase {

    public static WebDriver driver;
    SeleniumUtils seleniumUtils;

    @FindBy(xpath = "//span[@id='sc-subtotal-amount-buybox']")
    private WebElement totalAmount;

    public CartPage(WebDriver driver) {
        this.driver = driver;
        seleniumUtils = new SeleniumUtils(driver);
        PageFactory.initElements(driver, this);
    }

    public String gettotalAmount(){
        return seleniumUtils.getText(totalAmount);
    }

}
