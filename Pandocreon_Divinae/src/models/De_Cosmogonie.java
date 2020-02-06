package models;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import models.cartes.Origine;

public class De_Cosmogonie {

	private static De_Cosmogonie de = null;
	
	public static final De_Cosmogonie getInstance(){
		if(de == null){
			de = new De_Cosmogonie();
		}
		return de;
	}

	public static Origine lancerDe(){
		Map<Integer, Origine> composition = new HashMap<Integer, Origine>();
		composition.put(0, Origine.JOUR);
	    composition.put(1, Origine.NUIT);
	    composition.put(2, Origine.NEANT);
	    Random rand = new Random();
	    int nombre = rand.nextInt(3);
		return composition.get(nombre);
		
	}
	

}
