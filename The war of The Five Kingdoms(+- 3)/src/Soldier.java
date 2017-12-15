
public class Soldier {

	public static final String KNIGHT = "cavaleiro";
	public static final String SWORDSMAN = "espadachim";
	public static final String LANCER = "lanceiro";
	
	public static final int NO_RESULT = 0;
	public static final int ENEMY_LOSES = 10;
	public static final int ENEMY_WINS = 20;
	
	private String soldierType;
	private Point soldierPoint;
	private String Kingdom;
	
	
	public Soldier(String soldierType,Castle castle, String Kingdom) {
		this.soldierType = soldierType;
		soldierPoint = new Point(castle.getCastlePoint().getX(),castle.getCastlePoint().getY());
		this.Kingdom =  Kingdom;
	}
	
	public Point getSoldierPoint() {
		return soldierPoint;
	}
	
	public String getSoldierType() {
		return soldierType;
	}
	
	public String soldierKingdom() {
		return Kingdom;
	}
	
	public void moveSoldier(String direction) {
		soldierPoint.move(direction);
	}
	
	public int fightResult(String enemyType) {
		int result = NO_RESULT;
		
		if(soldierType.equals(enemyType) ||
			soldierType.equals(KNIGHT) && enemyType.equals(SWORDSMAN) ||
			soldierType.equals(SWORDSMAN) && enemyType.equals(LANCER) || 
			soldierType.equals(LANCER) && enemyType.equals(KNIGHT))
			result = ENEMY_LOSES;
		
		else if(soldierType.equals(KNIGHT) && enemyType.equals(LANCER) ||
				soldierType.equals(LANCER) && enemyType.equals(SWORDSMAN) ||
				soldierType.equals(SWORDSMAN) && enemyType.equals(KNIGHT))
			result = ENEMY_WINS;
		
		return result;
	}
}
