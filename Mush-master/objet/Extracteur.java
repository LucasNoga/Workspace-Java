package objet;

import config.ListObjets;

public class Extracteur extends Objet {
	public Extracteur () {
	this.setNom("Extracteur de spores");
	this.setId(ListObjets.EXTRACTEUR.getID());

}
public String toString() {
	return this.getNom() + ": Permet d’extraire 1 spore pour 1 PA (n’existe pas en début de partie, apparait dans le laboratoire lorsque la recherche correspondante est réalisée)";
}
}