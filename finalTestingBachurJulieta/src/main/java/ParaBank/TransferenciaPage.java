package ParaBank;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TransferenciaPage extends BasePage{
    private By btnTransferirFondos = By.linkText("Transfer Funds");
    private By titulo = By.xpath("//h1[normalize-space()='Transfer Funds']");
    private By inputImporte = By.id("amount");
    private By selectorCuentaUno = By.id("fromAccountId");
    private By cuentaUno = By.cssSelector("#fromAccountId option:first-child");
    private By selectorCuentaDos = By.id("toAccountId");
    private By cuentaDos = By.cssSelector("#fromAccountId option:nth-child(2)");
    private By btnTransferirOk = By.cssSelector("input[value='Transfer']");
    private By exito = By.cssSelector("div[id='showResult'] h1[class='title']");
    private By inputUsuario = By.cssSelector("input[name='username']");
    private By inputContraseña = By.cssSelector("input[name='password']");
    private By btnIniciarSesion = By.cssSelector("input[value='Log In']");


    /**Constructor de la clase TransferenciaPage
     * @param driver la instancia de WebDriver utilizada para interactuar con la página web
     */
    public TransferenciaPage(WebDriver driver, WebDriverWait wait) {
        super(driver, null);
    }

    /** Completa form de "Iniciar sesion" .
     * @throws InterruptedException si el hilo es interrumpido mientras espera
     */
    public void iniciarSesion(String username, String password) throws InterruptedException {
        this.logIn(username, inputUsuario, password, inputContraseña, btnIniciarSesion);
    }

    /** Hace click en la opcion "Transferir".
     * @throws InterruptedException si el hilo es interrumpido mientras espera
     */
    public void clickTransferirFondos() throws InterruptedException {
        this.click(btnTransferirFondos);
    }

    /** Obtiene el texto del titulo de transferir fondos.
     * @return el texto del mensaje de transferir fondos
     * @throws InterruptedException si el hilo es interrumpido mientras espera
     */
    public String paginaTransferirFondos() throws InterruptedException {
        String res = this.getText(titulo);
        System.out.println("Resultado titulo transferir fondos: " + res);
        return res;
    }

    /** Ingresa el monto  en el campo de monto.
     * @param amount el monto a ingresar en el campo
     * @throws InterruptedException si el hilo es interrumpido mientras espera
     */
    public void escribirElMonto(String amount) throws InterruptedException {
        this.sendText(amount, inputImporte);
    }

    /** Hace click en selector "Desde Cuenta" y selecciona 1era opcion.
     * @throws InterruptedException si el hilo es interrumpido mientras espera
     */
    public void clickOpcionCuentaUno() throws InterruptedException {
        this.click(selectorCuentaUno);
        this.click(cuentaUno);
        System.out.println("se hizo click 1era opcion de cuenta");
    }

    /** Hace click en selector "A Cuenta" y selecciona 2da opcion.
     * @throws InterruptedException si el hilo es interrumpido mientras espera
     */
    public void clickOpcionCuentaDos() throws InterruptedException {
        this.click(selectorCuentaDos);
        this.click(cuentaDos);
        System.out.println("se hizo click 2da opcion de cuenta");
    }

    /** Hace click en btn "transferir".
     * @throws InterruptedException si el hilo es interrumpido mientras espera
     */
    public void clickTransferir() throws InterruptedException {
        this.click(btnTransferirOk);
        System.out.println("se hizo click Transferir");
    }

    /** Obtiene el texto del titulo de transferencia realizada.
     * @return el texto del mensaje de transferencia realizada
     * @throws InterruptedException si el hilo es interrumpido mientras espera
     */
    public String paginaTransferenciaRealizada() throws InterruptedException {
        String res = this.getText(exito);
        System.out.println("Resultado de transferencia realizada: " + res);
        return res;
    }

}
