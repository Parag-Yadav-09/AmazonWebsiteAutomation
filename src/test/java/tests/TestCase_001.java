package tests;

import pageClass.*;
import utilities.SeleniumUtils;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.TestBase;

public class TestCase_001 extends TestBase {

    @Test
    public void placeOrder() throws InterruptedException {

    	SeleniumUtils seleniumUtils = new SeleniumUtils(driver);
    	
        HomePage hPage = new HomePage(driver);
        SearchResult rPage = new SearchResult(driver);
        ProductPage pPage = new ProductPage(driver);
        CartPage cPage = new CartPage(driver);

        //Step 1: Enter text in search field & search
        hPage.enterTextInSearchField("QA testing for beginners");
        hPage.clickSearchButton();

        //Step 2: Click on the Product
        String productPrice = rPage.getProductPrice();
        rPage.clickSearchedProduct();        

        //Step 3: Verify Product Price & Click Add to Cart
        seleniumUtils.switchTab();
        String displayedPrice = pPage.getProductPriceFromProductDetailsScreen();
        Assert.assertEquals(true, displayedPrice.contains(productPrice), "Correct Price not reflecting on Product Details screen");
        pPage.clickAddToCartButton();

        //Step 4: Verify Product Price & Click Proceed to Buy
        String printedPrice = pPage.getProductPriceFromProceedToBuyScreen();
        Assert.assertEquals(true, printedPrice.contains(printedPrice), "Correct Price not reflecting on Proceed to buy screen");
        pPage.clickCartButton();

        //Step 5: Verify the Product Price on Cart screen
        String totalPrice = cPage.gettotalAmount();
        Assert.assertEquals(true, totalPrice.contains(productPrice), "Correct Price not reflecting on Cart screen");

    }

}