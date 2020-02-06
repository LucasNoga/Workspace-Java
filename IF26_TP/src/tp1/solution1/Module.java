/**
 * Module IF26. TP01 . Exo1<p>
 * La classe module représente un module de l'UTT
 *
 * @auteur Marc Lemercier
 * @version 2017
 */
package tp1.solution1;

/**
 * Module IF26. TP01 . Exo1<p>
 * La classe module représente un module de l'UTT
 *
 * @auteur Marc Lemercier
 * @version 2017
 */
public class Module {

  private String sigle;
  private String categorie;
  private String parcours;
  private int credit;

  public Module() {
    sigle = "?";
    categorie = "?";
    parcours = "?";
    credit = 0;
  }

  public Module(String sigle, String categorie, String parcours, int credit) {
    this.sigle = sigle;
    this.categorie = categorie;
    this.parcours = parcours;
    this.credit = credit;
  }

  public String getSigle() {
    return sigle;
  }

  public void setSigle(String sigle) {
    this.sigle = sigle;
  }

  public String getCategorie() {
    return categorie;
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

  /**
   *
   * @return le nombre de crédit
   */
  public int getCredit() {
    return credit;
  }

  /**
   * Cette méthode setCredit permet de modifier l'attribut de la classe
   * @param credit
   */
  public void setCredit(int credit) {
    this.credit = credit;
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
