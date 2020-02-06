package td5_lo02;

import java.util.Scanner;

public class Lampe {

	private int puissance = 0;
	private int dureeDeVie = 150;

	public Lampe(){}

	public void allumer(){
		puissance+=50;
		setDureeDeVie(getDureeDeVie() - 1);
		System.out.println("La puissance de la lampe est de "+ this.puissance);
	}

	public void eteindre(){
		if(puissance == 0)
			System.out.println("la lampe est déjà éteinte");
		else{
			puissance = 0;
			System.out.println("La lampe vient de s'éteindre");
		}
	}

	public boolean estAllumé(){
		return (puissance > 0);
	}

	public int getPuissance(){
		return puissance;
	}

	public void setPuissance(int puis){
		this.puissance = puis;
	}

	public static void main(String[] args){
		Lampe lampe = new Lampe();
		Commutateur commutateur = new Commutateur(lampe);
		Bouton bouton = new Bouton(commutateur);
		Scanner sc = new Scanner(System.in);
		System.out.print("Bonjour ");
		while(true){
			System.out.print("Que voulez vous faire");
			System.out.println("\n1: appuyer sur le bouton");
			System.out.println("2: eteindre la lampe");
			System.out.println("3: quitter le programme");
			String choix = sc.nextLine();
			sc.close();
			int ch = Integer.parseInt(choix);			
			switch(ch){
			case 1:
				bouton.appuyer();
				break;

			case 2:
				lampe.eteindre();
				commutateur.setCompteurPuissance(0);
				break;

			case 3:
				System.out.println("Fin du programme");
				System.exit(0);

			default:
				System.out.println("Veuillez saisir un autre chiffre");
				break;
			}
		}
	}

	public int getDureeDeVie() {
		return dureeDeVie;
	}

	public void setDureeDeVie(int dureeDeVie) {
		this.dureeDeVie = dureeDeVie;
	}
}