package vaisseau.salles;

import config.ListSalles;
import vaisseau.Salle;

public class TourelleAlphaAvant extends Salle{
	
	public TourelleAlphaAvant () {
		 this.nom = "Tourelle Alpha Avant"; 
		 this.setId(ListSalles.TALPHA1.getID()); 
	}
	
}