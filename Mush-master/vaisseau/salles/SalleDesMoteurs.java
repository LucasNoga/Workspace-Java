package vaisseau.salles;

import config.ListSalles;
import vaisseau.Salle;

public class SalleDesMoteurs extends Salle{ 
	
	public SalleDesMoteurs() {
		 this.nom = " Salle Des Moteurs ";
		 this.setId(ListSalles.MOTEUR.getID()); 
	}
}