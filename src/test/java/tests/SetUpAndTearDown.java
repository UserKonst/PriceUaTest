/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import java.io.File;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import price.registrationtest.customclasess.User;
import price.registrationtest.customclasess.UserVariables;

/**
 *
 * @author Konst
 */
public class SetUpAndTearDown {

    public SetUpAndTearDown() {
    }

    public WebDriver driver;
    public FirefoxProfile profile;
    public String baseURL = UserVariables.getInstance().getBaseURL();
    User user = new User();
    
    
    
    @BeforeClass
    public void SetUp() {

        String browser = System.getProperty("browser");

        switch (browser) {

            case "firefox":
                File file = new File("D:\\Fprofile");
                profile = new FirefoxProfile(file);
                driver = new FirefoxDriver(profile);
                break;

            case "chrome":
                driver = new ChromeDriver();
                break;

            default:
                driver = new ChromeDriver();

        }

        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();

    }

    @AfterClass
    public void TearDown() {
        driver.manage().deleteAllCookies();
        driver.quit();
    }
}
