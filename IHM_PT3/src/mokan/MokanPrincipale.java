package mokan;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

public class MokanPrincipale extends JFrame implements ActionListener, KeyListener{
	private static final long serialVersionUID = 1L;

	//Gestion des autres fenetre
	public MokanModule frame3;
	public MokanAffect frame1; 
	public MokanModif frame2;
	public MokanApercu frame4;
	public MokanHelp frame5;
	public MokanLoad frame6;

	/**Panels*/
	public JPanel mainPanel, centerPanel, eastPanel, westPanel, northPanel, numeroPanel, southPanel, northWestPanel, northPanelCenter, southEastPanel, radioPanel;
	
	/**Boutons*/
	public JButton module, delete, save, affect1, modifier, add, calendrierDebut, calendrierFin, supprimer, top, bottom, load, help, b1, b2;
	
	/**Label*/
	public JLabel memoire;
	
	/**TextField*/
	public JTextField debut, fin, semaine;
	
	/**Calendrier*/
	public Calendrier cal;

	/**Boutons Radio*/
	public JRadioButton cm, td, tp2, tp4, tm, tq, ev2;
	
	/**Groupe de boutons*/
	public ButtonGroup groupeTypeCours;

	//Pour la liste
	DefaultListModel modeleDeListe = new DefaultListModel();
	JList liste = new JList(modeleDeListe);
	JScrollPane scroll;

	/**Booleens*/
	public int type, ouvertAffect, ouvertAdd, verificateur, ouvertAffectOnce, ouvertModule, ouvertAide = 0;

	/**Donnees*/
	public String cours = "CM";
	public String semestre = "";
	public String nomModule ="";
	public int[] dateDebut = new int[3];
	public int[] dateFin = new int[3] ;
	public String titreModule = "Choisir Module"; 
	public int nombreGroupe;
	public int numeroSemaine = 0;


	/**Affiche les professeur selectionnes*/
	public String[] professeurs = new String[19];

	/**Listes des professeurs*/
	
	String professeurCM = "";
	String professeurEV2 = "";
	String professeurTD = "";
	String professeurTM = "";
	String professeurTP2 = "";
	String professeurTP4 = "";
	String professeurTQ = "";
	
	public ArrayList<String> coursModule = new ArrayList<String>();
	public ArrayList<String> Intervenants = new ArrayList<String>();

	/**Liste des numeros de semaines des cours*/
	ArrayList<String> numerosSemaine = new ArrayList<String>();

	/**Objet pour la creation des fichiers*/
	public MokanIO data;

	/**Constructeur de la fenetre*/
	public MokanPrincipale(){
		this.setTitle("MOKAN");
		
		//professeur par défaut
		for(int i = 0; i < professeurs.length; i++)
			professeurs[i] = "default";

		//Preparation de l'apercu
		frame4 = new MokanApercu();
		frame4.principale = this;

		//Panel nord
		northPanel = new JPanel();
		northPanel.setLayout(new BorderLayout());

		northPanelCenter = new JPanel(new FlowLayout());

		//Bouton pour choisir son module
		module = new JButton("Choisir Module"); 
		module.setSize(new Dimension(204, 48));
		module.setActionCommand("module");
		module.addActionListener(this);

		//Bouton pour charger un module existant
		/*load = new JButton("Charger Module");
		load.setActionCommand("load");
		load.addActionListener(this);
		northPanelCenter.add(load);*/
		northPanelCenter.add(module);
		

		//Label pour afficher ce qu'il y a en memoire
		northWestPanel = new JPanel(new FlowLayout());
		memoire = new JLabel("");
		northWestPanel.add(memoire);

		northPanel.add(northWestPanel, BorderLayout.WEST);
		northPanel.add(northPanelCenter, BorderLayout.CENTER);
		memoire.setText("Veuillez creer ou choisir un module");
		
		//Panel Sud
		southPanel = new JPanel();
		southPanel.setLayout(new BorderLayout());//faire du GridBagLayout
		southEastPanel = new JPanel (new FlowLayout());
		delete = new JButton("Recommencer");
		save = new JButton("Sauvegarder");
		save.setEnabled(false);
		help = new JButton("Aide");

		delete.addActionListener(this);
		save.addActionListener(this);
		help.addActionListener(this);

		delete.setActionCommand("recommencer");
		save.setActionCommand("save");
		help.setActionCommand("help");

		southEastPanel.add(help);
		southEastPanel.add(delete);
		southEastPanel.add(save);

		//Panel Est
		eastPanel = new JPanel();
		eastPanel.setLayout(new GridBagLayout());

		JLabel labelDebut = new JLabel("Date de debut");
		JLabel labelFin = new JLabel("Date de fin");

		debut = new JTextField();
		debut.setColumns(8);

		fin = new JTextField();
		fin.setColumns(8);

		calendrierDebut = new JButton(new ImageIcon("./image/calendrier.jpg"));
		calendrierDebut.setActionCommand("validerDateDebut");
		calendrierDebut.setPreferredSize(new Dimension(50,50));
		calendrierDebut.addActionListener(this);

		calendrierFin = new JButton(new ImageIcon("./image/calendrier.png"));
		calendrierFin.setPreferredSize(new Dimension(50,50));
		calendrierFin.setActionCommand("validerDateFin");
		calendrierFin.addActionListener(this);

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		eastPanel.add(labelDebut, gbc);

		gbc.gridy = 1;
		eastPanel.add(debut, gbc);

		gbc.gridx = 1;
		eastPanel.add(calendrierDebut, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 2;
		eastPanel.add(labelFin, gbc);

		gbc.gridy = 3;
		eastPanel.add(fin, gbc);

		gbc.gridx = 1;
		gbc.gridy = 3;
		eastPanel.add(calendrierFin, gbc);

		//Ajout dans le EastPanel
		Border line = BorderFactory.createLineBorder(Color.GRAY, 2);
		TitledBorder panelBorder = BorderFactory.createTitledBorder(line, "Dates");
		eastPanel.setBorder(panelBorder);

		//Panel Centre
		centerPanel = new JPanel();
		centerPanel.setLayout(new GridBagLayout());
		cal = new Calendrier();
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		centerPanel.add(cal, gbc);
		line = BorderFactory.createLineBorder(Color.GRAY, 2);
		panelBorder = BorderFactory.createTitledBorder(line, "Calendrier");
		centerPanel.setBorder(panelBorder);

		//Panel West
		westPanel = new JPanel();
		westPanel.setLayout(new BorderLayout());

		radioPanel = new JPanel();
		radioPanel.setLayout(new GridLayout(7, 0));

		//Boutons Radios
		cm = new JRadioButton("CM");
		cm.setActionCommand("cm");

		td = new JRadioButton("TD");
		td.setActionCommand("td");

		tp2 = new JRadioButton("TP2");
		tp2.setActionCommand("tp2");

		tp4 = new JRadioButton("TP4");
		tp4.setActionCommand("tp4");

		tq = new JRadioButton("TQ");
		tq.setActionCommand("tq");

		tm = new JRadioButton("TM");
		tm.setActionCommand("tm");

		ev2 = new JRadioButton("EV2");
		ev2.setActionCommand("ev2");

		//Listeners
		cm.addActionListener(this);
		td.addActionListener(this);
		tp2.addActionListener(this);
		tp4.addActionListener(this);
		tq.addActionListener(this);
		tm.addActionListener(this);
		ev2.addActionListener(this);

		//Groupe de boutons
		groupeTypeCours = new ButtonGroup();
		groupeTypeCours.add(cm);
		groupeTypeCours.add(td);
		groupeTypeCours.add(tp2);
		groupeTypeCours.add(tp4);
		groupeTypeCours.add(tq);
		groupeTypeCours.add(tm);
		groupeTypeCours.add(ev2);

		//Ajout des radios dans le panel
		radioPanel.add(cm);
		radioPanel.add(td);
		radioPanel.add(tp2);
		radioPanel.add(tp4);
		radioPanel.add(tq);
		radioPanel.add(tm);
		radioPanel.add(ev2);

		/**Boutons*/
		add = new JButton("Ajouter");
		add.setActionCommand("add");
		add.addActionListener(this);

		affect1 = new JButton("Affecter");
		affect1.setActionCommand("affect");
		affect1.addActionListener(this);

		supprimer = new JButton(new ImageIcon("./image/poubelle.png"));
		supprimer.setActionCommand("supprimer");
		supprimer.addActionListener(this);

		JButton top = new JButton(new ImageIcon("./image/flecheHaut.png"));
		top.setActionCommand("haut");
		top.addActionListener(this);

		JButton bottom = new JButton(new ImageIcon("./image/flecheBas.png"));
		bottom.setActionCommand("bas");
		bottom.addActionListener(this);

		modifier = new JButton("Modifier");
		modifier.setActionCommand("modifier");
		modifier.addActionListener(this);
		
		//Ajout dans le panelCompteur
		b1 = new JButton(new ImageIcon("./image/plus.png"));
		b2 = new JButton(new ImageIcon("./image/moins.png"));
		b1.setActionCommand("plus");
		b2.setActionCommand("moins");
		b1.addActionListener(this);
		b2.addActionListener(this);
		b1.setPreferredSize(new Dimension(30,30));
		b2.setPreferredSize(new Dimension(30,30));
		numeroPanel = new JPanel();
		numeroPanel.setLayout(new GridBagLayout());
		semaine = new JTextField("1");
		semaine.setColumns(2);
		
		JLabel label = new JLabel("Semaine");
		gbc.gridy = 0;
		gbc.gridx = 0;
		gbc.gridheight = 1;
		numeroPanel.add(label, gbc);

		gbc.gridy = 1;
		numeroPanel.add(b1, gbc);
		
		gbc.gridy = 2;
		numeroPanel.add(semaine, gbc);
		
		gbc.gridy = 3;
		numeroPanel.add(b2, gbc);

		//Panel de cours
		JPanel coursPanel = new JPanel();
		coursPanel.setLayout(new GridBagLayout());
		line = BorderFactory.createLineBorder(Color.GRAY, 2);
		
		panelBorder = BorderFactory.createTitledBorder(line, "Cours");
		coursPanel.setBorder(panelBorder);

		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridheight = GridBagConstraints.REMAINDER;
		coursPanel.add(radioPanel, gbc);
		
		gbc.gridx = 1;
		gbc.gridheight = 1;
		gbc.anchor = GridBagConstraints.CENTER;
		coursPanel.add(numeroPanel, gbc);
		
		JPanel p1 = new JPanel(new GridLayout(2,0));
		p1.add(affect1);
		p1.add(add);
		
		gbc.gridx = 2;
		gbc.gridheight = 1;
		coursPanel.add(p1, gbc);
		
		//Panel de validation
		southPanel = new JPanel(new BorderLayout());	

		//Ajout dans le main Panel
		mainPanel = new JPanel(new BorderLayout());
		mainPanel.add(northPanel, BorderLayout.NORTH);
		mainPanel.add(centerPanel, BorderLayout.CENTER);
		mainPanel.add(southPanel, BorderLayout.SOUTH);

		//Panel de previsualisation
		JPanel previsuPanel = new JPanel(new GridBagLayout());
		line = BorderFactory.createLineBorder(Color.GRAY, 2);
		panelBorder = BorderFactory.createTitledBorder(line, "Affichage");
		previsuPanel.setBorder(panelBorder);
		line = BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2);

		//Ajout du scrolling
		liste.setBorder(line);
		scroll = new JScrollPane(liste, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.setPreferredSize(new Dimension(150, 130));
		scroll.setMinimumSize(new Dimension(150, 130));
		scroll.setMaximumSize(new Dimension(150, 130));

		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridheight = GridBagConstraints.REMAINDER;
		gbc.gridwidth = 1;
		previsuPanel.add(scroll, gbc);

		gbc.gridx = 1;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.gridheight = 1;
		previsuPanel.add(top, gbc);

		gbc.gridy = 1;
		previsuPanel.add(bottom, gbc);

		gbc.gridy = 2;
		previsuPanel.add(supprimer, gbc);

		gbc.gridy = 3;
		previsuPanel.add(modifier, gbc);

		//Ajout dans le westPanel
		radioPanel.setPreferredSize(new Dimension(170,120));
		previsuPanel.setPreferredSize(new Dimension(190,120));
		coursPanel.setPreferredSize(new Dimension(170,200));
		westPanel.add(coursPanel, BorderLayout.NORTH);		
		westPanel.add(previsuPanel, BorderLayout.CENTER);
		westPanel.setPreferredSize(new Dimension(300,300));

		//Ajout dans le southPanel
		southPanel.add(southEastPanel, BorderLayout.EAST);

		//Ajout dans le mainPanel
		mainPanel = new JPanel(new BorderLayout());
		mainPanel.add(westPanel, BorderLayout.WEST);
		mainPanel.add(eastPanel, BorderLayout.EAST);
		mainPanel.add(northPanel, BorderLayout.NORTH);
		mainPanel.add(southPanel, BorderLayout.SOUTH);
		mainPanel.add(centerPanel, BorderLayout.CENTER);
		
		this.addKeyListener(this);
		this.setFocusable(true);
		this.setContentPane(mainPanel);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(new Dimension(1020,500));
		this.setVisible(true);
		this.setLocation(10, 150);
	}

	/**Gestion des evenements*/
	public void actionPerformed(ActionEvent event) {
		if(event.getActionCommand().equals("module")){
			if(ouvertModule == 0){
				frame3 = new MokanModule();
				ouvertModule = 1;
				frame3.setVisible(true);
				frame3.principale = this;
				memoire.setText("");
				this.requestFocus();
			}
			else
				JOptionPane.showMessageDialog(null, "Deja ouvert", "Erreur", JOptionPane.ERROR_MESSAGE);
		}

		//Action qui permet de charger un module existant
		if(event.getActionCommand().equals("load")){
			frame6 = new MokanLoad();
			frame6.principale = this;
			this.requestFocus();
		}

		if(event.getActionCommand().equals("cm")){
			this.cours = "CM";
			this.nombreGroupe = 1;
			type = 1;
			verificateur = 1;
			memoire.setText("Veuillez affecter un professeur");
			this.requestFocus();
		}

		if(event.getActionCommand().equals("td")){
			this.cours = "TD";
			this.nombreGroupe = 2;
			type = 2;
			verificateur = 1;
			memoire.setText("Veuillez affecter un professeur");
			this.requestFocus();
		}

		if(event.getActionCommand().equals("tp2")){
			this.cours = "TP2";
			this.nombreGroupe = 4;
			type = 3;
			verificateur = 1;
			memoire.setText("Veuillez affecter un professeur");
			this.requestFocus();
		}

		if(event.getActionCommand().equals("tp4")){
			this.cours = "TP4";
			this.nombreGroupe = 4;
			type = 4;
			verificateur = 1;
			memoire.setText("Veuillez affecter un professeur");
			this.requestFocus();
		}

		if(event.getActionCommand().equals("tq")){
			this.cours = "TQ";
			this.nombreGroupe = 4;
			type = 5;
			verificateur = 1;
			memoire.setText("Veuillez affecter un professeur");
			this.requestFocus();
		}

		if(event.getActionCommand().equals("tm")){
			this.cours = "TM";
			this.nombreGroupe = 2;
			type = 6;
			verificateur = 1;
			memoire.setText("Veuillez affecter un professeur");
			this.requestFocus();
		}
		

		if(event.getActionCommand().equals("ev2")){
			this.cours = "EV2";
			this.nombreGroupe = 1;
			type = 7;
			verificateur = 1;
			memoire.setText("Veuillez affecter un professeur");
			this.requestFocus();
		}
		
		if(event.getActionCommand().equals("plus")){
			String d = semaine.getText();
			int c = Integer.parseInt(d);
			c++;
			semaine.setText(""+c);
			this.requestFocus();
		}
		
		if(event.getActionCommand().equals("moins")){
			String d = semaine.getText();
			int c = Integer.parseInt(d);
			if(c == 1)
				c = 1;
			else
				c--;
			semaine.setText(""+c);
			this.requestFocus();
		}
	
		if(event.getActionCommand().equals("add")){
			if (ouvertAffectOnce == 1 ){
				String numSemaine = semaine.getText();
				int c = Integer.parseInt(numSemaine); 
				numeroSemaine = c;
				
				//Ajout du numero de la semaine dans la liste des semaines
				numerosSemaine.add(numSemaine);
				
				switch(type){
				//CM
				case 1:
					professeurCM = professeurs[0];
					frame4.professeurCm.setText("Professeurs CM : " + professeurs[0]);
					modeleDeListe.addElement(cours +" "+ professeurs[0] + " " + numeroSemaine);
					coursModule.add(this.cours);
					break;
				//TD
				case 2:
					professeurTD = professeurs[2] + " " + professeurs[3];
					frame4.professeurTd.setText("Professeurs TD : " + professeurs[2] + " " + professeurs[3]);
					modeleDeListe.addElement(cours+" "+ professeurs[2] +" "+ professeurs[3] +" "
							+ numeroSemaine);
					coursModule.add(this.cours);
					break;
				//TP2
				case 3:
					professeurTP2 = professeurs[6] + " " + professeurs[7]+ " " + professeurs[8]+ " " + professeurs[9];
					frame4.professeurTp2.setText("Professeurs TP2 : " + professeurs[6] +
							" " + professeurs[7] + " " + professeurs[8] + " " + professeurs[9]);
					modeleDeListe.addElement(cours+ " "+ professeurs[6] +" "+ professeurs[7] +" "
							+ professeurs[8] +" "+ professeurs[9] + " " + numeroSemaine);
					coursModule.add(this.cours);
					break;
				//TP4
				case 4:
					professeurTP4 = professeurs[10] + " " + professeurs[11] + " " + professeurs[12] + " " + professeurs[13];
					frame4.professeurTp4.setText("Professeurs TP4 : " + professeurs[10] +
							" " + professeurs[11] + " " + professeurs[12] + " " + professeurs[13]);
					modeleDeListe.addElement(cours+ " "+ professeurs[10] +" "+ professeurs[11] +" "
							+ professeurs[12] +" "+ professeurs[13] + " " + numeroSemaine);
					coursModule.add(this.cours);
					break;
				//TQ
				case 5:
					professeurTQ = professeurs[14] + " " + professeurs[15] + " " +professeurs[16] + " " + professeurs[17];
					frame4.professeurTq.setText("Professeurs TQ : " + professeurs[14] +
							" " + professeurs[15] + " " + professeurs[16] + " " + professeurs[17]);
					modeleDeListe.addElement(cours+ " "+ professeurs[14] +" "+ professeurs[15] +" "
							+ professeurs[16] +" "+ professeurs[17] + " " + numeroSemaine);
					coursModule.add(this.cours);
					break;
				//TM
				case 6:
					professeurTM = professeurs[4] + " " + professeurs[5];
					frame4.professeurTm.setText("Professeurs TM : " + professeurs[4] + " " + professeurs[5]);
					modeleDeListe.addElement(cours+" "+ professeurs[4] +" "+ professeurs[5] +" "
							+ numeroSemaine);
					coursModule.add(this.cours);
					break;
				//EV2
				case 7:
					professeurEV2 = professeurs[1];
					frame4.professeurEv2.setText("Professeurs EV2 : " + professeurs[1]);
					modeleDeListe.addElement(cours +" "+ professeurs[1] + " " + numeroSemaine);
					coursModule.add(this.cours);
					break;
				}
				//coursModule.add(this.nomCours);
				ouvertAdd = 0;
				memoire.setText("Ajout d'un cours reussi");
				this.requestFocus();
			}
			else {
				memoire.setText("Veuillez affecter un professeur");
			}
		}

		if(event.getActionCommand().equals("affect")){
			ouvertAffectOnce = 1;
			if(verificateur == 1){
				if(ouvertAffect == 0){
					ouvertAffect = 1;
					memoire.setText("Affectation d'un professeur");
					frame1 = new MokanAffect();
					frame1.principale = this;
					frame1.nombreGroupe = nombreGroupe;
					frame1.dependance();
					frame1.nomCours = cours;
					frame1.titre.setText("<html><u>"+ frame1.nomCours +"</u></html>");
					try{
						frame1.setUndecorated(true);
					}
					catch(IllegalComponentStateException e){}
					ouvertAdd = 1;
				}
				else
					JOptionPane.showMessageDialog(null, "Deja ouvert", "Erreur", JOptionPane.ERROR_MESSAGE);	
			}
			else
				JOptionPane.showMessageDialog(null, "Aucun cours selectionne", "Erreur", JOptionPane.ERROR_MESSAGE);
			this.requestFocus();
		}
		
		if(event.getActionCommand().equals("modifier")){
			if(!liste.isSelectionEmpty()){
				memoire.setText("Modification d'un cours");
				frame2 = new MokanModif();
				frame2.principale = this;

				//Recupere les valeurs
				String str = (String) liste.getSelectedValue();
				frame2.table = str.split(" ");

				//Copie du tableau et affichage
				frame2.copy(frame2.table);
				frame2.typeCours = frame2.table[0];
				frame2.dependance();
				frame2.repaint();
				frame2.titre.setText("<html><u>"+ frame2.typeCours +"</u></html>");
			}
			else
				JOptionPane.showMessageDialog(null, "Aucun cours selectionner dans l'affichage", "Erreur", JOptionPane.ERROR_MESSAGE);
			this.requestFocus();
		}

		if(event.getActionCommand().equals("haut")){
			int a = liste.getSelectedIndex();
			int b = a;
			if( a >= 0){
				String tmp = modeleDeListe.getElementAt(--a).toString();
				String selection = modeleDeListe.getElementAt(b).toString();
				modeleDeListe.setElementAt(selection, a);
				modeleDeListe.setElementAt(tmp, b);
				liste.setSelectedIndex(a);
			}	
			else if (a < 0) 
				memoire.setText("Impossible de monter l'element");
			this.requestFocus();
		}

		if(event.getActionCommand().equals("bas")){
			int a = liste.getSelectedIndex();
			int b = a;

			if( a < modeleDeListe.size()-1){
				String tmp = modeleDeListe.getElementAt(++a).toString();
				String selection = modeleDeListe.getElementAt(b).toString();
				modeleDeListe.setElementAt(selection, a);
				modeleDeListe.setElementAt(tmp, b);
				liste.setSelectedIndex(a);
			}
			else 
				memoire.setText("Impossible de descendre l'element");
			this.requestFocus();
		}

		if(event.getActionCommand().equals("supprimer")){
			if(!liste.isSelectionEmpty()){
				int a = liste.getSelectedIndex();
				modeleDeListe.remove(a);
				liste.setSelectedIndex(a);
				numerosSemaine.remove(a);
				coursModule.remove(a);
			}
			else
				memoire.setText("Aucun element selectionne");
			this.requestFocus();
		}

		/**Gestion du calendrier*/
		if(event.getActionCommand().equals("validerDateDebut")){
			/**Jour*/
			dateDebut[0] = cal.getDay();

			/**Mois*/
			dateDebut[1] = cal.getMonth();
			dateDebut[1]++;

			/**Annee*/
			dateDebut[2] = cal.getYear();
			debut.setText(cal.getDate(dateDebut[0], dateDebut[1], dateDebut[2]));
			frame4.semaineDebut();
			this.requestFocus();
		}

		if(event.getActionCommand().equals("validerDateFin")){
			dateFin[0] = cal.getDay();
			dateFin[1] = cal.getMonth();
			dateFin[1]++;	
			dateFin[2] = cal.getYear();
			fin.setText(cal.getDate(dateFin[0], dateFin[1], dateFin[2]));
			frame4.semaineFin();
			this.requestFocus();
		}

		/**Reinitialise tout*/
		if(event.getActionCommand().equals("recommencer")){
			int option = JOptionPane.showConfirmDialog(null, "Voulez-vous recommencer ?", "Confirmation de la suppression", 
					JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			if(option == JOptionPane.OK_OPTION){
				type = 0;
				ouvertAdd=0;
				ouvertAffect=0;
				ouvertModule = 0;
				
				module.setEnabled(true);
				debut.setText("");
				fin.setText("");
				modeleDeListe.clear();
				semaine.setText("1");

				this.module.setText("Choisir Module");
				coursModule = new ArrayList<String>();
				professeurCM = "";
				professeurTD = "";
				professeurTP2 = "";
				professeurTP4 = "";
				professeurTQ = "";
				professeurTM =  "";
				professeurEV2 = "";
				Intervenants= new ArrayList<String>();
				numerosSemaine = new ArrayList<String>();

				frame4.nomModule.setText("Module");
				frame4.semestre.setText("Semestre : ");
				frame4.professeurCm.setText("Professeurs CM : ");
				frame4.professeurTd.setText("Professeurs TD : ");
				frame4.professeurTp2.setText("Professeurs TP2 : ");
				frame4.professeurTp4.setText("Professeurs TP4 : ");
				frame4.intervenants.setText("Professeurs TQ : ");
				frame4.professeurTm.setText("Professeurs TM : ");
				frame4.professeurEv2.setText("Professeurs EV2 : ");
				frame4.semaineDebut.setText("Semaine de debut : ");
				frame4.semaineFin.setText("Semaine de fin : ");
				frame4.debutModule = 0;
				frame4.finModule = 0;
			}
			this.requestFocus();
		}
		
		if(event.getActionCommand().equals("help")){
			frame5 = new MokanHelp();
			this.requestFocus();
		}
		
		if(event.getActionCommand().equals("save")){
			data=new MokanIO();
			data.principale = this;
			data.mod = frame3.getModule();
			data.debut = Integer.toString(frame4.debutModule);
			data.fin = Integer.toString(frame4.finModule);
			data.sauvegarde();	
			this.requestFocus();
		}	
	}
		
	public void keyPressed(KeyEvent e) {
			if(e.getKeyCode()==KeyEvent.VK_UP){
				String d = semaine.getText();
				int c = Integer.parseInt(d);
				c++;
				semaine.setText(""+c);
			}
			if(e.getKeyCode()==KeyEvent.VK_DOWN){
				String d = semaine.getText();
				int c = Integer.parseInt(d);
				if(c == 1)
					c = 1;
				else
					c--;
				semaine.setText(""+c);
			}
			if(e.getKeyCode()==KeyEvent.VK_Q){
				System.exit(0);
			}
			if(e.getKeyCode()==KeyEvent.VK_A){
				frame5 = new MokanHelp();
				
			}
			if(e.getKeyCode()==KeyEvent.VK_SPACE){
				ouvertAffectOnce = 1;
				if(verificateur == 1){
					if(ouvertAffect == 0){
						ouvertAffect = 1;
						memoire.setText("Affectation d'un professeur");
						frame1 = new MokanAffect();
						frame1.principale = this;
						frame1.nombreGroupe = nombreGroupe;
						frame1.dependance();
						frame1.nomCours = cours;
						frame1.titre.setText("<html><u>"+ frame1.nomCours +"</u></html>");
						try{
							frame1.setUndecorated(true);
						} catch(IllegalComponentStateException f){}
						ouvertAdd = 1;
					}
					else
						JOptionPane.showMessageDialog(null, "Deja ouvert", "Erreur", JOptionPane.ERROR_MESSAGE);	
				}
				else
					JOptionPane.showMessageDialog(null, "Aucun cours selectionne", "Erreur", JOptionPane.ERROR_MESSAGE);
				this.requestFocus();
	}
			if(e.getKeyCode()==KeyEvent.VK_ENTER){
				String numSemaine = semaine.getText();
				int c = Integer.parseInt(numSemaine); 
				numeroSemaine = c;
				numerosSemaine.add(numSemaine);
				
				//Affichage dans la previsualisation
				switch(type){
				//CM
				case 1:
					professeurTD = professeurs[0];
					frame4.professeurCm.setText("Professeurs CM : " + professeurs[0]);
					modeleDeListe.addElement(cours +" "+ professeurs[0] + " " + numeroSemaine);
					coursModule.add(this.cours);
					break;
				//TD
				case 2:
					professeurTD = professeurs[2] + " " + professeurs[3];
					frame4.professeurTd.setText("Professeurs TD : " + professeurs[2] + " " + professeurs[3]);
					modeleDeListe.addElement(cours+" "+ professeurs[2] +" "+ professeurs[3] +" "
							+ numeroSemaine);
					coursModule.add(this.cours);
					break;
				//TP2
				case 3:
					professeurTP2 = professeurs[6] + " " + professeurs[7]+ " " + professeurs[8]+ " " + professeurs[9];
					frame4.professeurTp2.setText("Professeurs TP2 : " + professeurs[6] +
							" " + professeurs[7] + " " + professeurs[8] + " " + professeurs[9]);
					modeleDeListe.addElement(cours+ " "+ professeurs[6] +" "+ professeurs[7] +" "
							+ professeurs[8] +" "+ professeurs[9] + " " + numeroSemaine);
					coursModule.add(this.cours);
					break;
				//TP4
				case 4:
					frame4.professeurTp4.setText("Professeurs TP4 : " + professeurs[10] +" " + professeurs[11] + " " + professeurs[12] + " " + professeurs[13]);
					modeleDeListe.addElement(cours+ " "+ professeurs[10] +" "+ professeurs[11] +" "
							+ professeurs[12] +" "+ professeurs[13] + " " + numeroSemaine);
					coursModule.add(this.cours);
					break;
				//TQ
				case 5:
					professeurTP4 = professeurs[10] + " " + professeurs[11] + " " + professeurs[12] + " " + professeurs[13];
					frame4.professeurTq.setText("Professeurs TQ : " + professeurs[14] +
							" " + professeurs[15] + " " + professeurs[16] + " " + professeurs[17]);
					modeleDeListe.addElement(cours+ " "+ professeurs[14] +" "+ professeurs[15] +" "
							+ professeurs[16] +" "+ professeurs[17] + " " + numeroSemaine);
					coursModule.add(this.cours);
					break;
				//TM
				case 6:
					professeurTM = professeurs[4] + " " + professeurs[5];
					frame4.professeurTm.setText("Professeurs TM : " + professeurs[4] + " " + professeurs[5]);
					modeleDeListe.addElement(cours+" "+ professeurs[4] +" "+ professeurs[5] +" "
							+ numeroSemaine);
					coursModule.add(this.cours);
					break;
				//EV2
				case 7:
					professeurEV2 = professeurs[1];
					frame4.professeurEv2.setText("Professeurs EV2 : " + professeurs[1]);
					modeleDeListe.addElement(cours +" "+ professeurs[1] + " " + numeroSemaine);
					coursModule.add(this.cours);
					break;
				}
			}
		}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}