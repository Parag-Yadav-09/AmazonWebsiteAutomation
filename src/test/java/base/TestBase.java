package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import utilities.ConfigFileReader;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class TestBase {

    protected WebDriver driver;
    public Logger logger = Logger.getLogger("OnlineShopping");
    ConfigFileReader configFileReader;

    @BeforeTest
    public void LaunchBrowser() {
    	
        try {
        	
        	configFileReader = new ConfigFileReader();
            System.setProperty("webdriver.chrome.driver", configFileReader.getDriverPath());
            driver = new ChromeDriver();
            logger.info("Drivers Initialised");

            driver.get(configFileReader.getApplicationUrl());
            logger.info("Browser Opened");
            driver.manage().window().maximize();
            logger.info("Window Maximized");
            
        }catch (Exception e){
            e.printStackTrace();
        }
        
        driver.manage().timeouts().implicitlyWait(configFileReader.getImplicitlyWait(), TimeUnit.SECONDS);
    }

    @AfterTest
    public void CloseBrowser() {

    	logger.info("Execution Completed");
        driver.quit();

    }
}
