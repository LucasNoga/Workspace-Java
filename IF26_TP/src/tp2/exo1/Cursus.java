/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp2.exo1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Comparator;

/**
 *
 * @author lemercie
 */
public class Cursus implements Jury{

	List<Element> profil;

	public Cursus() {
		profil = new ArrayList<Element>();
	}

	public void ajoute(Module m) {
		profil.add(m);
	}

	public void ajoute(Stage s) {
		profil.add(s);
	}

	public void affiche1() {
		System.out.println("Cursus : Affiche : Debut");
		Iterator<Element> iterateur = profil.iterator();
		while (iterateur.hasNext()) {
			Module m = (Module) (iterateur.next());
			m.affiche();
		}
	}

	public void affiche2() {
		System.out.println("Cursus : Affiche : Debut");
		Iterator<Element> iterateur = profil.iterator();
		while (iterateur.hasNext()) {
			Element element = iterateur.next();
			if (element instanceof Module) {
				((Module) element).affiche();
			} else if (element instanceof Stage) {
				((Stage) element).affiche();
			}
		}
	}

	@Override
	public String excellence() {
		return null;
	}

	@Override
	public String triParCredit() {
		Collections.sort(profil, new Comparator<Element>(){
			public int compare(Element elt1, Element elt2) {
				Integer credit1 = elt1.getCredit();
				Integer credit2 = elt2.getCredit();
				int result = credit1.compareTo(credit2);
				if(result == 0)
					return credit1.compareTo(credit2);
				return result;
			}
		});
		System.out.println(profil);
		return null;
	}

	@Override
	public String triParResultat() {
		Iterator<Element> iterateur = profil.iterator();
		while (iterateur.hasNext()) {
			Element element = iterateur.next();
			if (element instanceof Module) {
				((Module) element).affiche();
			} else if (element instanceof Stage) {
				((Stage) element).affiche();
			}
		}
		return null;
	}
}
