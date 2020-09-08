package model;

public class Piquero extends EstadoSoldado {
	
	public Piquero() {
		this.puntosDeFuerza = 5;
		this.puntosGanables = 3;
		this.costoEntrenamiento = 10;
		this.costoTransformacion = 30;
	}

	public void transformar(Soldado soldado) throws IncapacidadParaTransformarseError{
		soldado.transformar(new Arquero());
	}
}
