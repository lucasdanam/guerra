package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.Ejercito;
import model.EjercitoBizantino;
import model.EjercitoIngles;
import model.OroInsuficienteError;

public class EjercitoTest {
	
	@Test
	
	void gastarMasOroDelQueHayLanzaExcepcionTest(){
		Ejercito ejercitoIngles = new EjercitoIngles();
		boolean lanzarExcepcion;
	    
	    try {
	    	ejercitoIngles.gastarOro(ejercitoIngles.obtenerReservaOro() + 1);
	    	lanzarExcepcion = false;
	    } catch (OroInsuficienteError e) {
	    	lanzarExcepcion = true;
	    }
	    
	    assert(lanzarExcepcion);
	}
	
	@Test
	
	void obtenerPoderInicialDeEjercitoInglesDevuelve350Test() {
		Ejercito ejercitoIngles = new EjercitoIngles();
		assert(ejercitoIngles.obtenerPoder()==350);
	}
	
	@Test
	
	void obtenerPoderInicialDeEjercitoBizantinoDevuelve405Test() {
		Ejercito ejercitoBizantino = new EjercitoBizantino();
		assert(ejercitoBizantino.obtenerPoder()==405);
	}

}
