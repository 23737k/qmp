import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

import Excepciones.SugerenciaException;

public interface Guardarropas {	
}

class GuardarropasPublico implements Guardarropas{
	
	private List<Prenda> prendasDisponibles= new ArrayList<Prenda>();	
	private CategoriaGuardarropa categoria;
	private List<Sugerencia> suggestions;
	private Stack<Sugerencia> doneSuggestions;
	
	
	public GuardarropasPublico(List<Prenda> prendasDisponibles, CategoriaGuardarropa categoria) {
		this.prendasDisponibles = prendasDisponibles;
		this.categoria = categoria;
		this.suggestions = new ArrayList<Sugerencia>();
		this.doneSuggestions = new Stack<Sugerencia>();
	}

	public void sugerirAgregar(Prenda prenda) {
		this.suggestions.add(new SugerirAgregar(prenda));
	}
	
	public void sugerirQuitar(Prenda prenda) {
		this.suggestions.add(new SugerirQuitar(prenda));
	}
	
	
	public List<Prenda> getPrendasDeCategoria(Categoria categoria){
		return this.prendasDisponibles.stream().
				filter(prenda -> prenda.tipo.getCategoria().equals(categoria)).
				collect(Collectors.toList());
	}
	
	
	public List<Sugerencia>  getSuggestions() {
		return this.suggestions;
	}
	
	
	public void aceptarSugerencia(Sugerencia sugerencia) {
		if(!(suggestions.contains(sugerencia))) {
			throw new SugerenciaException("La sugerencia no existe en este guardarropas");
		}
		this.prendasDisponibles= sugerencia.hacer(this.prendasDisponibles);
		this.suggestions.remove(sugerencia);
		this.doneSuggestions.push(sugerencia);
	}
	
	
	public void rechazarSugerencia(Sugerencia sugerencia) {
		if(!(suggestions.contains(sugerencia))) {
			throw new SugerenciaException("La sugerencia no existe en este guardarropas");
		}
		this.suggestions.remove(sugerencia);
	}
	
	
	public void deshacerUltimaSugerencia() {
		if(this.doneSuggestions.empty()) {
			throw new SugerenciaException("No hay mas sugerencias por deshacer");
		}
		
		this.prendasDisponibles= this.doneSuggestions.pop().deshacer(this.prendasDisponibles);
	}

	public CategoriaGuardarropa getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoriaGuardarropa categoria) {
		this.categoria = categoria;
	}
	
	
}


class GuardarropasPrivado implements Guardarropas{
	private List<Prenda> prendasDisponibles= new ArrayList<Prenda>();	
	private CategoriaGuardarropa categoria;
	
	public GuardarropasPrivado(List<Prenda> prendasDisponibles, CategoriaGuardarropa categoria) {
		this.prendasDisponibles = prendasDisponibles;
		this.categoria = categoria;
	}

	public List<Prenda> getPrendasDisponibles() {
		return prendasDisponibles;
	}

	public CategoriaGuardarropa getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoriaGuardarropa categoria) {
		this.categoria = categoria;
	}
	
}
	
	

	

	
	
