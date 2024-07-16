package mantis.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import mantis.elements.LoginElements;

public class LoginPage {
    private WebDriver driver;
    private LoginElements elements;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.elements = new LoginElements(driver);
    }

    public void enterUsername(String username) {
        elements.getUsernameField().sendKeys(username);
    }

    public void clickEntrar() {
       elements.getEntrarButton().click();
    }

    public void enterPassword(String password) {
       elements.getPasswordField().sendKeys(password);
    }

    
    public void unselectSecureSessionCheckbox() {
        WebElement secureSessionCheckBoxElement = elements.getSecureSessionCheckbox();
        Boolean isSelected = secureSessionCheckBoxElement.isSelected();
        if(isSelected == true) {
            try {               
                secureSessionCheckBoxElement.click();
            } catch (Exception e) {
                JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;              
                jsExecutor.executeScript("arguments[0].click();", secureSessionCheckBoxElement);
            }
        }
    }

}