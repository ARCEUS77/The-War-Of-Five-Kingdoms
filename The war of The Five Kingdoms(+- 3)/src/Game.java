
public class Game {

	public static final String MAP_TOO_SMALL_MSG = "Mapa pequeno demais para o jogo.";
	public static final String INVALID_N_KINGDOMS_MSG = "Numero de reinos invalido.";
	public static final String INVALID_N_CASTLES_MSG = "Numero de castelos invalido.";
	public static final String INVALID_POS_CASTLE_MSG = "Castelo em posicao invalida.";
	public static final String INVALID_WEALTH_MSG = "Castelo com riqueza invalida.";
	public static final String DUPLICATE_CASTLE_NAME_MSG = "Os castelos nao podem ter nomes duplicados.";
	public static final String NOT_ENOUGH_CASTLES_MSG = "Numero insuficiente de castelos criados.";
	public static final String DUPLICATE_KINGDOM_NAME_MSG = "Os reinos nao podem ter nomes duplicados";
	public static final String OCCUPIED_CASTLE_MSG = "Castelo ja ocupado.";
	public static final String CASTLE_NON_EXISTANT_MSG = "Castelo nao existe.";
	public static final String NOT_ENOUGH_KINGDOMS_MSG = "Numero insuficiente de reinos criados";
	

	
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
	
	public static String validFirstLine(int xMap, int yMap, int nKingdoms, int nCastles) {
		String res = "";
		int maxCastles = xMap*yMap;
		
		if(xMap < Game.MINIMUM_MAP_X_Y || yMap < Game.MINIMUM_MAP_X_Y) {
			res = MAP_TOO_SMALL_MSG;
		}
		
		else if(nKingdoms < Game.MINIMUM_KINGDOMS || nKingdoms > Game.MAXIMUM_KINGDOMS) {
				res = INVALID_N_KINGDOMS_MSG;
		}
			else if(nCastles > maxCastles || nCastles < nKingdoms) {
					res = INVALID_N_CASTLES_MSG;
			}
		return res;
	}
	
	public String validCastle(int x, int y, int money, String name, int index) {
		String res = "";
			
		if(x < 1 || x > getXMap() ||
			y < 1 || y >getYMap()) { 
				res = INVALID_POS_CASTLE_MSG;
			}
				
		if(index > 0) {
					
			for(int i = index-1; i >= 0 && res.equals(""); i--) 
				if(x == getCastle(i).getXCastle() &&
					y == getCastle(i).getYCastle()) {
						res = INVALID_POS_CASTLE_MSG;
					}
				}
				
				if(money < 0 && res.equalsIgnoreCase("")) {
					res = INVALID_WEALTH_MSG;
				 }
						
				for(int i = index-1; i >= 0 && res.equals(""); i--) 
					if(name.equals(getCastle(index-1).getCastleName())) {
						res = DUPLICATE_CASTLE_NAME_MSG;
						}
				
		return res;
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
	
	public void createKingdom(String teamName) {
		Kingdoms.addKindom(teamName, nCastles, xMap, yMap);
	}
	
	public String kingdomName(int i) {
		return Kingdoms.kingdomName(i);
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
	
	public Kingdom getKingdom(String KingdomName) {
		return Kingdoms.getKingdom(KingdomName);
	}
	
	public void conquerCastle(String castleName, String kingdomName) {
		Kingdoms.getKingdom(kingdomName).conquerCastle(castleName);
	}
}
