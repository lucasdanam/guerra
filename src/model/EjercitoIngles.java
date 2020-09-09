package model;

public class EjercitoIngles extends Ejercito {
	
	public EjercitoIngles() {	
		this.maximoPiqueros = 10;
		this.maximoArqueros = 10;
		this.maximoCaballeros = 10;
	
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
