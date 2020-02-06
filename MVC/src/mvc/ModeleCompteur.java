package mvc;
import java.util.Observable;

public class ModeleCompteur extends Observable{

	/*Attributs*/
	public final static int TEMPORISATION = 500;
	protected int compteur;
	protected boolean compte;

	/*Constructeur*/
	public ModeleCompteur() {
		this.compteur = 0;
		this.compte = false;
	}

	/*Methode*/
	public void compter() {
		this.compte = true;
		while (compte) {
			compteur++;
			this.attendre();
		}
	}

	public void arreter() {
		this.compte = false;
	}

	public int getValeur() {
		return this.compteur;
	}

	protected void attendre(){
		try {
			Thread.sleep(TEMPORISATION);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} 
}
