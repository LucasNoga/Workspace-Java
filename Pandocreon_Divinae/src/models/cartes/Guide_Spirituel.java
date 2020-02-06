package models.cartes;

import java.util.ArrayList;
import java.util.Set;

public class Guide_Spirituel extends Religion{
	private ArrayList<Croyant> croyants;
	
	public Guide_Spirituel(String nom, String capaciteDesc, Origine origine, Integer nombre,
			Set<Dogme> sesDogmes) {
		super(nom, capaciteDesc, origine, nombre, sesDogmes);
		// TODO Auto-generated constructor stub
		setCroyants(new ArrayList<Croyant>());
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		StringBuffer buf = new StringBuffer();
		buf.append("GUIDE : ").append(this.nom);
		buf.append("\n");
		buf.append(this.capaciteDesc);
		buf.append("\n Origine : ");
		buf.append(this.origine);
		buf.append("\n Dogmes");
		buf.append(this.sesDogmes.toString());
		return buf.toString();
	}

	public ArrayList<Croyant> getCroyants() {
		return croyants;
	}

	public void setCroyants(ArrayList<Croyant> croyants) {
		this.croyants = croyants;
	}

}
