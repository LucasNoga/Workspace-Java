package objet;

import config.ListObjets;

public class Grenade  extends Objet {
	public Grenade () {
		this.setNom("Grenade (utilisable une fois)");
		this.setId(ListObjets.GRENADE.getID());
	}
	public String toString() {
		// Compléter la description avec la description du PDF
		return this.getNom() + ": Fait perdre 6 PV à tous les joueurs présents dans la salle";
	}
}
