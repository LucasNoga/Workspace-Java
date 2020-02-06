package objet;


/**
*	Structure d'un objet
*/
public abstract class Objet {
	
	private String nom;
	private int id;
	
	public static void action() {
		
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
