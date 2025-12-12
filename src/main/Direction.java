package main;

public enum Direction {

	NORTH(3*Math.PI/2),
	EAST(0),
	SOUTH(Math.PI/2),
	WEST(Math.PI);
	
	private double direction;
	
	Direction(double direction) {
		this.direction = direction;
	}
	
	public double getDirection() {
		return direction;
	}
	
}
