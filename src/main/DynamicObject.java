package main;
import java.awt.Graphics;

/**
 * 
 * Ein Objekt in der Kiste, welches sich bewegt.
 * 
 * @author Arne
 *
 */
public abstract class DynamicObject extends GameObject{
	
	private int x;
	private int y;
	private int size;
	
	private int velocity;
	private int direction;

	public DynamicObject(int x, int y, int size) {
		this.x = x;
		this.y = y;
		this.size = size;
	}
	
	public abstract void move();
	
	public void setVelocity(int velocity) {
		this.velocity = velocity;
	}
	
	public void setDirection(int direction) {
		this.direction = direction;
	}

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		g.drawRect(x, y, size, size);
	}

}
