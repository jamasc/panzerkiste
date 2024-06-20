// not yet done
// soll liste mit allen bullets machen mit: position x und y, speed, angle


package entities;

import java.awt.Color;
import java.awt.Graphics2D;
import main.Game;

public class Bullet {
	
	Game game;
	private int positionX, positionY;
	private int speed;	//max total speed
	private int angle;	//between 0 and 359
	private float speedX, speedY = 0;	//change of position
	private int extraX, extraY = 0;	//in percent
	private int bulletSize = 8;
	
	public Bullet(Game game, int x, int y, int maxSpeed, int angle) {
		this.game = game;
		this.positionX = x;
		this.positionY = y;
		this.speed = maxSpeed;
		this.angle = angle;
	}
	
	public void update() {
		//x position
		float changeX = speedX + (extraX/100);
		extraX = (int)(changeX * 100) % 100;
		positionX += (int)(changeX);
		//y position
		float changeY = speedY + (extraY/100);
		extraY = (int)(changeY * 100) % 100;
		positionY += (int)(changeY);
	}
	
	public void draw(Graphics2D g2) {
		
		//circle
		g2.setColor(Color.green);
		g2.fillOval(positionX, positionY, bulletSize, bulletSize);
	}
}
