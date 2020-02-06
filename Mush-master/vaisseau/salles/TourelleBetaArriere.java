package vaisseau.salles;

import config.ListSalles;
import vaisseau.Salle;

public class TourelleBetaArriere extends Salle{ 
	
	public TourelleBetaArriere() {
		 this.nom = " Tourelle Beta Arriere ";
		 this.setId(ListSalles.TBETA3.getID()); 
	}
}