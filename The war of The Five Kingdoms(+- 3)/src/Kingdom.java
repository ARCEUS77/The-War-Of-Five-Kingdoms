
public class Kingdom {
	
	private Army Army;
	private Castles Castles;
	private String kingdomName;
	
	public Kingdom(String teamName, int nCastles) {
		this.kingdomName = teamName;
		
		Army = new Army();
		Castles = new Castles(nCastles);
	}
	public String getKingdomName() {
		return kingdomName;
	}
	
	public void recruitUnit(String soldierType, Castle castle) {
		Army.recruitSoldier(soldierType, castle,kingdomName);
	}
	
	public void conquerCastle(Castle c) {
		Castles.addCastles(c);
		Castles.getCastle(c.getCastleName());
	}
	
	public String getConqueredCastleName(int i) {
		return Castles.getCastle(i).getCastleName();
	}
	
	
}
