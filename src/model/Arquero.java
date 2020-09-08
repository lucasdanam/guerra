package model;

public class Arquero extends EstadoSoldado {

	public Arquero() {
		this.puntosDeFuerza = 10;
		this.puntosGanables = 7;
		this.costoEntrenamiento = 20;
		this.costoTransformacion = 40;
	}

	public void entrenar() {
		this.puntosDeFuerza += this.puntosGanables;
	}

	public void transformar(Soldado soldado) throws IncapacidadParaTransformarseError{
		soldado.transformar(new Caballero());
	}
	
}
