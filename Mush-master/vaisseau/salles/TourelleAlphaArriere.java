package vaisseau.salles;

import config.ListSalles;
import vaisseau.Salle;

public class TourelleAlphaArriere extends Salle{ 
	
	public TourelleAlphaArriere() {
		 this.nom = " Tourelle Alpha Arriere ";
		 this.setId(ListSalles.TALPHA3.getID()); 
	}
}