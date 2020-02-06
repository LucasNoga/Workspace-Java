package controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import models.cartes.Carte;
import models.cartes.ConstanteCarte;
import models.cartes.Croyant;
import models.cartes.Divinite;
import models.cartes.Guide_Spirituel;
import models.joueur.Joueur;

public class Gestionnaire_Cartes_Joueur {
	private Joueur joueur;
	private List<Carte> main;
	private List<Guide_Spirituel> guides;
	private List<Croyant> croyants;
	private Divinite divinite;
	
	public Gestionnaire_Cartes_Joueur(Joueur joueur, List<Carte> main,Divinite divinite){
		this.setJoueur(joueur);
		this.main = main;
		this.divinite = divinite;
		this.guides = new ArrayList<Guide_Spirituel>();
		this.croyants = new ArrayList<Croyant>();
	}
	
	/**
	 * Transfert une partie ou la totalit� des cartes de la main du joueur dans la d�fausse. .
	 * Ajoute la liste de carte au Gestionnaire Carte Partie
	 */
	public void defausser(List<Carte> defausse){
		//TODO Impl�mentation
	}
	
	/**
	 * Transfet un nombre de cartes de la pioche vers la main du joueur.
	 * Retire le nombre de carte n�cessaire de la pioche et les mets dans la main du joueur.
	 * @param nb Le nombre de cartes � piocher.
	 */
	public void piocherCarte(int nb){
		//TODO Impl�mentation
	}
	
	/** 
	 * Transfert une carte de la main du joueur vers la table / devant lui / dans la d�fausse
	 * @param carte La carte jou�.
	 */
	public void jouerCarte(Carte carte){
		//TODO Impl�mentation
	}
	
	/**
	 * Tranfert une carte du joueur de devant lui vers la d�fausse.
	 * @param carte La carte sacrifi�.
	 */
	public void sacrifierCarte(Carte carte){
		//TODO Impl�mentation
	}
	
	public Divinite getDivinite() {
		return divinite;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		StringBuffer buf = new StringBuffer();
		buf.append(this.diviniteToString());
		buf.append(this.mainToString());
		buf.append(this.guidesToString());
		buf.append(this.croyantsToString());
		return buf.toString();
	}
	
	public String diviniteToString(){
		StringBuffer buf = new StringBuffer();
		buf.append("\nVotre Divinit�e : ");
		buf.append(divinite.toString()).append(ConstanteCarte.BARRE);
		return buf.toString();
	}
	
	public String mainToString(){
		StringBuffer buf = new StringBuffer();
		buf.append("\nCartes en main : ").append(ConstanteCarte.BARRE);
		int count = 1;
		Iterator<Carte> it = main.iterator();
		while(it.hasNext()){
			buf.append(count).append(" - ").append(((Carte)it.next()).toString()).append(ConstanteCarte.PETITEBARRE);
			count++;
		}
		return buf.toString();
	}
	
	public String guidesToString(){
		StringBuffer buf = new StringBuffer();
		buf.append("\nCartes Guide Spirituel devant vous : ").append(ConstanteCarte.BARRE);
		int count = 1;
		Iterator<Guide_Spirituel> it = guides.iterator();
		while(it.hasNext()){
			buf.append(count).append(" - ").append(((Carte)it.next()).toString()).append(ConstanteCarte.PETITEBARRE);
		}
		return buf.toString();
	}
	
	public String croyantsToString(){
		StringBuffer buf = new StringBuffer();
		buf.append("\nCartes Croyant devant vous : ").append(ConstanteCarte.BARRE);
		int count = 1;
		Iterator<Croyant> it = croyants.iterator();
		while(it.hasNext()){
			buf.append(count).append(" - ").append(((Carte)it.next()).toString()).append(ConstanteCarte.PETITEBARRE);
		}
		return buf.toString();
	}

	public Joueur getJoueur() {
		return joueur;
	}

	public void setJoueur(Joueur joueur) {
		this.joueur = joueur;
	}
	
}
