package vaisseau.salles;

import config.ListSalles;
import vaisseau.Salle;

public class BaieAlpha extends Salle{ 
	
	public BaieAlpha() {
		 this.nom = " Baie Alpha ";
		 this.setId(ListSalles.BALPHA1.getID()); 
	}
}