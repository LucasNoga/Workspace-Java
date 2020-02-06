package LO02_td9.patternObserver;

public class Main {

	public static void main(String[] args){
		//creation du modele
		ObserverLampCommu obs = new ObserverLampCommu();

		//definir une lampe
		Lampe lampe = new Lampe(70);
		//Ajouter un observer	
		lampe.addObserver(obs);
		
		System.out.println("Avant mise � jour de l'etat de la lampe:\nLampe: "+ lampe);
		//Effectuer un changement sur l'attribut etat de l'entreprise
		System.out.println("On allume la lampe");
		lampe.allumer();	
		System.out.println("Apr�s mise � jour de l'etat de la lampe:\nLampe: "+ lampe);
	}
}
