package vaisseau.salles;

import config.ListSalles;
import vaisseau.Salle;

public class CouloirArriere extends Salle{ 
	
	public CouloirArriere() {
		 this.nom = " Couloir Arriere ";
		 this.setId(ListSalles.COULOIR3.getID()); 
	}
}