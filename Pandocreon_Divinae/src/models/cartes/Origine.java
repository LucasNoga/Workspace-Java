package models.cartes;

public enum Origine {
	JOUR("Jour"),
	NUIT("Nuit"),
	AUBE("Aube"),
	CREPUSCULE("Crepuscule"),
	NEANT("Neant");
	
	private String origine;
	
	Origine(String origine){
		this.setOrigine(origine);
	}

	public String getOrigine() {
		return origine;
	}

	public void setOrigine(String origine) {
		this.origine = origine;
	}
}
