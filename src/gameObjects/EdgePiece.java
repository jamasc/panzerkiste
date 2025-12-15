package gameObjects;

import geometry.Circle;
import geometry.HitBox;

public class EdgePiece extends Wall {

	public EdgePiece(int x, int y, double blockedDirection) {
		super(x, y, blockedDirection);
		// TODO Auto-generated constructor stub
	}

	@Override
	public HitBox getHitBox() {
		return generateHitBox();
	}
	
	private HitBox generateHitBox() {
		Circle c = new Circle(this.getX(), this.getY(), 0);
		return new HitBox(c);
	}

}
