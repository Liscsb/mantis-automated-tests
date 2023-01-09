package org.example.pages;

import org.openqa.selenium.By;

public class RegisterPage extends BasePage {
    // Locators
    private By nameLocator = By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/input[2]");
    private By emailAddressLocator = By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/input[3]");
    private By submitBtnLocator = By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/button");
    private By addressInformationLocator = By.xpath("//*[@id=\"form\"]/div/div/div/div[1]/form/p[4]/label/span");

    // Locators ENTER ACCOUNT INFORMATION
    private By genderManLocator = By.xpath("//*[@id=\"form\"]/div/div/div/div/form/div[1]/div[1]/label");
    private By genderWomanLocator = By.xpath("//*[@id=\"form\"]/div/div/div/div/form/div[1]/div[2]/label");
    private By passwordLocator = By.xpath("//*[@id=\"password\"]");
    private By daysLocator = By.xpath("//*[@id=\"days\"]");
    private By monthLocator = By.xpath("//*[@id=\"months\"]");
    private By yearLocator = By.xpath("//*[@id=\"years\"]");
    private By newsletterLocator = By.xpath("//*[@id=\"form\"]/div/div/div/div/form/div[6]/label");
    private By receiveLocator = By.xpath("//*[@id=\"form\"]/div/div/div/div/form/div[7]/label");
    // Locators ADDRESS INFORMATION
    private By firstNameLocator = By.xpath("//*[@id=\"first_name\"]");
    private By lastNameLocator = By.xpath("//*[@id=\"last_name\"]");
    private By companyLocator = By.xpath("//*[@id=\"company\"]");
    private By addressLocator = By.xpath("//*[@id=\"address1\"]");
    private By address2Locator = By.xpath("//*[@id=\"address2\"]");
    private By countryLocator = By.xpath("//*[@id=\"country\"]");
    private By stateLocator = By.xpath("//*[@id=\"state\"]");
    private By cityLocator = By.xpath("//*[@id=\"city\"]");
    private By zipcodeLocator = By.xpath("//*[@id=\"zipcode\"]");
    private By mobileNumberLocator = By.xpath("//*[@id=\"mobile_number\"]");
    private By createAccountBtnLocator = By.xpath("//*[@id=\"form\"]/div/div/div/div/form/button");
    // Locators ACCOUNT CREATED!
    private By createAccountInformationLocator = By.xpath("//*[@id=\"form\"]/div/div/div/h2/b");

    public void register() {
        if(super.isDisplayed(emailAddressLocator)) {
            super.type("Bruno Henrique", nameLocator);
            super.type("bruno.dorea121212@gmail.com", emailAddressLocator);
            super.click(submitBtnLocator);
        } else {
            System.out.println("email text box was not present");
        }
    }
    public String getEmailNewAccount() {
        super.waitVisibilityOfElementLocated(addressInformationLocator);
        return super.getTextByAttribute(this.emailAddressLocator, "value");
    }

    public String getBtnCreateAccount() {
        return super.getText(createAccountBtnLocator);
    }

    public void fillOutForm() {
        this.register();
        super.waitVisibilityOfElementLocated(createAccountBtnLocator);
        if(isDisplayed(genderManLocator)) {
            super.click(genderManLocator);
            super.type("123456!", passwordLocator);
            super.selectByValue(daysLocator, "14");
            super.selectByValue(monthLocator, "5");
            super.selectByValue(yearLocator, "1994");
            super.click(newsletterLocator);
            super.click(receiveLocator);
            super.type("Bruno", firstNameLocator);
            super.type("Henrique", lastNameLocator);
            super.type("BH Tec", companyLocator);
            super.type("Avenida Pensilvânia, 1600",addressLocator);
            super.type("",address2Locator);
            super.selectByValue(countryLocator, "United States");
            super.type("Colúmbia", stateLocator);
            super.type("Washington", cityLocator);
            super.type("20500", zipcodeLocator);
            super.type("999999999", mobileNumberLocator);
            super.click(createAccountBtnLocator);
        } else {
            System.out.println("buttom create acoount was not found");
        }
    }

    public String getAccountCreateMessage() {
        super.waitVisibilityOfElementLocated(createAccountInformationLocator);
        return super.getText(createAccountInformationLocator);
    }

}
