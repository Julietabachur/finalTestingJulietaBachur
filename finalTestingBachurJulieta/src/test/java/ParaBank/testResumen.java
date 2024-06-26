package ParaBank;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import reportes.ReportFactory;

import java.time.Duration;

@Tag("RESUMEN")
public class testResumen {
    private WebDriver driver;
    private WebDriverWait wait;
    static ExtentSparkReporter info = new ExtentSparkReporter("reportes/Resumen-Test.html");
    static ExtentReports extent;

    @BeforeAll
    public static void createReport() {
        extent = ReportFactory.getInstance();
        extent.attachReporter(info);
        System.out.println("<<< COMIENZAN LOS TEST DE RESUMEN DE CUENTAS >>>");
    }

    @BeforeEach
    public void setUp() throws InterruptedException {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofMillis(5000));
        ResumenPage resumenPage = new ResumenPage(driver, wait);
        resumenPage.setUp();
        resumenPage.getUrl("https://parabank.parasoft.com/parabank/index.htm");
    }

    @Test
    @Tag("VER_RESUMEN")
    @Tag("EXITOSO")
    public void verResumenExitoso() throws InterruptedException {
        ExtentTest test = extent.createTest("Ver resumen exitoso");
        test.log(Status.INFO, "Comienza el Test de Ver resumen");
        System.out.println("Comienza el Test de Ver resumen");


        try{
            ResumenPage resumenPage = new ResumenPage(driver, wait);
            resumenPage.iniciarSesion("julio1", "123");
            test.log(Status.PASS, "Presiono 'Accounts Overview'");
            System.out.println("Presiono 'Accounts Overview'");
            resumenPage.clickResumen();
            test.log(Status.PASS, "Elijo el tipo de cuenta abrir");
            System.out.println("Elijo el tipo de cuenta abrir");
            Assertions.assertEquals("*Balance includes deposits that may be subject to holds", resumenPage.resumenExito());
            test.log(Status.PASS, "Validación de vista de resumen Exitoso");
            test.log(Status.INFO, "Finaliza el Test de Ver resumen");
            System.out.println("Validación de vista de resumen Exitoso");
            System.out.println("Finaliza el Test de Ver resumen");
        } catch(AssertionError e) {
            test.log(Status.FAIL, "Fallo en el test: " + e.getMessage());
            System.out.println("Fallo en el test: " + e.getMessage());
            throw e;
        }

    }


    @AfterEach
    public void endTest() throws InterruptedException {
        ResumenPage resumenPage = new ResumenPage(driver, wait);
        resumenPage.close();
    }

    @AfterAll
    public static void finish() {
        extent.flush();
        System.out.println("<<< FINALIZAN LOS TEST DE RESUMEN DE CUENTAS  >>>");
    }
}
