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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import price.registrationtest.customclasess.User;

/**
 *
 * @author Konst
 */
public class LoginFormPage {

    public WebDriver driver;

    public LoginFormPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "LoginForm_username")
    private WebElement fieldEmail;

    @FindBy(id = "login_user_password")
    private WebElement fieldPassword;

    @FindBy(xpath = "//a[@data-type='login'][text()='Вход']")
    private WebElement buttonEnter;

    @FindBy(xpath = "//div[@class='error-text']"
            + "[preceding-sibling::input[@id='login_user_password']]")
    private WebElement errorMessage;

    public void enterEmail(String email) {
        fieldEmail.sendKeys(email);
    }

    public void enterPassword(String password) {
        fieldPassword.sendKeys(password);
    }

    public void pressButtonEnter() {
        buttonEnter.click();
    }

    public String getErrorMessage() {
        return errorMessage.getText();
    }

    public boolean isErrorMessagePresent() {
        return errorMessage.isDisplayed();
    }

    public UserIndexPage enterUserPage(User user) {

        fieldEmail.sendKeys(user.getEmail());
        fieldPassword.sendKeys(user.getPassword());
        buttonEnter.click();

        new WebDriverWait(driver, 10).
                until(ExpectedConditions.
                        visibilityOfElementLocated(By.xpath("//span[text()='" + user.getName() + "']")));

        return new UserIndexPage(driver);
    }
}
