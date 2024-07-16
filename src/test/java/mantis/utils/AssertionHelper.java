package mantis.utils;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class AssertionHelper {
    private WebDriver driver;
   
    public AssertionHelper(WebDriver driver) {
        this.driver = driver;
    }

    public void validarTituloDaPagina(String title) {        
        Assert.assertTrue(driver.getTitle().contains(title)); 
    }
   
}
