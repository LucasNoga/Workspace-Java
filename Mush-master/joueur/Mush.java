package joueur;

import java.util.ArrayList;
import joueur.actions.*;
import objet.Objet;
import vaisseau.Salle;


public class Mush extends Joueur{

	public Mush(String nom, int pv, int pa ,int pm, int pmo, Salle salle,
			Salle salle2, Objet[] inventaire, ArrayList<Action> actions) {
		
		this.nom = nom;
		this.type = "Mush";
		
		this.modifiePv(pv);
		this.modifiePa(pa);
		this.modifiePm(pm);
		this.modifiePmo(pmo);
		
		this.setSalle(salle2);
		this.setInventaire(inventaire);
		this.setActions(actions);
		
		this.actions.add(new Telepathie());
		this.actions.add(new AffichageTele());
	}
	
}