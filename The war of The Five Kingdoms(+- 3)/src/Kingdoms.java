
public class Kingdoms {

	private Kingdom[] Kingdoms;
	private Kingdom[] ordKingdoms;
	private int counter;
	private int currentKingdom;
	private int currentKOrd;
	
	public Kingdoms(int nKingdoms) {
		Kingdoms =  new Kingdom[nKingdoms];
		counter = 0;
		currentKingdom = -1;
		currentKOrd = -1;
	}
	
	public void initializeIterator() {
		currentKingdom = 0;
	}
	
	public boolean hasNextKingdom() {
		return currentKingdom >= 0 && currentKingdom < counter;
	}
	
	public Kingdom nextKingdom() {
		return Kingdoms[currentKingdom++];
	}
	
	public void addKingdom(String teamName, int nCastles) {
		Kingdoms[counter++] =  new Kingdom(teamName,nCastles);
	}
	
	public String GetKingdomName(int i) {
		return Kingdoms[i].getKingdomName();
	}
	
	private int searchKingdomIndex(String kingdomName) {
		int res = -1;
		for(int i = 0;i < counter && res == -1;i++)
			if(Kingdoms[i].getKingdomName().equals(kingdomName))
				res = i;
		
		return res;
	}
	
	public Kingdom getKingdom(String kingdomName) {
		return Kingdoms[searchKingdomIndex(kingdomName)];
	}
	
	public Kingdom getKingdom(int i) {
		return Kingdoms[i];
	}
	
	public Soldier getSoldier(int x,int y, Kingdom k) {
		return k.getSoldier(x,y);
	}
	
	public String getConqueredCastleName(int kingdomIndex,int castleIndex) {
		return Kingdoms[kingdomIndex].getConqueredCastleName(castleIndex);
	}
	
	private void bubbleSort(Kingdom[] Kingdoms) {
		for(int i = 1; i < counter; i++)
			for(int j = counter-1; j >= i; j--)
				if(Kingdoms[j-1].greaterThan(Kingdoms[j])) {
					Kingdom temp = Kingdoms[j-1];
					Kingdoms[j-1] = Kingdoms[j];
					Kingdoms[j] = temp;
				}
	}
	
	public int nActiveKingdoms() {
		int res = 0;
		for(int i = 0; i < counter; i++)
			if(Kingdoms[i].isKingdomActive())
				res++;
		
		return res;
	}
	
	public void initializeOrdIterator() {
		ordKingdoms = new Kingdom[counter];
		for(int i = 0; i < counter; i++)
			ordKingdoms[i] = Kingdoms[i];
		bubbleSort(ordKingdoms);
		currentKOrd = 0;
		
	}
	
	public boolean hasNextOrd() {
		return currentKOrd >= 0 && currentKOrd < counter;
	}
	
	public Kingdom nextOrd() {
		return ordKingdoms[currentKOrd++];
	}
	
	public void initializeArmyIterator(String kingdomName) {
		Kingdoms[searchKingdomIndex(kingdomName)].initializeArmyIterator();
	}
	
	public boolean hasNextSoldier(String kingdomName) {
		return Kingdoms[searchKingdomIndex(kingdomName)].hasNextSoldier();
	}
	
	public Soldier nextSoldier(String kingdomName) {
		return Kingdoms[searchKingdomIndex(kingdomName)].nextSoldier();
	}
}
