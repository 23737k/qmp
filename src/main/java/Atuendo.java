import Excepciones.PrendaInvalidaException;

public class Atuendo {
	
	public Prenda superior;
	public Prenda inferior;
	public Prenda calzado;

	public Atuendo(Prenda superior, Prenda inferior, Prenda calzado) {
		verificarCategoria(Categoria.SUPERIOR,superior);
		this.superior = superior;
		verificarCategoria(Categoria.INFERIOR,inferior);
		this.inferior = inferior;
		verificarCategoria(Categoria.CALZADO,calzado);
		this.calzado = calzado;
	}

		
	public void verificarCategoria(Categoria categoria, Prenda prenda){
		if(prenda.getCategoria() != categoria) {
			throw new PrendaInvalidaException ("prenda de categoria incorrecta");
		}
	}
	
}