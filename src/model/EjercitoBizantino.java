package model;

public class EjercitoBizantino extends Ejercito {
	
	public EjercitoBizantino() {
		
		this.maximoPiqueros = 5;
		this.maximoArqueros = 8;
		this.maximoCaballeros = 15;
	
		for (int i=1; i<=this.maximoPiqueros; i++) {
			this.soldados.add(new Soldado(new Piquero(), this));
		}
		for (int j=1; j<=this.maximoArqueros; j++) {
			this.soldados.add(new Soldado(new Arquero(), this));
		}
		for (int k=1; k<=this.maximoCaballeros; k++) {
			this.soldados.add(new Soldado(new Caballero(), this));
		}
	}
}
