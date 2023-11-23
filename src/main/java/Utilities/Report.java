package Utilities;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Report extends Configuraciones{
	
	private static Report instance = null;
	
	// Patron Singleton para no generar nuevas instancias
	public static Report getInstance() {
		if (null == instance)
			instance = new Report();
		return instance;
	}

//Metodo que trae el dia, mes, año y hora para colocarla en los archivos
	public String getCurrentLocalDateTimeStamp() {
		return LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy_HH-mm-ss"));
	}

	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest logger;
	
	//Configura el inicio de los reportes para generarlos
	public void configuracionReporte() {
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") +"/reportes/ExtentReport" + getCurrentLocalDateTimeStamp() + ".html");
		extent = new ExtentReports ();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Host Name", "Pruebaspc");
		extent.setSystemInfo("Environment", "Personal PC");
		extent.setSystemInfo("User Name", "Josue Brenes");
		
		
		
		htmlReporter.config().setDocumentTitle("Prueba Tecnica QA PFC-TI");
		htmlReporter.config().setReportName("Prueba Tecnica QA PFC-TI");
		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
		htmlReporter.config().setTheme(Theme.DARK);
	}
	
	//Limpia los reportes despues de finalizado cada prueba
	public void cierreReporte() {
		extent.flush();
	}
	 //Clasifica el resultados de las pruebas para generar el informe
	public void obtenerResultado(ITestResult result) throws IOException {
			if(result.getStatus() == ITestResult.FAILURE){
				String screenShotPath = Screenshot.capture(driver, result.getName());
				logger.log(Status.FAIL, MarkupHelper
						.createLabel(result.getName() + " La prueba fallo, ver detalles abajo:", ExtentColor.RED));
				logger.fail(result.getThrowable());
				logger.log(Status.FAIL, "Snapshot below: " + logger.addScreenCaptureFromPath(screenShotPath));
			} else {
				if (result.getStatus() == ITestResult.SUCCESS) {
					logger.log(Status.PASS,
							MarkupHelper.createLabel(result.getName() + " Set de pruebas exitoso", ExtentColor.GREEN));
				} else {
					String screenShotPath1 = Screenshot.capture(driver, "prueba");
					logger.log(Status.SKIP,
							MarkupHelper.createLabel(result.getName() + " Set de pruebas omitido", ExtentColor.GREEN));
					logger.skip(result.getThrowable());
					logger.log(Status.SKIP, "Snapshot below: " + logger.addScreenCaptureFromPath(screenShotPath1));
				}
			}
			
		}
}
	

