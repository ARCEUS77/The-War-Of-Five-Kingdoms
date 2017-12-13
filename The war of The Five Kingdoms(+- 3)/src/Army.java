
public class Army {
	private static final int DEFAULT_SIZE = 1;
	private static final int GROWTH_FACTOR = 2;
	private Soldier[] Army;
	private int counter;
	
	public Army() {
		Army =  new Soldier[DEFAULT_SIZE];
		counter = 0;
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
		
		Army[counter] = new Soldier(soldierType,castle,Kingdomname);
	}
	
	public int getNSoldiers() {
		return counter;
	}
}
