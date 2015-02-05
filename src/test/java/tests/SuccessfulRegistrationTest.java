/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import static org.testng.Assert.*;
import org.testng.annotations.Test;
import price.registrationtest.pages.LoginFormPage;
import price.registrationtest.pages.MainPage;
import price.registrationtest.pages.UserIndexPage;

/**
 *
 * @author Konst
 */
public class SuccessfulRegistrationTest extends SetUpAndTearDown {

    public SuccessfulRegistrationTest() {
    }

    @Test
    public void user_name_should_be_displayed_when_registration_is_succsessful() throws InterruptedException {

        driver.get(baseURL);
        MainPage mainPage = new MainPage(driver);
        LoginFormPage loginPage = mainPage.login();
        UserIndexPage userPage = loginPage.enterUserPage(user);

        String name = userPage.getUserName(user);
        assertEquals(name, user.getName(), "Users name isn't correct, was found: " + name);

    }

}
