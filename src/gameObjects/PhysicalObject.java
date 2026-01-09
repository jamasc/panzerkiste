package gameObjects;

import java.awt.Graphics2D;

import geometry.HitBox;
import geometry.Vector;
import main.Config;

public abstract class PhysicalObject extends GameObject {
	
	public PhysicalObject(GameObjectType type) {
		super(type);
		// TODO Auto-generated constructor stub
	}
	
	public PhysicalObject() {
		System.out.println("PhysicalObject.PhysicalObject(): Dieser Konstruktor sollte nicht aufgerufen werden!");
	}

	@Override
	public void draw(Graphics2D g) {
		if (Config.DEBUG_MODE) {
			drawHitBox(g);
		}
	}
	
	public abstract int getX();
	
	public abstract int getY();
	
	public abstract HitBox getHitBox();
	
	public double getDirectionTo(PhysicalObject obj) {
		Vector v = Vector.with(obj.getX()-getX(), obj.getY()-getY());
		return v.getDirection();
	}
	
	private void drawHitBox(Graphics2D g) {
		this.getHitBox().draw(g);
	}

}
