package gameObjects;

import java.awt.Graphics2D;

import geometry.HitBox;
import geometry.Line;
import main.Config;
import main.Direction;

public class LinePiece extends Wall {

	private int radius; //wall spreads this much from center coordinates
	
	public LinePiece(int x, int y, int radius, double blockedDirection) {
		super(x, y, blockedDirection);
		this.radius = radius;
	}
	
	public int getRadius() {
		return radius;
	}

	@Override
	public HitBox getHitBox() {
		return generateHitBox();
	}
	
	private HitBox generateHitBox() {
		Line l = new Line(this.getX(), this.getY(), this.getRadius(), this.getBlockedDirection());
		return new HitBox(l);
	}

}
