package joueur.actions;

import joueur.Joueur;


public class Passer extends Action{

	public Passer() {
		nom = "Terminer le tour";
	}

	@Override
	public boolean disponible() {
		return true;
	}

	@Override
	public boolean action(Joueur j) {
		return false;
	}
	
}
