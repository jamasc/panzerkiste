package main;

import java.awt.Color;
import java.awt.Graphics2D;

public class Grid extends GameObject {

	public Grid() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void draw(Graphics2D g) {
		int unten = Properties.SCREEN_HEIGTH;
		int rechts = Properties.SCREEN_WIDTH;
		g.setColor(Color.CYAN);
		for (int x = 0; x <= Properties.HORIZONTAL_NUMBER_OF_TILES; x++) {
			int xp = x*Properties.TILE_SIZE;
			g.drawLine(xp, 0, xp, unten);
		}
		for (int y = 0; y <= Properties.VERTICAL_NUMBER_OF_TILES; y++) {
			int yp = y*Properties.TILE_SIZE;
			g.drawLine(0,  yp,  rechts,  yp);
		}
	}

}
