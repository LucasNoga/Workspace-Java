package models.cartes;

public enum Dogme {
	NATURE("Nature"),
	HUMAIN("Humain"),
	SYMBOLES("Symboles"),
	MYSTIQUE("Mystique"),
	CHAOS("Chaos");
	
	private String dogme=null;
	
	Dogme(String dogme){
		this.setDogme(dogme);
	}

	public String getDogme() {
		return dogme;
	}

	public void setDogme(String dogme) {
		this.dogme = dogme;
	}
		
}
