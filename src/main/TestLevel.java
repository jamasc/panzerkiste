package main;

import GameObjects.GameBox;
import GameObjects.Panzer;
import GameObjects.Rakete;

public class TestLevel extends GameBox {

	public TestLevel() {
		super();
		init();
	}
	
	private void init() {
		int unit = Config.UNIT;
		int tile = 10*unit;
		
		Panzer p1 = new Panzer(5*unit,5*unit);
		this.add(p1);
		
		Rakete r1 = new Rakete(15*unit,5*unit);
		r1.setVelocity(Config.MAX_VELOCITY);
		this.add(r1);
	}

}
