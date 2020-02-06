package vaisseau.salles;

import config.ListSalles;
import vaisseau.Salle;

public class StockageBetaArriere extends Salle{ 
	
	public StockageBetaArriere() {
		 this.nom = " Stockage Beta Arriere ";
		 this.setId(ListSalles.STOKAGEB2.getID()); 
	}
}