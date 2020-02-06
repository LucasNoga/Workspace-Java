/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp1.solution2;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author lemercie
 */
public class Cursus {

  ArrayList<Element> profil;

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
      Object o = iterateur.next();
      if (o instanceof Module) {
        ((Module) o).affiche();
      } else if (o instanceof Stage) {
        ((Stage) o).affiche();
      }
    }
  }
}
