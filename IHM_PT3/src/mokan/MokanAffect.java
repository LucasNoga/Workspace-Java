package mokan;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

public class MokanAffect extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	
	/**Fenetre*/
	MokanPrincipale principale;
	public JButton validate, vider, remplir, b1, b2, exit;
	public JPanel mainPanel, centerPanel, northPanel, southPanel, eastPanel, nombrePanel;
	public JTextField jtf1, jtf2, jtf3, jtf4;
	public JLabel titre = new JLabel("");
	public String nomCours;
	public int nombreGroupe;

	public MokanAffect(){
		this.setTitle("Affecter un cours");
		
		//NorthPanel
		northPanel = new JPanel(new FlowLayout());
		northPanel.add(titre);
		northPanel.setBackground(Color.GRAY);

		//SouthPanel
		southPanel = new JPanel(new BorderLayout());
		validate = new JButton("Valider");
		validate.addActionListener(this);
		validate.setActionCommand("Valider");
		southPanel.add(validate, BorderLayout.EAST);
		southPanel.setBackground(Color.GRAY);
		
		//Creation de 1, 2 ou 4 JTextFields
		centerPanel = new JPanel(new GridBagLayout());
		centerPanel.setBackground(Color.GRAY);
		
		jtf1 = new JTextField("");
		jtf1.setColumns(10);
		jtf2 = new JTextField("");
		jtf2.setColumns(10);
		jtf3 = new JTextField("");
		jtf3.setColumns(10);
		jtf4 = new JTextField("");
		jtf4.setColumns(10);
		
		
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridheight = 1;
		gbc.anchor = GridBagConstraints.CENTER;
		centerPanel.add(jtf1, gbc);
		
		gbc.gridx = 1;
		centerPanel.add(jtf2, gbc);
		
		gbc.gridx = 2;
		centerPanel.add(jtf3, gbc);
		
		gbc.gridx = 3;
		centerPanel.add(jtf4, gbc);
		
		//EastPanel
		exit = new JButton("Quitter");
		exit.addActionListener(this);
		exit.setActionCommand("quitter");
		
		remplir = new JButton("Remplir");
		remplir.addActionListener(this);
		remplir.setActionCommand("remplir");
		
		vider = new JButton("Vider");
		vider.addActionListener(this);
		vider.setActionCommand("vider");
		
		eastPanel = new JPanel();
		eastPanel.setLayout(new GridLayout(3,1));
		eastPanel.add(exit);
		eastPanel.add(remplir);
		eastPanel.add(vider);
		eastPanel.setBackground(Color.DARK_GRAY);
	
		//MainPanel
		mainPanel = new JPanel(new BorderLayout());
		mainPanel.add(northPanel, BorderLayout.NORTH);
		mainPanel.add(southPanel, BorderLayout.SOUTH);
		mainPanel.add(centerPanel, BorderLayout.CENTER);
		mainPanel.add(eastPanel, BorderLayout.EAST);
		mainPanel.setBackground(Color.GRAY);
		
		Border line = BorderFactory.createLineBorder(Color.BLACK, 2);
		TitledBorder panelBorder = BorderFactory.createTitledBorder(line, "Affecter cours");
		mainPanel.setBorder(panelBorder);
		
		this.setUndecorated(true); 
		this.setContentPane(mainPanel);
		this.setVisible(true);
		this.setSize(750, 150);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);	
	}
	
	/**Methode pour le nombre de prof dependant du cours*/
	public void dependance(){
		if(this.nombreGroupe == 1){
			jtf2.setVisible(false);
			jtf2.setText(" ");
			jtf3.setVisible(false);
			jtf3.setText(" ");
			jtf4.setVisible(false);
			jtf4.setText(" ");
		}
		else if(this.nombreGroupe == 2){
			jtf3.setVisible(false);
			jtf3.setText(" ");
			jtf4.setVisible(false);
			jtf4.setText(" ");
		}
	}

	/**Gestion des evenements*/
	public void actionPerformed(ActionEvent event) {
		if(event.getActionCommand().equals("quitter")){
			principale.ouvertAffect = 0;
			this.dispose();
			
		}
		if(event.getActionCommand().equals("remplir")){
			switch (nombreGroupe){
			case 1:
				jtf2.setText(" ");
				jtf3.setText(" ");
				jtf4.setText(" ");
				break;
			case 2:
				jtf3.setText(" ");
				jtf4.setText(" ");
				jtf2.setText(jtf1.getText());
				break;

			case 4:
				jtf2.setText(jtf1.getText());
				jtf3.setText(jtf1.getText());
				jtf4.setText(jtf1.getText());
				break;
			}
		}
		
		if(event.getActionCommand().equals("vider")){
			jtf1.setText(" ");
			jtf2.setText(" ");
			jtf3.setText(" ");
			jtf4.setText(" ");
		}

		if(event.getActionCommand().equals("Valider")){
			if (jtf1.getText().equals("")||jtf2.getText().equals("")||jtf3.getText().equals("")||jtf4.getText().equals(""))
				JOptionPane.showMessageDialog(null, "Aucun professeur", "Erreur", JOptionPane.ERROR_MESSAGE);
			else{
				if(principale.cours.equals("CM")){
					for(int i = 0; i < principale.professeurs.length; i++)
						principale.professeurs[i] = jtf1.getText();
				}
				if(principale.cours.equals("EV2")){
					principale.professeurs[1] = jtf1.getText();
				}
				if(principale.cours.equals("TD")){
					principale.professeurs[2] = jtf1.getText();
					principale.professeurs[3] = jtf2.getText();
				}
				if(principale.cours.equals("TM")){
					principale.professeurs[4] = jtf1.getText();
					principale.professeurs[5] = jtf2.getText();
				}
				if(principale.cours.equals("TP2")){
					principale.professeurs[6] = jtf1.getText();
					principale.professeurs[7] = jtf2.getText();
					principale.professeurs[8] = jtf3.getText();
					principale.professeurs[9] = jtf4.getText();
				}
				if(principale.cours.equals("TP4")){
					principale.professeurs[10] = jtf1.getText();
					principale.professeurs[11] = jtf2.getText();
					principale.professeurs[12] = jtf3.getText();
					principale.professeurs[13] = jtf4.getText();
				}
				if(principale.cours.equals("TQ")){
					principale.professeurs[14] = jtf1.getText();
					principale.professeurs[15] = jtf2.getText();
					principale.professeurs[16] = jtf3.getText();
					principale.professeurs[17] = jtf4.getText();
				}
				principale.memoire.setText("Veuillez choisir un numero de semaine puis ajouter au module");
				principale.ouvertAffect = 0;
				this.dispose();
			}
		}
	}
}

