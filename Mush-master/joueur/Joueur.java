package joueur;

import java.util.ArrayList;

import config.Utilitaire;
import joueur.actions.*;
import objet.Objet;
import objet.Vide;
import vaisseau.Salle;


/**
 *	
 */
public abstract class Joueur {
	
	private int pv = 12;
	private int pa = 12;
	private int pm = 14;
	private int pmo = 7;
	
	private Salle salle;
	protected String nom;
	protected String type = "Humain";
	private boolean vie = true;
	
	protected Objet[] inventaire = new Objet[3];
	protected ArrayList<Action> actions;
	
	
	public Joueur() {
		this.inventaire[0] = new Vide();
		this.inventaire[1] = new Vide();
		this.inventaire[2] = new Vide();
		
		this.actions = new ArrayList<>();
		
		actions.add(new Communication());
		actions.add(new AffichageComm());
		actions.add(new Passer());
	}
	
	
	/**
	 * Cherche si il y a une place libre dans l'inventaire
	 * @return indice de la place libre ou -1 si il n'y en a pas
	 */
	private int place() {
		int index = 0;
		
		// Parcours de l'inventaire 
		while(inventaire[index] != null) {
			// Si lobjet courant est vide
			if(inventaire[index].getId() == 0) {
				// On retourne l'index de cette objet
				return index;
			}
			index++;
		}
		
		/* 
		 * Si on a parcouru tout le tableau sans
		 * trouver d'objet vide on renvoie le code -1
		 */
		return -1;
	}
	
	
	/**
	 * Depot d'objet dans l'inventaire
	 * @param obj
	 */
	public void ajout(Objet obj) {
		int index  = place();
		
		if(index != -1) {
			inventaire[index] = obj;
		}
	}
	
	
	/**
	 *	Depot d'objet dans la salle
	 */
	public void depot() {
		System.out.println("Quel objet voulez-vous déposer dans la salle ?");
		
		int index = inventaireSelect();
		
		/*
		 *  Si l'indice séléctionner est dans les borne du tableau,
		 *  qu'il n'est pas vide et que ce n'est pas un spore
		 */
		if(index >= 0 && index < 4 &&
				inventaire[index].getId() != 0 &&
				inventaire[index].getId() != 20) {
			// On l'ajoute a l'inventaire de la salle
			salle.addInventaire(inventaire[index]);
			
			// Et on le retire de l'inventaire du joueur
			inventaire[index] = new Vide();
		}
		
	}
	
	
	/**
	 * Séléction de d'un objet dans l'inventaire
	 * @return indice de l'objet séléctionner
	 */
	private int inventaireSelect() {
		int index = 0;
		
		// parcours de l'inventaire
		while(inventaire[index] != null) {
			
			// Affichage de l'objet courant et de son indice +1
			System.out.println("\t" 
					+ index+1 + ": " 
					+ inventaire[index].getNom());
			index++;
		}
		
		// Saisi utilisateur de l'indice séléctionner
		index = Utilitaire.sc.nextInt();
		
		// Retour de l'indice -1
		return index--;
	}
	
	
	/**
	 * Effectue l'ation séléctionner par le joueur
	 * @return 
	 */
	public boolean action() {
		int i = listeActions();		// Séléction de l'action a effectuer
		
		// Si l'action saisi est disponible
		if(actions.get(i).disponible()) {
			// Alors on l'execute
			return actions.get(i).action(this);
		}
		return true;
	}
	
	
	/**
	 * Sélection de l'action a effectué
	 * @return numéros d'action
	 */
	private int listeActions() {
		
		int index = 1;
		
		// Pacours des actions disponibles
		for (Action a : this.actions) {
			
			// Affichage des actions et de leurs indices
			System.out.print(index + ": " + a.getNom());
			
			// Si l'action courante est disponible 
			if(a.disponible()) {
				// On passe a la ligne suivante
				System.out.println();
			}
			else {
				// Sinon on précise quel n'est pas disponible
				System.out.println(" (indisponible)");
			}
			index++;
		}

		// On demande l'action souhaiter
		System.out.print("\nSélectionner l'action a effectué:\t");

		// On enregistre la réponse
		int reponse = Utilitaire.sc.nextInt()-1;
		
		// On vide le buffer du scanner
		Utilitaire.sc.nextLine();
		
		// Puis on la retourne
		return reponse;
	}


	/**
	 * Modification des points de vie
	 * @param pv
	 */
	public void modifiePv(int pv) {
		this.pv += pv;
		if(this.pv > 14) {
			this.pv = 14;
		}
		else if(this.pv < 1) {
			vie = false;
		}
	}


	/**
	 * Modification des points d'action
	 * @param pa
	 */
	public void modifiePa(int pa) {
		this.pa += pa;
		if(this.pa > 12) {
			this.pa = 12;
		}
		else if(this.pa < 1) {
			this.pa = 0;
		}
	}


	/**
	 * Modification des points de mouvement
	 * @param pm
	 */
	public void modifiePm(int pm) {
		this.pm += pm;
		if(this.pm > 12) {
			this.pm = 12;
		}
		else if(this.pm < 1) {
			this.pm = 0;
		}
	}


	/**
	 * Modification des points de moral
	 * @param pmo
	 */
	public void modifiePmo(int pmo) {
		this.pmo += pmo;
		if(this.pmo > 14) {
			this.pmo = 14;
		}
		else if(this.pmo < 1) {
			this.pmo = 0;
		}
	}
	
	
	
	public String toString() {
		String s = "________________________________\n"
				+ nom + "\n"
				+ "Point(s) de vie:\t" + pv
				+ "\nPoint(s) d'action:\t" + pa
				+ "\nPoint(s) de mouvement:\t" + pm
				+ "\nPoint(s) de moral:\t" + pmo
				+ "\n" + type
				+ "\nInventaire:\n";
		
			for(int index = 0; index < inventaire.length; index++) {
				if(inventaire[index] != null) {
					s += "\t" + inventaire[index].getNom() + "\n";
				}
			}

			s += "\nActions:\n";
			
			try {
				for (Action a : this.actions) {
					s += "\t" + a.getNom() +"\n";
				}
			}
			catch(java.lang.NullPointerException e) {}
	
		s += "\n________________________________";
		
		return s;
	}
	
	
	public String getNom() {
		return nom;
	}


	public boolean isVie() {
		return vie;
	}


	public Mush toMush() {
		return new Mush(nom, pa, pa, pa, pa, salle, salle, inventaire, actions);
	}

	
	public void setSalle(Salle salle) {
		this.salle = salle;
	}


	public void setInventaire(Objet[] inventaire) {
		this.inventaire = inventaire;
	}


	public void setActions(ArrayList<Action> actions) {
		this.actions = actions;
	}
}