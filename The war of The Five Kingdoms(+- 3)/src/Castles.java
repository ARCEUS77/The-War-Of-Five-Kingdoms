
public class Castles {

	private Castle[] Castles;
	private int counter;

	
	public Castles(int nCastles) {
		Castles = new Castle[nCastles];
		counter = 0;
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
	
	public Castle getCastle(String castleName) {
		Castle c = null;
		int index = searchCastleIndex(castleName);
		
		if(index == -1)
			c =  null;
		else
			c = Castles[index];
		
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
	
	public void SwapTurn() {
		for(int i = 0; i < counter; i++)
			Castles[i].changeTurn();
	}
}
