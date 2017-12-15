
public class Soldier {

	public static final String KNIGHT = "cavaleiro";
	public static final String SWORDSMAN = "espadachim";
	public static final String LANCER = "lanceiro";
	
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
}
