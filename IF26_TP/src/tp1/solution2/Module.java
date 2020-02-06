/**
 * Module IF26. TP01 . Exo1<p>
 * La classe module représente un module de l'UTT
 *
 * @auteur Marc Lemercier
 * @version 2017
 */
package tp1.solution2;

import tp2.exo1.Resultat;

/**
 * Module IF26. TP01 . Exo1<p>
 * La classe module représente un module de l'UTT
 *
 * @auteur Marc Lemercier
 * @version 2017
 */
public class Module extends Element{

  private String parcours;

  public Module(String sigle, String categorie, String parcours, int credit, Resultat resultat) {
	super(sigle, categorie, credit, resultat);
    this.parcours = parcours;
  }

  public void setCategorie(String categorie) {
    this.categorie = categorie;
  }

  public String getParcours() {
    return parcours;
  }

  public void setParcours(String parcours) {
    this.parcours = parcours;
  }

  @Override
  public String toString() {
    return "Module{" + "sigle=" + sigle + ", categorie=" + categorie + ", parcours=" + parcours + ", credit=" + credit + '}';
  }

  /**
   * Cette methode affiche les données de l'objet
   */
  public void affiche() {
    System.out.println(toString());
  }

}
