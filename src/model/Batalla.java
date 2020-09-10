package model;

import java.util.HashMap;
import java.util.Map;

public class Batalla { 
	
	private final int PERDEDOR = 0;
	private final int GANADOR = 1;

	private Map<Ejercito, Integer> partida;
	private Ejercito ejercito1;
	private Ejercito ejercito2;

	public Batalla(Ejercito ejercito1, Ejercito ejercito2) {
		this.ejercito1 = ejercito1;
		this.ejercito2 = ejercito2;
		this.partida =  new HashMap<Ejercito, Integer>();
		partida.put(this.ejercito1, this.PERDEDOR);
		partida.put(this.ejercito2, this.PERDEDOR);
	}

	public void darGanada(Ejercito ejercito) {
		partida.put(ejercito, this.GANADOR);		
	}
	
	public Ejercito getGanador() {
		Ejercito ganador = null;
		if (partida.get(this.ejercito2) == this.GANADOR) {
			ganador = this.ejercito2;
		} else if (partida.get(this.ejercito1) == this.GANADOR) {
			ganador = this.ejercito1;
		}
		return ganador;
	}

	public boolean huboEmpate() {
		boolean huboEmpate = false;
		if (this.partida.get(this.ejercito2) == this.PERDEDOR && this.partida.get(this.ejercito1) == this.PERDEDOR) {
			huboEmpate = true;
		}
		return huboEmpate;
	}
}
