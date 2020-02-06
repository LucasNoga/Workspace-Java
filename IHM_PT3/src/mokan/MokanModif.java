package mokan;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class MokanModif extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	
	//une fenetre
	MokanPrincipale principale;
	public JButton validate, vider, remplir, b1, b2;
	public JPanel mainPanel, centerPanel, northPanel, southPanel, eastPanel, nombrePanel;
	public JTextField jtf1, jtf2, jtf3, jtf4;
	public JLabel titre, numeroSemaine;
	public String typeCours;
	
	//recupere l'element de la liste
	public String[] table = new String[10]; 

	public MokanModif(){
		this.setTitle("Affecter un cours");
		
		//NorthPanel
		northPanel = new JPanel(new FlowLayout());
		titre = new JLabel("");
		northPanel.add(titre);

		//SouthPanel
		southPanel = new JPanel(new BorderLayout());
		validate = new JButton("modifier");
		validate.addActionListener(this);
		validate.setActionCommand("Valider");
		southPanel.add(validate, BorderLayout.EAST);		
		
		centerPanel = new JPanel(new GridBagLayout());
		jtf1 = new JTextField();
		jtf1.setColumns(10);
		jtf2 = new JTextField();
		jtf2.setColumns(10);
		jtf3 = new JTextField();
		jtf3.setColumns(10);
		jtf4 = new JTextField();
		jtf4.setColumns(10);
		
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		centerPanel.add(jtf1, gbc);
		
		gbc.gridx = 1;
		centerPanel.add(jtf2, gbc);
		
		gbc.gridx = 2;
		centerPanel.add(jtf3, gbc);
		
		gbc.gridx = 3;
		centerPanel.add(jtf4, gbc);
		
		//ajout dans le panelCompteur
		numeroSemaine = new JLabel("1");
		
		b1 = new JButton(new ImageIcon("./image/plus.png"));
		b1.setActionCommand("plus");
		b1.addActionListener(this);
		b1.setPreferredSize(new Dimension(30,30));
		
		b2 = new JButton(new ImageIcon("./image/moins.png"));
		b2.setActionCommand("moins");
		b2.addActionListener(this);
		b2.setPreferredSize(new Dimension(30,30));
		
		nombrePanel = new JPanel(new FlowLayout());
		JLabel label = new JLabel("Numéro de semaine");
		nombrePanel.add(b2);
		nombrePanel.add(numeroSemaine);
		nombrePanel.add(b1);
		
		gbc.gridx = 1;
		gbc.gridy = 1;
		centerPanel.add(label, gbc);
		
		gbc.gridx = 2;
		centerPanel.add(nombrePanel, gbc);
		
		//EastPanel
		remplir = new JButton("Remplir");
		remplir.addActionListener(this);
		remplir.setActionCommand("remplir");
		
		vider = new JButton("Vider");
		vider.addActionListener(this);
		vider.setActionCommand("vider");
		
		eastPanel = new JPanel();
		eastPanel.setLayout(new GridLayout(2,1));
		eastPanel.add(remplir);
		eastPanel.add(vider);
	
		//mainPanel
		mainPanel = new JPanel(new BorderLayout());
		mainPanel.add(northPanel, BorderLayout.NORTH);
		mainPanel.add(southPanel, BorderLayout.SOUTH);
		mainPanel.add(centerPanel, BorderLayout.CENTER);
		mainPanel.add(eastPanel, BorderLayout.EAST);
		
		this.setContentPane(mainPanel);
		this.setVisible(true);
		this.setFocusableWindowState(true);
		this.setLocationRelativeTo(null);
		this.setSize(700, 150);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	
	public void dependance(){
		if(typeCours.equals("CM")|| this.typeCours.equals("EV2")){
			jtf2.setVisible(false);
			jtf3.setVisible(false);
			jtf4.setVisible(false);
			jtf1.setText(table[1]);
		}
		else if(typeCours.equals("TD") || this.typeCours.equals("TM")){
			jtf3.setVisible(false);
			jtf4.setVisible(false);
			jtf1.setText(table[1]);
			jtf2.setText(table[2]);
		}
		else if(typeCours.equals("TP2") || this.typeCours.equals("TP4") || this.typeCours.equals("TQ")){
			jtf1.setText(table[1]);
			jtf2.setText(table[2]);
			jtf3.setText(table[3]);
			jtf4.setText(table[4]);
		}
	}
	
	//pour copier le tableau
	public void copy(String[] array){
		if(principale.cours.equals("CM") || principale.cours.equals("EV2")){
			jtf1.setText(array[1]);
			numeroSemaine.setText(array[2]);
		}
		if(principale.cours.equals("TD") || principale.cours.equals("TM")){
			jtf1.setText(array[1]);
			jtf2.setText(array[2]);
			numeroSemaine.setText(array[3]);
			
		}
		if(principale.cours.equals("TP2") || principale.cours.equals("TP4")  || principale.cours.equals("TQ")){
			jtf1.setText(array[1]);
			jtf2.setText(array[2]);
			jtf3.setText(array[3]);
			jtf4.setText(array[4]);
			numeroSemaine.setText(array[5]);
		}
		
	}

	//Gestion des evenements
	public void actionPerformed(ActionEvent event) {
		if(event.getActionCommand().equals("plus")){
			String d = numeroSemaine.getText();
			int c = Integer.parseInt(d);
			c++;
			numeroSemaine.setText(""+c);
		}
		
		if(event.getActionCommand().equals("moins")){
			String d = numeroSemaine.getText();
			int c = Integer.parseInt(d);
			if(c == 1)
				c = 1;
			else
				c--;
			numeroSemaine.setText(""+c);
		}
		if(event.getActionCommand().equals("remplir")){
			if(table[0].equals("CM")){
				jtf2.setText("");
				jtf3.setText("");
				jtf4.setText("");
			}
			else if(table[0].equals("TD") || table[0].equals("TQ")){
				jtf3.setText("");
				jtf4.setText("");
				jtf2.setText(jtf1.getText());
			}
			else if(table[0].equals("TP") || table[0].equals("TM")){
				jtf2.setText(jtf1.getText());
				jtf3.setText(jtf1.getText());
				jtf4.setText(jtf1.getText());
			}
		}
		
		if(event.getActionCommand().equals("vider")){
			jtf1.setText("");
			jtf2.setText("");
			jtf3.setText("");
			jtf4.setText("");
		}
		
		if(event.getActionCommand().equals("Valider")){
			if(table[0].equals("CM")){
				String selection = typeCours + " " + principale.professeurs[0] + " " + numeroSemaine.getText();
				principale.modeleDeListe.setElementAt(selection, principale.liste.getSelectedIndex());
				
			}
			else if(table[0].equals("TD") || table[0].equals("TM")){
				String selection = typeCours +" "+ principale.professeurs[0] +" "+ principale.professeurs[1] +
						" " + numeroSemaine.getText();
				principale.modeleDeListe.setElementAt(selection, principale.liste.getSelectedIndex());
				
			}
			else if(table[0].equals("TP2") || table[0].equals("TP4") || table[0].equals("TQ")){
				String selection = typeCours +" "+ principale.professeurs[0] +" "+ principale.professeurs[1] +
						" " +principale.professeurs[2]+" " + principale.professeurs[3] 
						+ " "+ numeroSemaine.getText();
				principale.modeleDeListe.setElementAt(selection, principale.liste.getSelectedIndex());
			
			}
			
			//placer les changements dans l'intervenants
			//donc il faut les ajoutre dans l'arraylist intrevenants puis regarder dans les fichiers comment ils sont afficher
			//donc tester les chaines te la table modifier avec la table initiale et les differences on les stocke dans l'arraylist intervenante
			this.dispose();
		}
	}
}