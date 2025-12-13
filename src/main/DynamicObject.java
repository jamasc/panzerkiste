package main;
import java.awt.Color;
import java.awt.Graphics2D;

/**
 * 
 * Ein Objekt in der Kiste, welches sich bewegt.
 * 
 * @author Arne
 *
 */
public abstract class DynamicObject extends GameObject{
	
	private double x;
	private double y;
	private int hitboxRadius;
	
	private double velocity;
	private double direction; //in radians, 0 is east, clockwise

	public DynamicObject(int x, int y, int radius, GameObjectType type) {
		super(type);
		this.x = x;
		this.y = y;
		this.hitboxRadius = radius;
	}
	
	public void move() {
		double dx = 0;
		double dy = 0;
		dx = velocity*Math.cos(direction);
		dy = velocity*Math.sin(direction);
		x = x + dx;
		y = y + dy;
	}
	
	public void setVelocity(double velocity) {
		if (velocity < 0) {
			this.velocity = 0;
		} else if (velocity > Config.MAX_VELOCITY) {
			this.velocity = Config.MAX_VELOCITY;
		} else {
			this.velocity = velocity;
		}
	}
	
	public void setDirection(int direction) {
		this.direction = direction;
	}

	@Override
	public void draw(Graphics2D g) {
		if (Config.DEBUG_MODE) {
			int r = this.hitboxRadius;
			int x = this.getX();
			int y = this.getY();
			g.setColor(Color.RED);
			g.drawOval(x-r, y-r, 2*r, 2*r);
		}
	}
	
	public int getX() {
		return (int) x;
	}

	public int getY() {
		return (int) y;
	}

	public int getHitboxRadius() {
		return this.hitboxRadius;
	}

}
