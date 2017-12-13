
/**
 * @author Tiago Kebas
 *
 */
public class Game {

	public static final int MAP_TOO_SMALL_ERROR_N = 1;
	public static final int INVALID_N_KINGDOMS_ERROR_N = 2;
	public static final int INVALID_N_CASTLES_ERROR_N = 3;
	public static final int INVALID_POS_CASTLE_ERROR_N = 4;
	public static final int INVALID_WEALTH_ERROR_N = 5;
	public static final int DUPLICATE_CASTLE_NAME_ERROR_N = 6;
	public static final int NOT_ENOUGH_CASTLES_ERROR_N = 7;
	public static final int DUPLICATE_KINGDOM_NAME_ERROR_N = 8;
	public static final int OCCUPIED_CASTLE_ERROR_N = 9;
	public static final int CASTLE_NON_EXISTANT_ERROR_N = 10;
	public static final int NOT_ENOUGH_KINGDOMS_ERROR_N = 11;
	public static final int NO_ERRORS = 0;
	
	public static final int FIRST_KINGDOM_TURN = 0;
	public static final int SECOND_KINGDOM_TURN = 1;
	public static final int THIRD_KINGDOM_TURN = 2;
	public static final int FOURTH_KINGDOM_TURN = 3;
	public static final int FIFTH_KINGDOM_TURN = 4;
	public static final int SIXTH_KINGDOM_TURN = 5;
	public static final int SEVENTH_KINGDOM_TURN = 6;
	public static final int EIGHTH_KINGDOM_TURN = 7;
	
	public static final int MINIMUM_MAP_X_Y = 10;
	public static final int MINIMUM_KINGDOMS = 2;
	public static final int MAXIMUM_KINGDOMS = 8;
	
	private Kingdoms Kingdoms;
	private Castles Castles;
	private Point maximumMapPoint;
	private int nKingdoms;
	private int nCastles;
	private int currentKingdomTurn;
	
	/**
	 * @param xMap
	 * @param yMap
	 * @param nKingdoms
	 * @param nCastles
	 */
	public Game(int xMap, int yMap, int nKingdoms, int nCastles) {
		maximumMapPoint = new Point(xMap,yMap);
		
		Kingdoms = new Kingdoms(nKingdoms);
		Castles = new Castles(nCastles);

		this.nCastles = nCastles;
		this.nKingdoms = nKingdoms;
		currentKingdomTurn = FIRST_KINGDOM_TURN;
	}
	
	public void updateNCastlesNKingdoms(int nCastles, int nKingdoms) {
		this.nCastles = nCastles;
		this.nKingdoms = nKingdoms;
	}
	
	/**
	 * @param xMap
	 * @param yMap
	 * @param nKingdoms
	 * @param nCastles
	 * @return
	 */
	public static int validFirstLine(int xMap, int yMap, int nKingdoms, int nCastles) {
		int res = NO_ERRORS;
		int maxCastles = xMap*yMap;
		
		if(xMap < Game.MINIMUM_MAP_X_Y || yMap < Game.MINIMUM_MAP_X_Y) {
			res = MAP_TOO_SMALL_ERROR_N;
		}
		
		else if(nKingdoms < Game.MINIMUM_KINGDOMS || nKingdoms > Game.MAXIMUM_KINGDOMS) {
				res = INVALID_N_KINGDOMS_ERROR_N;
		}
			else if(nCastles > maxCastles || nCastles < nKingdoms) {
					res = INVALID_N_CASTLES_ERROR_N;
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
	public int validCastle(int x, int y, int money, String name, int index) {
		int res = NO_ERRORS;
		Point CastlePoint = new Point(x,y);
			
		if(Point.isPosInsideMap(CastlePoint,getMaximumMapPoint().getX(),getMaximumMapPoint().getY())) { 
				res = INVALID_POS_CASTLE_ERROR_N;
			}
				
		if(index > 0) {
					
			for(int i = index-1; i >= 0 && res == NO_ERRORS; i--) 
				if(CastlePoint.isPointEqualTo(Castles.getCastle(i).getCastlePoint())) {
						res = INVALID_POS_CASTLE_ERROR_N;
					}
				}
				
				if(money < 0 && res == NO_ERRORS) {
					res = INVALID_WEALTH_ERROR_N;
				 }
						
				for(int i = index-1; i >= 0 && res == NO_ERRORS; i--) 
					if(name.equals(Castles.getCastle(index-1).getCastleName())) {
						res = DUPLICATE_CASTLE_NAME_ERROR_N;
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
	public int validKingdom(String kingdomName, String castleName, Game G, int index) {
		int res = NO_ERRORS;
		
		if(index > 0) {
			
			for(int i = index-1; i >= 0; i--) 
				if(kingdomName.equals(getKingdomName(i)) && res == NO_ERRORS)
					res = DUPLICATE_KINGDOM_NAME_ERROR_N;
			
			for(int i = index-1; i >= 0; i--) 
				if(castleName.equals(Kingdoms.getConqueredCastleName(i,0)) && res == NO_ERRORS) 
					res = OCCUPIED_CASTLE_ERROR_N;
			
					}
		
		if(Castles.getCastle(castleName) == null && res == NO_ERRORS) 
					res = CASTLE_NON_EXISTANT_ERROR_N;

		return res;
	}
	
	public Point getMaximumMapPoint() {
		return maximumMapPoint;
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
		return Castles.getCastle(i).getCastleKingdomName();
	}
	/**
	 * @param i
	 * @return
	 */
	public Kingdom getKingdom(String kingdomName) {
		return Kingdoms.getKingdom(kingdomName);
	}
	
	public void addCastleToKingdom(String kingdomName, String castleName) {
		Castles.conquerCastle(castleName,kingdomName);
		Kingdoms.getKingdom(kingdomName).conquerCastle(Castles.getCastle(castleName));
	}
	
	public void swapTurn() {
		if(currentKingdomTurn == nKingdoms-1)
			currentKingdomTurn= FIRST_KINGDOM_TURN;
		else
			currentKingdomTurn++;
		
		Castles.SwapTurn();
		
	}
	
	public int currentTurn() {
		return currentKingdomTurn;
	}
	
	public int nOwnedCastles(int Kingdom) {
		return Kingdoms.getKingdom(Kingdom).nOwnedCastles();
	}
		
}
