package mantis.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import mantis.elements.CriarTarefaElements;
import mantis.utils.PageLoader;

public class CriarTarefaPage {

    private WebDriver driver;
    private CriarTarefaElements elements;
    private PageLoader pageLoader;

    public CriarTarefaPage(WebDriver driver){
        this.driver = driver;
        this.elements = new CriarTarefaElements(driver);
        this.pageLoader = new PageLoader(driver);
    }

    public void selecionarCategoria(String categoria){
        WebElement dropdownElement = elements.getCategoryMenu();
        Select dropdown = new Select(dropdownElement);

        dropdown.selectByVisibleText(categoria);
    }

    public void selecionarFrequencia(String frequencia){
        WebElement dropdownElement = elements.getReproducibilityMenu();
        Select dropdown = new Select(dropdownElement);

        dropdown.selectByVisibleText(frequencia);
    }

    public void selecionarGravidade(String gravidade){
        WebElement dropdownElement = elements.getSeverityMenu();
        Select dropdown = new Select(dropdownElement);

        dropdown.selectByVisibleText(gravidade);
    }

    public void selecionarPrioridade(String prioridade){
        WebElement dropdownElement = elements.getPriorityMenu();
        Select dropdown = new Select(dropdownElement);

        dropdown.selectByVisibleText(prioridade);
    }

    public void preencherSumario(String sumario){
        elements.getSummaryField().sendKeys(sumario);
    }

    public void preencherDescricao(String descricao){
        elements.getDescriptionField().sendKeys(descricao);
    }
    
    public void selecionarBotaoCriarNovaTarefa(){
        elements.getCreateNewTaskButton().click();
    }
    
}
