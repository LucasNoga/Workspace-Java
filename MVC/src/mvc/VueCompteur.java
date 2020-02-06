package mvc;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;
import javax.swing.*;

class VueCompteur implements Observer {
	private ModeleCompteur compteur;
	private JFrame fenetre;
	private JLabel texte;
	private JButton demarrer;


	public VueCompteur (ModeleCompteur c) { 
		compteur = c;
		compteur.addObserver(this);

		texte = new JLabel("Compteur : " + c.getValeur());
		demarrer = new JButton("Demarrer");
		fenetre = new JFrame ("Un compteur");
		Container reservoir = fenetre.getContentPane(); 

		reservoir.add(texte, BorderLayout.NORTH);
		reservoir.add(demarrer, BorderLayout.SOUTH);

		/*Action*/
		demarrer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				compteur.compter();	
			}
		});
		
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenetre.pack();
		fenetre.setVisible(true);
	}

	@Override
	public void update(Observable o, Object arg) {
		texte.setText("Compteur : " + compteur.getValeur());
	}

	public static void main(String[] args) {
		ModeleCompteur c = new ModeleCompteur();
		VueCompteur vc = new VueCompteur(c);
	}
}
