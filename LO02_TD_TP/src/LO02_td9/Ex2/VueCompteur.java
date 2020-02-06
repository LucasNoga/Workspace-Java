package LO02_td9.Ex2;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Observable;
import java.util.Observer;
import javax.swing.*;

//l'observateur
public class VueCompteur implements Observer, ActionListener{
	private Compteur compteur;
	private JFrame fenetre;
	private JLabel texte;
	private JButton demarrer;


	public VueCompteur(Compteur c) {
		compteur = c;
		compteur.addObserver(this);
		texte = new JLabel("Compteur : " + c.getValeur());   
		demarrer = new JButton("Demarrer");
		fenetre = new JFrame("Un compteur");
		Container reservoir = fenetre.getContentPane();


		reservoir.add(texte, BorderLayout.NORTH);
		reservoir.add(demarrer, BorderLayout.SOUTH);

		demarrer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				compteur.compter();
			}
		});
		
		demarrer.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				System.out.println("relache");
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				System.out.println("press�");
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				System.out.println("quitter");
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				System.out.println("entr�");
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("cliqu�");
				
			}
		});
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(e.getSource());
		
	}

	@Override
	public void update(Observable o, Object arg) {
		texte.setText("Compteur : " + compteur.getValeur());
	}
	
    public static void main(String[] args) {
        Compteur c = new Compteur();
        VueCompteur vc = new VueCompteur(c);
        vc.fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		vc.fenetre.setLocationRelativeTo(null);
		vc.fenetre.pack();
		vc.fenetre.setVisible(true);
    }
}
