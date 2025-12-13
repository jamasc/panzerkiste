package main;
import java.awt.Graphics;
import java.awt.Graphics2D;

public abstract class GameObject {
	
	public GameObject() {
		
	}
	
	public abstract void draw(Graphics2D g);
	
	public boolean isDead() {
		return false;
	}

}
