package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import model.Caballero;
import model.Ejercito;
import model.EjercitoIngles;
import model.OroInsuficienteError;
import model.Piquero;
import model.Soldado;

public class SoldadoTest {
	
	@Test
	void entrenarPiqueroDaPoderTotal8Test() {
		
		Ejercito ejercitoIngles = new EjercitoIngles();
		Soldado soldado = new Soldado(new Piquero(), ejercitoIngles);
		
	    try {
	    	soldado.entrenar();
	    } catch (OroInsuficienteError e) {
	    	assert(false);
	    }
	    
	    assertTrue(soldado.obtenerPoder() == 8);
	}
	
	@Test
	void entrenarGastaOroTest() {
		
		Ejercito ejercitoIngles = new EjercitoIngles();
		Soldado soldado = new Soldado(new Piquero(), ejercitoIngles);
	    
	    int reservaInicial = ejercitoIngles.obtenerReservaOro();

	    try {
	    	soldado.entrenar();
	    } catch (OroInsuficienteError e) {
	    	assert(false);
	    }
	    
	    assertTrue(ejercitoIngles.obtenerReservaOro() < reservaInicial);
	}
	
	@Test
	void entrenarConReservadeOroVaciaLanzaOroInsuficienteError() {
		
		Ejercito ejercitoIngles = new EjercitoIngles();
		Soldado soldado = new Soldado(new Piquero(), ejercitoIngles);
	    
	    try {
	    	ejercitoIngles.gastarOro(ejercitoIngles.obtenerReservaOro()); //reservas quedan en 0
	    } catch (OroInsuficienteError e) {
	    	//No Hacer Nada
	    }
	    
	    boolean lanzarExcepcion;
	    
	    try {
	    	soldado.entrenar();
	    	lanzarExcepcion = false;
	    } catch (OroInsuficienteError e) {
	    	lanzarExcepcion = true;
	    }
	    
	    assert(lanzarExcepcion);
	}
	
	@Test
	
	void transformarseDePiqueroArqueroIncrementaPuntosDeFuerzaDe5A10Test() throws OroInsuficienteError {
		Ejercito ejercitoInglesFalso = new EjercitoIngles();
		Soldado soldado = new Soldado(new Piquero(), ejercitoInglesFalso);
		int puntosAnteriores = soldado.obtenerPoder();
		assert(puntosAnteriores == 5);
		soldado.transformarse();
		int puntosPosteriores = soldado.obtenerPoder();
		assert(puntosPosteriores == 10);
	}
	
	void transformarseSiendoCaballeroNoProduceTransformacionTest() throws OroInsuficienteError {
		Ejercito ejercitoInglesFalso = new EjercitoIngles();
		Soldado soldado = new Soldado(new Caballero(), ejercitoInglesFalso);
		int puntosAnteriores = soldado.obtenerPoder();
		soldado.transformarse();
		int puntosPosteriores = soldado.obtenerPoder();
		assert(puntosAnteriores == puntosPosteriores);
	}
	
	@Test
	
	void transformarseDePiqueroArqueroGasta30() throws OroInsuficienteError {
		Ejercito ejercitoInglesFalso = new EjercitoIngles();
		Soldado soldado = new Soldado(new Piquero(), ejercitoInglesFalso);
		int reservaOroInicial = ejercitoInglesFalso.obtenerReservaOro();
		soldado.transformarse();
		assertEquals(30, reservaOroInicial - ejercitoInglesFalso.obtenerReservaOro());
	}
}
