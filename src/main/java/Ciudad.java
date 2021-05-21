
public enum Ciudad {
	
	BSAS("Buenos Aires, Argentina");
	
	private Ciudad(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	private String nombre;
	
	
}
