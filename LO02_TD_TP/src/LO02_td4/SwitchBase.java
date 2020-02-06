package LO02_td4;
import java.util.Stack;

public class SwitchBase{
	int nombre = 0; //ici que vous choissisez votre nombre a convertir
	int base = 0; //ici que vous choississez votre base
	Stack<Integer> pile = new Stack<Integer>(); //pile qui conserve les reste
	int quotient = 0; //le dividende
	
	//constructeur
	public SwitchBase(int nombre, int base){
		this.nombre=nombre;
		this.base = base;
		this.quotient=this.nombre;
	}

	/*methode de changement de base*/
	public void changementBase(){
		do{
			pile.push(quotient % base);
			quotient = quotient/base; //on recupere le dividende qu'on va par la suite recalculer	
		}while( quotient!= 0);

		int taille = pile.size();
		int[] tab = new int[taille];

		for(int i = 0; i<tab.length; i++)
			tab[i] = pile.pop();

		if(base == 16)
			traitementHexa(tab);
		else{
			traitementClassique(tab);
		}
		System.out.println("\n");

	}

	public void traitementHexa(int [] tab){
		String[] tab2 = new String[tab.length];
		String j="";
		int index = 0;
		for(int i : tab){
			switch(i){
			case 10:
				j="A";
				break;
			case 11:
				j="B";
				break;
			case 12:
				j="C";
				break;
			case 13:
				j="D";
				break;
			case 14:
				j="E";
				break;
			case 15:
				j="F";
				break;
			default:
				j = i+""; 
			}
			tab2[index++]=j;
		}
		System.out.println("le nombre "+ nombre + " en base "+ base + " est ");
		for(String r : tab2)
			System.out.print(r +" ");
	}

	public void traitementClassique(int [] tab){
		System.out.println("le nombre "+ nombre + " en base "+ base + " est ");
		for(int i : tab)
			System.out.print(i +" ");
	}

	public static void main(String[] args) {
		SwitchBase calcul1 = new SwitchBase(44, 2);
		SwitchBase calcul2 = new SwitchBase(500, 16);
		SwitchBase calcul3 = new SwitchBase(500, 8);
		SwitchBase calcul4 = new SwitchBase(44, 16);
		SwitchBase calcul5 = new SwitchBase(199999999, 16);
		SwitchBase calcul6 = new SwitchBase(199999999, 2);
		calcul1.changementBase();
		calcul2.changementBase();
		calcul3.changementBase();
		calcul4.changementBase();
		calcul5.changementBase();
		calcul6.changementBase();


	}

}
