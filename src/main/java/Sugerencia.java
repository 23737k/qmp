import java.util.List;

import Excepciones.SugerenciaException;

public interface Sugerencia {
  
	public abstract List<Prenda> hacer(List<Prenda> prendas);
	public abstract List<Prenda> deshacer(List<Prenda> prendas);
}



class Agregar implements Sugerencia{
  
  private Prenda prenda;

	public Agregar(Prenda prenda) {
		this.prenda= prenda;
	}
	
	
	public List<Prenda> hacer(List<Prenda> prendas) {
		
		if(prendas.contains(this.prenda)) {
			throw new SugerenciaException("El guardarropas ya contiene esta prenda");
		}

		List<Prenda> newList= prendas;
		newList.add(this.prenda);
		return newList;
	}
	
	public List<Prenda> deshacer(List<Prenda> prendas) {
		if(!prendas.contains(this.prenda)) {
			throw new SugerenciaException("No se puede realizar la accion. La prenda ya no existe");
		}
		List<Prenda> newList= prendas;
		newList.remove(this.prenda);
		return newList;
	}
		
}

class Quitar implements Sugerencia{
	
  private Prenda prenda;

	
	public Quitar(Prenda prenda) {
		this.prenda= prenda;
	}
	
	public List<Prenda> hacer(List<Prenda> prendas) {
		if(!prendas.contains(this.prenda)) {
			throw new SugerenciaException("Esta prenda no existe en el guardarropas");
		}
		
		List<Prenda> newList= prendas;
		newList.remove(this.prenda);
		return newList;
	}
	
	public List<Prenda> deshacer(List<Prenda> prendas) {
		if(prendas.contains(this.prenda)) {
			throw new SugerenciaException("No se puede realizar la accion. La prenda ya existe");
		}
		List<Prenda> newList= prendas;
		newList.add(this.prenda);
		return newList;
	}
	
	
}

