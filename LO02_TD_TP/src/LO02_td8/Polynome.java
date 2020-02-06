package LO02_td8;

public class Polynome {
	private int x2;
	private int x1;
	private int x0;


	/**constructeur*/
	public Polynome(int x2, int x1, int x0){
		this.x2 = x2;
		this.x1 = x1;
		this.x0 = x0;
	}

	/**méthode pour avoir le discriminant*/
	public double discriminant(){
		return Math.pow(x1, 2) - 4 * x2 * x0;
	}

	/**teste si le discriminant est négative*/
	public boolean hasComplexRoots(){
		return (this.discriminant() < 0);
	}

	/**teste si le discriminant est nul*/
	public boolean hasDoubleRoots(){
		return (this.discriminant() == 0);
	}

	/**teste si le discriminant est positif*/
	public boolean hasRealRoots(){
		return (this.discriminant() > 0);
	}

	
	/**methode de calcule de racine en traitant des exceptions*/
	public void getRoots() throws InvalidPolynomException{
		if(this.x2 == 0){
			throw new InvalidPolynomException();
		}
		else{
			double discriminant = discriminant();
			double s = 0;
			double sqrtDis = Math.sqrt(discriminant);
			System.out.println("delta = " +discriminant);

			if(this.hasRealRoots()){
				s = (- (x1) + sqrtDis ) / (2*x2) ;
				System.out.println("x1 = " +s);
				s = (- (x1) - sqrtDis ) / (2*x2) ;
				System.out.println("x2 = " +s);
			}
			else if(hasComplexRoots()){
				s = (- (x1) + sqrtDis ) / (2*x2) ;
				System.out.println("x1 = " +s);
				s = (- (x1) - sqrtDis ) / (2*x2) ;
				System.out.println("x2 = " +s);
			}
			if(this.hasDoubleRoots()){
				s = -x1 / (2*x2);
				System.out.println("x =" +s);
			}
		}
	}
	
	/**Methode equals*/
	public boolean equals(Object o){
		if (o instanceof Polynome){
			Polynome p = (Polynome) o;
			return p.x2 == this.x2 && p.x1 == this.x1 && p.x0 == this.x0;
		}else{
			return false;
		}
	}

	
	public static void main(String[] args) {
		Polynome calcul1 = new Polynome(0, 1, 0);

		Polynome calcul2 = new Polynome(1, 4, 3);


		//Polynome de degré 1 de plus on doit try catch puisque la méthode calculerRacine throws des exceptions 
		try {
			calcul1.getRoots();
		} catch (InvalidPolynomException e) {
			e.printStackTrace();
		}
		System.out.println();

		try {
			calcul2.getRoots();
		} catch (Exception e) {
			e.getMessage();
		}
		System.out.println();


	}

}
