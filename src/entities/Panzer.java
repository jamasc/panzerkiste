package entities;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

import main.Game;

public class Panzer {
	
	Game game;
	private int positionX, positionY;
	private int speed;	//max total speed
	private float speedX, speedY = 0;	//change of position
	private int extraX, extraY = 0;	//in percent
	private int aimX, aimY;	//position of mouse
	private int tankSize = 40;	//side length of the tank 

	public Panzer(Game game, int x, int y, int maxSpeed) {
		this.game = game;
		this.positionX = x;
		this.positionY = y;
		this.speed = maxSpeed;
	}
	
	//takes (x,y) and sets the speed 
	// |(x,y)| = 1
	public void setDirection(float x, float y) {
		speedX = x * speed;
		speedY = y * speed;
	}
	
	public void setAim(int mouseX, int mouseY) {
		aimX = mouseX; 
		aimY = mouseY; 
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
		
		//square
		AffineTransform old = g2.getTransform();
		if((int)(speedX) != 0 && (int)(speedY) != 0) {
			double rotationAngleInRadians = Math.toRadians(45); // Example rotation angle (45 degrees)
			g2.rotate(rotationAngleInRadians, positionX + tankSize / 2, positionY + tankSize / 2);
		}
		g2.setColor(Color.GREEN);
		g2.fillRect(positionX, positionY, tankSize, tankSize);
		g2.setTransform(old);
		//aim line (can be updated later to gun shaft and maybe dotted line with set amount of dots)
		g2.setColor(Color.BLUE);
        float thickness = 2.0f;
        g2.setStroke(new BasicStroke(thickness));
        g2.drawLine(positionX + (tankSize / 2), positionY + (tankSize / 2), aimX, aimY);
	}
}

