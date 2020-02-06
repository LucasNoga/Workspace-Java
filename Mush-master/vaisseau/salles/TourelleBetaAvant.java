package vaisseau.salles;

import config.ListSalles;
import vaisseau.Salle;

public class TourelleBetaAvant extends Salle{ 
	
	public TourelleBetaAvant() {
		 this.nom = "Tourelle Beta Avant"; 
		 this.setId(ListSalles.BALPHA1.getID()); 
	}
}