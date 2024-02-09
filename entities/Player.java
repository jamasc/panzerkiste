package entities;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

import main.Game;
import main.KeyHandler;

public class Player extends Panzer{
	
	KeyHandler keyH;
	int xySum;
		
	public Player(Game game, KeyHandler keyH) {
		
		super(game);
		
		this.keyH = keyH;
						
		setDefaultValues();
	}
	
	public void setDefaultValues() {
		//spawn point
		positionX = game.tileSize * 8 - 24;
		positionY = game.tileSize * 6 - 24;
		speed = 4;
	}
	
	public void update() {
		xySum = Math.abs(keyH.xMove) + Math.abs(keyH.yMove);
		speedX = (xySum == 0) ? 0 : (int) ((speed * keyH.xMove) / Math.sqrt(xySum));
		speedY = (xySum == 0) ? 0 : (int) ((speed * keyH.yMove) / Math.sqrt(xySum));
		positionX += speedX;
		positionY += speedY;

	}
	
	public void draw(Graphics2D g2) {
		AffineTransform old = g2.getTransform();
		if(Math.abs(keyH.xMove) + Math.abs(keyH.yMove) == 2) {
			double rotationAngleInRadians = Math.toRadians(45); // Example rotation angle (45 degrees)
			g2.rotate(rotationAngleInRadians, positionX + game.tileSize / 2, positionY + game.tileSize / 2);
			g2.setColor(Color.GREEN);
			g2.fillRect(positionX, positionY, game.tileSize, game.tileSize);
		}else {
			g2.setColor(Color.GREEN);
			g2.fillRect(positionX, positionY, game.tileSize, game.tileSize);
			g2.setTransform(old);
		}
	}
}
