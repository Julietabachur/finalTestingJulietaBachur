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
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.Order;
import java.time.Duration;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Tag("PARABANK")
public class testsParaBankFront {
    private static WebDriver driver;
    private static WebDriverWait wait;
    static ExtentSparkReporter info = new ExtentSparkReporter("reportes/ParaBank-TestsFront.html");
    static ExtentReports extent;

    @BeforeAll
    public static void createReport() throws InterruptedException {
        extent = ReportFactory.getInstance();
        extent.attachReporter(info);
        System.out.println("<<< COMIENZAN LOS TEST DE PARABANK >>>");

        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofMillis(5000));

        BasePage basePage = new BasePage(driver, wait);
        basePage.setUp();
        basePage.getUrl("https://parabank.parasoft.com/parabank/index.htm");
    }

//    @BeforeEach
//    public void setUp() throws InterruptedException {
//        driver = new ChromeDriver();
//        wait = new WebDriverWait(driver, Duration.ofMillis(5000));
//        RegisterPage registerPage = new RegisterPage(driver, wait);
//        registerPage.setUp();
//        registerPage.getUrl("https://parabank.parasoft.com/parabank/index.htm");
//    }



    @Test
    @Order(1)
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
            registerPage.escribirUsuario("paapaaaaaa");
            registerPage.escribirContraseña("12345678");
            registerPage.repetirContraseña("12345678");
            test.log(Status.PASS, "Ingreso todos los datos del registro");
            System.out.println("Ingreso todos los datos del registro");
            registerPage.clickCrearCuenta();
//            registerPage.cuentaCreadaExito().equals("Your account was created successfully. You are now logged in.");
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

    @Test
    @Order(2)
    @Tag("ABRIR_CAJA_AHORROS")
    @Tag("EXITOSO")
    public void abrirCajaAhorrosExitoso() throws InterruptedException {
        ExtentTest test = extent.createTest("Apertura de caja de ahorro exitosa");
        test.log(Status.INFO, "Comienza el Test de Apertura de caja de ahorro");
        System.out.println("Comienza el test de Apertura de caja de ahorro");

        try {
            OpenAccountPage openAccount = new OpenAccountPage(driver, wait);
//            openAccount.escribirUsuario("Juaniperez");
//            openAccount.escribirContraseña("12345678");
//            openAccount.clickIniciarSesion();
            test.log(Status.PASS, "Presiono 'Abrir nueva cuenta'");
            System.out.println("Presiono 'Abrir nueva cuenta'");
            openAccount.clickAbrirCuenta();
            openAccount.clickTipoCuenta();
            openAccount.clickSavings();
            System.out.println("Presiono 'Savings'");
            test.log(Status.PASS, "Elijo el tipo de cuenta a abrir");
            openAccount.clickAbrirCajaAhorro();
            test.log(Status.PASS, "Confirmo apertura de caja de ahorros");
            System.out.println("Confirmo apertura de caja de ahorros");
            Thread.sleep(6000);
            Assertions.assertEquals("Congratulations, your account is now open.", openAccount.cuentaCreadaExito());
            test.log(Status.PASS, "Validación de apertura de  caja de ahorros Exitoso");
            System.out.println("Validación de apertura de  caja de ahorros Exitoso");
            test.log(Status.PASS, "Repito el test para tener 2 cajas de ahorro y poder realizar la transferencia");
            System.out.println("Repito el test para tener 2 cajas de ahorro y poder realizar la transferencia");
            test.log(Status.PASS, "Presiono 'Abrir nueva cuenta'");
            System.out.println("Presiono 'Abrir nueva cuenta'");
            openAccount.clickAbrirCuenta();
            openAccount.clickTipoCuenta();
            openAccount.clickSavings();
            System.out.println("Presiono 'Savings'");
            test.log(Status.PASS, "Elijo el tipo de cuenta a abrir");
            openAccount.clickAbrirCajaAhorro();
            test.log(Status.PASS, "Confirmo apertura de caja de ahorros 2");
            System.out.println("Confirmo apertura de caja de ahorros 2");
            test.log(Status.PASS, "Validación de apertura de  caja de ahorros 2 Exitoso");
            System.out.println("Validación de apertura de  caja de ahorros 2 Exitoso");
            System.out.println("Finaliza el Test de Apertura de cajas de ahorro");
            test.log(Status.INFO, "Finaliza el Test de Apertura de cajas de ahorro");
        } catch(AssertionError e) {
            test.log(Status.FAIL, "Fallo en el test: " + e.getMessage());
            System.out.println("Fallo en el test: " + e.getMessage());
            throw e;
      }
    }

    @Test
    @Order(3)
    @Tag("VER_RESUMEN")
    @Tag("EXITOSO")
    public void verResumenExitoso() throws InterruptedException {
        ExtentTest test = extent.createTest("Ver resumen exitoso");
        test.log(Status.INFO, "Comienza el Test de Ver resumen");
        System.out.println("Comienza el Test de Ver resumen");
        
        test.log(Status.PASS, "Presiono 'Accounts Overview'");
        System.out.println("Presiono 'Accounts Overview'");
        try{
            ResumenPage resumenPage = new ResumenPage(driver, wait);
    //        resumenPage.escribirUsuario("Juaniperez");
    //        resumenPage.escribirContraseña("12345678");
    //        resumenPage.clickIniciarSesion();
            resumenPage.clickResumen();
            test.log(Status.PASS, "Elijo el tipo de cuenta abrir");
            System.out.println("Elijo el tipo de cuenta abrir");
            Assertions.assertEquals("*Balance includes deposits that may be subject to holds", resumenPage.resumenExito());
//            resumenPage.resumenExito().equals("*Balance includes deposits that may be subject to holds");
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

    @Test
    @Order(4)
    @Tag("TRANSFERIR")
    @Tag("EXITOSO")
    public void transferenciaExitosa() throws InterruptedException {
        ExtentTest test = extent.createTest("Hacer transferencia exitosa");
        test.log(Status.INFO, "Comienza el Test de Hacer transferencia");
        System.out.println("Comienza el Test de Hacer transferencia");

        test.log(Status.PASS, "Presiono 'Transferir fondos'");
        System.out.println("Presiono 'Transferir fondos'");
        try {
            TransferenciaPage transferenciaPage = new TransferenciaPage(driver, wait);
            // transferenciaPage.escribirUsuario("Juaniperez");
            // transferenciaPage.escribirContraseña("12345678");
            // transferenciaPage.clickIniciarSesion();
            transferenciaPage.clickTransferirFondos();
            test.log(Status.PASS, "Ingreso el monto a transferir");
            System.out.println("Ingreso el monto a transferir");

            Assertions.assertEquals("Transfer Funds", transferenciaPage.paginaTransferirFondos());
            transferenciaPage.escribirElMonto("10");
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


    @Test
    @Order(5)
    @Tag("ACTIVIDAD")
    @Tag("EXITOSO")
    public void verActividadExitosa() throws InterruptedException {
        ExtentTest test = extent.createTest("ver Actividad exitosa");
        test.log(Status.INFO, "Comienza el Test de ver Actividad");
        System.out.println("Comienza el Test de ver Actividad");

        test.log(Status.PASS, "Presiono 'Accounts Overview'");
        System.out.println("Presiono 'Accounts Overview'");
        try{
            ActividadPage actividadPage = new ActividadPage(driver, wait);
            //        actividadPage.escribirUsuario("Juaniperez");
            //        actividadPage.escribirContraseña("12345678");
            //        actividadPage.clickIniciarSesion();
            actividadPage.clickResumenDeCuentas();
            Assertions.assertEquals("*Balance includes deposits that may be subject to holds", actividadPage.fraseEnResumen());
//            actividadPage.fraseEnResumen().equals("*Balance includes deposits that may be subject to holds");
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

    @AfterAll
    public static void finish() {
        extent.flush();
        System.out.println("<<< FINALIZAN LOS TEST DE PARABANK >>>");
    }
}
