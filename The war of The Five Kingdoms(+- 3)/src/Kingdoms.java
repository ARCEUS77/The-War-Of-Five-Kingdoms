
public class Kingdoms {

	private Kingdom[] Kingdoms;
	private int counter;
	
	public Kingdoms(int nKingdoms, int xmap, int ymap) {
		Kingdoms =  new Kingdom[nKingdoms];
		counter = 0;
	}
	public void addKindom(String teamName, int nCastles, int xmap, int ymap) {
		Kingdoms[counter++] =  new Kingdom(teamName,nCastles,xmap,ymap);
	}
	
	public String kingdomName(int i) {
		return Kingdoms[i].getKingdomName();
	}
	
	public Kingdom getKingdom(int i) {
		return Kingdoms[i];
	}
	
	public Kingdom getKingdom(String kingdomName) {
		Kingdom res = null;
		for(int i = 0; i < counter; i++)
			if(Kingdoms[i].getKingdomName().equals(kingdomName))
				res = Kingdoms[i];
		
		return res;
	}
	
	public String getConqueredCastleName(int kingdomIndex,int castleIndex) {
		return Kingdoms[kingdomIndex].getConqueredCastleName(castleIndex);
	}
}
