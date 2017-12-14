
public class Castles {

	private Castle[] Castles;
	private int counter;
	private int currentCastle;
	
	public Castles(int nCastles) {
		Castles = new Castle[nCastles];
		counter = 0;
		currentCastle = -1;
	}
	
	public void initializeIterator() {
		currentCastle = 0;
	}
	
	public boolean hasNextCastle() {
		return currentCastle >= 0 && currentCastle < counter;
	}
	
	public Castle nextCastle() {
		return Castles[currentCastle++];
	}
	
	public void addCastles(int x, int y, int money, String castleName) {
		Castles[counter++] = new Castle(x,y,money,castleName);
	}
	
	public void addCastles(Castle c) {
		Castles[counter++] = c;
	}
	
	public void conquerCastle(String castleName, String kingdomName) {
		Castles[searchCastleIndex(castleName)].conquerCastle(kingdomName);
	}
	
	private boolean hasCastle(String castleName) {
		return searchCastleIndex(castleName) >= 0;
	}
	
	public Castle getCastle(String castleName) {
		Castle c = null;
		
		if(hasCastle(castleName))
			c = Castles[searchCastleIndex(castleName)];
		
		return c;
	}
	
	
	public Castle getCastle(int i) {
		return Castles[i];
	}
	
	private int searchCastleIndex(String castleName) {
		int res = -1;
		for(int i = 0; i < counter; i++)
			if(Castles[i].getCastleName().equals(castleName))
				res = i;
		
		return res;
	}
	public String getCastleName(int i) {
		return Castles[i].getCastleName();
	}
	
	public int getCastleMoney(int i) {
		return Castles[i].getMoney();
	}
	
	public void changeTurn() {
		for(int i = 0; i < counter; i++)
			Castles[i].incMoneyTurnC();
	}
	
	public int totalMoney() {
		int res = 0;
		for(int i = 0; i < counter; i++)
			res  += Castles[i].getMoney();
		
		return res;
	}
}
