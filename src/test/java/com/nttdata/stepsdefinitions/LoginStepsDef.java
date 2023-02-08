package com.nttdata.stepsdefinitions;

import com.nttdata.steps.BestQualificationsSteps;
import com.nttdata.steps.HomePageSteps;
import com.nttdata.steps.InformationProductSteps;
import com.nttdata.steps.LoginSteps;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginStepsDef {
    private WebDriver driver;
    private Scenario scenario;
    private HomePageSteps homePageSteps(WebDriver driver){
        return new HomePageSteps(driver);
    }

    private InformationProductSteps informationProductSteps(WebDriver driver) {
        return new InformationProductSteps(driver);
    }

    @Before(order = 0)
    public void setUp(){
        //inicializacion del ubicacion del driver+
        System.setProperty("webdriver.chrome.driver","." + "\\drivers\\chromedriver.exe");
        //creacion del driver
        driver = new ChromeDriver();
        //Expansion de display ventana
        driver.manage().window().maximize();
    }

    @Before(order = 1)
    public void setScenario(Scenario scenario){
        this.scenario = scenario;
    }

    @After
    public void tearDowm(){
       driver.close();
    }

    @Dado("que me encuentro en la página de login de Lineo")
    public void que_me_encuentro_en_la_página_de_login_de_lineo() {
        driver.get("https://www.linio.com.pe/account/login");
        screenShot();
    }

    @Cuando("inicio sesión con las credenciales Email: {string} y contraseña: {string}")
    public void inicio_sesión_con_las_credenciales_email_y_contraseña(String email, String contras) {
        LoginSteps loginSteps= new LoginSteps(driver);
        loginSteps.typeEmail(email);
        loginSteps.typeContras(contras);
        loginSteps.login();
        screenShot();
    }
    @Entonces("valido la autenticacion correcta {string}")
    public void valido_la_autenticacion_correcta(String expectedProUserName) {
        String title =  homePageSteps(driver).getProfileUser();
        //validar el nombre del perfil del usuario logeado
        Assertions.assertEquals(expectedProUserName, title);
        screenShot();
    }
    @Cuando("selecciona la categoria mejores calificados")
    public void selecciona_la_categoria_mejores_calificados() {
        homePageSteps(driver).selectCategoria();
        screenShot();
    }
    @Cuando("da click en el primer producto")
    public void da_click_en_el_primer_producto() {
        BestQualificationsSteps  bestQualificationsSteps = new BestQualificationsSteps(driver);
        bestQualificationsSteps.selectItemProduct();
        screenShot();
    }
    @Entonces("se visualiza el detalle del producto con nombre {string}")
    public void se_visualiza_el_detalle_del_producto_con_nombre(String expectedProductName) {
        InformationProductSteps informationProductSteps= new InformationProductSteps(driver);
        String nombreProducto = informationProductSteps.getProductName();
        Assertions.assertEquals(expectedProductName, nombreProducto);
        screenShot();
    }
    @Cuando("se selecciona el boton añadir carrito")
    public void se_selecciona_el_boton_añadir_carrito() {
        informationProductSteps(driver).selectAddButton();
    }
    @Entonces("se visualiza el mensaje {string}")
    public void se_visualiza_el_mensaje(String expecteMessage) {
        String messageConfirmation = informationProductSteps(driver).getAddConfirmation();
        Assertions.assertEquals(expecteMessage, messageConfirmation);
        screenShot();
    }
    public void screenShot(){
        byte[] evidencia = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        this.scenario.attach(evidencia, "imagen/png", "evidencias");
    }
}
