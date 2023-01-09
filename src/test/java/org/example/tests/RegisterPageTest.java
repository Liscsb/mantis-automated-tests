package org.example.tests;

import org.example.pages.RegisterPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RegisterPageTest {
    private RegisterPage registerPage;
    private final String URL = "https://automationexercise.com/login";

    @BeforeEach
    void setUp() throws Exception {
        this.registerPage = new RegisterPage();
        this.registerPage.visit(this.URL);
    }

    @AfterEach
    void tearDown() throws Exception {
        //this.registerPage.quitWebDriver();
    }

    @Test
    void wenRegisterNewUserSignupSuccess() {
        // when
        this.registerPage.register();
        // then
        Assertions.assertTrue(this.registerPage.getBtnCreateAccount().equals("Create Account"));
    }

    @Test
    void whenRegisterNewUserAccountSuccess() {
        // when
        this.registerPage.fillOutForm();
        // then
        String expected = "ACCOUNT CREATED!";
        String actual = this.registerPage.getAccountCreateMessage();
        Assertions.assertEquals(expected, actual);

        String actualUrl = this.registerPage.getCurrentUrl();
        Assertions.assertFalse(this.URL.equals(actualUrl));
    }
}
