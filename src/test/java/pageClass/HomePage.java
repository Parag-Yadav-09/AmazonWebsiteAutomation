package pageClass;

import utilities.SeleniumUtils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class HomePage extends TestBase {

    public static WebDriver driver;
    SeleniumUtils seleniumUtils;
    
    @FindBy(xpath = "//input[@id='twotabsearchtextbox']")
    private WebElement searchField;
    
    @FindBy(xpath = "//span[input[@id='nav-search-submit-button']]")
    private WebElement searchButton;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        seleniumUtils = new SeleniumUtils(driver);
        PageFactory.initElements(driver, this);
    }
    
    public void enterTextInSearchField(String productName) {
    	seleniumUtils.sendkeys(searchField, productName);
    }
    
    public void clickSearchButton(){
        seleniumUtils.click(searchButton);
    }

}
