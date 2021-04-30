
public class Prenda {
	TipoPrenda tipo;
	Material material;
	Color colorPrimario; 
	Color colorSecundario;
	Trama trama;

	public Prenda(TipoPrenda tipo, Material material, Trama trama, Color colorPrimario,
			Color colorSecundario) {
			  
			  this.tipo= tipo;
			  this.material= material;
			  this.colorPrimario= colorPrimario;
			  this.colorSecundario= colorSecundario;
			  this.trama=trama;
	}
	
	public Categoria getCategoria(){
	    return tipo.getCategoria();
	  }

}

class Color {
	public Color(String codigo) {
		this.codigo= codigo;
	}

	String codigo;
}
