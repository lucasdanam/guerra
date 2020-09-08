package model;

import java.util.ArrayList;

public abstract class Ejercito {
	
	protected ArrayList<Soldado> soldados;
	protected int reservaOro;
	protected int limitePiqueros;
	protected int limiteArqueros;
	protected int limiteCaballeros;
	
	public Ejercito() {
		this.soldados = new ArrayList<Soldado>();
		this.reservaOro = 1000;
	}
	
	public void gastarOro(int gasto) throws OroInsuficienteError {					
		if (gasto <= this.reservaOro) {
			this.reservaOro -= gasto;
		} else {
			throw new  OroInsuficienteError();
		}
	}
	
	public ArrayList<Soldado> obtenerSoldados(){
		return this.soldados;
	}

	public int obtenerReservaOro() {
		return this.reservaOro;
	}
}
