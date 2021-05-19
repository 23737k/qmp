
public class Borrador {
	TipoPrenda tipo;
	Material material;
	Color colorPrimario;
	Color colorSecundario;
	Trama trama;

	public void elegirTipo(TipoPrenda tipo) {
		validarTipoNonNull(tipo);
		this.tipo = tipo;
	}

	public void elegirMaterial(Material material) {
		validarMaterialesDisponibles(material);
		this.material = material;
	}

	public void elegirTrama(Trama trama) {
		validarTramasDisponibles(trama);
		this.trama = trama;
	}

	public void elegirColorPrimario(Color colorPrimario) {
		validarColoresPrimariosDisponibles(colorPrimario);
		this.colorPrimario = colorPrimario;
	}

	public void elegirColorSecundario(Color colorSecundario) {
		validarColoresSecundariosDisponibles(colorSecundario);
		this.colorSecundario = colorSecundario;
	}

	public Prenda finalizarPrenda() {
		if (tipo == null || material == null || colorPrimario == null) {
			throw new PrendaInvalidaException("Falta definir uno o mas atributos de la prenda");
		}

		if (trama == null) {

			this.trama = defaultTrama();
		}

		return new Prenda(tipo, material, trama, colorPrimario, colorSecundario);
	}

	private void validarTipoNonNull(TipoPrenda tipo) {
		if (tipo == null) {
			throw new PrendaInvalidaException("El tipo de prenda no esta especificado");
		}
	}

	private void validarColoresSecundariosDisponibles(Color colorSecundario) {
		if (!(this.tipo.getColoresSecundariosDisponibles().contains(colorSecundario))) {
			throw new PrendaInvalidaException("El tipo de prenda no admite este tipo de color" + " secundario");
		}
	}

	private void validarColoresPrimariosDisponibles(Color colorPrimario) {
		if (!(this.tipo.getColoresPrimariosDisponibles().contains(colorPrimario))) {
			throw new PrendaInvalidaException("El tipo de prenda no admite este tipo de color" + " primario");
		}
	}

	private void validarMaterialesDisponibles(Material material) {
		if (!(this.tipo.getMaterialesDisponibles().contains(material))) {
			throw new PrendaInvalidaException("El tipo de prenda no admite este tipo de material");
		}
	}

	private void validarTramasDisponibles(Trama trama) {
		if (!(this.tipo.getTramasDisponibles().contains(trama))) {
			throw new PrendaInvalidaException("El tipo de prenda no admite este tipo de trama");
		}
	}

	private Trama defaultTrama() {
		return Trama.LISA;
	}

}

class Atuendo {

	Prenda superior;
	Prenda inferior;
	Prenda calzado;

	public Atuendo(Prenda superior, Prenda inferior, Prenda calzado) {
		this.superior = superior;
		this.inferior = inferior;
		this.calzado = calzado;
	}

}

interface BorradorAtuendo {

	public void elegirSuperior();

	public void elegirInferior();

	public void elegirCalzado();

	public Atuendo finalizarAtuendo();

}

class ColegioSanJuan implements BorradorAtuendo {

	Prenda superior;
	Prenda inferior;
	Prenda calzado;

	@Override
	public void elegirSuperior() {
		Borrador superior = new Borrador();
		superior.elegirTipo(null);
		superior.elegirMaterial(null);
		superior.elegirTrama(null);
		superior.elegirColorPrimario(null);
		superior.elegirColorSecundario(null);
		this.superior = superior.finalizarPrenda();
	}

	@Override
	public void elegirInferior() {
		Borrador inferior = new Borrador();
		inferior.elegirTipo(null);
		inferior.elegirMaterial(null);
		inferior.elegirTrama(null);
		inferior.elegirColorPrimario(null);
		inferior.elegirColorSecundario(null);
		this.inferior = inferior.finalizarPrenda();
	}

	@Override
	public void elegirCalzado() {
		Borrador calzado = new Borrador();
		calzado.elegirTipo(null);
		calzado.elegirMaterial(null);
		calzado.elegirTrama(null);
		calzado.elegirColorPrimario(null);
		calzado.elegirColorSecundario(null);
		this.calzado = calzado.finalizarPrenda();
	}

	@Override
	public Atuendo finalizarAtuendo() {
		return new Atuendo(superior, inferior, calzado);
	}

}






