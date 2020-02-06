package mokan;

import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MokanHelp extends JFrame{
	private static final long serialVersionUID = 1L;

	public MokanHelp(){
		this.setTitle("Aide");
		JLabel label = new JLabel("<html>"
				+ "<ol>"
					+ "<li>Creer un module a l'aide du bouton creer module<br/>"
					+ "<li>Selection d'un cours"
						+ "<ul>"
							+ "<li>CM : Cours Magistral</li>"
							+ "<li>TD Travaux dirigés</li>"
							+ "<li>TP2 Travaux Pratiques de 2 heures</li>"
							+ "<li>TP4 Travaux Pratiques de 4 heures</li>"
							+ "<li>TQ Salle de cours (Hors salle machine)</li>"
							+ "<li>TM Salle Machine</li>"
							+ "<li>EV2 Evaluation de deux heures</li>"
						+ "</ul>"
					+ "<li>Affecter un professeur a un cours</li>"
					+ "<li>Ajout d'un cours dans la previsualisation</li>"
					+ "<li>Defini les dates de debut et fin de module</li>"
					+ "<li>Si besoin, modifier les cours dans la previsualisation</li>"
				+ "</ol>"
			+ "</html>");
		
		JLabel label2 = new JLabel("<html>"
				+ "<ul>"
					+ "<li>Entrées claviers : <br/>"
						+ "<ul>"
							+ "<li>Fleche du haut/bas : Incrémenter et décrémenter le numéro de la semaine</li>"
							+ "<li>Q : Ferme le programme</li>"
							+ "<li>A : Ouvre la fenétre d'aide</li>"
							+ "<li>Espace : Ouvre la fenétre d'affectation</li>"
							+ "<li>Entrer : Permet l'ajout d'un cours dans l'Affichage</li>"
						+ "</ul>"
				+ "</ul>"
			+ "</html>");		
		
		JPanel mainPanel = new JPanel(new FlowLayout());
		mainPanel.add(label);
		mainPanel.add(label2);
		
		this.add(mainPanel);
		this.setVisible(true);
		this.pack();
		this.setLocationRelativeTo(null);
	}	
	
	

}
