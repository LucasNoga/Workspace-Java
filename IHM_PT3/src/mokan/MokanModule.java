package mokan;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

public class MokanModule extends JFrame implements ActionListener, KeyListener{
	private static final long serialVersionUID = 1L;

	MokanPrincipale principale;
	
	/**Fenetre*/
	public JRadioButton asr, acd, apl, bd, wim, ego, m, ec, ang;
	public JButton validation, b1, b2, b3, b4 ;
	public JPanel mainPanel, modules, validationPanel, numeros, modulePanel, semestrePanel;
	public ButtonGroup groupe;
	public JLabel numeroModule, numeroSemestre;
	public JComboBox semestre;
	public String[] sem ={"S1", "S2", "S3", "IN", "WM"}; 
	
	/**Condition*/
	public int test = 0;
	
	/**Donnees*/ 
	public String matiere = "";
	public String numero = "";
	public String module = "";
	
	/**Constructeur de la fenetre*/
	public MokanModule(){
		this.setTitle("Choix du module");
		
		//Ajout des differents semestres
		semestre = new JComboBox(sem);
		
		//JRadioButton
		asr = new JRadioButton("ASR");
		acd = new JRadioButton("ACD");
		apl = new JRadioButton("APL");
		bd = new JRadioButton("BD");
		wim = new JRadioButton("WIM");
		ego = new JRadioButton("EGO");
		m = new JRadioButton("M");
		ec = new JRadioButton("EC");
		ang = new JRadioButton("ANG");
		
		//Definition des commandes
		asr.setActionCommand("asr");
		acd.setActionCommand("acd");
		apl.setActionCommand("apl");
		bd.setActionCommand("bd");
		wim.setActionCommand("wim");
		ego.setActionCommand("ego");
		m.setActionCommand("m");
		ec.setActionCommand("ec");
		ang.setActionCommand("ang");
		
		//Listeners
		ang.addActionListener(this);
		asr.addActionListener(this);
		acd.addActionListener(this);
		apl.addActionListener(this);
		bd.addActionListener(this);
		wim.addActionListener(this);
		ego.addActionListener(this);
		m.addActionListener(this);
		ec.addActionListener(this);
		
		
		//Groupe RadioButtons
		groupe = new ButtonGroup();
		groupe.add(ang);
		groupe.add(asr);
		groupe.add(acd);
		groupe.add(apl);
		groupe.add(bd);
		groupe.add(wim);
		groupe.add(ego);
		groupe.add(m);
		groupe.add(ec);
		
		
		modules = new JPanel();
		modules.setLayout(new GridLayout(12, 1));
		modules.add(acd);
		modules.add(ang);
		modules.add(apl);
		modules.add(asr);
		modules.add(bd);
		modules.add(ec);
		modules.add(ego);
		modules.add(m);
		modules.add(wim);
		
		
	
		//Numero du module
		numeros = new JPanel(new GridLayout(2,1));
		
		modulePanel = new JPanel(new FlowLayout());
		numeroModule = new JLabel("1");
		numeroModule.setPreferredSize(new Dimension(30,30));
		
		b2 = new JButton(new ImageIcon("./image/plus.png"));
		b1 = new JButton(new ImageIcon("./image/moins.png"));
		b2.setActionCommand("plus");
		b1.setActionCommand("moins");
		b2.addActionListener(this);
		b1.addActionListener(this);
		b2.setPreferredSize(new Dimension(30,30));
		b1.setPreferredSize(new Dimension(30,30));
		
		JLabel mod = new JLabel("Numero du module :  ");
		
		modulePanel.add(mod);
		modulePanel.add(b1);
		modulePanel.add(numeroModule);
		modulePanel.add(b2);
		
		//Numero du semestre
		semestrePanel = new JPanel(new FlowLayout());
		numeroSemestre = new JLabel("1");
		numeroSemestre.setPreferredSize(new Dimension(30,30));
		
		b4 = new JButton(new ImageIcon("./image/plus.png"));
		b3 = new JButton(new ImageIcon("./image/moins.png"));
		b4.setActionCommand("plusSemestre");
		b3.setActionCommand("moinsSemestre");
		b4.addActionListener(this);
		b3.addActionListener(this);
		b4.setPreferredSize(new Dimension(30,30));
		b3.setPreferredSize(new Dimension(30,30));
		
		JLabel sem = new JLabel("Semestre :  ");
		
		semestrePanel.add(sem);
		semestrePanel.add(semestre);
		
		numeros.add(modulePanel);
		numeros.add(semestrePanel);
		
		//Bouton validation
		validationPanel = new JPanel(new FlowLayout());
		validation = new JButton("Valider");
		validation.setPreferredSize(new Dimension(75, 40));
		validation.setActionCommand("validerModule");
		validation.addActionListener(this);
		validationPanel.add(validation);
		
		//Ajout dans le panel principale
		mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());
		mainPanel.add(modules, BorderLayout.WEST);
		mainPanel.add(numeros, BorderLayout.CENTER);
		mainPanel.add(validationPanel, BorderLayout.SOUTH);
		
		//Ajouter a la frame
		this.setFocusable(true);
		this.addKeyListener(this);
		this.setContentPane(mainPanel);
		this.pack();
		this.setSize(400, 400);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	
	public String getModule(){
		return module;
	}
	
	public void actionPerformed(ActionEvent event) {
		
		if(event.getActionCommand().equals("plus")){
			String d = numeroModule.getText();
			int c = Integer.parseInt(d);
			c++;
			numeroModule.setText(""+c);
			this.requestFocus();
		}
		if(event.getActionCommand().equals("moins")){
			String d = numeroModule.getText();
			int c = Integer.parseInt(d);
			if(c == 1)
				c = 1;
			else
				c--;
			numeroModule.setText(""+c);
			this.requestFocus();
		}
		if(event.getActionCommand().equals("plusSemestre")){
			String d = numeroSemestre.getText();
			int c = Integer.parseInt(d);
			if(c == 4)
				c = 4;
			else
				c++;
			numeroSemestre.setText(""+c);
			this.requestFocus();
		}
		if(event.getActionCommand().equals("moinsSemestre")){
			String d = numeroSemestre.getText();
			int c = Integer.parseInt(d);
			if(c == 1)
				c = 1;
			else
				c--;
			numeroSemestre.setText(""+c);
			this.requestFocus();
		}
		
		if(event.getActionCommand().equals("asr")){
			matiere = "ASR";
			test = 1;
			this.requestFocus();
		}
			
		if(event.getActionCommand().equals("acd")){
			matiere = "ACD";
			test = 1;
			this.requestFocus();
		}
		
		if(event.getActionCommand().equals("apl")){
			matiere = "APL";
			test = 1;
			this.requestFocus();
		}
		
		if(event.getActionCommand().equals("bd")){
			matiere = "BD";
			test = 1;
			this.requestFocus();
		}
		
		if(event.getActionCommand().equals("wim")){
			matiere = "WIM";
			test = 1;
			this.requestFocus();
		}
		if(event.getActionCommand().equals("ego")){
			matiere = "EGO";
			test = 1;
			this.requestFocus();
		}
		
		if(event.getActionCommand().equals("m")){
			matiere = "M";
			test = 1;
			this.requestFocus();
		}
		
		if(event.getActionCommand().equals("ec")){
			matiere = "EC";
			test = 1;
			this.requestFocus();
		}
		
		if(event.getActionCommand().equals("ang")){
			matiere = "ANG";
			test = 1;
			this.requestFocus();
		}
		
		if(event.getActionCommand().equals("validerModule")){
			if(test == 1){
				numero = numeroModule.getText();
				module = matiere+""+numero;
				principale.semestre = (String) semestre.getSelectedItem();
				principale.module.setText(module + " " + principale.semestre);
				principale.nomModule = module +".txt";
				principale.frame4.nomModule.setText(module);
				principale.frame4.semestre.setText(principale.frame4.semestre.getText() + principale.semestre);
				this.dispose();
				test = 0;
				principale.save.setEnabled(true);
				principale.memoire.setText("Veuillez choisir un type cours ");
				principale.ouvertAdd=0;
			}
			else{
				JOptionPane.showMessageDialog(null, "Aucun cours sélectionné", "Erreur", JOptionPane.ERROR_MESSAGE);
			}
		}
		this.requestFocus();
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_RIGHT){
			String d = numeroModule.getText();
			int c = Integer.parseInt(d);
			c++;
			numeroModule.setText(""+c);
		}
		if(e.getKeyCode()==KeyEvent.VK_LEFT){
			String d = numeroModule.getText();
			int c = Integer.parseInt(d);
			if(c == 1)
				c = 1;
			else
				c--;
			numeroModule.setText(""+c);
		}
		if(e.getKeyCode()==KeyEvent.VK_ENTER){
			if(test == 1){
				numero = numeroModule.getText();
				module = matiere+""+numero;
				principale.semestre = (String) semestre.getSelectedItem();
				
				principale.module.setText(module + " " + principale.semestre);
				principale.nomModule = module +".txt";
				principale.frame4.nomModule.setText(module);
				principale.frame4.semestre.setText(principale.frame4.semestre.getText() + principale.semestre);
				this.dispose();
				test = 0;
				principale.save.setEnabled(true);
				principale.memoire.setText("Veuillez choisir un type cours ");
				principale.ouvertAdd=0;
			}
			else{
				JOptionPane.showMessageDialog(null, "Aucun cours sélectionné", "Erreur", JOptionPane.ERROR_MESSAGE);
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
