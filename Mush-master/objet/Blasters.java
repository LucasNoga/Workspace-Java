package objet;

import config.ListObjets;

public class Blasters extends Objet {
	public Blasters () {
		this.setNom("Blasters (pistolets)");
		this.setId(ListObjets.BLASTERS.getID());
	}
	public String toString() {
		// Compléter la description avec la description du PDF
		return this.getNom() + ": Fait perdre 4 PV en cas d’attaque";
	}
	
}

