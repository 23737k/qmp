
public interface Sugerencia {
  
	public abstract void hacer(Guardarropas guardarropas);
	public abstract void deshacer(Guardarropas guardarropas);
  public abstract Prenda getPrenda();
}



class Agregar implements Sugerencia{
  
  private Prenda prenda;

	public Agregar(Prenda prenda) {
		this.prenda= prenda;
	}
	
	
	public void hacer(Guardarropas guardarropas) {
	  guardarropas.agregar(this.prenda);
	}
	
	public void deshacer(Guardarropas guardarropas) {
		guardarropas.quitar(this.prenda);
	}


  @Override
  public Prenda getPrenda() {
   return this.prenda;
  }
		
}

class Quitar implements Sugerencia{
	
  private Prenda prenda;

	
	public Quitar(Prenda prenda) {
		this.prenda= prenda;
	}
	
	public void hacer(Guardarropas guardarropas) {
		guardarropas.quitar(this.prenda);
	}
	
	public void deshacer(Guardarropas guardarropas) {
		guardarropas.agregar(this.prenda);
	}

  @Override
  public Prenda getPrenda() {
   return this.prenda;
  }
	
	
}

