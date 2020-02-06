package objet;

import config.ListObjets;


/**
 * Objet gants 
 * @author adrien
 */
public class Gants extends Objet{
	
	
	public Gants() {
		
		// Définit le nom de l'objet 
		// a prendre dans la liste des objets sur le PDF
		this.setNom("Paire de gants de protection");
		
		// Définit l'id de l'objet
		// aller chercher dans l'enum: ListObjets dans le package config
		this.setId(ListObjets.GANTS.getID());
	}
	
	@Override
	public String toString() {
		// Compléter la description avec la description du PDF
		return this.getNom() + ": Doivent  être  dans  l’inventaire  pendant  une réparation pour ne pas se salir";
	}
}
