package objet;

import config.ListObjets;

public class Souche extends Objet{
	public Souche() {
		this.setNom("Souche de test mush");
		this.setId(ListObjets.SOUCHE.getID());
	}
	public String toString() {
		return this.getNom() + ": Debloque des recherces si présent au laboratoire";
	}

}
