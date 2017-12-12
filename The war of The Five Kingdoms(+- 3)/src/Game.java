
/**
 * @author Tiago Kebas
 *
 */
public class Game {

	public static final String MAP_TOO_SMALL_MSG = "Mapa pequeno demais para o jogo.";
	public static final String INVALID_N_KINGDOMS_MSG = "Numero de reinos invalido.";
	public static final String INVALID_N_CASTLES_MSG = "Numero de castelos invalido.";
	public static final String INVALID_POS_CASTLE_MSG = "Castelo em posicao invalida.";
	public static final String INVALID_WEALTH_MSG = "Castelo com riqueza invalida.";
	public static final String DUPLICATE_CASTLE_NAME_MSG = "Os castelos nao podem ter nomes duplicados.";
	public static final String NOT_ENOUGH_CASTLES_MSG = "Numero insuficiente de castelos criados.";
	public static final String DUPLICATE_KINGDOM_NAME_MSG = "Os reinos nao podem ter nomes duplicados.";
	public static final String OCCUPIED_CASTLE_MSG = "Castelo ja ocupado.";
	public static final String CASTLE_NON_EXISTANT_MSG = "Castelo nao existe.";
	public static final String NOT_ENOUGH_KINGDOMS_MSG = "Numero insuficiente de reinos criados.";
	
	public static final int MINIMUM_MAP_X_Y = 10;
	public static final int MINIMUM_KINGDOMS = 2;
	public static final int MAXIMUM_KINGDOMS = 8;
	
	private int xMap,yMap;
	
	private Kingdoms Kingdoms;
	private Castles Castles;
	private int nKingdoms;
	private int nCastles;
	private int currentElement;
	
	/**
	 * @param xMap
	 * @param yMap
	 * @param nKingdoms
	 * @param nCastles
	 */
	public Game(int xMap, int yMap, int nKingdoms, int nCastles) {
		this.xMap = xMap;
		this.yMap = yMap;
		
		Kingdoms = new Kingdoms(nKingdoms);
		Castles = new Castles(nCastles);

		this.nCastles = nCastles;
		this.nKingdoms = nKingdoms;
		currentElement = 0;
	}
	
	public void initializeIterator() {
		currentElement = 0;
	}
	/**
	 * @param xMap
	 * @param yMap
	 * @param nKingdoms
	 * @param nCastles
	 * @return
	 */
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
	
	/**
	 * @param x
	 * @param y
	 * @param money
	 * @param name
	 * @param index
	 * @return
	 */
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
	
	/**
	 * @param kingdomName
	 * @param castleName
	 * @param G
	 * @param index
	 * @return
	 */
	public String validKingdom(String kingdomName, String castleName, Game G, int index) {
		String res = "";
		
		if(index > 0) {
			
			for(int i = index-1; i >= 0; i--) 
				if(kingdomName.equals(getKingdomName(i)) && res.equals(""))
					res = DUPLICATE_KINGDOM_NAME_MSG;
			
			for(int i = index-1; i >= 0; i--)
				if(castleName.equals(getKingdom(i).getConqueredCastleName(0)) && res.equals("")) 
					res = OCCUPIED_CASTLE_MSG;
					}
		
		if(Castles.getCastle(castleName) == null && res.equals("")) 
					res = CASTLE_NON_EXISTANT_MSG;

		return res;
	}
	
	/**
	 * @return
	 */
	public int getXMap() {
		return xMap;
	}
	
	/**
	 * @return
	 */
	public int getYMap() {
		return yMap;
	}
	
	/**
	 * @return
	 */
	public int getNKingdoms() {
		return nKingdoms;
	}
	
	/**
	 * @return
	 */
	public int getNCastles() {
		return nCastles;
	}
	
	/**
	 * @param x
	 * @param y
	 * @param money
	 * @param castleName
	 */
	public void createCastle(int x, int y, int money, String castleName) {
		Castles.addCastles(x, y,money,castleName);
	}
	
	/**
	 * @param teamName
	 */
	public void createKingdom(String teamName) {
		Kingdoms.addKingdom(teamName, nCastles);
	}
	
	/**
	 * @param i
	 * @return
	 */
	public String getKingdomName(int i) {
		return Kingdoms.GetKingdomName(i);
	}
	
	public String getCastleName(int i) {
		return Castles.getCastleName(i);
	}
	
	public String getCastleKingdomName(int i) {
		
	}
	/**
	 * @param i
	 * @return
	 */
	public Kingdom getKingdom(String kingdomName) {
		return Kingdoms.getKingdom(kingdomName);
	}

	/**
	 * @param castleName
	 * @param kingdomName
	 */
	public void conquerCastle(String castleName, String kingdomName) {
		Castles.conquerCastle(Castles.getCastleIndex(castleName),kingdomName);
		Kingdoms.getKingdom(kingdomName).conquerCastle(Castles.getCastle(castleName));
	}
	
}
