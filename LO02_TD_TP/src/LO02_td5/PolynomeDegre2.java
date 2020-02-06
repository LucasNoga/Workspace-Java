package LO02_td5;
public class PolynomeDegre2 {
	double a,b,c = 0;

	//constructeur
	public PolynomeDegre2(double a, double b, double c){
		this.a=a;
		this.b=b;
		this.c=c;
	}

	/*methode de changement de base*/
	public void getRoots(){
		Complexe complexe = new Complexe(1, 1);
		double discriminant = Math.pow(b, 2) - (4*a*c); 
		double s = 0;
		double sqrtDis = Math.sqrt(Math.abs(discriminant));

		if(discriminant > 0){
			s = (- (b) + sqrtDis ) / (2*a) ;
			System.out.println("x1 = " +s);
			s = (- (b) - sqrtDis ) / (2*a) ;
			System.out.println("x2 = " +s);
		}
		else if(discriminant < 0){
			complexe.partie_reel = (- (b) + sqrtDis ) / (2*a) ;
			complexe.partie_img = - (sqrtDis / (2*a));
			System.out.println(complexe);

			complexe.partie_reel = (- (b) + sqrtDis ) / (2*a) ;
			complexe.partie_img = sqrtDis / (2*a) ;
			System.out.println(complexe);
		}
		else{
			s = -b / (2*a);
			System.out.println("x =" +s);
		}
	}
	public static void main(String[] args) {
		PolynomeDegre2 calcul1 = new PolynomeDegre2(1, 1, 1);
		PolynomeDegre2 calcul2 = new PolynomeDegre2(2, -5, -3);
		PolynomeDegre2 calcul3 = new PolynomeDegre2(1, -4, 5);
		PolynomeDegre2 calcul4 = new PolynomeDegre2(9, 6, 1);
		PolynomeDegre2 calcul5 = new PolynomeDegre2(5, 5, -10);			

		calcul1.getRoots();
		System.out.println();
		calcul2.getRoots();
		System.out.println();
		calcul3.getRoots();
		System.out.println();
		calcul4.getRoots();
		System.out.println();
		calcul5.getRoots();

	}
}
