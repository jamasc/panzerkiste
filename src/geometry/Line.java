package geometry;

public class Line extends Shape {

	public final int x;
	public final int y;
	public final int radius;
	public final double direction;
	
	public Line(int x, int y, int radius, double direction) {
		this.x = x;
		this.y = y;
		this.radius = radius;
		this.direction = direction;
	}

}
