package joueur.actions;

import config.Static;
import joueur.Joueur;

public class AffichageTele extends Action{

	public AffichageTele() {
		nom = "Affichage des communication télépathique";
	}
	
	@Override
	public boolean disponible() {
		return true;
	}

	@Override
	public boolean action(Joueur j) {
		Static.telepathie.affichage();
		return true;
	}
	
}
