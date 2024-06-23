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

@Tag("REGISTER")
public class testRegister {
    private WebDriver driver;
    private WebDriverWait wait;
    static ExtentSparkReporter info = new ExtentSparkReporter("reportes/Register-Test.html");
    static ExtentReports extent;

    @BeforeAll
    public static void createReport() {
        extent = ReportFactory.getInstance();
        extent.attachReporter(info);
        System.out.println("<<< COMIENZAN LOS TEST DE REGISTRO >>>");
    }

    @BeforeEach
    public void setUp() throws InterruptedException {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofMillis(5000));
        RegisterPage registerPage = new RegisterPage(driver, wait);
        registerPage.setUp();
        registerPage.getUrl("https://parabank.parasoft.com/parabank/index.htm");
    }

    @Test
    @Tag("REGISTRO")
    @Tag("EXITOSO")
    public void registroExitoso() throws InterruptedException {
        ExtentTest test = extent.createTest("Registro Exitoso");
        test.log(Status.INFO, "Comienza el Test");
        System.out.println("Comienza el test de Registro Exitoso");
        test.log(Status.PASS, "Ingreso en el registro de ParaBank");
        System.out.println("Ingreso en el registro de ParaBank");
        try {
            RegisterPage registerPage = new RegisterPage(driver, wait);
            registerPage.clickRegistrarse();
            registerPage.escribirNombre("lisa");
            registerPage.escribirApellido("Perez");
            registerPage.escribirDireccion("Av. Siempre Viva 123");
            registerPage.escribirCiudad("Springfield");
            registerPage.escribirEstado("Massachussetts");
            registerPage.escribirCodigoPostal("2356");
            registerPage.escribirTelefono("45731596");
            registerPage.escribirSsn("123458");
            registerPage.escribirUsuario("lisaap");
            registerPage.escribirContraseña("12345678");
            registerPage.repetirContraseña("12345678");
            test.log(Status.PASS, "Ingreso todos los datos del registro");
            System.out.println("Ingreso todos los datos del registro");
            registerPage.clickCrearCuenta();
            Assertions.assertEquals("Your account was created successfully. You are now logged in.", registerPage.cuentaCreadaExito());
            test.log(Status.PASS, "Validación de registro Exitoso");
            System.out.println("Validación de registro Exitoso");
            test.log(Status.INFO, "Finaliza el Test de Registro Exitoso");
            System.out.println("Finaliza el Test de Registro Exitoso");
        } catch(AssertionError e) {
            test.log(Status.FAIL, "Fallo en el test: " + e.getMessage());
            System.out.println("Fallo en el test: " + e.getMessage());
            throw e;
        }
    }

    @AfterEach
    public void endTest() throws InterruptedException {
        RegisterPage registerPage = new RegisterPage(driver, wait);
        registerPage.close();
    }

    @AfterAll
    public static void finish() {
        extent.flush();
        System.out.println("<<< FINALIZAN LOS TEST DE REGISTRO >>>");
    }
}
