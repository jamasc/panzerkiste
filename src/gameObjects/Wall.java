package gameObjects;

import java.awt.Color;
import java.awt.Graphics2D;

import main.Config;
import main.Direction;

public class Wall extends GameObject {

	private int x;
	private int y; //center coordinates
	private double direction; //blocked direction, facing the wall
	private int radius; //wall spreads this much from center coordinates
	private boolean vertical; //false if wall is horizontal, true if vertical
	
	public Wall(int x, int y, int radius, Direction blockedDirection) {
		super(GameObjectType.WALL);
		this.direction = blockedDirection.getDirection();
		this.radius = radius;
		this.x = x;
		this.y = y;
		switch (blockedDirection) {
		case NORTH, SOUTH:
			vertical = false;
			break;
		case EAST, WEST:
			vertical = true;
			break;
		}
	}

	@Override
	public void draw(Graphics2D g) {
		if (Config.DEBUG_MODE) {
			g.setColor(Color.RED);
			if (!vertical) {
				g.drawLine(x-radius, y, x+radius, y);
			}else {
				g.drawLine(x, y-radius, x, y+radius);
			}
		}
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public int getRadius() {
		return radius;
	}
	
	public double getBlockedDirection() {
		return direction;
	}
	
	public boolean isVertical() {
		return vertical;
	}
	
	public boolean isHorizontal() {
		return !vertical;
	}

}
