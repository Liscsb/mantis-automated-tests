package mantis.tests;

import org.testng.ITestNGListener;
import org.testng.TestNG;
import org.testng.reporters.EmailableReporter;
import org.testng.reporters.JUnitXMLReporter;
import org.testng.reporters.TestHTMLReporter;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;  

public class RunTests {

    public static void main(String[] args) {
        TestNG testNG = new TestNG();
        
        String username = System.getenv("MANTIS_USERNAME");
        String password = System.getenv("MANTIS_PASSWORD");

        if (username == null || password == null) {
            throw new IllegalArgumentException("Variáveis de ambiente USERNAME ou PASSWORD não foram configuradas.");
        }

        String configFile = "src/test/resources/config-test.properties";

        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream(configFile));
        } catch (IOException e) {
            e.printStackTrace();
        }

        properties.setProperty("username", username);
        properties.setProperty("password", password);   

        try (FileOutputStream fos = new FileOutputStream(configFile)) {
            properties.store(fos, "Configuração atualizada com variáveis de ambiente");
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<Class<? extends ITestNGListener>> listeners = new ArrayList<>();
        listeners.add(TestHTMLReporter.class);
        listeners.add(JUnitXMLReporter.class);
        listeners.add(EmailableReporter.class);

        testNG.setUseDefaultListeners(false);
        testNG.setListenerClasses(listeners);

        XmlSuite suite = new XmlSuite();
        suite.setName("Suite de Testes");

        XmlTest test = new XmlTest(suite);
        test.setName("Executar Testes");

        List<XmlClass> classes = new ArrayList<>();
        classes.add(new XmlClass("mantis.tests.LoginTest")); 
        classes.add(new XmlClass("mantis.tests.MinhaVisaoTest")); 
        classes.add(new XmlClass("mantis.tests.TarefaTest")); 
        classes.add(new XmlClass("mantis.tests.CriarTarefaTest")); 
        test.setXmlClasses(classes);

        List<XmlSuite> suites = new ArrayList<>();
        suites.add(suite);
        testNG.setXmlSuites(suites);

        testNG.setOutputDirectory("test-output");

        testNG.run();
    }
}