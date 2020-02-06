/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp1.solution1;

public class Stage {
  private String sigle;
  private String categorie;
  private String entreprise;
  private int credit;

  public Stage(String sigle, String categorie, String entreprise, int credit) {
    this.sigle = sigle;
    this.categorie = categorie;
    this.credit = credit;
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
