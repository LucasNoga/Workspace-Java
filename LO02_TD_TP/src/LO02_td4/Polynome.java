package LO02_td4;
public class Polynome {

	double a,b,c = 0;
	int discriminant; 
	
	
	//constructeur
	public Polynome(double a, double b, double c){
		this.a=a;
		this.b=b;
		this.c=c;
	}

	/*methode de changement de base*/
	public void calculerRacine(){
		double discriminant = Math.pow(b, 2) - (4*a*c); 
		double s = 0;
		double sqrtDis = Math.sqrt(discriminant);
		System.out.println("delta = " +discriminant);
		
		if(discriminant > 0){
			s = (- (b) + sqrtDis ) / (2*a) ;
			System.out.println("x1 = " +s);
			s = (- (b) - sqrtDis ) / (2*a) ;
			System.out.println("x2 = " +s);
		}
		else if(discriminant < 0){
			s = (- (b) + sqrtDis ) / (2*a) ;
			System.out.println("x1 = " +s);
			s = (- (b) - sqrtDis ) / (2*a) ;
			System.out.println("x2 = " +s);
		}
		if(discriminant == 0){
			s = -b / (2*a);
			System.out.println("x =" +s);
		}
	}
		public static void main(String[] args) {
			Polynome calcul1 = new Polynome(1, 1, 1);
			Polynome calcul2 = new Polynome(2, -5, -3);
			Polynome calcul3 = new Polynome(1, -4, 5);
			Polynome calcul4 = new Polynome(9, 6, 1);
			Polynome calcul5 = new Polynome(5, 5, -10);			
			
			calcul1.calculerRacine();
			System.out.println();
			calcul2.calculerRacine();
			System.out.println();
			calcul3.calculerRacine();
			System.out.println();
			calcul4.calculerRacine();
			System.out.println();
			calcul5.calculerRacine();

		}

	}
