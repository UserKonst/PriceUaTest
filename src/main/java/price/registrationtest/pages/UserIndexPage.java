/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package price.registrationtest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import price.registrationtest.customclasess.User;

/**
 *
 * @author Konst
 */
public class UserIndexPage {

    public WebDriver driver;

    public UserIndexPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getUserName(User user) {
        String userName = driver.findElement(By.
                xpath("//span[text()='" + user.getName() + "']")).getText();

        return userName;
    }

    public String getRegistrationMessage() {
        String text = driver.
                findElement(By.xpath("//div[@class='alert in alert-block fade alert-error']")).getText();

        return text;
    }

}
