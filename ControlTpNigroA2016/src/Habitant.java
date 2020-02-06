//Examen : tps pass� 55 Min
//Manque : Strat�gie V�t�ran Elfe.

public abstract class Habitant {
	
	private String nom;
	private int pointDeVie;
	private int puissanceAttaque;
	
	public Habitant (String nomPersonnage) {
		nom=nomPersonnage;
		pointDeVie=30;
		puissanceAttaque=5;
	}

	public Habitant (String nomPersonnage, int ptVie, int puissance) {
		nom=nomPersonnage;
		pointDeVie=ptVie;
		puissanceAttaque=puissance;
	}
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getPointDeVie() {
		return pointDeVie;
	}

	public void setPointDeVie(int pointDeVie) {
		this.pointDeVie = pointDeVie;
	}

	public int getPuissanceAttaque() {
		return puissanceAttaque;
	}

	public void setPuissanceAttaque(int puissanceAttaque) {
		this.puissanceAttaque = puissanceAttaque;
	}

	public void seRepose () {
		pointDeVie+=4;
	}
	
	public abstract void attaque(Habitant hab);
	
	public static void main(String[] args) {
		new Humain("Paul1");
		new Humain("Paul2");
		new Humain("Paul3");
		new Humain("Paul4");
		new Humain("Paul5");

		new Elfe("Enrick1");
		new Elfe("Enrick2");
		new Elfe("Enrick3");
		new Elfe("Enrick4");
		new Elfe("Enrick5");
		
		System.out.println(Humain.listeHumains);
		System.out.println(Elfe.listeElfes);
		
		while (Humain.listeHumains.size()>0 && Elfe.listeElfes.size()>0) {
			int hasard=(int)(2*Math.random());
			if (hasard==0) // Humain attaque
			{Humain h=Humain.listeHumains.get(0);
			 h.StrategieVeteran();
			}
			else {// Elfe attaque
			 Elfe h=Elfe.listeElfes.get(0);
			 h.StrategieSoldat();
			}
				
			System.out.println(Humain.listeHumains);
			System.out.println(Elfe.listeElfes);
			
		}
	}

}
