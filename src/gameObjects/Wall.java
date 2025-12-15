package gameObjects;

import java.awt.Color;
import java.awt.Graphics2D;

import main.Config;
import main.Direction;

public abstract class Wall extends PhysicalObject {

	private int x;
	private int y;
	private double blockedDirection;
	
	public Wall(int x, int y, double blockedDirection) {
		super(GameObjectType.WALL);
		this.x = x;
		this.y = y;
		this.blockedDirection = blockedDirection;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public double getBlockedDirection() {
		return blockedDirection;
	}

}
