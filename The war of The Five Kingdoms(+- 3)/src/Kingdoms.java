
public class Kingdoms {

	private Kingdom[] Kingdoms;
	private int counter;
	
	public Kingdoms(int nKingdoms) {
		Kingdoms =  new Kingdom[nKingdoms];
		counter = 0;
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
	
	public String getConqueredCastleName(int kingdomIndex,int castleIndex) {
		return Kingdoms[kingdomIndex].getConqueredCastleName(castleIndex);
	}
	
	private boolean greaterThan(String kingdomName, String other) {
		return kingdomName.compareTo(other) > 0;
	}
	
	public void bubbleSort(Game G) {
		for(int i = 1; i < counter; i++)
			for(int j = counter-1; j >= i; j--)
				if(greaterThan(Kingdoms[i].getKingdomName(),Kingdoms[j].getKingdomName())) {
					Kingdom temp = Kingdoms[j-1];
					Kingdoms[j-1] = Kingdoms[j];
					Kingdoms[j] = temp;
				}
	}
}
