package vaisseau.salles;

import config.ListSalles;
import vaisseau.Salle;

public class JardinHydroponique extends Salle{ 
	
	public JardinHydroponique() {
		 this.nom = " Jardin Hydroponique "; 
		 this.setId(ListSalles.JARDIN.getID()); 
	}
}