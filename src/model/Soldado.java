package model;

public class Soldado {
	
	private EstadoSoldado estado;
	private Ejercito ejercitoPropio;
	
	public Soldado(EstadoSoldado estado, Ejercito ejercitoPropio) {
		this.estado = estado;
		this.ejercitoPropio = ejercitoPropio;
	}
	
	public int obtenerPoder() {
		return this.estado.obtenerPuntos();
	}
	
	public void entrenar() throws OroInsuficienteError {
		try {
			int gastoDeOro = this.estado.obtenerCostoEntrenamiento();
			this.ejercitoPropio.gastarOro(gastoDeOro);
		} catch (OroInsuficienteError oroInsuficiente) {
			throw new OroInsuficienteError();
		} finally {
			this.estado.ganarPuntos();
		}
	}
	
	public void transformarse() throws OroInsuficienteError{
		try {
			int gastoDeOro = this.estado.obtenerCostoTransformacion();
			this.ejercitoPropio.gastarOro(gastoDeOro);
		} catch (OroInsuficienteError oroInsuficiente) {
			throw new OroInsuficienteError();
		} finally {
			try {
				this.estado.transformar(this);
			} catch (IncapacidadParaTransformarseError e) {
				//NO SE TRANSFORMA
			}
		}
	}
	
	
	public void transformar(EstadoSoldado nuevoEstado) {
		this.estado = nuevoEstado;
	}
}
