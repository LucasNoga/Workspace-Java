package vaisseau.salles;

import config.ListSalles;
import vaisseau.Salle;

public class Refectoire extends Salle{ 
	
	public Refectoire() {
		 this.nom = " Refectoire ";
		 this.setId(ListSalles.REFECTOIRE.getID()); 
	}
}