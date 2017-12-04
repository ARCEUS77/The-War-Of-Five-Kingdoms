
public class Kingdom {
	
	private Army Army;
	private Castles Castles;
	private String teamName;
	
	public Kingdom(String teamName, int nCastles, int xmap, int ymap) {
		this.teamName = teamName;
		
		Army = new Army(xmap,ymap);
		Castles = new Castles(nCastles);
	}
	public String getTeamName() {
		return teamName;
	}
	
	public void recruitUnit(String soldierType, Castle castle) {
		Army.recruitSoldier(soldierType, castle,teamName);
	}
	
	public void conquerCastle(String castleName) {
		Castles.conquerCastle(teamName, castleName);
	}
	
	
}
