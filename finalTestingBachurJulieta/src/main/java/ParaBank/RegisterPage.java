package ParaBank;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterPage extends BasePage{
    private By btnRegistrarse = By.linkText("Register");
    private By nombre = By.id("customer.firstName");
    private By apellido = By.id("customer.lastName");
    private By direccion = By.id("customer.address.street");
    private By ciudad = By.id("customer.address.city");
    private By estado = By.id("customer.address.state");
    private By codigoPostal = By.id("customer.address.zipCode");
    private By telefono = By.id("customer.phoneNumber");
    private By ssn = By.id("customer.ssn");
    private By usuario = By.id("customer.username");
    private By password = By.id("customer.password");
    private By repassword = By.id("repeatedPassword");
    private By btnCrearCuenta = By.cssSelector("input[value='Register']");
    private By gracias = By.className("txt-gracias");
    private By exito = By.xpath("//p[contains(text(),'Your account was created successfully. You are now')]");
    private By mailRegister = By.className("form-feedback");
    private By passwordDis = By.className("small-feedback");

    /**Constructor de la clase RegisterPage
     * @param driver la instancia de WebDriver utilizada para interactuar con la página web
     */
    public RegisterPage(WebDriver driver, WebDriverWait wait) {
        super(driver, null);
    }

    /** Hace click en el botón "REGISTER" luego de llenar el form.
     * @throws InterruptedException si el hilo es interrumpido mientras espera
     */
    public void clickCrearCuenta() throws InterruptedException {
        this.click(btnCrearCuenta);
    }

    /** Ingresa el nombre proporcionado en el campo de nombre.
     * @param name el nombre a ingresar en el campo
     * @throws InterruptedException si el hilo es interrumpido mientras espera
     */
    public void escribirNombre(String name) throws InterruptedException {
        this.sendText(name, nombre);
    }

    /** Ingresa el apellido proporcionado en el campo de apellido.
     * @param name el apellido a ingresar en el campo
     * @throws InterruptedException si el hilo es interrumpido mientras espera
     */
    public void escribirApellido(String name) throws InterruptedException {
        this.sendText(name, apellido);
    }

    /** Ingresa el direccion proporcionado en el campo de direccion.
     * @param name el direccion a ingresar en el campo
     * @throws InterruptedException si el hilo es interrumpido mientras espera
     */
    public void escribirDireccion(String name) throws InterruptedException {
        this.sendText(name, direccion);
    }

    /** Ingresa el ciudad proporcionado en el campo de ciudad.
     * @param name el ciudad a ingresar en el campo
     * @throws InterruptedException si el hilo es interrumpido mientras espera
     */
    public void escribirCiudad(String name) throws InterruptedException {
        this.sendText(name, ciudad);
    }

    /** Ingresa el estado proporcionado en el campo de estado.
     * @param name el estado a ingresar en el campo
     * @throws InterruptedException si el hilo es interrumpido mientras espera
     */
    public void escribirEstado(String name) throws InterruptedException {
        this.sendText(name, estado);
    }

    /** Ingresa el codigoPostal proporcionado en el campo de codigoPostal.
     * @param name el codigoPostal a ingresar en el campo
     * @throws InterruptedException si el hilo es interrumpido mientras espera
     */
    public void escribirCodigoPostal(String name) throws InterruptedException {
        this.sendText(name, codigoPostal);
    }

    /** Ingresa el telefono proporcionado en el campo de telefono.
     * @param name el telefono a ingresar en el campo
     * @throws InterruptedException si el hilo es interrumpido mientras espera
     */
    public void escribirTelefono(String name) throws InterruptedException {
        this.sendText(name, telefono);
    }

    /** Ingresa el ssn proporcionado en el campo de ssn.
     * @param name el ssn a ingresar en el campo
     * @throws InterruptedException si el hilo es interrumpido mientras espera
     */
    public void escribirSsn(String name) throws InterruptedException {
        this.sendText(name, ssn);
    }

    /** Ingresa el usuario proporcionado en el campo de usuario.
     * @param name el usuario a ingresar en el campo
     * @throws InterruptedException si el hilo es interrumpido mientras espera
     */
    public void escribirUsuario(String name) throws InterruptedException {
        this.sendText(name, usuario);
    }


//    /** Ingresa el correo electrónico proporcionado en el campo de correo electrónico.
//     * @param mail el correo electrónico a ingresar en el campo
//     * @throws InterruptedException si el hilo es interrumpido mientras espera
//     */
//    public void escribirCorreo(String mail) throws InterruptedException {
//        this.sendText(mail, email);
//    }

    /** Ingresa la contraseña proporcionada en el campo de contraseña.
     * @param pass la contraseña a ingresar en el campo
     * @throws InterruptedException si el hilo es interrumpido mientras espera
     */
    public void escribirContraseña(String pass) throws InterruptedException {
        this.sendText(pass, password);
    }

    /** Reingresa la contraseña proporcionada en el campo de confirmación de contraseña.
     * @param pass la contraseña a reingresar en el campo
     * @throws InterruptedException si el hilo es interrumpido mientras espera
     */
    public void repetirContraseña(String pass) throws InterruptedException {
        this.sendText(pass, repassword);
    }

    /** Hace click en el botón "Register".
     *
     * @throws InterruptedException si el hilo es interrumpido mientras espera
     */
    public void clickRegistrarse() throws InterruptedException {
        this.click(btnRegistrarse);
    }

    /** Obtiene el texto del mensaje de "Gracias" indicando la creación de la cuenta.
     * @return el texto del mensaje de "Gracias"
     * @throws InterruptedException si el hilo es interrumpido mientras espera
     */
    public String cuentaCreadaGracias() throws InterruptedException {
        String res = this.getText(gracias);
        System.out.println("Resultado Card value: " + res);
        return res;
    }

    /** Obtiene el texto del mensaje de éxito indicando la creación de la cuenta.
     * @return el texto del mensaje de éxito
     * @throws InterruptedException si el hilo es interrumpido mientras espera
     */
    public String cuentaCreadaExito() throws InterruptedException {
        String res = this.getText(exito);
        System.out.println("Resultado Card value: " + res);
        return res;
    }

    /** Obtiene el texto del mensaje indicando que el correo ya está registrado.
     * @return el texto del mensaje de correo registrado
     * @throws InterruptedException si el hilo es interrumpido mientras espera
     */
    public String mailRegistrado() throws InterruptedException {
        String res = this.getText(mailRegister);
        System.out.println("Resultado Card value: " + res);
        return res;
    }

    /** Obtiene el texto del mensaje indicando que las contraseñas no coinciden.
     * @return el texto del mensaje de contraseñas no coincidentes
     * @throws InterruptedException si el hilo es interrumpido mientras espera
     */
    public String contraseñaNoCoinciden() throws InterruptedException {
        String res = this.getText(passwordDis);
        System.out.println("Resultado Card value: " + res);
        return res;
    }
}
