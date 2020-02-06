package objet;

import config.ListObjets;

public class Couteau extends Objet {
	public Couteau () {
		this.setNom("Couteau");
		this.setId(ListObjets.COUTEAU.getID());
	}
	public String toString() {
		return this.getNom() + ": Fait perdre 2 PV en cas d’attaque";
	}
}
