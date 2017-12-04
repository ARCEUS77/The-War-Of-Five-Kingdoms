
public class Game {

	public static final int MINIMUM_MAP_X_Y = 10;
	public static final int MINIMUM_KINGDOMS = 2;
	public static final int MAXIMUM_KINGDOMS = 8;
	
	private int xMap,yMap;
	
	private Kingdoms Kingdoms;
	private Castles Castles;
	private int nKingdoms;
	private int nCastles;
	
	public Game(int xMap, int yMap, int nKingdoms, int nCastles) {
		this.xMap = xMap;
		this.yMap = yMap;
		
		Kingdoms = new Kingdoms(nKingdoms,xMap,yMap);
		Castles = new Castles(nCastles);

		this.nCastles = nCastles;
		this.nKingdoms = nKingdoms;
	}
	public int getXMap() {
		return xMap;
	}
	
	public int getYMap() {
		return yMap;
	}
	
	public int getNKingdoms() {
		return nKingdoms;
	}
	
	public int getNCastles() {
		return nCastles;
	}
	
	public void createCastle(int x, int y, int money, String castleName) {
		Castles.addCastles(x, y,money,castleName);
	}
	
	public void createKingdom(String teamName,String castleName) {
		Kingdoms.addKindom(teamName, nCastles, xMap, yMap);
	}
	
	public String teamName(int i) {
		return Kingdoms.teamName(i);
	}
	public Castle getCastle(String castleName) {
		return Castles.getCastle(castleName);
	}
	
	public Castle getCastle(int i) {
		return Castles.getCastle(i);
	}
	
	public Kingdom getKingdom(int i) {
		return Kingdoms.getKingdom(i);
	}
}
