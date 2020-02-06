package vaisseau.salles;

import config.ListSalles;
import vaisseau.Salle;

public class Nexus extends Salle{ 
	
	public Nexus() {
		 this.nom = " Nexus ";
		 this.setId(ListSalles.NEXUS.getID()); 
	}
}