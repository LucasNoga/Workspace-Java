package objet;

import config.ListObjets;

public class Ration extends Objet {
	public Ration () {
		this.setNom("Rations standards");
	}
	public String toString() {
		return this.getNom() + ": Présentes dans le réfectoire, peuvent être cuisinées par Stephen";
	}
}
