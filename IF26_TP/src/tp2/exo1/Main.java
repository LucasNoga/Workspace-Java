/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp2.exo1;

/**
 *
 * @author lemercie
 */
public class Main {

  public static void main(String[] args) {
    System.out.println("Methode main de l'exercice 2");

    Module lo07 = new Module();
    //lo07.affiche();

    Module if26 = new Module("IF26", "TM", "FCBR", 6);
    //if26.affiche();

    Cursus cursus = new Cursus();
    cursus.ajoute(if26);
    cursus.ajoute(lo07);
    cursus.affiche1();

   // Exercice 2 - question 11
    Stage st09 = new Stage("ST09", "ST", "Utt", 30);
    cursus.ajoute(st09);
    
    
    // cursus.affiche1(); 
    
    // Erreur avec affiche 1 cat dans la collection il y a des objets de plusieurs classes (Module et Stage)
    // l'iterator renvoie des objets et ne sait pas de quel objet il s'agit
    
    // Solution
    // dans la methode affiche2(), nous allons utiliser l'instruction instanceof qui permet de connaitre la classe d'un objet.
    // ainsi on peut faire appelle à la bonne méthode affiche soit de Module soit de Stage.
    
    cursus.affiche2();

  }

}
