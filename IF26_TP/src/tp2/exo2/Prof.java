package tp2.exo2;

import java.util.Observable;
import java.util.Observer;

public class Prof implements Observer{
	
	private String nom;

	public Prof(String nom) {
		this.nom = nom;	
	}
	
	@Override
	public void update(Observable o, Object arg) {
		Cursus cur = (Cursus) o;
		System.out.println(this.getNom() + " observe " + cur.getLabel() + " qui a ajouté le module " + cur.profil.get(cur.profil.size()-1).getSigle());
	
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
}
