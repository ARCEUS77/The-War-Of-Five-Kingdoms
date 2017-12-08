
public class Castles {

	private Castle[] Castles;
	private int counter;
	
	public Castles(int nCastles) {
		Castles = new Castle[nCastles];
		counter = 0;
	}
	
	public Castle getCastle(String castleName) {
		Castle c = null;
		
		for(int i = 0; i < counter; i++) {
			if(castleName.equals(Castles[i].getCastleName()))
				c = Castles[i];
		}
		
		return c;
	}
	
	public void addCastles(int x, int y, int money, String castleName) {
		Castles[counter++] = new Castle(x,y,money,castleName);
	}
	
	public void conquerCastle(String kingdomName,Castle castle) {
		castle.conquerCastle(kingdomName);
	}
	
	public Castle getCastle(int i) {
		return Castles[i];
	}
	
	public int getCastleMoney(int i) {
		return Castles[i].getMoney();
	}
	
}
