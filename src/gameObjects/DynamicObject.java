package gameObjects;
import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;

import geometry.Circle;
import geometry.HitBox;
import geometry.Vector;
import main.Config;

/**
 * 
 * Ein Objekt in der Kiste, welches sich bewegt.
 * 
 * @author Arne
 *
 */
public abstract class DynamicObject extends PhysicalObject{
	
	private double x;
	private double y;
	private int hitboxRadius;
	
	private double velocity;
	private double direction; //in radians, 0 is east, clockwise
	
	private ArrayList<Double> blockedDirections;

	public DynamicObject(int x, int y, int radius, GameObjectType type) {
		super(type);
		this.x = x;
		this.y = y;
		this.hitboxRadius = radius;
		this.blockedDirections = new ArrayList<Double>();
	}
	
	public void move() {
		Vector d = Vector.normVector(direction).multiplyBy(velocity);
		for (double block : blockedDirections) {
			Vector correction = Vector.getPartFacing(d, block);
			d = d.add(correction.multiplyBy(-1));
		}
		blockedDirections.clear();
		x = x + d.x;
		y = y + d.y;
	}
	
	public void blockDirection(double block) {
		blockedDirections.add(block);
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
	
	public void setDirection(double direction) {
		this.direction = direction;
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
	
	public double getDirection() {
		return this.direction;
	}
	
	@Override
	public HitBox getHitBox() {
		return generateHitBox();
	}
	
	private HitBox generateHitBox() {
		Circle c = new Circle(this.getX(), this.getY(), this.getHitboxRadius());
		return new HitBox(c);
	}


}
