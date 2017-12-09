
public class Castle {

	public static final String NO_OWNER = "sem dono";
	
	private Point c;
	private String castleName;
	private String castleKingdomName;
	private int money;
	
	
	public Castle(int xCastle, int yCastle,int money, String castleName) {
		c = new Point(xCastle,yCastle);
		this.castleName = castleName;
		this.money =  money;
		castleKingdomName = NO_OWNER;
		
	}
	
	public int getXCastle() {
		return c.getX();
	}
	
	public int getYCastle() {
		return c.getY();
	}
	
	public String getCastleName() {
		return castleName;
	}
	public void conquerCastle(String team) {
		castleKingdomName = team;
	}
	public String getCastleKingdomName() {
		return castleKingdomName;
	}
	
	public int getMoney() {
		return money;
	}
}
