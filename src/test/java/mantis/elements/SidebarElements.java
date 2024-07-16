package mantis.elements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class SidebarElements {
    
    private WebDriver driver;

    public SidebarElements(WebDriver driver) {
        this.driver = driver;
    }
 
    public WebElement getSidebarMenu(){
        return driver.findElement(By.id("sidebar"));    
    }

}
