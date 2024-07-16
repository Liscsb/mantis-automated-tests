package mantis.tests;

import org.testng.ITestNGListener;
import org.testng.TestNG;
import org.testng.reporters.EmailableReporter;
import org.testng.reporters.JUnitXMLReporter;
import org.testng.reporters.TestHTMLReporter;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;
import java.util.ArrayList;
import java.util.List;

public class RunTests {

    public static void main(String[] args) {
        TestNG testNG = new TestNG();

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

        // Adicionar a suite ao TestNG
        List<XmlSuite> suites = new ArrayList<>();
        suites.add(suite);
        testNG.setXmlSuites(suites);

        testNG.setOutputDirectory("test-output");

        // Executar os testes
        testNG.run();
    }
}