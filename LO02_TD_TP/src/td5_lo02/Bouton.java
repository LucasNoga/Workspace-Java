package td5_lo02;

public class Bouton {
	
	private Commutateur commu;
	
	public Bouton(Commutateur com){
		this.commu = com;
	}

	
	public void appuyer(){
		System.out.println("Vous venez d'appuyer sur le bouton");
		commu.commuter();
		
	}
}
