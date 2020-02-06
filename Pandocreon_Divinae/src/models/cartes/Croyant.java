package models.cartes;

import java.util.Set;

public class Croyant extends Religion{
	
	private Guide_Spirituel guide;
	
	public Croyant(String nom,String capaciteDesc,Origine origine,Integer nombre,Set<Dogme> sesDogmes){
		super(nom,capaciteDesc,origine,nombre,sesDogmes);
		setGuide(null);
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		StringBuffer buf = new StringBuffer();
		buf.append("CROYANT : ").append(this.nom).append("\n").append(this.capaciteDesc).append("\n Origine : ").append(this.origine).append("\n Dogmes : ").append(this.sesDogmes.toString());
		return buf.toString();
	}

	public Guide_Spirituel getGuide() {
		return guide;
	}

	public void setGuide(Guide_Spirituel guide) {
		this.guide = guide;
	}

}
