package models;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

import controller.Gestionnaire_cartes_partie;
import models.cartes.Carte;
import models.cartes.Divinite;
import models.cartes.Origine;
import models.joueur.Joueur;

public class Partie {
	
	private Set<Joueur> joueurs;
	private Gestionnaire_cartes_partie gcp = null;
	
	public Partie(Set<Joueur> joueurs, ArrayList<Carte> deck){
		this.joueurs = joueurs;
		
		Collections.shuffle(deck);
		//R�cup�ration des divinit�es dans la paquet de carte.
		Queue<Divinite> divinites = this.getDivinites(deck);
		deck.removeAll(divinites);
		
		//Distribution des divinites aux joueurs
		this.distributionCartes(deck, divinites);
		
		System.out.println(gcp.toString());
		/*
		Iterator<Joueur> it = joueurs.iterator();
		while(it.hasNext()){
			System.out.println(((Joueur)it.next()).toString());
		}
		*/
		this.jouerPartie(true);
	}
	
	/**
	 * Lance une partie
	 * Cette m�thode contient la boucle principal
	 */
	public void jouerPartie(boolean jouer){
		while(jouer){
			jouer = this.jouerTour();
		}
		System.out.println("Fin de partie");
	}
	
	private boolean jouerTour(){
		//Lancer du d�s de cosmogonie
		
		distribuerPointsAction(De_Cosmogonie.lancerDe());
		
		Iterator<Joueur> it = joueurs.iterator();
		boolean next;
		while(it.hasNext()){
			next = ((Joueur)it.next()).jouer();
			//Si la m�thode jouer renvois faux et qu'il y a moins de 4 joueurs dans la partie, fin de la partie
			if(!next && joueurs.size()<4) return false;
			//Si la m�thode jouer renvois faux et qu'il y a au moins 4 joueurs dans la partie, 
			else if(!next && joueurs.size()>=4){
				//�limine un joueur et reset le tours.
				
				return true;
			}
		}
		//Le tour de jeu s'est bien d�roul�. Le premier joueur est plac� � la fin de la liste de joueurs.
		this.toTheEnd();
		return true;
	}
	
	private void distribuerPointsAction(Origine o){
		Iterator<Joueur> it = joueurs.iterator();
		while(it.hasNext()){
			((Joueur)it.next()).attribuerPointsAction(o);
		}
	}
	
	/**
	 * Place le premier joueur � la fin de la liste de joueur. 
	 */
	private void toTheEnd(){
		
	}
	
	private void distributionCartes(ArrayList<Carte> deck, Queue<Divinite> divinites){
		Iterator<Joueur> it = joueurs.iterator();
		while(it.hasNext()){
			//Chaque joueur d�marre avec 7 cartes
			List<Carte> main =  new ArrayList<Carte>(deck.subList(0, 6));
			deck.removeAll(main);
			((Joueur)it.next()).attachGestionnaire_Cartes_Joueur(main, divinites.poll());
		}
		this.gcp = new Gestionnaire_cartes_partie(deck, divinites);
	}
	
	private Queue<Divinite> getDivinites(ArrayList<Carte> deck){
		Queue<Divinite> divinites = new LinkedList<Divinite>();
		for(int i=0;i<deck.size();i++){
			if(deck.get(i) instanceof Divinite){
				divinites.add((Divinite)deck.get(i));
			}
		}
		return divinites;
	}
	
	
}
