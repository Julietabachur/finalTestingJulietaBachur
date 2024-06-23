package ParaBank;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ResumenPage extends BasePage{
    private By verResumen = By.linkText("Accounts Overview");
    private By exito = By.xpath("//td[contains(text(),'*Balance includes deposits that may be subject to holds')]");
    private By inputUsuario = By.cssSelector("input[name='username']");
    private By inputContraseña = By.cssSelector("input[name='password']");
    private By btnIniciarSesion = By.cssSelector("input[value='Log In']");


    /**Constructor de la clase ResumenPage
     * @param driver la instancia de WebDriver utilizada para interactuar con la página web
     */
    public ResumenPage(WebDriver driver, WebDriverWait wait) {
        super(driver, null);
    }

    /** Completa form de "Iniciar sesion" .
     * @throws InterruptedException si el hilo es interrumpido mientras espera
     */
    public void iniciarSesion(String username, String password) throws InterruptedException {
        this.logIn(username, inputUsuario, password, inputContraseña, btnIniciarSesion);
    }

    /** Hace click en la opcion "Accounts Overview".
     * @throws InterruptedException si el hilo es interrumpido mientras espera
     */
    public void clickResumen() throws InterruptedException {
        this.click(verResumen);
    }

    /** Obtiene el texto del mensaje de éxito indicando que se ve el resumen.
     * @return el texto del mensaje de éxito
     * @throws InterruptedException si el hilo es interrumpido mientras espera
     */
    public String resumenExito() throws InterruptedException {
        String res = this.getText(exito);
        System.out.println("Resultado: " + res);
        return res;
    }
}
