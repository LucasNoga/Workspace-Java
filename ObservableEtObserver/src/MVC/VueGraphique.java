package MVC;

import java.util.Observable;
import java.util.Observer;
import javax.swing.*;
import java.awt.*;

public class VueGraphique extends JFrame implements Observer {

	private static final long serialVersionUID = 1L;
	JFrame frame;
	JPanel mainPanel;
	JButton b1, b2;
	JLabel label;

	public VueGraphique(){
		frame = new JFrame("mon compteur MVC");
		mainPanel = new JPanel(new BorderLayout());

		b1 = new JButton("+");
		b2 = new JButton("-");
		label = new JLabel("0", JLabel.CENTER);

		mainPanel.add(b1, BorderLayout.NORTH);
		mainPanel.add(label, BorderLayout.CENTER);
		mainPanel.add(b2, BorderLayout.SOUTH);


		frame.setContentPane(mainPanel);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setSize(200, 200);
	}

	public void update(Observable obs, Object o){
		Model modele = (Model) obs;
		System.out.println(o);
		int d = modele.getCompteur();
		label.setText(""+d);	
	}
}
