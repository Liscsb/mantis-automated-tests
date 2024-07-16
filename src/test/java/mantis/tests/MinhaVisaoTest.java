package mantis.tests;

import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import mantis.pages.LoginPage;
import mantis.pages.MinhaVisaoPage;
import mantis.utils.Sidebar;

public class MinhaVisaoTest extends BaseTest {

    @Test
    public void testLogin() {
       WebDriver driver = getDriver();
        
        LoginPage loginPage = new LoginPage(driver);
        MinhaVisaoPage minhaVisaoPage = new MinhaVisaoPage(driver);
        Sidebar sidebar = new Sidebar(driver);

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
        
        
    }
}
