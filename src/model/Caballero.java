package model;

public class Caballero extends EstadoSoldado {
	
	public Caballero() {
		this.puntosDeFuerza = 20;
		this.puntosGanables = 10;
		this.costoEntrenamiento = 30;
	}
	
	public void transformar(Soldado soldado) throws IncapacidadParaTransformarseError {
		throw new IncapacidadParaTransformarseError();
	}
}
