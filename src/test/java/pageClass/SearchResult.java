package pageClass;

import utilities.SeleniumUtils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class SearchResult extends TestBase {

    public static WebDriver driver;
    SeleniumUtils seleniumUtils;
    
    @FindBy(xpath = "(//span[@class='a-price-whole'])[3]")
    private WebElement searchedProductPrice;
    
    @FindBy(xpath = "(//span[@class='a-price-whole'])[3]")
    private WebElement productPrice; 

    public SearchResult(WebDriver driver) {
        this.driver = driver;
        seleniumUtils = new SeleniumUtils(driver);
        PageFactory.initElements(driver, this);
    }

    public void clickSearchedProduct(){
        seleniumUtils.click(searchedProductPrice);
    }

    public String getSearchedProductPrice(){
        return seleniumUtils.getText(searchedProductPrice);
    }
    
    public String getProductPrice(){
    	return seleniumUtils.getText(productPrice);
    }

}
