package objet;

import config.ListObjets;

public class Armure extends Objet {
	
	public Armure () {
		this.setNom("Armure");
		this.setId(ListObjets.ARMURE.getID());
		
	}
	
	public String toString() {
		return this.getNom() + ": Absorbe un point de dégât de combat";
	}
}


