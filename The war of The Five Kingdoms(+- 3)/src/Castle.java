
public class Castle {

	private Point c;
	
	private String castleName;
	private String castleTeam;
	private int money;
	
	
	public Castle(int xCastle, int yCastle,int money, String castleName) {
		c = new Point(xCastle,yCastle);
		this.castleName = castleName;
		this.money =  money;
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
		castleTeam = team;
	}
	public String castleTeam() {
		return castleTeam;
	}
}
