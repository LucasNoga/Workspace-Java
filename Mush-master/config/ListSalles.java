package config;

public enum ListSalles {

	TALPHA1(21),
	PONT(22),
	TBETA1(23),
	COULOIR1(24),
	JARDIN(25),
	LABO(26),
	STOCKAGE(27),
	INFIRMERIE(28),
	TALPHA2(29),
	TBETA2(30),
	BALPHA1(31),
	COULOIR2(32),
	STOKAGEA1(33),
	REFECTOIRE(34),
	STOKAGEB1(35),
	BALPHB1(36),
	DORTOIRA(37),
	NEXUS(38),
	DORTOIRB(39),
	COULOIR3(40),
	BALPHA2(41),
	STOKAGEA2(42),
	STOKAGEB2(43),
	BICARUS(44),
	TALPHA3(45),
	MOTEUR(46),
	TBETA3(45);
	
	private int id;
	
	private ListSalles(int id) {
		this.id = id;
	}
	
	
	public int getID() {
		return this.id;
	}
}
