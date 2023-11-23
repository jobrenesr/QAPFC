package Utilities;

public class DataProviders extends Configuraciones{

	private static DataProviders instance = null;
	
	// Patron Singleton para no generar nuevas instancias
	public static DataProviders getInstance() {
		if (null == instance)
			instance = new DataProviders();
		return instance;
	}

	public String sNombrePersona() {
		return "Departamento QA";  
	}
	
	public String sCorreo() {
		return "grupoqa@promerica.fi.cr";  
	}
	
	public String sComentario() {
		return "Me parece muy bonita su pagina sigan adelante";  
	}
	
	
}