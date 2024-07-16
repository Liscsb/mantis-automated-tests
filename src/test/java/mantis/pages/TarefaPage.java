package mantis.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import mantis.elements.TarefaElements;

public class TarefaPage {
    private WebDriver driver;
    private TarefaElements elements;

    public TarefaPage (WebDriver driver) {
        this.driver = driver;
        this.elements = new TarefaElements(driver);
    }

    public void addAnotacaoATarefaCriada(String anotacao){
        elements.getAnotacaoField().sendKeys(anotacao);
        elements.getAddNoteButton().click();
    }

    public void aguardarTarefaCarregar(){
        try {
            Thread.sleep(5000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void validarAnotacaoAdicionada(String conteudo){
        WebElement bugnotes = elements.getBugNotes();
        List<WebElement> linhas = bugnotes.findElements(By.tagName("tr"));

        for (WebElement linha : linhas) {

         WebElement colunaTexto = linha.findElement(By.tagName("td"));

            if (colunaTexto.getText().contains(conteudo)) {             
                break;
            }
        }
    }   
}
