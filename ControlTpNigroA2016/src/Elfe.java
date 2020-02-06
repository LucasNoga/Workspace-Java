import java.util.LinkedList;

public class Elfe extends Habitant implements Strategie {
	public static LinkedList<Elfe> listeElfes=new LinkedList<Elfe>();
	
	 public Elfe (String nomElfe){
		 super(nomElfe);
		 listeElfes.add(this);
	 }

	 public void attaque(Habitant hab){
		 if (hab instanceof Humain) {
			 hab.setPointDeVie(hab.getPointDeVie()-5);
			 if (hab.getPointDeVie()<0) 
				    Humain.listeHumains.remove(hab);
		 }
	 }
	 
	 public void attaqueDouble(Habitant hab1, Habitant hab2){
		 if ((hab1 instanceof Humain) && (hab1 instanceof Humain)) {
			 hab1.setPointDeVie(hab1.getPointDeVie()-5);
			 hab2.setPointDeVie(hab2.getPointDeVie()-5);
			 this.setPointDeVie(this.getPointDeVie()-4);
			 if (hab1.getPointDeVie()<0) 
				    Humain.listeHumains.remove(hab1);
			 if (hab2.getPointDeVie()<0) 
				    Humain.listeHumains.remove(hab2);
		 }
	 } 
	 public void seRepose (){
		 this.setPointDeVie(this.getPointDeVie()+4);
	 }
	 
	 private Humain chercheUnHumain(){
		 int nbrHumains=Humain.listeHumains.size();
		 int indiceAleatoire= (int)(nbrHumains*Math.random());
		 return Humain.listeHumains.get(indiceAleatoire);
	 }
	 public void StrategieSoldat(){
		 if (this.getPointDeVie()<10) this.seRepose();
		 else {Humain unHumain1= chercheUnHumain();
		       Humain unHumain2= chercheUnHumain();
		       this.attaqueDouble(unHumain1, unHumain2);
		 }
	 };
	 public void StrategieVeteran(){
		 
	 };

}
