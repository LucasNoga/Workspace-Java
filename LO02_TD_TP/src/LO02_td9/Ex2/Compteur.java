package LO02_td9.Ex2;

import java.util.Observable;

//l'objet observable
public class Compteur extends Observable {
	
	public final static int TEMPORISATION = 500;
	protected int compteur;
	protected boolean compte;
	
	public Compteur () { 
		this.compteur = 0;
		this.compte = false;
	 }
	public void compter() {
		this.compte = true;
		compteur++;
		setChanged();
		notifyObservers();
	}
	public void arreter() {
		this.compte = false;
    }
	    
	public int getValeur() {
		return this.compteur;
    }
	
	protected void attendre() {
	        // Dans un bloc try/catch
		try {
			Thread.sleep(Compteur.TEMPORISATION);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    } 
}
