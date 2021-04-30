import java.util.Arrays;
import java.util.List;

public enum TipoPrenda {

	ZAPATO(Categoria.CALZADO) {
		@Override
		public List<Material> materialesDisponibles() {
			List<Material> materiales = Arrays.asList(Material.CUERO);
			return materiales;
		}
		@Override
		public List<Trama> tramasDisponibles(){
			List<Trama> tramas = Arrays.asList(Trama.LISA);
			return tramas;
		}
		
		@Override
		public List<Color> coloresPrimariosDisponibles(){
			List<Color> color = Arrays.asList(new Color("#FF0000"));
			return color;
		}
		

		@Override
		public List<Color> coloresSecundariosDisponibles() {
			List<Color> color = Arrays.asList();
			return color;
		}
		
	},

	CAMISA(Categoria.SUPERIOR) {
		@Override
		public List<Material> materialesDisponibles() {
			List<Material> materiales = Arrays.asList(Material.JEAN, Material.ALGODON);
			return materiales;
		}
		
		@Override
		public List<Trama> tramasDisponibles(){
			List<Trama> tramas = Arrays.asList(Trama.LISA, Trama.CUADROS, Trama.LUNARES, Trama.LUNARES);
			return tramas;
		}
		
		@Override
		public List<Color> coloresPrimariosDisponibles(){
			List<Color> color = Arrays.asList(new Color("#FF0000"));
			return color;
		}
		

		@Override
		public List<Color> coloresSecundariosDisponibles() {
			List<Color> color = Arrays.asList();
			return color;
		}
	};

	Categoria categoria;
	
	public Categoria getCategoria() {
		return this.categoria;
	}

	public abstract List<Color> coloresPrimariosDisponibles();
	
	public abstract List<Color> coloresSecundariosDisponibles();
	
	public abstract List<Material> materialesDisponibles();
	
	public abstract List<Trama> tramasDisponibles();

	TipoPrenda(Categoria categoria) {
		this.categoria = categoria;
	}
}
