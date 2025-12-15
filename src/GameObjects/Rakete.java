package GameObjects;

import java.awt.Color;
import java.awt.Graphics2D;

import main.Config;

public class Rakete extends DynamicObject {

	public Rakete(int x, int y) {
		super(x, y, Config.RAKETE_HITBOX_RADIUS, GameObjectType.RAKETE);
		// TODO Auto-generated constructor stub
	}
	
	public void bounce(double blockedDirection) {
		Vector base = Vector.normVector(this.getDirection());
		Vector correction = Vector.getPartFacing(base, blockedDirection);
		correction = correction.multiplyBy(-2);
		base = base.add(correction);
		this.setDirection(base.getDirection());
	}

	@Override
	public void draw(Graphics2D g) {
		int r = Config.RAKETE_HITBOX_RADIUS;
		int x = super.getX();
		int y = super.getY();
		g.setColor(Color.WHITE);
		g.fillRect(x - 3*r, y-r, 3*r, 2*r);
		g.fillOval(x-r, y-r, 2*r, 2*r);
		super.draw(g);
	}

}
