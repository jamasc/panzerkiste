package gameObjects;
import java.awt.Graphics;
import java.awt.Graphics2D;

public abstract class GameObject {
	
	private final GameObjectType type;
	private boolean alive;
	
	public GameObject(GameObjectType type) {
		this.type = type;
		init();
	}
	
	public GameObject() {
		type = GameObjectType.NOTYPE;
		init();
	}
	
	private void init() {
		alive = true;
	}
	
	public abstract void draw(Graphics2D g);
	
	public boolean isDead() {
		return !alive;
	}
	
	public GameObjectType getType() {
		return type;
	}
	
	public void die() {
		alive = false;
	}

}
