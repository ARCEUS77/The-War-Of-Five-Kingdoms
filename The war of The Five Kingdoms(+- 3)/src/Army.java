
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
	
	public void removeSoldier(Soldier S) {
		int index = -1;
		for(int i = 0; i < counter; i++)
			if(S.soldierKingdom().equals(Army[i].soldierKingdom()) && S.getSoldierPoint().equals(Army[i].getSoldierPoint()))
				index = i;
		
		Army[index] = Army[counter-1];
		counter--;
			
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
		Soldier[] tmp = new Soldier[GROWTH_FACTOR*counter];
		for(int i = 0; i<counter; i++) 
			tmp[i] = Army[i];
		
		Army = tmp;
	}
	
	public Soldier getSoldier(int i) {
		return Army[i];
	}
	
	private boolean isFull() {
		return counter == Army.length;
	}
	
	public void recruitSoldier(String soldierType, Castle castle, String Kingdomname) {
		if(isFull())
			resize();
		
		Army[counter++] = new Soldier(soldierType,castle,Kingdomname);
	}
	
	public int getNSoldiers() {
		return counter;
	}
	
	private int searchSoldierIndex(int x, int y) {
		int res = -1;
		for(int i = 0; i < counter && res == -1; i++) {
			Point p = Army[i].getSoldierPoint();
			if(p.getX() == x && p.getY() == y)
				res = i;
		}
		
		return res;
	}
	
	public boolean hasSoldier(int x, int y) {
		return searchSoldierIndex(x,y) >= 0;
	}
	
	public Soldier getSoldier(int x, int y) {
		Soldier s = null;
		
		if(hasSoldier(x,y))
			s = Army[searchSoldierIndex(x,y)];
		
		return s;
	}
	
	public void moveSoldier(int x, int y, String direction) {
		getSoldier(x,y).moveSoldier(direction);
	}
}
