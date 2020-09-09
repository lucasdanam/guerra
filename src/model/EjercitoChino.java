package model;

public class EjercitoChino extends Ejercito {
	
	public EjercitoChino() {	
		this.maximoPiqueros = 2;
		this.maximoArqueros = 25;
		this.maximoCaballeros = 2;
	
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
