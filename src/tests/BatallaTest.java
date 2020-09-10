package tests;

import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

import model.Batalla;
import model.Ejercito;
import model.EjercitoBizantino;
import model.EjercitoIngles;

public class BatallaTest {
	
	@Test

	void atacarAEjercitoConMenorPoderImplicaGanarBatalla() {
		Ejercito ejercitoBizantino = new EjercitoBizantino(); //Poder Inicial 405
		Ejercito ejercitoIngles = new EjercitoIngles(); //Poder Inicial 350
		
		ejercitoBizantino.atacar(ejercitoIngles);
		
		Batalla batalla = ejercitoBizantino.obtenerBatalla();
		
		assert (batalla.getGanador() == ejercitoBizantino);
	}
	
	@Test
	
	void atacarAEjercitoConMayorPoderImplicaPerderBatalla() {
		
		Ejercito ejercitoBizantino = new EjercitoBizantino(); //Poder Inicial 405
		Ejercito ejercitoIngles = new EjercitoIngles(); //Poder Inicial 350
		
		ejercitoIngles.atacar(ejercitoBizantino);
		
		Batalla batalla = ejercitoBizantino.obtenerBatalla();
		
		assert(batalla.getGanador() == ejercitoBizantino);
		assertFalse(batalla.getGanador() == ejercitoIngles);
	}
	
	@Test
	
	void atacarAEjercitoConIgualPoderImplicaQueNingunoGana() {
		
		Ejercito ejercitoBizantino1 = new EjercitoBizantino(); //Poder Inicial 405
		Ejercito ejercitoBizantino2 = new EjercitoBizantino(); //Poder Inicial 350

		ejercitoBizantino1.atacar(ejercitoBizantino2);
		
		Batalla batalla = ejercitoBizantino1.obtenerBatalla();
		
		assert(batalla.huboEmpate());
	}
	
	
	

}
