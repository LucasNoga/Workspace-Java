package vaisseau.salles;

import config.ListSalles;
import vaisseau.Salle;

public class DortoirAlpha extends Salle{ 
	
	public DortoirAlpha() {
		 this.nom = " Dortoir Alpha ";
		 this.setId(ListSalles.DORTOIRA.getID()); 
	}
}