/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp1.solution2;

import tp2.exo1.Resultat;

/**
 *
 * @author lemercie
 */
public class Main {

  public static void main(String[] args) {
    System.out.println("Methode main de l'exercice 2");

    Module lo07 = new Module("LO07", "TM", "FCBR", 6, Resultat.C);
    //lo07.affiche();

    Module if26 = new Module("IF26", "TM", "FCBR", 6, Resultat.A);
    //if26.affiche();

    Cursus cursus = new Cursus();
    cursus.ajoute(if26);
    cursus.ajoute(lo07);
    cursus.affiche1();

    Stage st09 = new Stage("ST09", "ST", "Utt", 30, Resultat.D);
    cursus.ajoute(st09);
    
    cursus.affiche2();

  }

}
