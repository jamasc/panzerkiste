package entities;

import java.awt.Color;
import java.awt.Graphics2D;

import main.Game;

public class Panzer {
	
	Game game;
	public int positionX, positionY;
	public int speed, speedX, speedY;
	
	public Panzer(Game game) {
		this.game = game;
	}
		
	public void update() {
		positionX += speedX;
		positionY += speedY;
	}
	
	public void draw(Graphics2D g2) {
		
		//rectangle
		g2.setColor(Color.RED);
		g2.drawRect(positionX, positionY, game.tileSize, game.tileSize);
	}
}

