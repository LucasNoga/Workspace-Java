/**
* Module IF26. TP01 . Exo1<p>
 * La classe module représente un module de l'UTT
 *
 * @auteur Marc Lemercier
 * @version 2017
 */
package tp2.exo2;

/**
 * Module IF26. TP01 . Exo1<p>
 * La classe module représente un module de l'UTT
 *
 * @auteur Marc Lemercier
 * @version 2017
 */
public class Module extends Element{

  private String parcours;

  public Module() {
	super("?", "?", 0);
    parcours = "?";
  }

  public Module(String sigle, String categorie, String parcours, int credit) {
	super(sigle, categorie, credit);
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
