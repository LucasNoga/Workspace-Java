package vaisseau.salles;

import config.ListSalles;
import vaisseau.Salle;

public class TourelleAlphaCentre extends Salle{ 
	
	public TourelleAlphaCentre() {
		 this.nom = " Tourelle Alpha Centre ";
		 this.setId(ListSalles.TALPHA2.getID()); 
	}
}