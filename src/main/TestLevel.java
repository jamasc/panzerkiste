package main;

import gameObjects.Grid;
import gameObjects.LinePiece;
import gameObjects.Panzer;
import gameObjects.Rakete;
import gameObjects.Wall;

public class TestLevel extends GameBox {

	public TestLevel() {
		super();
		init();
	}
	
	private void init() {
		int unit = Config.UNIT;
		int tile = 10*unit;
		
		Panzer p1 = new Panzer(5*unit,15*unit);
		this.add(p1);
		
		Rakete r1 = new Rakete(15*unit,15*unit);
		r1.setVelocity(Config.MAX_VELOCITY);
		this.add(r1);
		
		Wall w1 = new LinePiece(15*tile, 15*unit, tile, 0);
		this.add(w1);
		
		this.add(new Grid());
	}

}
