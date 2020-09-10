package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.EstadoSoldado;
import model.Piquero;

public class PiqueroTest {
	
	@Test
	void ganarPuntosDeFuerzaImplicaTener8PuntosEnTotalTest() {
		
		EstadoSoldado piquero = new Piquero();
		//puntos iniciales 5
		piquero.ganarPuntos();
		//puntos ganados 3
		assertEquals(piquero.obtenerPuntos(), 8);
	}
}
