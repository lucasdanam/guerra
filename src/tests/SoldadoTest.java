package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import model.Ejercito;
import model.EjercitoIngles;
import model.OroInsuficienteError;
import model.Piquero;
import model.Soldado;

public class SoldadoTest {
	
	@Test
	void entrenarOtorgaPuntosTest() {
		
		Ejercito ejercitoIngles = new EjercitoIngles();
		ArrayList<Soldado> soldados = ejercitoIngles.obtenerSoldados();
	    Soldado soldado = soldados.get(0);
	    
	    int puntosIniciales = soldado.obtenerPuntos();

	    try {
	    	soldado.entrenar();
	    } catch (OroInsuficienteError e) {
	    	assert(false);
	    }
	    
	    assertTrue(soldado.obtenerPuntos() > puntosIniciales);
	}
	
	@Test
	void entrenarGastaOroTest() {
		//Inicialmente hay 1000 monedas de oro
		Ejercito ejercitoIngles = new EjercitoIngles();
		ArrayList<Soldado> soldados = ejercitoIngles.obtenerSoldados();
	    Soldado soldado = soldados.get(0);
	    
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
		ArrayList<Soldado> soldados = ejercitoIngles.obtenerSoldados();
	    Soldado soldado = soldados.get(0);
	    
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
	

}
