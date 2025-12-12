package main;
import java.awt.Graphics;
import java.awt.Graphics2D;

public abstract class GameObject {
	
	public GameObject() {
		// TODO Auto-generated constructor stub
	}
	
	public abstract void draw(Graphics2D g);
	
	public boolean isDead() {
		return false;
	}

}
