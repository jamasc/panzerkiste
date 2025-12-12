package main;

import java.awt.Graphics2D;

public class Rakete extends DynamicObject {

	public Rakete(int x, int y) {
		super(x, y, Properties.RAKETE_HITBOX_RADIUS);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void draw(Graphics2D g) {
		// TODO Auto-generated method stub
		super.draw(g);
		int r = Properties.RAKETE_HITBOX_RADIUS;
		int x = super.getX();
		int y = super.getY();
		g.drawRect(x - 3*r, y-r, 3*r, 2*r);
	}

}
