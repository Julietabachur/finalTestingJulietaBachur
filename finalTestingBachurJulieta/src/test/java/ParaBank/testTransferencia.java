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

@Tag("TRANSFERENCIA")
public class testTransferencia {
    private WebDriver driver;
    private WebDriverWait wait;
    static ExtentSparkReporter info = new ExtentSparkReporter("reportes/Transferencia-Test.html");
    static ExtentReports extent;

    @BeforeAll
    public static void createReport() {
        extent = ReportFactory.getInstance();
        extent.attachReporter(info);
        System.out.println("<<< COMIENZAN LOS TEST DE TRANSFERENCIA  >>>");
    }

    @BeforeEach
    public void setUp() throws InterruptedException {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofMillis(5000));
        TransferenciaPage transferenciaPage = new TransferenciaPage(driver, wait);
        transferenciaPage.setUp();
        transferenciaPage.getUrl("https://parabank.parasoft.com/parabank/index.htm");
    }

    @Test
    @Tag("TRANSFERIR")
    @Tag("EXITOSO")
    public void transferenciaExitosa() throws InterruptedException {
        ExtentTest test = extent.createTest("Hacer transferencia exitosa");
        test.log(Status.INFO, "Comienza el Test de Hacer transferencia");
        System.out.println("Comienza el Test de Hacer transferencia");

        try {
            TransferenciaPage transferenciaPage = new TransferenciaPage(driver, wait);
            transferenciaPage.iniciarSesion("julio1", "123");
            transferenciaPage.clickTransferirFondos();
            test.log(Status.PASS, "Presiono 'Transferir fondos'");
            System.out.println("Presiono 'Transferir fondos'");
            Assertions.assertEquals("Transfer Funds", transferenciaPage.paginaTransferirFondos());
            transferenciaPage.escribirElMonto("10");
            test.log(Status.PASS, "Ingreso el monto a transferir");
            System.out.println("Ingreso el monto a transferir");
            transferenciaPage.clickOpcionCuentaUno();
            test.log(Status.PASS, "Selecciono la cuenta desde donde transfiero");
            System.out.println("Selecciono la cuenta desde donde transfiero");
            transferenciaPage.clickOpcionCuentaDos();
            test.log(Status.PASS, "Selecciono la cuenta a donde transfiero");
            System.out.println("Selecciono la cuenta a donde transfiero");
            transferenciaPage.clickTransferir();
            test.log(Status.PASS, "Confirmo transferencia");
            System.out.println("Confirmo transferencia");
            Thread.sleep(4000);
            Assertions.assertEquals("Transfer Complete!", transferenciaPage.paginaTransferenciaRealizada());
            test.log(Status.INFO, "Finaliza el Test de Hacer transferencia");
            System.out.println("Finaliza el Test de Hacer transferencia");
        } catch (AssertionError e) {
            test.log(Status.FAIL, "Fallo en el test: " + e.getMessage());
            System.out.println("Fallo en el test: " + e.getMessage());
            throw e;
        }
    }

    @AfterEach
    public void endTest() throws InterruptedException {
        TransferenciaPage transferenciaPage = new TransferenciaPage(driver, wait);
        transferenciaPage.close();
    }

    @AfterAll
    public static void finish() {
        extent.flush();
        System.out.println("<<< FINALIZAN LOS TEST DE TRANSFERENCIA   >>>");
    }
}
