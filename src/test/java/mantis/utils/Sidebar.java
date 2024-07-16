package mantis.utils;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import mantis.elements.SidebarElements;

public class Sidebar {

    private WebDriver driver;
    private SidebarElements elements;
    PageLoader pageLoader;

    public Sidebar(WebDriver driver){
        this.driver = driver;
        this.pageLoader = new PageLoader(driver);
        this.elements = new SidebarElements(driver);
    }

    public void criarTarefa(){
      
        WebElement sidebarMenu = elements.getSidebarMenu();
        List<WebElement> linhas = sidebarMenu.findElements(By.tagName("li"));
        for (WebElement linha : linhas) {

         WebElement colunaTexto = linha.findElement(By.tagName("span"));

         if (colunaTexto.getText().contains("Criar Tarefa")) {
             colunaTexto.click();
             break;
         }
     }
 }
   
    
}
