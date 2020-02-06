package td6_lo02;

public class Train extends Vehicule{
	public Train() {
		super(200);
	}
	@Override
	public void rouler (int kilometres) {
		this.vitesse = kilometres;
		System.out.println("je roule en "+ this.getClass().getSimpleName().toLowerCase() + " à "+ this.vitesse + "/h");
	}
	
	
	@Override
	public void tournerADroite(int degre) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void tournerAGauche(int degre) {
		// TODO Auto-generated method stub
		
	}
}
