import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

import Excepciones.PrendaInvalidaException;
import Excepciones.SugerenciaException;

public interface Guardarropas {

  public void agregar(Prenda prenda);	
  
  public void quitar(Prenda prenda);
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
		this.suggestions.add(new Agregar(prenda));
	}
	
	public void sugerirQuitar(Prenda prenda) {
		this.suggestions.add(new Quitar(prenda));
	}
	
	public void agregar(Prenda prenda) {
	  if(this.prendasDisponibles.contains(prenda)) {
      throw new PrendaInvalidaException("La prenda indicada en la sugerencia ya existe en el guardarropas");
    }
	  this.prendasDisponibles.add(prenda);
	}
	
	public void quitar(Prenda prenda) {
	  if(!(this.prendasDisponibles.contains(prenda))) {
      throw new PrendaInvalidaException("La prenda indicada en la sugerencia no existe en el guardarropas");
    }
    this.prendasDisponibles.remove(prenda);
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
		sugerencia.hacer(this);
		this.suggestions.remove(sugerencia);
		this.doneSuggestions.push(sugerencia);
	}
	
	
	public void rechazarSugerencia(Sugerencia sugerencia) {
		this.suggestions.remove(sugerencia);
	}
	
	
	public void deshacerUltimaSugerencia() {
		if(this.doneSuggestions.empty()) {
			throw new SugerenciaException("No hay mas sugerencias por deshacer");
		}
		
		this.doneSuggestions.pop().deshacer(this);
	}

	public CategoriaGuardarropa getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoriaGuardarropa categoria) {
		this.categoria = categoria;
	}

	
	
}


	

	
	
