
public class Kingdom {
	
	private Army Army;
	private Castles Castles;
	private String teamName;
	
	public Kingdom(String teamName, int nCastles, int xmap, int ymap) {
		this.teamName = teamName;
		
		Army = new Army(xmap,ymap);
		Castles = new Castles(nCastles);
	}
	public String getKingdomName() {
		return teamName;
	}
	
	public void recruitUnit(String soldierType, Castle castle) {
		Army.recruitSoldier(soldierType, castle,teamName);
	}
	
	public void conquerCastle(Castle castle) {
		Castles.addCastles(castle.getXCastle(), castle.getYCastle(), castle.getMoney(), castle.getCastleName());
		Castles.conquerCastle(teamName,castle);
	}
	
	public String getConqueredCastleName(int i) {
		return Castles.getCastle(i).getCastleName();
	}
	
	
}
