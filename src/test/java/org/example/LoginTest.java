package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.*;

public class LoginTest {
    private WebDriver driver;

    @BeforeEach
    void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://automationexercise.com/login");
    }

    @AfterEach
    void tearDown() throws Exception {
        driver.quit();
    }

    @Test
    void test() {
        WebElement emailAddressElement = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/input[2]"));
        emailAddressElement.sendKeys("bruno.outroscontatos@gmail.com");

        WebElement passwordElement = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/input[3]"));
        passwordElement.sendKeys("DYC5RjzwRzC");

        WebElement submitBtnElement = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/button"));
        submitBtnElement.click();

        WebElement logoutBtnElement = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a"));
        String textTag = logoutBtnElement.getText();

        assertTrue(textTag.equals("Logout"));
    }
}
