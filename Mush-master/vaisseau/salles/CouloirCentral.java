package vaisseau.salles;

import config.ListSalles;
import vaisseau.Salle;

public class CouloirCentral extends Salle{ 
	
	public CouloirCentral() {
		 this.nom = " Couloir Central ";
		 this.setId(ListSalles.COULOIR2.getID()); 
	}
}