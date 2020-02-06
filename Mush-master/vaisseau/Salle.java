package vaisseau;

import java.util.ArrayList;
import joueur.actions.Action;
import objet.Objet;


/**
*	Salle du vaisseau
*/
public abstract class Salle {
	
	protected String nom;
	private int id;

	private ArrayList<Salle> portes;
	private ArrayList<Action> actions;
	private ArrayList<Objet> inventaire;
	
	
	public Salle() {
		this.portes = new ArrayList<>();
		this.actions = new ArrayList<>();
		this.inventaire = new ArrayList<>();
	}
	
	
	public void action() {
		
	}


	public ArrayList<Salle> getPortes() {
		return portes;
	}


	public void addPortes(Salle porte) {
		this.portes.add(porte);
	}


	public ArrayList<Action> getActions() {
		return actions;
	}


	public void addActions(Action action) {
		this.actions.add(action);
	}


	public ArrayList<Objet> getInventaire() {
		return inventaire;
	}


	public void addInventaire(Objet obj) {
		this.inventaire.add(obj);
	}


	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}


	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	
	
}
