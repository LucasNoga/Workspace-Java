package objet;

import config.ListObjets;

public class Medikit extends Objet{
	public Medikit () {
		this.setNom("Medikit");
		this.setId(ListObjets.MEDIKIT.getID());
}
public String toString() {
	return this.getNom() + ": Doit être dans l’inventaire pour pouvoir soigner un autre joueur ou soi-même";
}

}