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

@Tag("CAJA_AHORROS")
public class testOpenAccount {
    private WebDriver driver;
    private WebDriverWait wait;
    static ExtentSparkReporter info = new ExtentSparkReporter("reportes/OpenAccount-Test.html");
    static ExtentReports extent;

    @BeforeAll
    public static void createReport() {
        extent = ReportFactory.getInstance();
        extent.attachReporter(info);
        System.out.println("<<< COMIENZAN LOS TEST DE APERTURA DE CAJA DE AHORROS >>>");
    }

    @BeforeEach
    public void setUp() throws InterruptedException {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofMillis(5000));
        OpenAccountPage openAccount = new OpenAccountPage(driver, wait);
        openAccount.setUp();
        openAccount.getUrl("https://parabank.parasoft.com/parabank/index.htm");
    }


    @Test
    @Tag("ABRIR_CAJA_AHORROS")
    @Tag("EXITOSO")
    public void AbrirCajaAhorrosExitoso() throws InterruptedException {
        ExtentTest test = extent.createTest("Apertura de caja de ahorros Exitosa");
        test.log(Status.INFO, "Comienza el Test");
        System.out.println("Comienza el test");

        try {
            OpenAccountPage openAccount = new OpenAccountPage(driver, wait);
            openAccount.escribirUsuario("Juaniperez");
            openAccount.escribirContraseña("12345678");
            openAccount.clickIniciarSesion();
            test.log(Status.PASS, "Presiono 'Abrir nueva cuenta'");
            System.out.println("Presiono 'Abrir nueva cuenta'");
            openAccount.clickAbrirCuenta();
            openAccount.clickTipoCuenta();
            openAccount.clickSavings();
            System.out.println("Presiono 'Savings'");
            test.log(Status.PASS, "Elijo el tipo de cuenta abrir");
            openAccount.clickAbrirCajaAhorro();
            test.log(Status.PASS, "Confirmo apertura de caja de ahorros");
            System.out.println("Confirmo apertura de caja de ahorros");
            openAccount.cuentaCreadaExito().equals("Congratulations, your account is now open.");
            test.log(Status.PASS, "Validación de apertura de  caja de ahorros Exitoso");
            test.log(Status.INFO, "Finaliza el Test");
        } catch(AssertionError e) {
            test.log(Status.FAIL, "Fallo en el test: " + e.getMessage());
            throw e;
        }
    }
    
    
//    @AfterEach
//    public void endTest() throws InterruptedException {
//        OpenAccountPage openAccount = new OpenAccountPage(driver, wait);
//        openAccount.close();
//    }

    @AfterAll
    public static void finish() {
        extent.flush();
        System.out.println("<<< FINALIZAN LOS TEST DE APERTURA DE CAJA DE AHORROS >>>");
    }
}
