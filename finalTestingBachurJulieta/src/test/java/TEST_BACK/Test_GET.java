package TEST_BACK;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.junit.jupiter.api.*;
import reportes.ReportFactory;

import static io.restassured.RestAssured.given;

public class Test_GET {
    static ExtentSparkReporter info = new ExtentSparkReporter("reportes/ParaBank-TestBackGET-Test.html");
    static ExtentReports extent;

    @BeforeAll
    public static void setup() {
        extent = ReportFactory.getInstance();
        extent.attachReporter(info);
    }

    @AfterAll
    public static void teardown() {
        extent.flush();
    }

    @Test
    @Tag("GET")
    @Tag("REGISTRO")
    public void GET_REGISTRO() {
        ExtentTest test = extent.createTest("Test GET REGISTRO de Parabank");
        System.out.println("Iniciando Test de registro");
        test.log(Status.INFO, "Iniciando Test de registro");

        given()
                .get("https://parabank.parasoft.com/parabank/register.htm")
                .then().statusCode(200)
                .log().body();

        System.out.println("Test de registro finalizado");
        test.log(Status.PASS, "Test de registro finalizado");
    }

    @Test
    @Tag("GET")
    @Tag("VER_RESUMEN")
    public void GET_RESUMEN() {
        ExtentTest test = extent.createTest("Test GET RESUMEN de Parabank");
        System.out.println("Iniciando Test de RESUMEN");
        test.log(Status.INFO, "Iniciando Test de RESUMEN");

        given()
                .auth().basic("julio1", "123")
                .get("https://parabank.parasoft.com/parabank/overview.htm")
                .then()
                .statusCode(200)
                .log().status()
                .log().body();

        System.out.println("Test de RESUMEN finalizado");
        test.log(Status.PASS, "Test de RESUMEN finalizado");
    }

    @Test
    @Tag("GET")
    @Tag("VER_ACTIVIDAD")
    public void GET_ACTIVIDAD() {
        ExtentTest test = extent.createTest("Test GET ACTIVIDAD de Parabank");
        System.out.println("Iniciando Test de ACTIVIDAD");
        test.log(Status.INFO, "Iniciando Test de ACTIVIDAD");

        given()
                .auth().basic("julio1", "123")
                .get("https://parabank.parasoft.com/parabank/services_proxy/bank/accounts/13566/transactions/month/All/type/All")
                .then()
                .statusCode(200)
                .log().status()
                .log().body();

        System.out.println("Test de ACTIVIDAD finalizado");
        test.log(Status.PASS, "Test de ACTIVIDAD finalizado");
    }
}