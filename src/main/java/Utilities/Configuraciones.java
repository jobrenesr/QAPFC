package Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Configuraciones {

	public static WebDriver driver;
	static {
		driver = getDriver("es");
	}

	public static WebDriver getDriver(String locate) {

		try {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "/src/main/java/Dependencias/chromedriver.exe");
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.addArguments("--start-maximized");
			chromeOptions.addArguments("--lang=es-la");
			driver = new ChromeDriver(chromeOptions);
			driver.manage().window().maximize();
		} catch (Exception e) {

		}
		return driver;

	}

}
