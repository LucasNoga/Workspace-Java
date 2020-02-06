package LO02_td9.patternObserver;

import java.util.Observable;
import java.util.Observer;

public class ObserverLampCommu implements Observer{

	@Override
	public void update(Observable obs, Object arg) {
		//System.out.println("salut");
		if(obs instanceof Lampe){
			if(((Lampe) obs).estAllume == true)
				setInfos("l'etat de la lampe est allum�");
			else
				setInfos("l'etat de la lampe est �teinte");
		}	
		if(obs instanceof Commutateur){
			// methode a appeler un commutateur
		}	
	}

	public void setInfos(String string) {
		System.out.println(string);
	}

}
