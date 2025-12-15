package geometry;

import java.awt.Color;
import java.awt.Graphics2D;

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

	@Override
	public void draw(Graphics2D g) {
		Vector m = Vector.with(x, y);
		double rightangle = Math.PI/2;
		Vector s = Vector.normVector(direction+rightangle).multiplyBy(radius);
		Vector k1 = m.add(s);
		Vector k2 = m.add(s.multiplyBy(-1));
		g.setColor(Color.RED);
		g.drawLine((int)k1.x,(int)k1.y,(int)k2.x,(int)k2.y);
	}

}
