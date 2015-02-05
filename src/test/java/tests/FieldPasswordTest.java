package tests;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import static org.testng.Assert.*;
import org.testng.annotations.Test;
import price.registrationtest.pages.LoginFormPage;
import price.registrationtest.pages.MainPage;
import price.registrationtest.pages.UserIndexPage;

/**
 *
 * @author Konst
 */
public class FieldPasswordTest extends SetUpAndTearDown {

    private final String email;
    private final String pass;

    public FieldPasswordTest() {
        this.email = user.getEmail();
        this.pass = user.getPassword();
    }

    @Test
    public void empty_field_password_should_return_error_message() {

        driver.get(baseURL);
        MainPage mainPage = new MainPage(driver);
        LoginFormPage loginPage = mainPage.login();
        loginPage.enterEmail(email);
        loginPage.enterPassword("");
        loginPage.pressButtonEnter();
        assertTrue(loginPage.isErrorMessagePresent(), "The error message didn't appear");
    }

    @Test
    public void empty_field_password_should_return_error_message_with_text() {

        driver.get(baseURL);
        MainPage mainPage = new MainPage(driver);
        LoginFormPage loginPage = mainPage.login();
        loginPage.enterEmail(email);
        loginPage.enterPassword("");
        loginPage.pressButtonEnter();
        String message = loginPage.getErrorMessage();
        assertEquals(message, "Необходимо заполнить поле «Пароль».",
                "The error message doesn't correct");

    }

    @Test
    public void user_should_login_with_correct_password() {

        driver.get(baseURL);
        MainPage mainPage = new MainPage(driver);
        LoginFormPage loginPage = mainPage.login();
        UserIndexPage userPage = loginPage.enterUserPage(user);

        String name = userPage.getUserName(user);
        assertEquals(name, user.getName(), "User didn't enter the index page");

    }

    @Test
    public void should_be_error_when_email_and_pass_are_replaced() {

        driver.get(baseURL);
        MainPage mainPage = new MainPage(driver);
        LoginFormPage loginPage = mainPage.login();
        loginPage.enterEmail(pass);
        loginPage.enterPassword(email);
        loginPage.pressButtonEnter();

        assertTrue(loginPage.isErrorMessagePresent(), "The error message didn't appear");

    }

    @Test
    public void should_be_error_when_user_type_character_sequence_in_field_password() {

        driver.get(baseURL);
        MainPage mainPage = new MainPage(driver);
        LoginFormPage loginPage = mainPage.login();
        loginPage.enterEmail(email);
        loginPage.enterPassword(" “♣☺♂” , “”‘~!@#$%^&*()?>,./\\<][ /*<!–“”, “${code}”;–>");
        loginPage.pressButtonEnter();

        String message = loginPage.getErrorMessage();
        assertEquals(message, "Неверное имя пользователя или пароль.",
                "The error message doesn't correct, was found: " + message);

    }

    @Test
    public void should_be_error_when_user_type_script_in_field_password() {

        driver.get(baseURL);
        MainPage mainPage = new MainPage(driver);
        LoginFormPage loginPage = mainPage.login();
        loginPage.enterEmail(email);
        loginPage.enterPassword("<script>alert(123)</script>");
        loginPage.pressButtonEnter();

        String message = loginPage.getErrorMessage();
        assertEquals(message, "Неверное имя пользователя или пароль.",
                "The error message doesn't correct, was found: " + message);

    }

    @Test
    public void should_be_error_when_user_type_whitespaces_in_field_password() {

        driver.get(baseURL);
        MainPage mainPage = new MainPage(driver);
        LoginFormPage loginPage = mainPage.login();
        loginPage.enterEmail(email);
        loginPage.enterPassword("           ");
        loginPage.pressButtonEnter();

        String message = loginPage.getErrorMessage();
        assertEquals(message, "Необходимо заполнить поле «Пароль».",
                "The error message doesn't correct, was found: " + message);
    }

}
