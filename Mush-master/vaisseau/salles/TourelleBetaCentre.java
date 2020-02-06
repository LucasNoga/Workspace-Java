package vaisseau.salles;

import config.ListSalles;
import vaisseau.Salle;

public class TourelleBetaCentre extends Salle{ 
	
	public TourelleBetaCentre() {
		 this.nom = " Tourelle Beta Centre ";
		 this.setId(ListSalles.TBETA2.getID()); 
	}
}