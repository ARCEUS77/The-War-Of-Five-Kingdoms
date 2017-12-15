
public class Kingdom {
	
	private Army Army;
	private Castles Castles;
	private String kingdomName;
	private int nOwnedCastles;
	private boolean isKingdomActive;

	
	public Kingdom(String teamName, int nCastles) {
		this.kingdomName = teamName;
		
		Army = new Army();
		Castles = new Castles(nCastles);
		nOwnedCastles = 0;
		isKingdomActive = true;
	}
	public String getKingdomName() {
		return kingdomName;
	}
	
	public void conquerCastle(Castle c) {
		Castles.addCastles(c);
		Castles.getCastle(c.getCastleName());
		nOwnedCastles++;
	}
	
	public String getConqueredCastleName(int i) {
		return Castles.getCastleName(i);
	}
	
	public int getNOwnedCastles() {
		return nOwnedCastles;
	}
	
	public Castle getCastle(int i) {
		return Castles.getCastle(i);
	}
	
	public Castle getCastle(String castleName) {
		return Castles.getCastle(castleName);
	}
	
	public int getNSoldiers() {
		return Army.getNSoldiers();
	}
	
	public Soldier getSoldier(int i) {
		return Army.getSoldier(i);
	}
	
	public boolean greaterThan(Kingdom other) {
		return kingdomName.compareTo(other.getKingdomName()) > 0;
	}
	
	public void deactivateKingdom() {
		isKingdomActive = false;
	}
	
	public boolean isKingdomActive() {
		return isKingdomActive;
	}
	
	public void initializeArmyIterator() {
		Army.initializeIterator();
	}
	
	public boolean hasNextSoldier() {
		return Army.hasNextSoldier();	
	}
	
	public Soldier nextSoldier() {
		return Army.nextSoldier();
	}
	
	public void initializeCastleIterator() {
		Castles.initializeIterator();
	}
	
	public boolean hasNextCastle() {
		return Castles.hasNextCastle();
	}
	
	public Castle nextCastle() {
		return Castles.nextCastle();
	}
	
	public int totalMoney() {
		return Castles.totalMoney();
	}
	
	public void recruit(String type, String castleName) {
		Castle c = getCastle(castleName);
		c.occupyCastle();
		Army.recruitSoldier(type,c,kingdomName);
	}
	
	public Soldier getSoldier(int x, int y) {
		return Army.getSoldier(x,y);
	}
	
	public Point getSoldierPoint(int x, int y) {
		return getSoldier(x,y).getSoldierPoint();
	}
	
	public void moveSoldier(int x, int y, String direction) {
		Army.moveSoldier(x,y,direction);
	}
	
	public String getSoldierType(int x, int y) {
		String type = "";
		
		if(getSoldier(x,y) != null) 
			type = getSoldier(x,y).getSoldierType();
		
		return type;
	}
}
