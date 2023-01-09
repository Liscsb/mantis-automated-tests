package org.example.pages;

import org.openqa.selenium.By;

public class DressesPage extends BasePage {
    // Locators

    private By menuWomanDressesLocator = By.cssSelector("#Women");
    private By submenuWomanDressesLocator = By.cssSelector("#Women > div > ul > li:nth-child(1)");
    private By titlePageWomanDressesLocator = By.cssSelector("body > section > div > div.row > div.col-sm-9.padding-right > div > h2");


    public void viewWomanDressesPage() {
        if(super.isDisplayed(menuWomanDressesLocator)) {
            super.click(menuWomanDressesLocator);
            super.click(submenuWomanDressesLocator);
        } else {
            System.out.println("menu dresses was not found");
        }
    }

    public String getTitlePage() {
        return super.getText(titlePageWomanDressesLocator);
    }



}
