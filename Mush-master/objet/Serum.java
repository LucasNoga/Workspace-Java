package objet;

import config.ListObjets;

public class Serum extends Objet {
	public Serum() {
		this.setNom("Serum retro-fongique");
		this.setId(ListObjets.SERUM.getID());

	}
	public String toString() {
		return this.getNom() + ": Permet à un humain de guérir un mush contre 2 PA";
}
}