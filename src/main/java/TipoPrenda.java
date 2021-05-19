import java.util.Arrays;
import java.util.List;

public enum TipoPrenda {

	ZAPATO(Categoria.CALZADO, Arrays.asList(new Color("#FF0000"), new Color("#00FF00")), null,
			Arrays.asList(Material.CUERO), Arrays.asList(Trama.LISA)),

	CAMISA(Categoria.SUPERIOR, Arrays.asList(new Color("#FF0000")), null,
			Arrays.asList(Material.JEAN, Material.ALGODON),
			Arrays.asList(Trama.LISA, Trama.CUADROS, Trama.LUNARES, Trama.LUNARES));
	

	public Categoria getCategoria() {
		return this.categoria;
	}

	
	public List<Color> getColoresPrimariosDisponibles() {
		return coloresPrimariosDisponibles;
	}

	public List<Color> getColoresSecundariosDisponibles() {
		return coloresSecundariosDisponibles;
	}

	public List<Material> getMaterialesDisponibles() {
		return materialesDisponibles;
	}

	public List<Trama> getTramasDisponibles() {
		return tramasDisponibles;
	}

	
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public void setColoresPrimariosDisponibles(List<Color> coloresPrimariosDisponibles) {
		this.coloresPrimariosDisponibles = coloresPrimariosDisponibles;
	}

	public void setColoresSecundariosDisponibles(List<Color> coloresSecundariosDisponibles) {
		this.coloresSecundariosDisponibles = coloresSecundariosDisponibles;
	}

	public void setMaterialesDisponibles(List<Material> materialesDisponibles) {
		this.materialesDisponibles = materialesDisponibles;
	}

	public void setTramasDisponibles(List<Trama> tramasDisponibles) {
		this.tramasDisponibles = tramasDisponibles;
	}
	
	

	private TipoPrenda(Categoria categoria, List<Color> coloresPrimariosDisponibles,
			List<Color> coloresSecundariosDisponibles, List<Material> materialesDisponibles,
			List<Trama> tramasDisponibles) {
		this.categoria = categoria;
		this.coloresPrimariosDisponibles = coloresPrimariosDisponibles;
		this.coloresSecundariosDisponibles = coloresSecundariosDisponibles;
		this.materialesDisponibles = materialesDisponibles;
		this.tramasDisponibles = tramasDisponibles;
	}

	
	Categoria categoria;
	List<Color> coloresPrimariosDisponibles;
	List<Color> coloresSecundariosDisponibles;
	List<Material> materialesDisponibles;
	List<Trama> tramasDisponibles;
}


