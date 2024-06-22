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
    public void RegistroExitoso() throws InterruptedException {
        ExtentTest test = extent.createTest("Registro Exitoso");
        test.log(Status.INFO, "Comienza el Test");
        test.log(Status.PASS, "Ingreso en el registro de ParaBank");
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
        registerPage.escribirUsuario("pepeperez");
        registerPage.escribirContraseña("12345678");
        registerPage.repetirContraseña("12345678");
        test.log(Status.PASS, "Ingreso todos los datos del registro");
        registerPage.clickCrearCuenta();
        registerPage.cuentaCreadaExito().equals("Your account was created successfully. You are now logged in.");
        test.log(Status.PASS, "Validación de registro Exitoso");
        test.log(Status.INFO, "Finaliza el Test");
    }

//    @AfterEach
//    public void endTest() throws InterruptedException {
//        RegisterPage registerPage = new RegisterPage(driver, wait);
//        registerPage.close();
//    }

    @AfterAll
    public static void finish() {
        extent.flush();
        System.out.println("<<< FINALIZAN LOS TEST DE REGISTRO >>>");
    }
}
