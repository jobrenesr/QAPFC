package Automation;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import Utilities.Configuraciones;
import Utilities.DataProviders;
import Utilities.LogPaso;
import Utilities.Report;
import Utilities.Screenshot;
import pomPages.ComerciosPom;
import pomPages.ContactoPom;
import pomPages.HomePom;
import pomPages.LoginPom;

public class Main extends Configuraciones{

private static HomePom homePom =  HomePom.getInstance();
private static LoginPom loginPom =  LoginPom.getInstance();
private static ContactoPom contactoPom =  ContactoPom.getInstance();
private static DataProviders dataProviders = DataProviders.getInstance();
private static ComerciosPom comerciosPom = ComerciosPom.getInstance();
public static Report report = Report.getInstance();
private static LogPaso paso = LogPaso.getInstance();
private final int start=1;
private final String Spaso = "Paso";



@BeforeTest
	public void inicioTest() {
	//Setea todas las propiedades para el iniciar con el reporte
	report.configuracionReporte();
}

@AfterTest
public void finalizarTest() {
	//Cierra el driver después de usarlo y cierra el reporte
	driver.close();
	driver.quit();
	report.cierreReporte();
	
}

//Procesa los resultados de las pruebas para generar el reporte
@AfterMethod
public void generarStatus(ITestResult result) throws IOException {
	report.obtenerResultado(result);
}


@Test (priority = 1, description = "Parte 1 Acceso y Navegación")
public void Parte1() throws IOException, InterruptedException {
	paso.setPaso(start);
try {
	report.logger = report.extent.createTest("Parte 1 Acceso y Navegación");
	
	//Ingresa al home de Club Promerica
	driver.get(homePom.sHomeClubPromerica());
	report.logger.log(Status.PASS, MarkupHelper.createLabel(Spaso + paso.getPaso(), ExtentColor.GREEN));
	paso.addPaso();
	
	// Da Click en el botón de login
	homePom.btnLogin().click();
	report.logger.log(Status.PASS, MarkupHelper.createLabel(Spaso + paso.getPaso(), ExtentColor.GREEN));
	paso.addPaso();
	
	//Da click en el boton de iniciar sesión
	homePom.btnIniciarSesion().click();
	report.logger.log(Status.PASS, MarkupHelper.createLabel(Spaso + paso.getPaso(), ExtentColor.GREEN));
	paso.addPaso();
	
	//Verifica que el titulo de la página sea el esperado con el mensaje de aceptación
	assertEquals("Club Promerica. Inicio de sesión",driver.getTitle());
	report.logger.log(Status.PASS, MarkupHelper.createLabel(Spaso + paso.getPaso(), ExtentColor.GREEN));
	paso.addPaso();
	
	//Verifica que se encuentre un elemento por medio de XPATH
	loginPom.txtMensajeLoginPath().isDisplayed();
	report.logger.log(Status.PASS, MarkupHelper.createLabel(Spaso + paso.getPaso(), ExtentColor.GREEN));
	paso.addPaso();
	
	Assert.assertTrue(true);
	
} catch (NoSuchElementException e) {
	
	/*Al no estar visible el elemento, la prueba genera un fallo en el test
	e imprime en consola en caso que se quier debugear */
	
	Assert.assertTrue(false);
	report.logger.log(Status.FAIL, MarkupHelper.createLabel("Caso de prueba ERRONEO", ExtentColor.RED));
}

}

@Test (priority = 2, description = "Parte 2: Interacción con Elementos")
public void Parte2() throws IOException, InterruptedException {
	paso.setPaso(start);
	try {
		
		report.logger = report.extent.createTest("Parte 2: Interacción con Elementos");
		
		//Ingresa al formulario de club Promerica
		driver.get(contactoPom.sLinkContactoClubPromerica());
		report.logger.log(Status.PASS, MarkupHelper.createLabel(Spaso + paso.getPaso(), ExtentColor.GREEN));
		paso.addPaso();
		
		//Llena el campo de nombre del formulario de contacto
		contactoPom.txtNombreContacto().sendKeys(dataProviders.sNombrePersona());
		report.logger.log(Status.PASS, MarkupHelper.createLabel(Spaso + paso.getPaso(), ExtentColor.GREEN));
		paso.addPaso();
		
		//Llena el campo de correo del formulario de contacto
		contactoPom.txtCorreroContacto().sendKeys(dataProviders.sCorreo());
		report.logger.log(Status.PASS, MarkupHelper.createLabel(Spaso + paso.getPaso(), ExtentColor.GREEN));
		paso.addPaso();
		
		//Llena el campo de Comentario del formulario de contacto
		contactoPom.txtComentarioContacto().sendKeys(dataProviders.sComentario());
		report.logger.log(Status.PASS, MarkupHelper.createLabel(Spaso + paso.getPaso(), ExtentColor.GREEN));
		paso.addPaso();
		
		//Da click al botón enviar para llenar el formulario
		contactoPom.btnEnviarContacto().click();
		report.logger.log(Status.PASS, MarkupHelper.createLabel(Spaso + paso.getPaso(), ExtentColor.GREEN));
		paso.addPaso();
		
		//Valida que  se muestre la pagina donde se confirma el envío exitoso del formulario
		assertEquals(contactoPom.txtConfirmacionContactForm().getText(), contactoPom.sMensajeConfirmacionContactForm());
		report.logger.log(Status.PASS, MarkupHelper.createLabel(Spaso + paso.getPaso(), ExtentColor.GREEN));
		paso.addPaso();
		
		Assert.assertTrue(true);
	
		} catch (NoSuchElementException e) {
	
	/*Al no estar visible el elemento, la prueba genera un fallo en el test
	e imprime en consola en caso que se quier debugear */
	Assert.assertTrue(false);
	report.logger.log(Status.FAIL, MarkupHelper.createLabel("Caso de prueba ERRONEO", ExtentColor.RED));
		}
}

@Test (priority = 3, description = "Parte 3: Validación")
public void Parte3() throws IOException, InterruptedException {
	paso.setPaso(start);
	try {
		report.logger = report.extent.createTest("Parte 3: Validación");

		//Navega a la pagina web de comercios
		comerciosPom.btnComercios().click();
		report.logger.log(Status.PASS, MarkupHelper.createLabel(Spaso + paso.getPaso(), ExtentColor.GREEN));
		paso.addPaso();
		
		//Verifica por medio de texto que se muestre la página de comercios
		assertEquals(comerciosPom.txtComercios().getText(), comerciosPom.sMensajeComercios());
		report.logger.log(Status.PASS, MarkupHelper.createLabel(Spaso + paso.getPaso(), ExtentColor.GREEN));
		paso.addPaso();
		
		Assert.assertTrue(true);
	} catch (Exception e) {
		// TODO: handle exception
		Assert.assertTrue(false);
		report.logger.log(Status.FAIL, MarkupHelper.createLabel("Caso de prueba ERRONEO", ExtentColor.RED));}
 }


@Test (priority = 4, description = "Parte 4: Capturas de Pantalla y Reportes")
public void Parte4() throws IOException, InterruptedException {
	paso.setPaso(start);
	try {
		report.logger = report.extent.createTest("Parte 4: Capturas de Pantalla y Reportes");
		
		//Toma un screenshot de la página actual
		Screenshot.capture(driver, "Parte 4"  + "_" + Spaso + paso.getPaso() + "_" + report.getCurrentLocalDateTimeStamp());
		report.logger.log(Status.PASS, MarkupHelper.createLabel(Spaso + paso.getPaso(), ExtentColor.GREEN));
		paso.addPaso();
		
		Assert.assertTrue(true);
		
	} catch (Exception e) {
		// TODO: handle exception
		Assert.assertTrue(false);
		report.logger.log(Status.FAIL, MarkupHelper.createLabel("Caso de prueba ERRONEO", ExtentColor.RED));
	}

}
}