/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp2.exo1;

public class Stage extends Element{
  private String entreprise;

  public Stage(String sigle, String categorie, String entreprise, int credit) {
	  super(sigle, categorie, credit);
	  this.entreprise = entreprise;
  }


  @Override
  public String toString() {
    return "Stage{" + "sigle=" + sigle + ", categorie=" + categorie + ", entreprise=" + entreprise + ", credit=" + credit + '}';
  }
  
    public void affiche() {
    System.out.println(toString());
  }
  
  

}
