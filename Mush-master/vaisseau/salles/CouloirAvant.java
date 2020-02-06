package vaisseau.salles;

import config.ListSalles;
import vaisseau.Salle;

public class CouloirAvant extends Salle{ 
	
	public CouloirAvant() {
		 this.nom = " Couloir Avant "; 
		 this.setId(ListSalles.COULOIR1.getID()); 
	}
}