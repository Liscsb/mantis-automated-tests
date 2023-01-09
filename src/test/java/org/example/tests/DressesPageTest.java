package org.example.tests;

import org.example.pages.DressesPage;
import org.example.pages.LoginPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DressesPageTest {
    private DressesPage dressesPage;
    private final String URL = "https://automationexercise.com/";

    @BeforeEach
    void setUp() throws Exception {
        this.dressesPage = new DressesPage();
        this.dressesPage.visit(this.URL);
    }

    @AfterEach
    void tearDown() throws Exception {
        this.dressesPage.quitWebDriver();
    }

    @Test
    void test() {
        // when
        this.dressesPage.viewWomanDressesPage();
        // then
        Assertions.assertEquals("Women - Dress Products", this.dressesPage.getTitlePage());
        Assertions.assertFalse(this.URL.equals(dressesPage.getCurrentUrl()));
    }
}
