package td4_lo02;

public class Binaire {

	public static void main(String[] args){
		int[] adresseIp = {1, 0, 1, 1, 0, 1, 0, 1, 1, 0, 1, 1, 0, 1, 0, 1,       1, 0, 1, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1}; 
		int[] masque = {   1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,       0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		
		int[] partieReseau = new int[16];
		int[] partieMachine = new int[16];
		int index = 0;
		int index2 = 0;
		
		for(int i : masque){
			if(i == 1){
				partieReseau[index] = adresseIp[index];		
				index++;
			}
			
			else{
				partieMachine[index2] = adresseIp[index];
				System.out.println(adresseIp[index2]);
				index2++; 
				index++;
			}
		}	
		System.out.println("Partie reseau");
		affichage(partieReseau);
		System.out.println("\nPartie machine");
		affichage(partieMachine);
		
		
	}
	
	public static void affichage(int[] tab){
		for(int i : tab)
			System.out.print(i + " ");
		
	}
	
}
