
public class Soldier {

	public static final String KNIGHT = "cavaleiro";
	public static final String SWORDSMAN = "espadachim";
	public static final String LANCER = "lanceiro";
	
	private String soldierType;
	private Point soldierPos;
	private String Kingdom;
	
	public Soldier(String soldierType,Castle castle, String Kingdom) {
		this.soldierType = soldierType;
		soldierPos = new Point(castle.getXCastle(),castle.getYCastle());
		this.Kingdom =  Kingdom;
	}
	
	public int getSoldierX() {
		return soldierPos.getX();
	}
	
	public int getSoldierY() {
		return soldierPos.getX();
	}
	
	public String getSoldier() {
		return soldierType;
	}
	
	public String soldierKingdom() {
		return Kingdom;
	}
}
