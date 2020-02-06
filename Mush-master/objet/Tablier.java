package objet;

import config.ListObjets;

public class Tablier extends Objet {
	public Tablier () { 
		this.setNom("Tablier intachable");
		this.setId(ListObjets.TABLIER.getID());
	}
	public String toString() {
		return this.getNom() + ":Pour ne pas se salir pendant les recherches au laboratoire si dans l’inventaire";

}
}
