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
public class testActividad {
    private WebDriver driver;
    private WebDriverWait wait;
    static ExtentSparkReporter info = new ExtentSparkReporter("reportes/Actividad-Test.html");
    static ExtentReports extent;

    @BeforeAll
    public static void createReport() {
        extent = ReportFactory.getInstance();
        extent.attachReporter(info);
        System.out.println("<<< COMIENZAN LOS TEST DE ACTIVIDAD  >>>");
    }

    @BeforeEach
    public void setUp() throws InterruptedException {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofMillis(5000));
        ActividadPage actividadPage = new ActividadPage(driver, wait);
        actividadPage.setUp();
        actividadPage.getUrl("https://parabank.parasoft.com/parabank/index.htm");
    }
    @Test
    @Tag("ACTIVIDAD")
    @Tag("EXITOSO")
    public void verActividadExitosa() throws InterruptedException {
        ExtentTest test = extent.createTest("ver Actividad exitosa");
        test.log(Status.INFO, "Comienza el Test de ver Actividad");
        System.out.println("Comienza el Test de ver Actividad");

        try{
            ActividadPage actividadPage = new ActividadPage(driver, wait);
            actividadPage.iniciarSesion("julio1", "123");
            actividadPage.clickResumenDeCuentas();
            test.log(Status.PASS, "Presiono 'Accounts Overview'");
            System.out.println("Presiono 'Accounts Overview'");
            Assertions.assertEquals("*Balance includes deposits that may be subject to holds", actividadPage.fraseEnResumen());
            actividadPage.clickCuenta();
            test.log(Status.PASS, "Selecciono cuenta");
            System.out.println("Selecciono cuenta");
            Assertions.assertEquals("Account Details", actividadPage.fraseEnDetalle());
            test.log(Status.PASS, "Selecciono el periodo");
            System.out.println("Selecciono el periodo");
            actividadPage.clickPeriodo();
            test.log(Status.PASS, "Selecciono el tipo de actividad");
            System.out.println("Selecciono el tipo de actividad");
            actividadPage.clickTipo();
            actividadPage.clickIr();
            test.log(Status.PASS, "Confirmo busqueda");
            test.log(Status.INFO, "Finaliza el Test de ver Actividad");
            System.out.println("Confirmo busqueda");
            System.out.println("Finaliza el Test de ver Actividad");
        } catch(AssertionError e) {
            test.log(Status.FAIL, "Fallo en el test: " + e.getMessage());
            System.out.println("Fallo en el test: " + e.getMessage());
            throw e;
        }

    }

    @AfterEach
    public void endTest() throws InterruptedException {
        ActividadPage actividadPage = new ActividadPage(driver, wait);
        actividadPage.close();
    }

    @AfterAll
    public static void finish() {
        extent.flush();
        System.out.println("<<< FINALIZAN LOS TEST DE ACTIVIDAD   >>>");
    }
}
