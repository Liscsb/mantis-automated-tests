package mantis.tests;

import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import mantis.pages.CriarTarefaPage;
import mantis.pages.LoginPage;
import mantis.pages.MinhaVisaoPage;
import mantis.pages.TarefaPage;
import mantis.utils.AssertionHelper;
import mantis.utils.PageLoader;
import mantis.utils.Sidebar;

public class CriarTarefaTest extends BaseTest {

    @Test
    public void testCriarTarefaNaCategoriaTeste() {

        WebDriver driver = getDriver();
            
        LoginPage loginPage = new LoginPage(driver);
        MinhaVisaoPage minhaVisaoPage = new MinhaVisaoPage(driver);
        CriarTarefaPage criarTarefaPage = new CriarTarefaPage(driver);
        Sidebar sidebar = new Sidebar(driver);
        AssertionHelper assertionHelper = new AssertionHelper(driver);
        PageLoader pageLoader = new PageLoader(driver);
        TarefaPage tarefaPage = new TarefaPage(driver);
        
        Properties properties = new Properties();
        String resourceName = "/config-test.properties"; // caminho relativo ao classpath de teste

        // Carregar o arquivo usando ClassLoader
        try (InputStream inputStream = LoginTest.class.getResourceAsStream(resourceName)) {
            if (inputStream == null) {
                throw new IllegalArgumentException("Arquivo " + resourceName + " não encontrado no classpath de teste.");
            }
            properties.load(inputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String username = properties.getProperty("login.username");
        String password = properties.getProperty("login.password");

        loginPage.enterUsername(username);
        loginPage.clickEntrar();
        loginPage.enterPassword(password);
        loginPage.unselectSecureSessionCheckbox();
        loginPage.clickEntrar();
        minhaVisaoPage.validaTituloDaPaginaMinhaVisao();
        sidebar.criarTarefa();
        pageLoader.waitForPageTitle("Criar Tarefa - MantisBT");         
        criarTarefaPage.selecionarCategoria("[Todos os Projetos] categoria teste");
        criarTarefaPage.selecionarFrequencia("aleatório");
        criarTarefaPage.selecionarGravidade("pequeno");
        criarTarefaPage.selecionarPrioridade("normal");
        criarTarefaPage.preencherSumario("Nova Tarefa na Categoria Teste");
        criarTarefaPage.preencherDescricao("Nova Tarefa na Categoria Teste está sendo criada para teste");
        criarTarefaPage.selecionarBotaoCriarNovaTarefa();
        tarefaPage.aguardarTarefaCarregar();
        assertionHelper.validarTituloDaPagina("Nova Tarefa na Categoria Teste - MantisBT");
    }

    @Test
    public void testCriarTarefaNaNovaCateogira() {

        WebDriver driver = getDriver();
            
        LoginPage loginPage = new LoginPage(driver);
        MinhaVisaoPage minhaVisaoPage = new MinhaVisaoPage(driver);
        CriarTarefaPage criarTarefaPage = new CriarTarefaPage(driver);
        Sidebar sidebar = new Sidebar(driver);
        AssertionHelper assertionHelper = new AssertionHelper(driver);
        TarefaPage tarefaPage = new TarefaPage(driver);

        Properties properties = new Properties();
        String resourceName = "/config-test.properties"; // caminho relativo ao classpath de teste

        // Carregar o arquivo usando ClassLoader
        try (InputStream inputStream = LoginTest.class.getResourceAsStream(resourceName)) {
            if (inputStream == null) {
                throw new IllegalArgumentException("Arquivo " + resourceName + " não encontrado no classpath de teste.");
            }
            properties.load(inputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String username = properties.getProperty("login.username");
        String password = properties.getProperty("login.password");

        loginPage.enterUsername(username);
        loginPage.clickEntrar();
        loginPage.enterPassword(password);
        loginPage.unselectSecureSessionCheckbox();
        loginPage.clickEntrar();
        minhaVisaoPage.validaTituloDaPaginaMinhaVisao();
        sidebar.criarTarefa();
        criarTarefaPage.selecionarCategoria("[Todos os Projetos] nova categoria");
        criarTarefaPage.selecionarFrequencia("sempre");
        criarTarefaPage.selecionarGravidade("grande");
        criarTarefaPage.selecionarPrioridade("alta");
        criarTarefaPage.preencherSumario("Nova Tarefa na Nova Categoria");
        criarTarefaPage.preencherDescricao("Nova Tarefa na Nova Categoria está sendo criada para teste");
        criarTarefaPage.selecionarBotaoCriarNovaTarefa();
        tarefaPage.aguardarTarefaCarregar();
        assertionHelper.validarTituloDaPagina("Nova Tarefa na Nova Categoria");

    }


}
