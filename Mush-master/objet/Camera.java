package objet;

import config.ListObjets;

public class Camera extends Objet{
	public Camera() {
		this.setNom("Caméras");
		this.setId(ListObjets.GANTS.getID());
	}
	public String toString() {
		return this.getNom() + ": Une fois installées, permettent de détecter les actions mush dans la salle (extirper un spore, poinçonner) et de les afficher dans les logs de la salle";
	}
}


