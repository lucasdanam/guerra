package model;

public abstract class EstadoSoldado {
	
	protected int puntosGanables;
	protected int puntosDeFuerza;
	protected int costoEntrenamiento;
	protected int costoTransformacion; 
	
	public EstadoSoldado() {

	}

	public void ganarPuntos() {
		this.puntosDeFuerza += this.puntosGanables;
	}
	
	public int obtenerPuntos() {
		return this.puntosDeFuerza;
	}

	public int obtenerCostoEntrenamiento() {
		return this.costoEntrenamiento;
	}

	protected abstract void transformar(Soldado soldado) throws IncapacidadParaTransformarseError;

	public int obtenerCostoTransformacion() {
		return this.costoTransformacion;
	}
}
