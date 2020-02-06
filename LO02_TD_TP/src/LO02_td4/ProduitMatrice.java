package LO02_td4;
public class ProduitMatrice {		

	static int[][] multiplier(int[][] MA, int[][] MB){
		int[][] MC;
		int l,c;

		//La multiplication de deux matrices n'est possible que si le nombre de colonne du premier est égal au nombre de ligne du second!!
		if(MA[0].length != MB.length)
			System.exit(0);

		
		if(MA[0].length < MB[0].length){
			l= MB.length;
			c= MB[0].length;
			System.out.println("B");
		}else{
			l= MA.length;
			c= MA[0].length;
			System.out.println("A");
		}

		MC = new int[l][c];

		l = 0;
		for (int i = 0;i < MA.length;i++){ /// Ligne de MA
			c = 0;
			for (int n = 0;n < MB[0].length;n++){ /// colonne de  MB

				int calcul= 0;
				for (int m = 0;m < MB.length;m++){
					calcul += MA[i][m] * MB[m][n];
				}
				MC[l][c] = calcul;
				c++;
			}
			l++;
		}
		return MC;
	}


	static void afficher(int [][]M){
		for (int i = 0;i < M.length;i++){
			for (int j = 0;j < M[0].length ;j++){
				System.out.printf("%4d ",M[i][j] );
			}
			System.out.println();
		}
		System.out.println();
	}

	public static void main(String[] args){	
		int[][] MA = { {2, 3}, {2, 1} };
		int[][] MB= { {4, 2}, {3, 1} };
		int[][]MC = null;
		afficher(MA);
		afficher(MB);
		MC = multiplier(MA, MB);
		System.out.println();
		afficher(MC);

	}
}
