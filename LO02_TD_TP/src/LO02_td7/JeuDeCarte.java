package LO02_td7;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;

public class JeuDeCarte {
	public final static int NOMBRE_DE_CARTES = Carte.VALEURS.length * Carte.COULEURS.length;
	
	private LinkedList<Carte> tasDeCarte;
	
	public JeuDeCarte(){
		for(int c = Carte.PIC; c <= Carte.TREFLE; c++){
			for(int v = Carte.SEPT; v <= Carte.AS; v++){
				Carte card = new Carte(v, c); 
				System.out.println(card);
				tasDeCarte.add(card);
			}
		}
	}
	
	public void melanger(){
		Collections.shuffle(tasDeCarte);
	}
	
	public void afficherTasDeCartes(){
		Iterator<Carte> it = tasDeCarte.iterator();
		
		while(it.hasNext()){
			System.out.println("Carte : " +it.next());
		}
	}
	
	public Carte tirerCarteduDessus(){
		return tasDeCarte.pop();
	}
	
	public Carte tirerCarteRandom(){
		int position = (int) Math.round(Math.random() * (JeuDeCarte.NOMBRE_DE_CARTES - 1));
		return tasDeCarte.remove(position);
	}
	
	
	
	
	
	
	
	public static void main(String[] arg){
		JeuDeCarte jc = new JeuDeCarte();
		jc.afficherTasDeCartes();
		jc.melanger();
		jc.afficherTasDeCartes();
	}
	
}
