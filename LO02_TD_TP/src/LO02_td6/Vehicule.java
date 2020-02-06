package LO02_td6;
public abstract class Vehicule implements Pilotable, Orientable {
	protected int nombreDePlaces = 0;
	protected int capaciteMarchandises = 0;
	protected int vitesse = 0;

	public Vehicule (int nombreDePlaces) {
        this.nombreDePlaces = nombreDePlaces;
    }

	public abstract void rouler (int kilometres);
	
	public void rouler(){
		System.out.println("je roule en "+ this.getClass().getSimpleName().toLowerCase() + " à "+ this.vitesse + "/h");
	}
	
	@Override
	public void accelerer(int vitesse) {
		vitesse+= vitesse;
		System.out.println("le "+ getClass().getSimpleName()+" roule maintenant a "+this.vitesse);
	}
	
	@Override
	public void ralentir(int vitesse) {
		this.vitesse -= vitesse;
		System.out.println("le "+ getClass().getSimpleName()+" roule maintenant a "+ this.vitesse);
		
	}
	
	
	public static void main(String[] args){
		Vehicule vehicule1 = new Voiture();
		Vehicule vehicule2 = new Train();
		Voiture voiture1 = (Voiture) vehicule1;
		Train train1 = (Train) vehicule2;
		
		/*Voitures*/
		System.out.println("Adresse memoires des instances voitures");
		System.out.println(vehicule1.hashCode());
		System.out.println(voiture1.hashCode());
		
		System.out.println("Methodes pour prouver que les deux instances voitures font references au même objet");
		vehicule1.rouler(50);
		voiture1.rouler();
		
		/*Train*/
		System.out.println("Adresse memoires des instances Train");
		System.out.println(vehicule2.hashCode());
		System.out.println(train1.hashCode());	
		
		System.out.println("Methodes pour prouver que les deux instances voitures font references au même objet");
		vehicule2.rouler(200);
		train1.rouler();
		//System.out.println(voiture1.capaciteMarchandises.toString());
		
		 String mot = "exemple";
		    mot=mot+" test";
		    System.out.println(mot);
		    System.exit(0);
	}
}