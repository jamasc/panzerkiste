package main;

import java.awt.Color;
import java.awt.Graphics2D;

public class Panzer extends DynamicObject {

	public Panzer(int x, int y) {
		super(x, y, Config.PANZER_HITBOX_RADIUS, GameObjectType.PANZER);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void draw(Graphics2D g) {
		int r = Config.PANZER_HITBOX_RADIUS;
		int x = super.getX() - r;
		int y = super.getY() - r;
		int size = 2 * r;
		g.setColor(Color.white);
		g.fillRect(x, y, size, size);
		super.draw(g);
	}
	
	

}
