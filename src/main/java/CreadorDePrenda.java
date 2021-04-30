

public  class CreadorDePrenda {
	TipoPrenda tipo;
	Material material;
	Color colorPrimario; 
	Color colorSecundario;
	Trama trama;
  
	public  void elegirTipo(TipoPrenda tipo) {
		this.tipo= tipo;
	}
	
	public  void elegirMaterial(Material material, Trama trama, Color colorPrimario,
			Color colorSecundario) {
		if(tipo==null)
		{
			throw new PrendaInvalidaException("El tipo de prenda no esta especificado");
		}
		
		if(!(this.tipo.materialesDisponibles().contains(material))) {
			throw new PrendaInvalidaException("El tipo de prenda no admite este tipo de material");
		}
		
		if(!(this.tipo.tramasDisponibles().contains(trama))) {
			throw new PrendaInvalidaException("El tipo de prenda no admite este tipo de trama");
		}
		
		if(!(this.tipo.coloresPrimariosDisponibles().contains(colorPrimario))) {
			throw new PrendaInvalidaException("El tipo de prenda no admite este tipo de color"
					+ " primario");
		}
		
		if(!(this.tipo.coloresSecundariosDisponibles().contains(colorSecundario))) {
			throw new PrendaInvalidaException("El tipo de prenda no admite este tipo de color"
					+ " secundario");
		}
		
		
	}
	
	public  Prenda finalizarPrenda() {
		if(tipo == null || material == null || colorPrimario == null) {
			throw new PrendaInvalidaException("Falta definir uno o mas atributos de la prenda");
		}
		
		if(trama == null) {
			trama= Trama.LISA;
		}
		
		return new Prenda(tipo,material,trama,colorPrimario,colorSecundario);
	}
	
}


abstract class Atuendo{
	
	Prenda superior;
	Prenda inferior;
	Prenda calzado; 
	
	public void armarUniforme() {
		this.elegirPrendaSuperior();
		this.elegirPrendaInferior();
		this.elegirCalzado();
	}
	
	public abstract void elegirPrendaSuperior();
	
	public abstract void elegirPrendaInferior();
	
	public abstract void elegirCalzado();
}

class ColegioSanJuanBuilder extends Atuendo{
	
	@Override 
	
	public  void elegirPrendaSuperior() {
		CreadorDePrenda borrador= new CreadorDePrenda();
		borrador.elegirTipo(null);
		borrador.elegirMaterial(null, null, null, null);
		this.superior= borrador.finalizarPrenda();
		
	}
	
	@Override 
	
	public  void elegirPrendaInferior() {
		
	}

	@Override 

	public  void elegirCalzado() {
		
	}
}








