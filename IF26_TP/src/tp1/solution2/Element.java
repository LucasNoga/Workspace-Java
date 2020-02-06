package tp1.solution2;

import tp2.exo1.Resultat;

public class Element {
	protected String sigle;
	protected String categorie;
	protected int credit;
	protected Resultat resultat;

	public Element(String sigle, String categorie, int credit, Resultat resultat) {
		this.sigle = sigle;
		this.categorie = categorie;
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
}