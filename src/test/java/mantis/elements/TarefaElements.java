package mantis.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TarefaElements {
    private WebDriver driver;

    public TarefaElements(WebDriver driver) {
        this.driver = driver;
    }
    
    public WebElement getBugNotes() {
        return driver.findElement(By.id("bugnotes"));
    }

    
    public WebElement getAnotacaoField(){
        return driver.findElement(By.id("bugnote_text"));
    }

    public WebElement getAddNoteButton() {
        return driver.findElement(By.cssSelector("input[value='Adicionar Anotação']"));
    }

    public WebElement getTaskHistory(){
        return driver.findElement(By.id("history"));
    }
}
