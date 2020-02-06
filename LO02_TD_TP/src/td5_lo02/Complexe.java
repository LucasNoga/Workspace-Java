package td5_lo02;

public class Complexe {
	double partie_reel;
	double partie_img;

	public Complexe(double reel, double img){
		this.partie_reel = reel;
		this.partie_img = img;
	}

	/**Méthode qui conjugue le complexe*/
	public void conjuger(){
		this.partie_img = -this.partie_img;
	}

	/**Méthode qui retourne le module du complexe
	 * @return double 
	 */
	public double module(){
		return Math.sqrt( Math.pow(this.partie_reel, 2) + Math.pow(this.partie_img, 2)  );
	}

	/**Méthode qui multiplie le complexe en paramètre a l'objet this
	 * @param complexe
	 */
	public void multiplyComplexe(Complexe complexe){
		this.partie_reel = (this.partie_reel * complexe.partie_reel) - (this.partie_img * complexe.partie_img);
		this.partie_img = (this.partie_reel * complexe.partie_img) + (this.partie_img * complexe.partie_reel);

	}

	/**Méthode qui addition le complexe en paramètre a l'objet this
	 * @param complexe
	 */
	public void addComplexe(Complexe complexe){
		this.partie_reel += complexe.partie_reel;
		this.partie_img += complexe.partie_img;
	}
	
	public void ajouterReference(Complexe complexe){
		complexe.partie_reel += this.partie_reel;
		complexe.partie_img += this.partie_img;
	}
	
	public void ajouterReference(int pr, int pi){
		pr += this.partie_reel;
		pi += this.partie_img;
	}

	/**Méthode toString*/
	public String toString(){
		String s = "z = "+ this.partie_reel +" ";

		if(this.partie_img == 1)
			return s+= "+ i";
		else if(this.partie_img > 0)
			return s += "+ " + this.partie_img + "i";
		else if(this.partie_img == -1)
			return s+= "- i";
		else
			return s+= "- " + (-this.partie_img) + "i";
	}

	/**Méthode equals*/
	public boolean equals(Object obj){
		Complexe complexe = (Complexe) obj;
		if (this == complexe)
			return true;
		else if (this.partie_reel == complexe.partie_reel)
			return true;
		else if (this.partie_img == complexe.partie_img)
			return true;
		else 
			return false;
	}
	


	public static void main(String[] args){
		//Conjuger
		Complexe comp1 = new Complexe(2, 2);
		System.out.println(comp1);
		comp1.conjuger();
		System.out.println(comp1);

		//module
		Complexe comp2 = new Complexe(2, 2);
		System.out.println("Module de " + comp2 +" est "+comp2.module());

		//addition d'un module
		comp1 = new Complexe(1, 4);
		comp2 = new Complexe(5, 3);
		System.out.println("\nAddition de \n"+comp1+" avec "+comp2);
		comp1.addComplexe(comp2);
		System.out.println("resultat "+ comp1);

		//multiplication d'un module
		comp1 = new Complexe(1, 4);
		comp2 = new Complexe(5, 3);
		System.out.println("\nMultiplication de \n"+comp1+" avec "+comp2);
		comp1.multiplyComplexe(comp2);
		System.out.println("resultat "+ comp1);
		
		//teste de la methode equals
		comp1 = new Complexe(1, 4);
		comp2 = new Complexe(5, 3);
		System.out.println("\nTest entre : "+ comp1+" et "+comp2+" nous donne "+ comp1.equals(comp2));
		comp1 = new Complexe(5, 3);
		System.out.println("Test entre : "+ comp1+" et "+comp2+" nous donne "+ comp1.equals(comp2));
		
		//montre que les objets sont des refercence(pointeurs)
		comp1 = new Complexe(1, 4);
		comp2 = comp1;
		System.out.println(comp1.hashCode());
		System.out.println(comp2.hashCode());
		
		
		
	}
}
