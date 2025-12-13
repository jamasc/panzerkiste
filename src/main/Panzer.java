package main;

import java.awt.Color;
import java.awt.Graphics2D;

public class Panzer extends DynamicObject {

	public Panzer(int xTile, int yTile) {
		super(xTile*Properties.TILE_SIZE-Properties.HALF_UNIT*Properties.UNITS_PER_TILE,
				yTile*Properties.TILE_SIZE-Properties.HALF_UNIT*Properties.UNITS_PER_TILE, 
				Properties.PANZER_HITBOX_RADIUS);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void draw(Graphics2D g) {
		int r = Properties.PANZER_HITBOX_RADIUS;
		int x = super.getX() - r;
		int y = super.getY() - r;
		int size = 2 * r;
		g.setColor(Color.white);
		g.fillRect(x, y, size, size);
		super.draw(g);
	}
	
	

}
