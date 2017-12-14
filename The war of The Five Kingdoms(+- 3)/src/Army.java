
public class Army {
	private static final int DEFAULT_SIZE = 1;
	private static final int GROWTH_FACTOR = 2;
	private Soldier[] Army;
	private int counter;
	private int currentSoldier;
	
	public Army() {
		Army =  new Soldier[DEFAULT_SIZE];
		counter = 0;
	}
	
	public void initializeIterator() {
		currentSoldier = 0;
	}
	
	public boolean hasNextSoldier() {
		return currentSoldier >= 0 && currentSoldier < counter;
	}
	
	public Soldier nextSoldier() {
		return Army[currentSoldier++];
	}
	
	private void resize() {
		Soldier[] tmp = new Soldier[GROWTH_FACTOR*DEFAULT_SIZE];
		for(int i = 0; i<counter; i++) 
			tmp[i] = Army[i];
		
		Army = tmp;
	}
	
	public Soldier getSoldier(int i) {
		return Army[i];
	}
	
	private boolean isFull() {
		return counter==Army.length;
	}
	
	public void recruitSoldier(String soldierType, Castle castle, String Kingdomname) {
		if(isFull())
			resize();
		
		Army[counter++] = new Soldier(soldierType,castle,Kingdomname);
	}
	
	public int getNSoldiers() {
		return counter;
	}
	
	private int searchSoldierIndex(int x, int y, String type) {
		int res = -1;
		for(int i = 0; i < counter && res == -1; i++) {
			Soldier s = Army[i];
			Point p = s.getSoldierPoint();
			if(p.getX() == x && p.getY() == y && s.getSoldierType().equals(type))
				res = i;
		}
		
		return res;
	}
	
	private boolean hasSoldier(int x, int y, String type) {
		return searchSoldierIndex(x,y,type) >= 0;
	}
	
	public Soldier getSoldier(int x, int y, String type) {
		Soldier s = null;
		
		if(hasSoldier(x,y,type))
			s = Army[searchSoldierIndex(x,y,type)];
		
		return s;
	}
	
	public void moveSoldier(int x, int y, String type, String direction) {
		getSoldier(x,y,type).moveSoldier(direction);
	}
}
