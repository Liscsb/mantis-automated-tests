package mantis.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginElements {

    private WebDriver driver;

    public LoginElements(WebDriver driver) {
        this.driver = driver;
    }
    
    public WebElement getUsernameField() {
        return driver.findElement(By.id("username"));
    }

    public WebElement getPasswordField() {
        return driver.findElement(By.id("password"));
    }

    public WebElement getEntrarButton() {
        return driver.findElement(By.cssSelector("input[type='submit']"));
    }

    public WebElement getSecureSessionCheckbox() {
        return driver.findElement(By.id("secure-session"));
    }

}