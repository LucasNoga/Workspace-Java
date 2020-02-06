package vaisseau.salles;

import config.ListSalles;
import vaisseau.Salle;

public class Infirmerie extends Salle{ 
	
	public Infirmerie() {
		 this.nom = " Infirmerie ";
		 this.setId(ListSalles.INFIRMERIE.getID()); 
	}
}