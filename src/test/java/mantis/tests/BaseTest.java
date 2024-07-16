package mantis.tests;

import org.testng.annotations.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseTest {
    private WebDriver driver;
    
    @BeforeMethod
    public void setUpSuite() {
        // Configuração do WebDriver
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://mantis-prova.base2.com.br/");
    }

    @AfterMethod
    public void tearDownSuite() {
        driver.quit();
    }

    public WebDriver getDriver() {
        return driver;
    }
}