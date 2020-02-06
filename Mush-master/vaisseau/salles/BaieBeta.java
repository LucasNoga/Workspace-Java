package vaisseau.salles;

import config.ListSalles;
import vaisseau.Salle;

public class BaieBeta extends Salle{ 
	
	public BaieBeta() {
		 this.nom = " Baie Beta ";
		 this.setId(ListSalles.BALPHB1.getID()); 
	}
}