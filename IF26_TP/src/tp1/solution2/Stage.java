/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp1.solution2;

import tp2.exo1.Resultat;

public class Stage extends Element{
	private String entreprise;

	public Stage(String sigle, String categorie, String entreprise, int credit, Resultat resultat) {
		super(sigle, categorie, credit, resultat);
		this.entreprise = entreprise;
	}


	@Override
	public String toString() {
		return "Stage{" + "sigle=" + sigle + ", categorie=" + categorie + ", entreprise=" + entreprise 
				+ ", credit=" + credit + ", resultat=" + resultat + "}";
	}

	public void affiche() {
		System.out.println(toString());
	}
	
}