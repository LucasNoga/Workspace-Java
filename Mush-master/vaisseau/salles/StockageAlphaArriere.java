package vaisseau.salles;

import config.ListSalles;
import vaisseau.Salle;

public class StockageAlphaArriere extends Salle{ 
	
	public StockageAlphaArriere() {
		 this.nom = " Stockage Alpha Arriere ";
		 this.setId(ListSalles.STOKAGEA2.getID()); 
	}
}