package entities;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

import main.Game;

public class Panzer {
	
	Game game;
	int[] position = new int[2];
	int speed;
	float speedX, speedY = 0;
	int extraX, extraY = 0;	//in percent
	
	int tankSize = 40;
	int circSize = 30;
	
	public Panzer(Game game, int x, int y, int maxSpeed) {
		this.game = game;
		this.position[0] = x;
		this.position[1] = y;
		this.speed = maxSpeed;
	}
	
	public void setDirection(float x, float y) {
		this.speedX = x * speed;
		this.speedY = y * speed;
	}
		
	public void update() {
		speedX = speedX + (extraX/100);
		extraX = (int)(speedX * 100) % 100;
		speedY = speedY + (extraY/100);
		extraY = (int)(speedY * 100) % 100;
		position[0] += (int)(speedX);
		position[1] += (int)(speedY);
	}
	
	public void draw(Graphics2D g2) {
		AffineTransform old = g2.getTransform();
		if((int)(speedX) != 0 && (int)(speedY) != 0) {
			double rotationAngleInRadians = Math.toRadians(45); // Example rotation angle (45 degrees)
			g2.rotate(rotationAngleInRadians, position[0] + tankSize / 2, position[1] + tankSize / 2);
		}
		g2.setColor(Color.GREEN);
		g2.fillRect(position[0], position[1], tankSize, tankSize);
		g2.setTransform(old);
		int circleX = position[0] + (tankSize - circSize) / 2;
		int circleY = position[1] + (tankSize - circSize) / 2;
		g2.setColor(Color.RED);
		g2.fillOval(circleX, circleY, circSize, circSize);
	}
}

