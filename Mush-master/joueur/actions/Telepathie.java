package joueur.actions;

import config.Static;
import config.Utilitaire;
import joueur.Joueur;

public class Telepathie extends Action{

	public Telepathie() {
		nom = "Communication";
	}

	@Override
	public boolean disponible() {
		return true;
	}

	@Override
	public boolean action(Joueur j) {
		Static.telepathie.affichage();
		String reponse = "";
		
		do {
			System.out.println("Voulez vous dire quelque chose dans le cannal de discution ? (oui / non)");

			reponse = Utilitaire.sc.nextLine();

			if(reponse.equals("oui")) {
				System.out.println("Que voulez-vous dire ?");
				Static.telepathie.add(j.getNom() + ": " + Utilitaire.sc.nextLine());
			}

		}
		while(!reponse.equals("oui") && !reponse.equals("non"));
		
		return true;
	}
	
}
