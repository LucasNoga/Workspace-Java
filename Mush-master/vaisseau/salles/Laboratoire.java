package vaisseau.salles;

import config.ListSalles;
import vaisseau.Salle;

public class Laboratoire extends Salle{ 
	
	public Laboratoire() {
		 this.nom = "  Laboratoire ";
		 this.setId(ListSalles.LABO.getID()); 
	}
}