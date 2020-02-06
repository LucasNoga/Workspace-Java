package vaisseau.salles;

import vaisseau.Salle;
import config.ListSalles; 


public class Pont extends Salle{
	
	public Pont() {
		this.nom = "Pont";
		this.setId(ListSalles.PONT.getID());
	}

}