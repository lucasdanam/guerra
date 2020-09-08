package model;

public class EjercitoIngles extends Ejercito {
	
	public EjercitoIngles() {	
		this.limitePiqueros = 10;
		this.limiteArqueros = 10;
		this.limiteCaballeros = 10;
	
		for (int i=1; i<=this.limitePiqueros; i++) {
			this.soldados.add(new Soldado(new Piquero(), this));
		}
		for (int j=1; j<=this.limiteArqueros; j++) {
			this.soldados.add(new Soldado(new Arquero(), this));
		}
		for (int k=1; k<=this.limiteCaballeros; k++) {
			this.soldados.add(new Soldado(new Caballero(), this));
		}
	}
}
