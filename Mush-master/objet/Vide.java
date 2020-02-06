package objet;

import config.ListObjets;


/**
 * Objet vide 
 * @author adrien
 */
public class Vide extends Objet{
	
	
	public Vide() {
		
		// Définit le nom de l'objet 
		this.setNom("Vide");
		
		// Définit l'id de l'objet
		this.setId(ListObjets.VIDE.getID());
	}
	
	@Override
	public String toString() {
		// Compléter la description avec la description du PDF
		return this.getNom();
	}
}