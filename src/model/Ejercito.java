package model;

import java.util.ArrayList;
import java.util.Iterator;

public abstract class Ejercito {
	
	protected ArrayList<Soldado> soldados;
	private int reservaOro;
	protected int maximoPiqueros;
	protected int maximoArqueros;
	protected int maximoCaballeros;
	protected ArrayList<Batalla> historialBatallas;
	private Batalla batallaActual;
	
	public Ejercito() {
		this.soldados = new ArrayList<Soldado>();
		this.reservaOro = 1000;
		this.historialBatallas = new ArrayList<Batalla>();
		this.batallaActual = null;
	}
	
	public void gastarOro(int gasto) throws OroInsuficienteError {					
		if (gasto <= this.reservaOro) {
			this.reservaOro -= gasto;
		} else {
			throw new  OroInsuficienteError();
		}
	}

	public int obtenerReservaOro() {
		return this.reservaOro;
	}
	
	public int obtenerPoder() {
		Iterator<Soldado> soldadosIterador = soldados.iterator();
		int poderTotal = 0;
		while (soldadosIterador.hasNext()) {
		    Soldado soldado = soldadosIterador.next();
		    poderTotal += soldado.obtenerPoder();
		}
		return poderTotal; 
	}
	
	public void atacar(Ejercito otroEjercito) {
		Batalla batalla = new Batalla(this, otroEjercito);
		this.entrarEnBatalla(batalla);
		otroEjercito.entrarEnBatalla(batalla);
		this.historialBatallas.add(batalla);
		if (this.obtenerPoder() > otroEjercito.obtenerPoder()) {
			this.ganar(otroEjercito);
			batalla.darGanada(this);
		} else if (this.obtenerPoder() < otroEjercito.obtenerPoder()) {
			otroEjercito.ganar(this);
			batalla.darGanada(otroEjercito);
		} else {
			this.empatar(otroEjercito);
		}
	}

	public void entrarEnBatalla(Batalla batalla) {
		this.batallaActual = batalla;
	}

	public void empatar(Ejercito otroEjercito) {
		if (!this.soldados.isEmpty() && otroEjercito.obtenerCantidadDeSoldados()!=0) {
			this.darDeBajaSoldado(this.obtenerSoldadoConMayorPoder());
			otroEjercito.darDeBajaSoldado(otroEjercito.obtenerSoldadoConMayorPoder());
		}
	}

	public void ganar(Ejercito otroEjercito) {
		otroEjercito.perder();
		this.reservaOro += 100;
	}

	public void perder() {
		for (int i = 1; i <= 2; i++) {
			if (!this.soldados.isEmpty()) {
				Soldado soldadoMayorPoder = this.obtenerSoldadoConMayorPoder();
				this.darDeBajaSoldado(soldadoMayorPoder);
			}
		}
	}

	public Soldado obtenerSoldadoConMayorPoder() {
		Iterator<Soldado> soldadosIterador = soldados.iterator();
		int mayorPoder = 0;
		Soldado soldadoConMayorPoder = null;
		while (soldadosIterador.hasNext()) {
		    Soldado soldado = soldadosIterador.next();
		    if (soldado.obtenerPoder() > mayorPoder) {
		    	mayorPoder = soldado.obtenerPoder();
		    	soldadoConMayorPoder = soldado;
		    }
		}
		return soldadoConMayorPoder; 
	}

	private void darDeBajaSoldado(Soldado soldado) {
		this.soldados.remove(soldado);		
	}
	
	public int obtenerCantidadDeSoldados() {
		return this.soldados.size();
	}

	public Batalla obtenerBatalla() {
		return this.batallaActual;
	}
}
