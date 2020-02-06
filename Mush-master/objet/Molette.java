package objet;

import config.ListObjets;

public class Molette extends Objet{
	
	public Molette() {
		this.setNom("Clé à molette");
		this.setId(ListObjets.MOLETTE.getID());
	}
	
	@Override
	public String toString() {
		return this.getNom() + ": Nécessaire  dans  l’inventaire  pour  réparer  1 équipement";
	}
}