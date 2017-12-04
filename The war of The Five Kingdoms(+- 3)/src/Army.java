
public class Army {

	private Soldier[] Army;
	private int counter;
	
	public Army(int xmap, int ymap) {
		Army =  new Soldier[xmap*ymap];
		counter = 0;
	}
	
	public void recruitSoldier(String soldierType, Castle castle, String Kingdomname) {
		Army[counter] = new Soldier(soldierType,castle,Kingdomname);
	}
}
