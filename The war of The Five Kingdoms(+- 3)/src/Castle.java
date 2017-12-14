
public class Castle {

	public static final String NO_OWNER = "sem dono";
	
	private Point castlePoint;
	private String castleName;
	private String castleKingdomName;
	private int money;
	
	
	public Castle(int xCastle, int yCastle,int money, String castleName) {
		castlePoint = new Point(xCastle,yCastle);
		this.castleName = castleName;
		this.money =  money;
		castleKingdomName = NO_OWNER;
	}
	
	public Point getCastlePoint() {
		return castlePoint;
	}
	
	public String getCastleName() {
		return castleName;
	}
	public void conquerCastle(String kingdomName) {
		castleKingdomName = kingdomName;
	}
	public String getCastleKingdomName() {
		return castleKingdomName;
	}
	
	public int getMoney() {
		return money;
	}
	
	public void incMoneyTurnC() {
		money++;
	}
}
