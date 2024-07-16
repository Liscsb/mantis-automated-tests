package mantis.elements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class MinhaVisaoElements {
    public static final String MINHA_VISAO_PAGE_TITLE = "Minha Visão - MantisBT";
    
    private WebDriver driver;

    public MinhaVisaoElements(WebDriver driver) {
        this.driver = driver;
    }
 
    public WebElement getUnassignedTasksTable(){
        return driver.findElement(By.id("unassigned"));
    }

    public WebElement getReportedByMeTasksTable(){
        return driver.findElement(By.id("reported"));
    }

    public WebElement getRecentModifiedTasksTable(){
        return driver.findElement(By.id("recent_mod"));
    }
    
    public WebElement getMonitoredByMeTasksTable(){
        return driver.findElement(By.id("monitored"));
    }

    public WebElement getTimelineTasksTable(){
        return driver.findElement(By.id("timeline"));
    }
}
