package td5_lo02;


public class Commutateur {

	private int compteurPuissance = 0;
	private Lampe lampe;
	public Commutateur(Lampe la){
		this.lampe = la;
	}

	public void commuter(){
		if(getCompteurPuissance() <= 4){
			lampe.allumer();
			compteurPuissance++;
		}
		else{
			lampe.eteindre();
			this.setCompteurPuissance(0);
		}
	}

	public int getCompteurPuissance(){
		return this.compteurPuissance;
	}

	public void setCompteurPuissance(int cpt){
		this.compteurPuissance = cpt;
	}

}
