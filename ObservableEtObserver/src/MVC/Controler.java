package MVC;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controler implements ActionListener {

	private Model model;

	public Controler(Model m) {
		this.model=m;
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("+"))
			model.modifier(1);
		if(e.getActionCommand().equals("-"))	
			model.modifier(-1);	
	}

}
