package entities;

public enum WorkerLevel {
	JUNIOR(1),
	MID_LEVEL(2),
	SENIOR(3);
	
	private int codigo;
	
	WorkerLevel (int codigo) {
		this.codigo = codigo;
	}

	public int getCodigo() {
		return codigo;
	}

	
	
}
