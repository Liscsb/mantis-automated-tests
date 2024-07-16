package mantis.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CriarTarefaElements {
     private WebDriver driver;

    public CriarTarefaElements(WebDriver driver) {
        this.driver = driver;
    }
    
    public WebElement getCategoryMenu() {
        return driver.findElement(By.id("category_id"));
    }

    public WebElement getSummaryField() {
        return driver.findElement(By.id("summary"));
    }

    public WebElement getDescriptionField() {
        return driver.findElement(By.id("description"));
    }

    public WebElement getCreateNewTaskButton() {
        return driver.findElement(By.cssSelector("[value=\"Criar Nova Tarefa\"]"));
    }

    public WebElement getReproducibilityMenu() {
        return driver.findElement(By.id("reproducibility"));
    }

    public WebElement getSeverityMenu() {
        return driver.findElement(By.id("severity"));
    }

    public WebElement getPriorityMenu() {
        return driver.findElement(By.id("priority"));
    }

}
