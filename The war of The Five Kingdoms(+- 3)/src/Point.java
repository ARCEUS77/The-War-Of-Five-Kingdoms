
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
	
	public  boolean isPointOutsideMap(int xMap, int yMap) {
		return (x < 1 || x > xMap || y < 1 || y> yMap);
	}
	
	public boolean isPointEqualTo(Point OtherPoint) {
		return (x == OtherPoint.getX() &&
				y == OtherPoint.getY());
	}
	
	public boolean isMovingOutOfMap(int xmap, int ymap, String direction) {
		Point temp = new Point(x,y);
		temp.move(direction);
		
		return temp.isPointOutsideMap(xmap, ymap);
	}
	
	public boolean alliedObstruction(String direction, Kingdom K) {
		boolean res = false;
		Point P = new Point(x,y);
		P.move(direction);
		
		for(int i = 0; i < K.getNSoldiers(); i++)
			if(P.isPointEqualTo(K.getSoldier(i).getSoldierPoint()))
				res = true;
		
		return res;
		
		
	}
	
}
