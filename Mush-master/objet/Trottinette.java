package objet;

import config.ListObjets;

public class Trottinette extends Objet {
	public Trottinette () {
		this.setNom("Trottinette");
		this.setId(ListObjets.TROTTINETTE.getID());
	}
	public String toString() {
		// Compléter la description avec la description du PDF
		return this.getNom() + ": Ajoute 2 PM lors de la conversion PA-PM";
	}

}

