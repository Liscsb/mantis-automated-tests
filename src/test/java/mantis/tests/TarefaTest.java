package mantis.tests;

import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import mantis.pages.LoginPage;
import mantis.pages.MinhaVisaoPage;
import mantis.pages.TarefaPage;
import mantis.utils.AssertionHelper;

public class TarefaTest extends BaseTest {
    
    @Test
    public void testTarefaAddAnotacao() {

        WebDriver driver = getDriver();
            
        LoginPage loginPage = new LoginPage(driver);
        MinhaVisaoPage minhaVisaoPage = new MinhaVisaoPage(driver);
        AssertionHelper assertionHelper = new AssertionHelper(driver);
        TarefaPage tarefaPage = new TarefaPage(driver);

        Properties properties = new Properties();
        String resourceName = "/config-test.properties";

        // Carregar o arquivo usando ClassLoader
        try (InputStream inputStream = LoginTest.class.getResourceAsStream(resourceName)) {
            if (inputStream == null) {
                throw new IllegalArgumentException("Arquivo " + resourceName + " não encontrado no classpath de teste.");
            }
            properties.load(inputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }

        String username = properties.getProperty("username");
        String password = properties.getProperty("password");

        loginPage.enterUsername(username);
        loginPage.clickEntrar();
        loginPage.enterPassword(password);
        loginPage.unselectSecureSessionCheckbox();
        loginPage.clickEntrar();
        minhaVisaoPage.validaTituloDaPaginaMinhaVisao();
        minhaVisaoPage.selecionarTarefa("teste");
        tarefaPage.aguardarTarefaCarregar();
        assertionHelper.validarTituloDaPagina("teste");
        tarefaPage.addAnotacaoATarefaCriada("Testando anotacao na tarefa teste");
        tarefaPage.validarAnotacaoAdicionada("Testando anotacao na tarefa teste");
    }


}
