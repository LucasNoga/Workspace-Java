package config;

import java.util.ArrayList;
import joueur.Joueur;
import vaisseau.Salle;


public class Controleur {
	
	private ArrayList<Joueur> Joueurs;
	private ArrayList<Salle> Salles;
	
	
	public Controleur() {
		System.out.println("Lancement...");
		this.Joueurs = Initialisation.initJoueur();
		this.Salles = Initialisation.initVaisseau();
	}
	
	
	public void lancement() {
		for(Joueur j : Joueurs) {
			System.out.println("____________________________________");
			System.out.println(j.getNom() + " :\n");
			while(j.action()) {
				
			}
		}
			
	}
	
}