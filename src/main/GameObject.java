package main;
import java.awt.Graphics;

public abstract class GameObject {
	
	public GameObject() {
		// TODO Auto-generated constructor stub
	}
	
	public abstract void draw(Graphics g);
	
	public boolean isDead() {
		return false;
	}

}
