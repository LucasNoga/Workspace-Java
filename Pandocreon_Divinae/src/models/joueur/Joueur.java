package models.joueur;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import controller.Gestionnaire_Cartes_Joueur;
import models.cartes.Carte;
import models.cartes.ConstanteCarte;
import models.cartes.Divinite;
import models.cartes.Origine;

public abstract class Joueur {
	protected Map<Origine,Integer> pointsAction;
	protected Gestionnaire_Cartes_Joueur gcj = null;

	public Joueur(){
		this.pointsAction = new HashMap<Origine,Integer>();
		this.pointsAction.put(Origine.JOUR, 0);
		this.pointsAction.put(Origine.NUIT, 0);
		this.pointsAction.put(Origine.NEANT, 0);
	}
	
	/**
	 * Permet au joueur de jouer
	 * @return Renvois faux si une carte APOCALYPSE a �t� jou� sinon renvois vrai.
	 */
	public boolean jouer(){
		return false;
	};
	
	/**
	 * Permet au joueur de jouer une carte de sa main.
	 * @param indice L'indice de la carte dans sa main.
	 * @return Vrai si la carte a �ffectivement �t� jou�. Faux sinon. 
	 */
	public boolean jouerCarte(int indice){
		return false;
	}
	
	/**
	 * Permet au joueur de sacrifier une des cartes qui se trouvent devant lui.
	 * @param indice L'indice de la carte devant lui.
	 */
	public void sacrifierCarte(int indice){
		
	}
	
	/**
	 * Permet au joueur d'utiliser la capacit� de sa divinit�. 
	 */
	public void activerCapaciteDivinite(){
		
	}
	
	/**
	 * Permet au joueur de savoir quels cartes il peut jouer en fonction de ses points d'action. 
	 * @return Une sous liste de main. 
	 */
	public List<Carte> cartesJouables(){
		return null;
	}
	
	/**
	 * Distribue des points d'action au joueur en fonction de sa divinit�. 
	 * @param origine L'Origine tir� par le d� de cosmogonie. 
	 */
	public void attribuerPointsAction(Origine origine){
		switch(this.gcj.getDivinite().getOrigine()){
		case JOUR : 
			if(origine.equals(Origine.JOUR)){
				incrementerPointAction(origine);
				incrementerPointAction(origine);
			}
			break;
		case NUIT :
			if(origine.equals(Origine.NUIT)){
				incrementerPointAction(origine);
				incrementerPointAction(origine);
			}
			break;
		case AUBE :
			if(origine.equals(Origine.JOUR)){
				incrementerPointAction(origine);
			}
			if(origine.equals(Origine.NUIT)){
				incrementerPointAction(origine);
			}
			break;
		case CREPUSCULE :
			if(origine.equals(Origine.NUIT)){
				incrementerPointAction(origine);
			}
			if(origine.equals(Origine.NUIT)){
				incrementerPointAction(origine);
			}
			break;
		default : break;
		}
	}
	
	/**
	 * Ajoute 1 point d'action dans la PointsAction en fonction de l'Origine.
	 * @param origine L'Origine. 
	 */
	public void incrementerPointAction(Origine origine){
		pointsAction.replace(origine, pointsAction.get(origine) + 1);
	}
	
	public void attachGestionnaire_Cartes_Joueur(List<Carte> main, Divinite divinite){
		this.gcj = new Gestionnaire_Cartes_Joueur(this, main, divinite);
	}
	
	public Gestionnaire_Cartes_Joueur getGestionnaire_Cartes_Joueur(){
		return this.gcj;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		StringBuffer buf = new StringBuffer();
		buf.append("Points d'action : ").append(pointsAction.toString()).append(ConstanteCarte.BARRE);
		buf.append(gcj.toString()).append("\n");
		return buf.toString();
	}
}
