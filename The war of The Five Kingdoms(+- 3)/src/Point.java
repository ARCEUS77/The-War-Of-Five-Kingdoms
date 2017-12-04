
public class Point {

	public static final String XCOORD = "x";
	public static final String YCOORD = "y";
	
	public static final String NORTH = "norte";
	public static final String SOUTH = "sul";
	public static final String EAST = "este";
	public static final String WEST = "oeste";
	
	private int x,y;
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public void move(String direction) {
		switch(direction) {
		
		case NORTH:
			y++;
			break;
			
		case SOUTH:
			y--;
			break;
			
		case EAST:
			x++;
			break;
			
		case WEST:
			x--;
			break;
		}
	}
	
}
