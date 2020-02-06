package MVC;

public class Main {
	public static void main(String[] args){

		Model modele = new Model();
		Controler controler = new Controler(modele);

		VueGraphique v = new VueGraphique();
		modele.addObserver(v);

		v.b1.addActionListener(controler);
		v.b2.addActionListener(controler);

	}
}
