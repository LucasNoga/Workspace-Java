package objet;

import config.ListObjets;

public class Savon extends Objet {
	public Savon() { 
		this.setNom("Savon");
		this.setId(ListObjets.SAVON.getID());
	}
	public String toString() {
		return this.getNom() + ": L’action « se laver » coûte un PA de moins si dans l’inventaire";
}
}

