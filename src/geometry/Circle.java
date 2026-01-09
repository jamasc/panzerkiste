package geometry;

import java.awt.Color;
import java.awt.Graphics2D;

public class Circle extends Shape {
	
	public final int x;
	public final int y;
	public final int radius;
	
	public Circle(int x, int y, int radius) {
		this.x = x;
		this.y = y;
		this.radius = radius;
	}

	@Override
	public void draw(Graphics2D g) {
		g.setColor(Color.RED);
		g.drawOval(x-radius, y-radius, 2*radius, 2*radius);
	}

}
