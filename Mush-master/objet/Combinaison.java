package objet;

import config.ListObjets;

public class Combinaison extends Objet{

	public Combinaison() {
		this.setNom("Combinaison");
		this.setId(ListObjets.COMMBINAISON.getID());
	}
	
	@Override
	public String toString() {
		return this.getNom() + ": Nécessaire dans l’inventaire pour piloter un jet d’attaque ou d’exploration";
	}
}
