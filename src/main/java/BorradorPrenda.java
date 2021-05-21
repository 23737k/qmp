import java.util.List;
import java.util.Map;

import Excepciones.PrendaInvalidaException;

public class BorradorPrenda {	
	
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






