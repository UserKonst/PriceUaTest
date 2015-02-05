/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import org.openqa.selenium.By;
import static org.testng.Assert.*;
import org.testng.annotations.Test;
import price.registrationtest.customclasess.UserVariables;
import price.registrationtest.pages.GmailPage;
import price.registrationtest.pages.GooglePage;
import price.registrationtest.pages.LoginFormPage;
import price.registrationtest.pages.MainPage;
import price.registrationtest.pages.UserIndexPage;

/**
 *
 * @author Konst
 */
public class EmailRegistrationTest extends SetUpAndTearDown {

    public EmailRegistrationTest() {
    }

    @Test
    public void correct_message_should_be_displayed_when_activation_is_succsessful() throws InterruptedException {
        driver.get(baseURL);
        MainPage mainPage = new MainPage(driver);
        LoginFormPage loginPage = mainPage.login();
        loginPage.enterUserPage(user);

        GooglePage googlePage = new GooglePage(driver);
        GmailPage gmailPage = googlePage.enterGmail(user);
        UserIndexPage userPage = gmailPage.confirmRegistration();
        String message = userPage.getRegistrationMessage();
        assertTrue(message.contains("Аккаунт был активирован"),
                "Message isn't correct, was found: " + message);

    }

    @Test
    public void user_name_should_be_displayed_when_activation_is_succsessful() throws InterruptedException {
        driver.get(baseURL);
        MainPage mainPage = new MainPage(driver);
        LoginFormPage loginPage = mainPage.login();
        loginPage.enterUserPage(user);

        GooglePage googlePage = new GooglePage(driver);
        GmailPage gmailPage = googlePage.enterGmail(user);
        UserIndexPage userPage = gmailPage.confirmRegistration();
        String name = userPage.getUserName(user);
        assertEquals(name, user.getName(), "Users name isn't correct, was found: " + name);

    }

}
