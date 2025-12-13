package main;

public class TestLevel extends GameBox {

	public TestLevel() {
		super();
		init();
	}
	
	private void init() {
		int unit = Properties.UNIT;
		int tile = 10*unit;
		
		Panzer p1 = new Panzer(1,1);
		Panzer p2 = new Panzer(16,9);
		this.add(p1);
		this.add(p2);
	}

}
