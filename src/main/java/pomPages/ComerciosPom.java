package pomPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Utilities.Configuraciones;
import Utilities.Report;

public class ComerciosPom extends Configuraciones {
	
	private static ComerciosPom instance = null;
	
	// Patron Singleton para no generar nuevas instancias
	public static ComerciosPom getInstance() {
		if (null == instance)
			instance = new ComerciosPom();
		return instance;
	}
	
	public WebElement btnComercios() {
		return driver.findElement(By.cssSelector(".mega-menu > li:nth-child(5) > a:nth-child(1)"));
	}
	
	public WebElement txtComercios() {
		return driver.findElement(By.cssSelector(".page-title > h1:nth-child(1)"));
	}
	
	public String sMensajeComercios() {
		return "COMERCIOS";  
	}
	
}