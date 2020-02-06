package objet;

import config.ListObjets ; 

public class Extincteur extends Objet {
	public Extincteur () {
		this.setNom("Extincteurs");
		this.setId(ListObjets.EXTINCTEUR.getID());
	}
	public String toString() {
		return this.getNom() + ": Permet d’éteindre un incendie lorsqu’il se déclenche dans une salle";
	}

}
