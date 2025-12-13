package GameObjects;
import java.awt.Graphics;
import java.awt.Graphics2D;

public abstract class GameObject {
	
	private final GameObjectType type;
	
	public GameObject(GameObjectType type) {
		this.type = type;
	}
	
	public GameObject() {
		type = GameObjectType.NOTYPE;
	}
	
	public abstract void draw(Graphics2D g);
	
	public boolean isDead() {
		return false;
	}
	
	public GameObjectType getType() {
		return type;
	}

}
