package vaisseau.salles;

import config.ListSalles;
import vaisseau.Salle;

public class DortoirBeta extends Salle{ 
	
	public DortoirBeta() {
		 this.nom = " Dortoir Beta ";
		 this.setId(ListSalles.DORTOIRB.getID()); 
	}
}