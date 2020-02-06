package vaisseau.salles;

import config.ListSalles;
import vaisseau.Salle;

public class StockageAlphaCentre extends Salle{ 
	
	public StockageAlphaCentre() {
		 this.nom = " Stockage Alpha Centre ";
		 this.setId(ListSalles.STOKAGEA1.getID()); 
	}
}
