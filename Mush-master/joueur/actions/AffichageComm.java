package joueur.actions;

import config.Static;
import joueur.Joueur;

public class AffichageComm extends Action{
	
	public AffichageComm() {
		nom = "Affichage des communication";
	}

	
	@Override
	public boolean disponible() {
		return true;
	}

	@Override
	public boolean action(Joueur j) {
		Static.talkyWalky.affichage();
		return true;
	}
}
