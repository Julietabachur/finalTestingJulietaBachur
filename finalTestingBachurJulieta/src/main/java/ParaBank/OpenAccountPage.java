package ParaBank;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OpenAccountPage extends BasePage{
    private By inputUsuario = By.cssSelector("input[name='username']");
    private By inputContraseña = By.cssSelector("input[name='password']");
    private By btnIniciarSesion = By.cssSelector("input[value='Log In']");
    private By btnAbrirCuenta = By.cssSelector("a[href='openaccount.htm']");
    private By tipoCuenta = By.id("type");
    private By cajaDeAhorro = By.cssSelector("option[value='1']");
    private By abrirCuenta = By.cssSelector("input[value='Open New Account']");
    private By exito = By.xpath("//p[normalize-space()='Congratulations, your account is now open.']");

    /**Constructor de la clase OpenAccountPage
     * @param driver la instancia de WebDriver utilizada para interactuar con la página web
     */
    public OpenAccountPage(WebDriver driver, WebDriverWait wait) {
        super(driver, null);
    }

    /** Ingresa el usuario en el campo de usuario.
     * @param name el usuario a ingresar en el campo
     * @throws InterruptedException si el hilo es interrumpido mientras espera
     */
    public void escribirUsuario(String name) throws InterruptedException {
        this.sendText(name, inputUsuario);
    }

    /** Ingresa la contraseña en el campo de contraseña.
     * @param name el usuario a ingresar en el campo
     * @throws InterruptedException si el hilo es interrumpido mientras espera
     */
    public void escribirContraseña(String name) throws InterruptedException {
        this.sendText(name, inputContraseña);
    }

    /** Hace click en el botón "Iniciar sesion" .
     * @throws InterruptedException si el hilo es interrumpido mientras espera
     */
    public void clickIniciarSesion() throws InterruptedException {
        this.click(btnIniciarSesion);
    }

    /** Hace click en el botón "Open new account" .
     * @throws InterruptedException si el hilo es interrumpido mientras espera
     */
    public void clickAbrirCuenta() throws InterruptedException {
        this.click(btnAbrirCuenta);
    }

    /** Hace click en el desplegable "Tipo de cuenta" .
     * @throws InterruptedException si el hilo es interrumpido mientras espera
     */
    public void clickTipoCuenta() throws InterruptedException {
        this.click(tipoCuenta);
    }

    /** Hace click en la opcion "Savings" .
     * @throws InterruptedException si el hilo es interrumpido mientras espera
     */
    public void clickSavings() throws InterruptedException {
        this.click(cajaDeAhorro);
    }

    /** Hace click en la opcion "Abrir cuenta" para confirmar.
     * @throws InterruptedException si el hilo es interrumpido mientras espera
     */
    public void clickAbrirCajaAhorro() throws InterruptedException {
        this.click(abrirCuenta);
    }

    /** Obtiene el texto del mensaje de éxito indicando la creación de la cuenta.
     * @return el texto del mensaje de éxito
     * @throws InterruptedException si el hilo es interrumpido mientras espera
     */
    public String cuentaCreadaExito() throws InterruptedException {
        wait.until(ExpectedConditions.presenceOfElementLocated(exito));
        String res = this.getText(exito);
        System.out.println("Resultado: " + res);
        return res;
    }
}
