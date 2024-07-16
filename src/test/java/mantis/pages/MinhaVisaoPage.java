package mantis.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import mantis.elements.MinhaVisaoElements;
import mantis.utils.AssertionHelper;

public class MinhaVisaoPage {

    private WebDriver driver;
    private MinhaVisaoElements elements;
    private AssertionHelper assertionHelper;

    public MinhaVisaoPage(WebDriver driver){
        this.driver = driver;
        this.elements = new MinhaVisaoElements(driver);
        this.assertionHelper = new AssertionHelper(driver);
    }

    public void validaTituloDaPaginaMinhaVisao() {
        assertionHelper.validarTituloDaPagina(MinhaVisaoElements.MINHA_VISAO_PAGE_TITLE);
    }

    public void selecionarTarefa(String nomeDaTarefa) {
        WebElement unassignedTasks = elements.getUnassignedTasksTable();
        List<WebElement> linhas = unassignedTasks.findElements(By.tagName("td"));

        for (WebElement linha : linhas) {

         WebElement colunaTexto = linha.findElement(By.tagName("a"));

            if (colunaTexto.getText().contains(nomeDaTarefa)) {  
                colunaTexto.click();     
                break;
            }
        }
    }
    
}