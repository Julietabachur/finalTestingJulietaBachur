package TEST_BACK;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.google.gson.JsonObject;
import com.aventstack.extentreports.gherkin.model.Given;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import reportes.ReportFactory;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

public class Test_POST {
    static ExtentSparkReporter info = new ExtentSparkReporter("reportes/ParaBank-TestBackPOST-Test.html");
    static ExtentReports extent;
    ExtentTest test;

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
    @Tag("POST")
    @Tag("ABRIR-CUENTA")
    public void POST_ABRIR_CUENTA() {
        test = extent.createTest("Test POST de abrir cuenta Parabank");
        test.log(Status.INFO, "Comienza el Test de back de abrir cuenta");

        System.out.println("Iniciando Test de abrir cuenta Post");
        test.log(Status.INFO, "Iniciando Test de abrir cuenta Post");


        given()
                .auth().basic("julio1", "123")
                .contentType("application/x-www-form-urlencoded")
                .formParam("customerId", "12545")
                .formParam("newAccountType", "1")
                .formParam("fromAccountId", "14676")
                .when().post("https://parabank.parasoft.com/parabank/services_proxy/bank/createAccount")
                .then()
                .statusCode(200)
                .log().status()
                .log().body();

        System.out.println("Test Post de abrir cuenta finalizado");
        test.log(Status.PASS, "Test Post de abrir cuenta finalizado");
    }

    @Test
    @Tag("POST")
    @Tag("TRANSFERIR")
    public void POST_TRANSFERIR() {
        test = extent.createTest("Test POST de TRANSFERIR Parabank");

        System.out.println("Iniciando Test de TRANSFERIR Post");
        test.log(Status.INFO, "Iniciando Test de TRANSFERIR Post");


        given()
                .auth().basic("julio1", "123")
                .contentType("application/x-www-form-urlencoded")
                .formParam("fromAccountId", "13566")
                .formParam("toAccountId", "13677")
                .formParam("amount", "10")
                .when().post("https://parabank.parasoft.com/parabank/services_proxy/bank/transfer")
                .then()
                .statusCode(200)
                .log().status()
                .log().body();

        System.out.println("Test Post de TRANSFERIR finalizado");
        test.log(Status.PASS, "Test Post de TRANSFERIR finalizado");
    }


}