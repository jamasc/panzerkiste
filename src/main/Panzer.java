package main;

import java.awt.Graphics2D;

public class Panzer extends DynamicObject {

	public Panzer(int x, int y) {
		super(x, y, Properties.PANZER_HITBOX_RADIUS);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void draw(Graphics2D g) {
		// TODO Auto-generated method stub
		super.draw(g);
		int r = super.getHitboxRadius();
		int x = super.getX() - r;
		int y = super.getY() - r;
		int size = 2 * r;
		g.drawRect(x, y, size, size);
	}
	
	

}
