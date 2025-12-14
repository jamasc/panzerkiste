package main;

import GameObjects.GameBox;
import GameObjects.Grid;
import GameObjects.Panzer;
import GameObjects.Rakete;
import GameObjects.Wall;

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
		
		Wall w1 = new Wall(15*tile, 15*unit, tile, Direction.EAST);
		this.add(w1);
		
		this.add(new Grid());
	}

}
