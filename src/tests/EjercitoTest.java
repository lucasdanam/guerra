package tests;

import org.junit.jupiter.api.Test;

import model.Ejercito;
import model.EjercitoBizantino;
import model.EjercitoChino;
import model.EjercitoIngles;
import model.OroInsuficienteError;
import model.Soldado;

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
	
	@Test
	
	void atacarAUnEjercitoConMenorPoderOtorga100DeOroAlAtacanteTest() {
		Ejercito ejercitoBizantino = new EjercitoBizantino(); //Poder Inicial 405
		Ejercito ejercitoIngles = new EjercitoIngles(); //Poder Inicial 350
		int oroGanador = ejercitoBizantino.obtenerReservaOro();
		ejercitoBizantino.atacar(ejercitoIngles);
		
		assert(ejercitoBizantino.obtenerReservaOro() == oroGanador + 100);
	}
	
	@Test
	
	void atacarAEjercitoConMayorPoderEliminaLosDosSoldadosConMayorPoderDelAtacanteTest() {
		Ejercito ejercitoBizantino = new EjercitoBizantino(); //Poder Inicial 405
		Ejercito ejercitoIngles = new EjercitoIngles(); //Poder Inicial 350
		Soldado soldadoConMayorPoder = ejercitoIngles.obtenerSoldadoConMayorPoder();
		int cantidadSoldadosInicial = ejercitoIngles.obtenerCantidadDeSoldados();
		ejercitoIngles.atacar(ejercitoBizantino);
		
		assert(ejercitoIngles.obtenerSoldadoConMayorPoder() != soldadoConMayorPoder);
		assert(ejercitoIngles.obtenerCantidadDeSoldados() == cantidadSoldadosInicial - 2);
		
		//Ejercito Ingles tiene inicialmente tiene 350 de poder y pierde dos Caballeros 40 ptos en total;
		 assert(ejercitoIngles.obtenerPoder() == 310);
	}
	
	@Test
	
	void atacarAEjercitoConMenorPoderEliminaLosDosSoldadosConMayorPoderDelDefensorTest() {
		Ejercito ejercitoBizantino = new EjercitoBizantino(); //Poder Inicial 405
		Ejercito ejercitoIngles = new EjercitoIngles(); //Poder Inicial 350
		Soldado soldadoConMayorPoder = ejercitoIngles.obtenerSoldadoConMayorPoder();
		int cantidadSoldadosInicial = ejercitoIngles.obtenerCantidadDeSoldados();
		ejercitoBizantino.atacar(ejercitoIngles);
		
		assert(ejercitoIngles.obtenerSoldadoConMayorPoder() != soldadoConMayorPoder);
		assert(ejercitoIngles.obtenerCantidadDeSoldados() == cantidadSoldadosInicial - 2);
		
		//Ejercito Ingles tiene inicialmente tiene 350 de poder y pierde dos Caballeros 40 ptos en total;
		assert(ejercitoIngles.obtenerPoder() == 310);
	}
	
	@Test
	
	void atacarAUnEjercitoConMayorPoderOtorga100DeOroAlDefensorTest() {
		Ejercito ejercitoBizantino = new EjercitoBizantino(); //Poder Inicial 405
		Ejercito ejercitoIngles = new EjercitoIngles(); //Poder Inicial 350
		int oroGanador = ejercitoBizantino.obtenerReservaOro();
		ejercitoIngles.atacar(ejercitoBizantino);
		
		assert(ejercitoBizantino.obtenerReservaOro() == oroGanador + 100);
	}
	
	@Test
	
	void atacarAEjercitoConIgualPoderEliminaUnSoldadoEnAmbosEjercitosTest() {
		Ejercito ejercito1 = new EjercitoChino();
		Ejercito ejercito2 = new EjercitoChino(); 
		Soldado soldadoConMayorPoder1 = ejercito1.obtenerSoldadoConMayorPoder();
		Soldado soldadoConMayorPoder2 = ejercito2.obtenerSoldadoConMayorPoder();
		int cantidadSoldadosInicial = ejercito1.obtenerCantidadDeSoldados();

		ejercito1.atacar(ejercito2);
		
		assert(ejercito1.obtenerSoldadoConMayorPoder() != soldadoConMayorPoder1);
		assert(ejercito2.obtenerSoldadoConMayorPoder() != soldadoConMayorPoder2);

		assert(ejercito1.obtenerCantidadDeSoldados() == ejercito2.obtenerCantidadDeSoldados());
		assert(ejercito2.obtenerCantidadDeSoldados() == cantidadSoldadosInicial - 1);

	}

}
