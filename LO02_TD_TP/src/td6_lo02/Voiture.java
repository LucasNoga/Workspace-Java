package td6_lo02;


public class Voiture extends Vehicule {
	
	private int degre = 0;
	
	public Voiture() {
		super(4);
	}

	@Override
	public void rouler(int kilometres) {
		this.vitesse = kilometres;
		System.out.println("je roule en "+ this.getClass().getSimpleName().toLowerCase() + " à "+ this.vitesse + "/h");
	}
	
	@Override
	public void tournerADroite(int degre) {
		this.degre += degre;
		System.out.println("la "+ getClass().getSimpleName() +" est orienté maintenant à "+ this.degre);	
	}
	@Override
	public void tournerAGauche(int degre) {
		this.degre -= degre;
		System.out.println("la "+ getClass().getSimpleName() +" est orienté maintenant à "+ this.degre);	
	}
}
