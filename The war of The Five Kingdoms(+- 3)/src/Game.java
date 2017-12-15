
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
	public static final int UNKNOWN_SOLDIER_TYPE_ERROR_N = 12;
	public static final int ILLEGAL_CASTLE_INVASION_ERROR_N = 13;
	public static final int NO_MONEY_FOR_RECRUIT_ERROR_N = 14;
	public static final int CASTLE_OCCUPIED_BY_SOLDIER_ERROR_N = 15;
	public static final int NON_EXISTANT_SOLDIER_ERROR_N = 16;
	public static final int SOLDIER_OUT_OF_MAP_ERROR_N = 17;
	public static final int ALLY_OBSTRUCTION_ERROR_N = 18;
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
	
	public static final int KINGDOMS_IT = 0;
	public static final int CASTLES_IT = 1;
	
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
	
	public void initializeIterator(int type) {
		
		if(type == KINGDOMS_IT)
			Kingdoms.initializeIterator();
		else
			Castles.initializeIterator();
	}
	
	public void initializeArmyIterator(String kingdomName) {
		Kingdoms.initializeArmyIterator(kingdomName);
	}
	
	public boolean hasNext(int type) {
		boolean res = false;
		
		if(type == KINGDOMS_IT)
			res = Kingdoms.hasNextKingdom();
		else
			res = Castles.hasNextCastle();
		
		return res;
	}
	
	public boolean hasNextSoldier(String kingdomName) {
		return Kingdoms.hasNextSoldier(kingdomName);
	}
	
	public Kingdom nextKingdom() {
		return Kingdoms.nextKingdom();
	}
	
	public Castle nextCastle() {
		return Castles.nextCastle();
	}
	
	public Soldier nextSoldier(String kingdomName) {
		return Kingdoms.nextSoldier(kingdomName);
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
			
		if(CastlePoint.isPointOutsideMap(getMaximumMapPoint().getX(),getMaximumMapPoint().getY())) { 
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
	
	public int validRecruit(String type, String castleName, Kingdom K) {
		int res = NO_ERRORS;
		
		switch(type) {
		
		case Soldier.KNIGHT:
			break;
			
		case Soldier.LANCER:
			break;
			
		case Soldier.SWORDSMAN:
			break;
			
		default:
			res = UNKNOWN_SOLDIER_TYPE_ERROR_N;
		}
		
		if(K.getCastle(castleName) == null && res == NO_ERRORS)
			res = ILLEGAL_CASTLE_INVASION_ERROR_N;
		
		else if(K.getCastle(castleName).getMoney() < 2 && !type.equals(Soldier.KNIGHT) ||
				K.getCastle(castleName).getMoney() < 4 && type.equals(Soldier.KNIGHT)  && res == NO_ERRORS)
			res = NO_MONEY_FOR_RECRUIT_ERROR_N;
		
		else if(K.getCastle(castleName).isOccupied() && res == NO_ERRORS)
			res = CASTLE_OCCUPIED_BY_SOLDIER_ERROR_N;
			
		return res;
	}
	
	public int validMovement(int x, int y, String direction, Kingdom K) {
		int res = NO_ERRORS;
		
		if(K.getSoldierPoint(x,y).isMovingOutOfMap(maximumMapPoint.getX(),maximumMapPoint.getY(),direction))
			res = SOLDIER_OUT_OF_MAP_ERROR_N;
		
		else if(K.getSoldierPoint(x,y).alliedObstruction(direction,K))
			res = ALLY_OBSTRUCTION_ERROR_N;
		
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
	
	public Kingdom getKingdom(int i) {
		return Kingdoms.getKingdom(i);
	}
	
	public void addCastleToKingdom(String kingdomName, String castleName) {
		Castles.conquerCastle(castleName,kingdomName);
		Kingdoms.getKingdom(kingdomName).conquerCastle(Castles.getCastle(castleName));
	}
	
	public void swapTurn() {
		if(currentKingdomTurn == nKingdoms-1)
			currentKingdomTurn = FIRST_KINGDOM_TURN;
		else
			currentKingdomTurn++;
		
		Castles.changeTurn();
	}
	
	public int currentTurn() {
		return currentKingdomTurn;
	}
	
	public int nOwnedCastles(int Kingdom) {
		return Kingdoms.getKingdom(Kingdom).getNOwnedCastles();
	}
	
	public int nActiveKingdoms() {
		return Kingdoms.nActiveKingdoms();
	}
	
	public void initializeOrdIterator() {
		Kingdoms.initializeOrdIterator();
	}
	
	public boolean hasNextOrd() {
		return Kingdoms.hasNextOrd();
	}
	
	public Kingdom nextOrd() {
		return Kingdoms.nextOrd();
	}
	
	public void moveSoldier(int x, int y, String direction, Kingdom K) {
		K.moveSoldier(x,y,direction);
	}
		
}
