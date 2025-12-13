package main;

import java.awt.Color;
import java.awt.Graphics2D;

public class Wall extends GameObject {

	private int x;
	private int y; //center coordinates
	private double direction; //blocked direction, facing the wall
	private int radius;
	private boolean horizontal;
	
	public Wall(int x, int y, int lengthUnits, Direction blockedDirection) {
		super(GameObjectType.WALL);
		this.direction = blockedDirection.getDirection();
		radius = lengthUnits * Config.HALF_UNIT;
		switch (blockedDirection) {
		case NORTH, SOUTH:
			this.horizontal = true;
			this.x = x + radius;
			this.y = y;
			break;
		case EAST, WEST:
			this.horizontal = false;
			this.x = x;
			this.y = y + radius;
			break;
		}
	}

	@Override
	public void draw(Graphics2D g) {
		if (Config.DEBUG_MODE) {
			g.setColor(Color.RED);
			if (horizontal) {
				g.drawLine(x-radius, y, x+radius, y);
			}else {
				g.drawLine(x, y-radius, x, y+radius);
			}
		}
	}

}
