package Utilities;

public class LogPaso {
	
private static LogPaso instance = null;
	
	// Patron Singleton para no generar nuevas instancias
	public static LogPaso getInstance() {
		if (null == instance)
			instance = new LogPaso();
		return instance;
	}

	private int paso;
	private int subPaso;

	public int getPaso() {
		return paso;
	}

	public void setPaso(int step) {
		this.paso = step;
	}

	public int addPaso() {
		return paso++;
	}

	public int getSuBPaso() {
		return subPaso;
	}

	public void setSubPaso(int subStep) {
		this.subPaso = subStep;
	}

	public int addSubPaso() {
		return subPaso++;
	}
}
