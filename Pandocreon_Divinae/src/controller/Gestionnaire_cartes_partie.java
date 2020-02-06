package controller;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import models.cartes.Carte;
import models.cartes.Divinite;

public class Gestionnaire_cartes_partie {
	
	private Queue<Carte> pioche;
	private List<Carte> defausse;
	private List<Carte> table;
	private Queue<Divinite> divinitesRestantes;
	
	public Gestionnaire_cartes_partie(List<Carte> deck,Queue<Divinite> divinitesRestantes){
		this.pioche = new LinkedList<Carte>(deck);
		this.defausse = new ArrayList<Carte>();
		this.table = new ArrayList<Carte>();
		this.setDivinitesRestantes(divinitesRestantes);
	}
	
	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		StringBuffer buf = new StringBuffer();
		buf.append("\nNombre de cartes dans la pioche : ").append(this.pioche.size()).append("\n");
		buf.append("Nombre de cartes dans la defausse : ").append(this.defausse.size()).append("\n\n");
		buf.append("Cartes au centre de la table : \n");
		for(int i=0;i<this.table.size();i++){
			buf.append(this.table.get(i).toString()).append("\n");
		}
		return buf.toString();
	}



	public Queue<Divinite> getDivinitesRestantes() {
		return divinitesRestantes;
	}



	public void setDivinitesRestantes(Queue<Divinite> divinitesRestantes) {
		this.divinitesRestantes = divinitesRestantes;
	}
}
