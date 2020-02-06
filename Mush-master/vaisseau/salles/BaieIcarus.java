package vaisseau.salles;

import config.ListSalles;
import vaisseau.Salle;

public class BaieIcarus extends Salle{ 
	
	public BaieIcarus() {
		 this.nom = " Baie Icarus ";
		 this.setId(ListSalles.BICARUS.getID()); 
	}
}