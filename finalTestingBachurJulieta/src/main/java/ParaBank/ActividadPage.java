package ParaBank;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ActividadPage extends BasePage{
    private By resumenDeCuentas = By.linkText("Accounts Overview");
    private By fraseResumen = By.xpath("//td[contains(text(),'*Balance includes deposits that may be subject to holds')]");
    private By cuenta = By.cssSelector("#accountTable tbody tr:first-of-type td:first-of-type a");
    private By detalleDeCuenta = By.cssSelector("div[id='accountDetails'] h1[class='title']");
    private By periodo = By.id("month");
    private By todoPeriodo = By.cssSelector("select[id='month'] option[value='All']");
    private By todoTipo = By.cssSelector("select[id='transactionType'] option[value='All']");
    private By tipo = By.id("transactionType");
    private By ir = By.cssSelector("input[value='Go']");
    private By inputUsuario = By.cssSelector("input[name='username']");
    private By inputContraseña = By.cssSelector("input[name='password']");
    private By btnIniciarSesion = By.cssSelector("input[value='Log In']");

    /**Constructor de la clase ActividadPage
     * @param driver la instancia de WebDriver utilizada para interactuar con la página web
     */
    public ActividadPage(WebDriver driver, WebDriverWait wait) {
        super(driver, null);
    }


    /** Completa form de "Iniciar sesion" .
     * @throws InterruptedException si el hilo es interrumpido mientras espera
     */
    public void iniciarSesion(String username, String password) throws InterruptedException {
        this.logIn(username, inputUsuario, password, inputContraseña, btnIniciarSesion);
    }

    /** Hace click en la opcion "Resumen de cuentas".
     * @throws InterruptedException si el hilo es interrumpido mientras espera
     */
    public void clickResumenDeCuentas() throws InterruptedException {
        this.click(resumenDeCuentas);
        System.out.println("se hizo click en resumen De Cuentas");
    }

    /** Obtiene el texto de la aclaracion del resumen.
     * @return el texto del mensaje del resumen
     * @throws InterruptedException si el hilo es interrumpido mientras espera
     */
    public String fraseEnResumen() throws InterruptedException {
        String res = this.getText(fraseResumen);
        System.out.println("Resultado titulo resumen: " + res);
        return res;
    }


    /** Hace click en cuenta.
     * @throws InterruptedException si el hilo es interrumpido mientras espera
     */
    public void clickCuenta() throws InterruptedException {
        this.click(cuenta);
    }

    /** Obtiene el texto del detalle.
     * @return el texto del mensaje del detalle
     * @throws InterruptedException si el hilo es interrumpido mientras espera
     */
    public String fraseEnDetalle() throws InterruptedException {
        String res = this.getText(detalleDeCuenta);
        System.out.println("Resultado titulo detalle: " + res);
        return res;
    }

    /** Hace click en periodo y 'todo'.
     * @throws InterruptedException si el hilo es interrumpido mientras espera
     */
    public void clickPeriodo() throws InterruptedException {
        this.click(periodo);
        this.click(todoPeriodo);
        System.out.println("se hizo click en periodo-todo");
    }

    /** Hace click en tipo y 'todo'.
     * @throws InterruptedException si el hilo es interrumpido mientras espera
     */
    public void clickTipo() throws InterruptedException {
        this.click(tipo);
        this.click(todoTipo);
        System.out.println("se hizo click en tipo-todo");
    }

    /** Hace click en tipo y 'todo'.
     * @throws InterruptedException si el hilo es interrumpido mientras espera
     */
    public void clickIr() throws InterruptedException {
        this.click(ir);
        System.out.println("se hizo click en ir");
    }
}
