package MVC;

import java.util.Observable;

public class Model extends Observable{

	private int compteur;

	public Model(){
		this.compteur = 0;
	}


	public void modifier(int n){
		this.compteur=compteur+n;
		this.setChanged();
		this.notifyObservers();
	}


	public int getCompteur(){
		return compteur;

	}
}
