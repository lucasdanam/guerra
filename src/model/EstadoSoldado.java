package model;

public abstract class EstadoSoldado {
	
	protected int puntosGanables;
	protected int puntosDeFuerza;
	protected int costoEntrenamiento;
	protected int costoTransformacion; 

	public void ganarPuntos() {
		this.puntosDeFuerza += this.puntosGanables;
	}
	
	public int obtenerPuntos() {
		return this.puntosDeFuerza;
	}

	protected int obtenerCostoEntrenamiento() {
		return this.costoEntrenamiento;
	}

	protected abstract void transformar(Soldado soldado) throws IncapacidadParaTransformarseError;

	protected int obtenerCostoTransformacion() {
		return this.costoTransformacion;
	}
}
