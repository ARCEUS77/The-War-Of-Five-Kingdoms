
public class Castle {

	public static final String NO_OWNER = "sem dono";
	
	private Point castlePoint;
	private String castleName;
	private String castleKingdomName;
	private int money;
	private boolean isOccupied;
	
	
	public Castle(int xCastle, int yCastle,int money, String castleName) {
		castlePoint = new Point(xCastle,yCastle);
		this.castleName = castleName;
		this.money =  money;
		castleKingdomName = NO_OWNER;
		isOccupied = false;
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
	
	public int recruitCost(String Type) {
		int cost = 0;
		if(Type.equals(Soldier.KNIGHT)) {
			money -= 4;
			cost = 4;
		}
		else {
			money -= 2;
			cost = 2;
		}
		
		return cost;
	}
	
	public void occupyCastle() {
		isOccupied = true;
	}
	
	public void leaveCastle() {
		isOccupied = false;
	}
	
	public boolean isOccupied(){
		return isOccupied;	
	}
}
