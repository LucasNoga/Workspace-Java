package objet;

import config.ListObjets;

public class Chat extends Objet{
	public Chat() {
		this.setNom("Chat de Schrödinger");
		this.setId(ListObjets.CHAT.getID());
	}
	public String toString() {
		return this.getNom() + ": Peut rendre 1 PMO à un joueur qui le caresse (1 fois par jour). Peut être contaminé par 1 spore mush (ce qui augmente le nombre de spores sur les joueurs humains de 1 à chaque caresse).";
	}

}
