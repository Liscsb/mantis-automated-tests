package org.example.pages;

import org.openqa.selenium.By;

public class LoginPage extends BasePage {

    // Locators
    private By emailAddressLocator = By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/input[2]");
    private By passwordLocator = By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/input[3]");
    private By submitBtnLocator = By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/button");
    private By logoutBtnLocator = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a");

    public void signIn() {
        if(super.isDisplayed(emailAddressLocator)) {
            super.type("bruno.outroscontatos@gmail.com", emailAddressLocator);
            super.type("DYC5RjzwRzC", passwordLocator);
            super.click(submitBtnLocator);
        } else {
            System.out.println("username textbox was not present");
        }
    }

    public String getBtnLogout() {
        return super.getText(logoutBtnLocator);
    }

}
