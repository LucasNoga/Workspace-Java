/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp2.exo2;

/**
 *
 * @author lemercie
 */
public class Main {

  public static void main(String[] args) {
    System.out.println("Methode main de l'exercice 2");

    Module lo07 = new Module("LO07", "CS", "FCBR", 6);
    Module le01 = new Module("LE01", "CC", "FCBR", 4);
    Module le02 = new Module("LE02", "CC", "FCBR", 4);
    Module le03 = new Module("LE03", "CC", "FCBR", 4);
    Module le08 = new Module("LE08", "CC", "FCBR", 4);
    Module if10 = new Module("IF10", "CS", "FIL", 6);
    Module if16 = new Module("IF16", "CS", "FIL", 6);
    Module if26 = new Module("IF26", "TM", "FIL", 6);
 

    Cursus cursusSandra = new Cursus("Sandra");
    Cursus cursusLucie = new Cursus("Lucie");
    
    Prof michael = new Prof("Michael");
    Prof marc = new Prof("Marc");
    
    //ajout des observers
    cursusLucie.addObserver(michael);
    cursusSandra.addObserver(marc);
    cursusLucie.addObserver(marc);
    
    
    //ajout des modules
    cursusSandra.ajoute(lo07);   
    cursusLucie.ajoute(if26);
    cursusSandra.ajoute(le01);   
    cursusLucie.ajoute(le02);
    cursusSandra.ajoute(le03);   
    cursusLucie.ajoute(le08);
    cursusSandra.ajoute(if10);   
    cursusLucie.ajoute(if16);
  }

}
