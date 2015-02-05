/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package price.registrationtest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import price.registrationtest.customclasess.User;

/**
 *
 * @author Konst
 */
public class GooglePage {

    public WebDriver driver;

    public GooglePage() {
    }

    public GooglePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        driver.get("https://www.google.com.ua");
    }

    @FindBy(id = "Email")
    private WebElement fieldEmail;

    @FindBy(id = "Passwd")
    private WebElement fieldPass;

    @FindBy(id = "signIn")
    private WebElement buttonEnter;

    @FindBy(xpath = "//a[text()='Увійти']")
    private WebElement linkEnter;

    @FindBy(xpath = "//input[@value='Ні, дякую']")
    private WebElement linkNoThanks;

    public GmailPage enterGmail(User user) {
        linkEnter.click();
        fieldEmail.sendKeys(user.getEmail());
        fieldPass.sendKeys(user.getPassword());
        buttonEnter.click();
        //linkNoThanks.click();
        driver.findElement(By.xpath("//a[text()='Почта']")).click();
        return new GmailPage(driver);
    }

}
