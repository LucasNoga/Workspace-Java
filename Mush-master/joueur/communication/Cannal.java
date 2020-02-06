package joueur.communication;

/**
 * Cannal de communication pour les humains
 * @author adrien
 */
public class Cannal {

	private String[] cannal;
	
	
	public Cannal() {
		this.cannal = new String[10];
		for(int index = 0; index < cannal.length; index++) {
			this.cannal[index] = "";
		}
	}
	
	
	private void decalage(){
		
	    int courant=0, suivant=0;
		String temp;
	    String tampon=cannal[cannal.length-1];
	    for (courant=0; courant < cannal.length; courant+=2){
	        suivant = (courant+1) % cannal.length;
	        temp = cannal[suivant];
	        cannal[suivant]=cannal[courant];
	        cannal[courant]=tampon;
	        tampon = temp;
	    }
	}
	
	
	/**
	 * Ajoute une communication au cannal
	 * @param com : ligne ajouter au cannal de discution
	 */
	public void add(String com) {
		decalage();
		this.cannal[0]= com + "\n";
	}
	
	
	/**
	 * 	Affichage du cannal de discution
	 */
	public void affichage() {
		for(int index = 0; index < cannal.length; index++) {
			if(cannal[index] != "") {
				System.out.println(this.cannal[index]);
			}
		}
	}
	
}