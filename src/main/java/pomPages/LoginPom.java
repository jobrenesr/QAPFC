package pomPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Utilities.Configuraciones;
import Utilities.Report;

public class LoginPom extends Configuraciones{
	
	private static LoginPom instance = null;
	
	// Patron Singleton para no generar nuevas instancias
	public static LoginPom getInstance() {
		if (null == instance)
			instance = new LoginPom();
		return instance;
	}
	
	//Texto que indica que estamos dentro de la página de login, mensaje que debería mostrar: "Bienvenido, identifícate"
	
	public WebElement txtMensajeLoginPath() {
		return driver.findElement(By.xpath("//*[@id=\"pageTittleText\"]"));
	}
	
	public String txtMensajeLogin() {
		
		String mensaje = "BIENVENIDO, IDENTIFÍCATE!";
		
		return mensaje;
	}
}
