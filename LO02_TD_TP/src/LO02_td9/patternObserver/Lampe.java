package LO02_td9.patternObserver;

import java.util.Observable;

public class Lampe extends Observable{

	public final static int PUISSANCE_STANDARD = 100;
	private int puissance;
	public boolean estAllume;

	public Lampe(int puissance){
		this.puissance = puissance;
		this.estAllume = false;
	}

	public void allumer() {
		this.estAllume = true;
		setChanged();
		notifyObservers(this.estAllume);	
	}

	public int getPuissance() {
		return this.puissance;
	}

	public void eteindre(){
		this.estAllume = false;
		setChanged();
		notifyObservers();
	}

	public String toString(){
		return "la lampe est a "+this.estAllume;
	}
}