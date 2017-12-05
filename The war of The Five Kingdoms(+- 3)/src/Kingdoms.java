
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
	
	public String teamName(int i) {
		return Kingdoms[i].getTeamName();
	}
	
	public Kingdom getKingdom(int i) {
		return Kingdoms[i];
	}
	
	public String getConqueredCastleName(int kingdomIndex,int castleIndex) {
		return Kingdoms[kingdomIndex].getConqueredCastleName(castleIndex);
	}
}
