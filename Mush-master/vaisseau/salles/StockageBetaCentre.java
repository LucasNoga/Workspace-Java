package vaisseau.salles;

import config.ListSalles;
import vaisseau.Salle;

public class StockageBetaCentre extends Salle{ 
	
	public StockageBetaCentre() {
		 this.nom = " Stockage Beta Centre ";
		 this.setId(ListSalles.STOKAGEB1.getID()); 
	}
}