package mantis.tests;

import org.testng.annotations.BeforeSuite;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;

public class BaseTest {
    private WebDriver driver;
    
    @BeforeSuite
    public void setUpSuite() {
        // Configuração do WebDriver
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://mantis-prova.base2.com.br/");
    }

    // @AfterSuite
    // public void tearDownSuite() {
    //     driver.quit();
    // }

    public WebDriver getDriver() {
        return driver;
    }
}