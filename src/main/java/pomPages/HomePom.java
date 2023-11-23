package pomPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Utilities.Configuraciones;
import Utilities.Report;

public class HomePom extends Configuraciones {

	private static HomePom instance = null;

	// Patron Singleton para no generar nuevas instancias
	public static HomePom getInstance() {
		if (null == instance)
			instance = new HomePom();
		return instance;
	}

	public WebElement btnHome() {
		return driver.findElement(By.cssSelector(".mega-menu > li:nth-child(1) > a:nth-child(1) > span:nth-child(1)"));
	}

	public WebElement btnComercios() {
		return driver.findElement(By.cssSelector(".mega-menu > li:nth-child(2) > a:nth-child(1)"));
	}

	public WebElement btnLogin() {
		return driver.findElement(By.cssSelector("#header-links-opener > span:nth-child(1)"));
	}

	public WebElement btnIniciarSesion() {
		return driver.findElement(By.cssSelector(".ico-login"));
	}

	public String sHomeClubPromerica() {
		return "https://www.clubpromerica.com/costarica/";
	}

}
