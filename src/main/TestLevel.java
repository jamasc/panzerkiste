package main;

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
	}

}
