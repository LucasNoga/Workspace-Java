import java.util.Iterator;
import java.util.LinkedList;

public class Humain extends Habitant implements Strategie{
	public static LinkedList<Humain> listeHumains=new LinkedList<Humain>();
	
 public Humain (String nomHumain){
	 super(nomHumain);
	 listeHumains.add(this);
 }
 
 public void attaque(Habitant hab){
	 if (hab instanceof Elfe) {
		 hab.setPointDeVie(hab.getPointDeVie()-5);
		 if (hab.getPointDeVie()<0) 
		    Elfe.listeElfes.remove(hab);
	 }
 }
 public void soigne (Habitant hab){
	 if (hab instanceof Humain) hab.setPointDeVie(hab.getPointDeVie()+4);
 }
 public void seRepose (){
	 this.setPointDeVie(this.getPointDeVie()+4);
 }
 
 private Elfe chercheUnElfe(){
	 int nbrElfes=Elfe.listeElfes.size();
	 int indiceAleatoire= (int)(nbrElfes*Math.random());
	 return Elfe.listeElfes.get(indiceAleatoire);
 }
 
 private Elfe chercheUnElfePresqueMort(){
	 for (Iterator<Elfe> it=Elfe.listeElfes.iterator(); it.hasNext();){
		 Elfe unElfe = (Elfe) it.next();
		 if (unElfe.getPointDeVie()<=5) return unElfe;
	 }
	     
	 return Elfe.listeElfes.get(0);
 }

 
 public void StrategieSoldat(){
	 if (this.getPointDeVie()<10) this.seRepose();
	 else {Elfe unElfe= chercheUnElfe();
	       this.attaque(unElfe);
	 }
 };
 public void StrategieVeteran(){
	 if (this.getPointDeVie()<10) this.seRepose();
	 else {Elfe unElfe= chercheUnElfePresqueMort();
	       this.attaque(unElfe);
	 }
 };
}
