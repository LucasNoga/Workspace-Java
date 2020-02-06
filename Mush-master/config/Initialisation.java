package config;

import java.util.ArrayList;
import joueur.*;
import vaisseau.Salle;
import vaisseau.salles.*;

public class Initialisation {

	/**
	 * Initialisation de tous les joueurs
	 * @return Liste de joueurs
	 */
	public static ArrayList<Joueur> initJoueur(){
		ArrayList<Joueur> Joueurs = new ArrayList<>();
		
		System.out.println("Initialisation des personnages");
		
		Joueurs.add(new WangChao());
		Joueurs.add(new EleeshaWilliams());
		Joueurs.add(new FinolaKeegan());
		Joueurs.add(new FriedaBergmann());
		Joueurs.add(new GioeleRinaldao());
		Joueurs.add(new IanSoulton());
		Joueurs.add(new JaniceKent());
		Joueurs.add(new JiangHua());
		Joueurs.add(new KimJinSu());
		Joueurs.add(new LaiKuanTi());
		Joueurs.add(new PaolaRinaldo());
		Joueurs.add(new ZhongChun());

		System.out.println("Séléction des Mush");
		
		// Choix des deux Mush
		int r1, r2 = 0;
		r1 = (int) (Math.random() * Joueurs.size());
		
		do {
			r2 = (int) (Math.random() * Joueurs.size());
		}
		while(r2 == r1);
		
		Joueurs.add(r1, Joueurs.get(r1).toMush());
		Joueurs.add(r2, Joueurs.get(r2).toMush());

		return Joueurs;
	}
	
	
	/**
	 * Liste des salles
	 * @return liste de salle
	 */
	public static ArrayList<Salle> initVaisseau(){
		ArrayList<Salle> vaisseau = new ArrayList<>();

		System.out.println("Initialisation des salles du vaisseau");
		
		// Initialise les autres salles
		vaisseau.add(new Pont());
		vaisseau.add(new TourelleAlphaAvant());
		vaisseau.add(new TourelleBetaAvant());
		vaisseau.add(new CouloirAvant());
		vaisseau.add(new JardinHydroponique());
		vaisseau.add(new Laboratoire ());
		vaisseau.add(new Infirmerie ());
		vaisseau.add(new StockageAvant());
		vaisseau.add(new CouloirCentral());
		vaisseau.add(new TourelleAlphaCentre());
		vaisseau.add(new TourelleBetaCentre ());
		vaisseau.add(new BaieBeta());
		vaisseau.add(new DortoirBeta());
		vaisseau.add(new StockageBetaCentre());
		vaisseau.add(new Refectoire());
		vaisseau.add(new Nexus());
		vaisseau.add(new DortoirAlpha());
		vaisseau.add(new StockageAlphaCentre());
		vaisseau.add(new BaieAlpha());
		vaisseau.add(new BaieAlpha2 ());
		vaisseau.add(new CouloirArriere ());
		vaisseau.add(new StockageAlphaArriere ());
		vaisseau.add(new StockageBetaArriere ());
		vaisseau.add(new BaieIcarus ());
		vaisseau.add(new TourelleAlphaArriere ());
		vaisseau.add(new TourelleBetaArriere ());
		vaisseau.add(new SalleDesMoteurs ());
		

		
		
		// Etablissement les liens entre les salles
		vaisseau.get(0).addPortes(vaisseau.get(1));		// Ajout de la tourelle alpha avant au pont
		vaisseau.get(0).addPortes(vaisseau.get(2));		// Ajout de la tourelle beta avant au pont
		vaisseau.get(0).addPortes(vaisseau.get(3));
		vaisseau.get(1).addPortes(vaisseau.get(0));
		vaisseau.get(1).addPortes(vaisseau.get(3));
		vaisseau.get(1).addPortes(vaisseau.get(3));
		vaisseau.get(1).addPortes(vaisseau.get(0));
		vaisseau.get(3).addPortes(vaisseau.get(0));
		vaisseau.get(3).addPortes(vaisseau.get(1));
		vaisseau.get(3).addPortes(vaisseau.get(2));
		vaisseau.get(3).addPortes(vaisseau.get(4));
		vaisseau.get(3).addPortes(vaisseau.get(5));
		vaisseau.get(3).addPortes(vaisseau.get(6));
		vaisseau.get(3).addPortes(vaisseau.get(7));
		vaisseau.get(3).addPortes(vaisseau.get(8));
		vaisseau.get(4).addPortes(vaisseau.get(7));
		vaisseau.get(4).addPortes(vaisseau.get(3));
		vaisseau.get(2).addPortes(vaisseau.get(0));
		vaisseau.get(2).addPortes(vaisseau.get(3));
		vaisseau.get(5).addPortes(vaisseau.get(3));
		vaisseau.get(5).addPortes(vaisseau.get(6));
		vaisseau.get(6).addPortes(vaisseau.get(3));
		vaisseau.get(6).addPortes(vaisseau.get(5));
		vaisseau.get(6).addPortes(vaisseau.get(10));
		vaisseau.get(7).addPortes(vaisseau.get(3));
		vaisseau.get(7).addPortes(vaisseau.get(4));
		vaisseau.get(7).addPortes(vaisseau.get(9));
		vaisseau.get(7).addPortes(vaisseau.get(8));
		vaisseau.get(8).addPortes(vaisseau.get(3));
		vaisseau.get(8).addPortes(vaisseau.get(11));
		vaisseau.get(8).addPortes(vaisseau.get(16));
		vaisseau.get(8).addPortes(vaisseau.get(14));
		vaisseau.get(9).addPortes(vaisseau.get(7));
		vaisseau.get(9).addPortes(vaisseau.get(16));
		vaisseau.get(10).addPortes(vaisseau.get(6));
		vaisseau.get(10).addPortes(vaisseau.get(11));
		vaisseau.get(11).addPortes(vaisseau.get(10));
		vaisseau.get(11).addPortes(vaisseau.get(8));
		vaisseau.get(11).addPortes(vaisseau.get(13));
		vaisseau.get(11).addPortes(vaisseau.get(12));
		vaisseau.get(11).addPortes(vaisseau.get(20));
		vaisseau.get(12).addPortes(vaisseau.get(11));
		vaisseau.get(12).addPortes(vaisseau.get(20));
		vaisseau.get(13).addPortes(vaisseau.get(11));
		vaisseau.get(14).addPortes(vaisseau.get(8));
		vaisseau.get(15).addPortes(vaisseau.get(20));
		vaisseau.get(16).addPortes(vaisseau.get(20));
		vaisseau.get(16).addPortes(vaisseau.get(18));
		vaisseau.get(17).addPortes(vaisseau.get(18));
		vaisseau.get(18).addPortes(vaisseau.get(17));
		vaisseau.get(18).addPortes(vaisseau.get(16));
		vaisseau.get(19).addPortes(vaisseau.get(18));
		vaisseau.get(19).addPortes(vaisseau.get(20));
		vaisseau.get(19).addPortes(vaisseau.get(26));
		vaisseau.get(19).addPortes(vaisseau.get(24));
		vaisseau.get(20).addPortes(vaisseau.get(19));
		vaisseau.get(20).addPortes(vaisseau.get(16));
		vaisseau.get(20).addPortes(vaisseau.get(15));
		vaisseau.get(20).addPortes(vaisseau.get(12));
		vaisseau.get(20).addPortes(vaisseau.get(11));
		vaisseau.get(20).addPortes(vaisseau.get(23));
		vaisseau.get(20).addPortes(vaisseau.get(22));
		vaisseau.get(20).addPortes(vaisseau.get(21));
		vaisseau.get(21).addPortes(vaisseau.get(20));
		vaisseau.get(21).addPortes(vaisseau.get(26));
		vaisseau.get(22).addPortes(vaisseau.get(20));
		vaisseau.get(22).addPortes(vaisseau.get(26));
		vaisseau.get(23).addPortes(vaisseau.get(20));
		vaisseau.get(23).addPortes(vaisseau.get(26));
		vaisseau.get(23).addPortes(vaisseau.get(22));
		vaisseau.get(24).addPortes(vaisseau.get(19));
		vaisseau.get(24).addPortes(vaisseau.get(26));
		vaisseau.get(25).addPortes(vaisseau.get(26));
		vaisseau.get(25).addPortes(vaisseau.get(23));
		vaisseau.get(26).addPortes(vaisseau.get(25));
		vaisseau.get(26).addPortes(vaisseau.get(23));
		vaisseau.get(26).addPortes(vaisseau.get(22));
		vaisseau.get(26).addPortes(vaisseau.get(21));
		vaisseau.get(26).addPortes(vaisseau.get(24));
		
		return vaisseau;
		
	}
	
}