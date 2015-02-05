/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package price.registrationtest.pages;

import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 *
 * @author Konst
 */
public class GmailPage {

    public WebDriver driver;
    String parentHandler;

    public GmailPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public GmailPage() {
    }

    @FindBy(partialLinkText = "Входящие")
    private WebElement linkIncoming;

    @FindBy(xpath = "//span[contains(text(),'Добро пожаловать на Price.ua')]")
    private WebElement textWellCome;

    @FindBy(partialLinkText = "http://price.ua/user/confirm")
    private WebElement linkConfirm;

    public UserIndexPage confirmRegistration() {
        textWellCome.click();
        linkConfirm.click();

        WebDriver newWindowDriver = switchToNewWindow();
//        String text = newWindowDriver.
//                findElement(By.xpath("//div[@class='alert in alert-block fade alert-error']")).getText();
//
//        return text;
        return new UserIndexPage(newWindowDriver);
    }

    public String getRegistrationMessage() {
        WebDriver newWindowDriver = switchToNewWindow();
        String text = newWindowDriver.
                findElement(By.xpath("//div[@class='alert in alert-block fade alert-error']")).getText();

        return text;
    }

    public String getUserName() {
        WebDriver newWindowDriver = switchToNewWindow();
        String text = newWindowDriver.
                findElement(By.xpath("//a[@id='header-user-link']/span")).getText();

        return text;
    }

    public WebDriver switchToNewWindow() {
        WebDriver newWindowDriver = null;
        parentHandler = driver.getWindowHandle();
        Set<String> allHendlers = driver.getWindowHandles();
        for (String currentHandler : allHendlers) {
            newWindowDriver = driver.switchTo().window(currentHandler);
            if (!currentHandler.equals(parentHandler)) {
                break;
            }
        }
        return newWindowDriver;
    }
}
