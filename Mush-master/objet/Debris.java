package objet;

import config.ListObjets;

public class Debris extends Objet {
	public Debris() {
		this.setNom("Debris métalliques");
		this.setId(ListObjets.DEBRIS.getID());
	}
	public String toString() {
		return this.getNom() + ": Nécessaire pour les réparations. Le maximum entreposable dans le vaisseau est 100.";
	}
	
}



