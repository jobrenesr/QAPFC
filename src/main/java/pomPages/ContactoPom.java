package pomPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Utilities.Configuraciones;
import Utilities.Report;

public class ContactoPom extends Configuraciones{
	
	private static ContactoPom instance = null;
	
	// Patron Singleton para no generar nuevas instancias
	public static ContactoPom getInstance() {
		if (null == instance)
			instance = new ContactoPom();
		return instance;
	}
	
	public String sLinkContactoClubPromerica() {
		return "https://www.clubpromerica.com/costarica/contactus";  
	}
	
	public WebElement txtNombreContacto() {
		return driver.findElement(By.cssSelector("#FullName"));
	}
	
	public WebElement txtCorreroContacto() {
		return driver.findElement(By.cssSelector("#Email"));
	}
	
	public WebElement txtComentarioContacto() {
		return driver.findElement(By.cssSelector("#Enquiry"));
	}
	
	public WebElement btnEnviarContacto() {
		return driver.findElement(By.cssSelector("input.button-1:nth-child(1)"));
	}
	
	public WebElement txtConfirmacionContactForm() {
		return driver.findElement(By.cssSelector(".result"));
	}
	
	public String sMensajeConfirmacionContactForm() {
		return "Su comentario ha sido enviado con éxito al propietario de la tienda.";  
	}
	
	
}
