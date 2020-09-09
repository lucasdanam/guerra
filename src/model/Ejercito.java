package model;

import java.util.ArrayList;
import java.util.Iterator;

public abstract class Ejercito {
	
	protected ArrayList<Soldado> soldados;
	private int reservaOro;
	protected int maximoPiqueros;
	protected int maximoArqueros;
	protected int maximoCaballeros;
	
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

	public int obtenerReservaOro() {
		return this.reservaOro;
	}
	
	public int obtenerPoder() {
		Iterator<Soldado> soldadosIterador = soldados.iterator();
		int poderTotal = 0;
		while(soldadosIterador.hasNext()){
		    Soldado soldado = soldadosIterador.next();
		    poderTotal += soldado.obtenerPoder();
		}
		return poderTotal; 
	}
	
	public void atacar(Ejercito otroEjercito) {
		if (this.obtenerPoder() > otroEjercito.obtenerPoder()) {
			this.ganar(otroEjercito);
		}else if (this.obtenerPoder() == otroEjercito.obtenerPoder()) {
			this.darDeBajaSoldado(this.obtenerSoldadoConMayorPoder());
			otroEjercito.darDeBajaSoldado(otroEjercito.obtenerSoldadoConMayorPoder());
		}
	}

	public void ganar(Ejercito otroEjercito) {
		otroEjercito.perder();
		this.reservaOro += 100;
	}

	public void perder() {
		Soldado soldadoMayorPoder = this.obtenerSoldadoConMayorPoder();
		this.darDeBajaSoldado(soldadoMayorPoder);
		Soldado soldadoSegundoMayorPoder = this.obtenerSoldadoConMayorPoder();
		this.darDeBajaSoldado(soldadoSegundoMayorPoder);
	}

	//Lanzar excepcion si la lista de soldados esta vacia
	private Soldado obtenerSoldadoConMayorPoder() {
		Iterator<Soldado> soldadosIterador = soldados.iterator();
		int mayorPoder = 0;
		Soldado soldadoConMayorPoder = soldados.get(0);
		while(soldadosIterador.hasNext()){
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
}
