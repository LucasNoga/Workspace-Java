package mokan;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

public class MokanApercu extends JFrame{
	private static final long serialVersionUID = 1L;
	
	//composant
	public JLabel nomModule, semestre, professeurCm, professeurTd, professeurTp2, professeurTp4, professeurTp, professeurTq, professeurTm, professeurEv2, intervenants;
	public JLabel semaineDebut, semaineFin;
	public JPanel mainPanel, panelModule, panelInfo;

	public MokanPrincipale principale;

	//donnees
	public int debutModule, finModule;

	public MokanApercu(){
		this.setTitle("Apercu");

		nomModule = new JLabel("Module");
		semestre = new JLabel("Semestre: ");
		professeurCm = new JLabel("Professeurs CM : ");
		professeurTd = new JLabel("Professeurs TD : ");
		professeurTp2 = new JLabel("Professeurs TP2 : ");
		professeurTp4 = new JLabel("Professeurs TP4 : ");
		professeurTq = new JLabel("Professeurs TQ : ");
		professeurTm = new JLabel("Professeurs TM : ");
		professeurEv2 = new JLabel("Professeurs EV2 : ");
		intervenants = new JLabel("Intervenants : ");
		semaineDebut = new JLabel("Semaine de debut : ");
		semaineFin = new JLabel("Semaine de fin :");
		
		panelModule = new JPanel(new FlowLayout());
		panelModule.add(nomModule);
		
		//bordures
		Border line = BorderFactory.createLineBorder(Color.GRAY, 2);
		TitledBorder panelBorder = BorderFactory.createTitledBorder(line, "Module");
        panelModule.setBorder(panelBorder);
		
		panelInfo = new JPanel(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();

		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridheight = 1;
		panelInfo.add(semestre, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridheight = 1;
		panelInfo.add(professeurCm, gbc);

		gbc.gridx = 0;
		gbc.gridy = 3;
		panelInfo.add(professeurTd, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 5;
		panelInfo.add(professeurTp2, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 6;
		panelInfo.add(professeurTp4, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 7;
		panelInfo.add(professeurTq, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 4;
		panelInfo.add(professeurTm, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 2;
		panelInfo.add(professeurEv2, gbc);

		gbc.gridx = 0;
		gbc.gridy = 8;
		panelInfo.add(intervenants, gbc);

		gbc.gridx = 0;
		gbc.gridy = 9;
		panelInfo.add(semaineDebut, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 10;
		panelInfo.add(semaineFin, gbc);
		
		panelBorder = BorderFactory.createTitledBorder(line, "Cours");
        panelInfo.setBorder(panelBorder);
		
		//ajout dans le panel principale
		mainPanel = new JPanel(new BorderLayout());
		mainPanel.add(panelModule, BorderLayout.NORTH);
		mainPanel.add(panelInfo, BorderLayout.CENTER);
		this.add(mainPanel);
		
		this.setLocation(1050, 200);
		this.setSize(400, 300);
		this.setVisible(true);
	}		
	
	//recuperer le nombre de jours 
	public int nombreJour(int jour, int mois){
		int i = 1;
		int j = 1;
		int semaine = 0;
		while(i<mois){
			if(mois%2 == 0 || mois == 2){
				j+=30;
				i++;
			}
			else{
				j+=31;
				i++;
			}
		}
		j+=jour;
		semaine=j/7+1;
		return semaine;
	}
	
	//pour le numero de semaine de debut
	public void semaineDebut(){
		semaineDebut.setText("Semaine de debut : ");
		int debut[] = principale.dateDebut;
		int jour = debut[0];
		int mois = debut[1];
		debutModule = nombreJour(jour, mois);
		semaineDebut.setText(semaineDebut.getText()+""+ debutModule);
	}
	
	//pour le numero de semaine de fin
	public void semaineFin(){
		semaineFin.setText("Semaine de fin : ");
		int fin[] = principale.dateFin;
		int jour = fin[0];
		int mois = fin[1];
		finModule = nombreJour(jour, mois);
		semaineFin.setText(semaineFin.getText()+""+ finModule);
	}
	
}
