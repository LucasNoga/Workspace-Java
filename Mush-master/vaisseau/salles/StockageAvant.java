package vaisseau.salles;

import config.ListSalles;
import vaisseau.Salle;

public class StockageAvant extends Salle{ 
	
	public StockageAvant() {
		 this.nom = " Stockage Avant ";
		 this.setId(ListSalles.STOCKAGE.getID()); 
	}
}