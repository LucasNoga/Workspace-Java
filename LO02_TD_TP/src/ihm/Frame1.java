package ihm;

import javax.annotation.Generated;
import javax.swing.JFrame;

@SuppressWarnings("serial")
@Generated("test")
public class Frame1 extends JFrame{
	
	public Frame1(){
		this.setTitle("salut");
	}

	public static void main (String [] args){
		Frame1 fenetre = new Frame1();
		fenetre.setVisible(true);
		fenetre.setSize(500, 500);
		fenetre.setDefaultCloseOperation(EXIT_ON_CLOSE);
		fenetre.setLocationRelativeTo(null);
	}
}
