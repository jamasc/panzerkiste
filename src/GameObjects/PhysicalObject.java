package GameObjects;

import java.awt.Graphics2D;

public class PhysicalObject extends GameObject {
	
	public PhysicalObject(GameObjectType type) {
		super(type);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void draw(Graphics2D g) {
		// TODO Auto-generated method stub

	}
	
	public HitBox getHitBox() {
		return new HitBox(this);
	}

}
