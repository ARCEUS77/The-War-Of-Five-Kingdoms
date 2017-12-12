
public class Castles {

	private Castle[] Castles;
	private int counter;
	private int currentCastle;
	
	public Castles(int nCastles) {
		Castles = new Castle[nCastles];
		counter = 0;
		currentCastle = -1;
	}
	
	public void addCastles(int x, int y, int money, String castleName) {
		Castles[counter++] = new Castle(x,y,money,castleName);
	}
	
	public void addCastles(Castle c) {
		Castles[counter++] = c;
	}
	
	public void conquerCastle(int i, String kingdomName) {
		Castles[i].conquerCastle(kingdomName);
	}
	
	public void initializeCastleIterator() {
		currentCastle = 0;
	}
	
	public Castle getCastle(String castleName) {
		return Castles[searchCastleIndex(castleName)];
	}
	
	public String getCastleName(int i) {
		return Castles[i].getCastleName();
	}
	
	private int searchCastleIndex(String castleName) {
		int res = -1;
		for(int i = 0; i < counter; i++)
			if(Castles[i].getCastleName().equals(castleName))
				res = i;
		
		return res;
	}
	
	public int getCastleMoney(int i) {
		return Castles[i].getMoney();
	}
	
}
