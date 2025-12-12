package main;

import java.awt.Color;
import java.awt.Graphics2D;

public class Wall extends GameObject {

	private double direction; //facing the wall
	private int distance; //to 0
	private int closeCorner;
	private int farCorner;
	
	private int x1;
	private int x2;
	private int y1;
	private int y2;
	
	public Wall(int x, int y, int length, Direction blockedDirection) {
		this.direction = blockedDirection.getDirection();
		switch (blockedDirection) {
		case NORTH, SOUTH:
			distance = y;
			closeCorner = x;
			farCorner = x + length;
			x1=closeCorner;
			x2=farCorner;
			y1=distance;
			y2=distance;
			break;
		case EAST, WEST:
			distance = x;
			closeCorner = y;
			farCorner = y + length;
			x1=distance;
			x2=distance;
			y1=closeCorner;
			y2=closeCorner;
			break;
		}
	}

	@Override
	public void draw(Graphics2D g) {
		if (Properties.DEBUG_MODE) {
			g.setColor(Color.RED);
			g.drawLine(x1, y1, x2, y2);
		} else {
			g.setColor(Color.WHITE);
			g.drawLine(x1, y1, x2, y2);
		}
		
	}

}
