package main;

public class Config {
	
	public static final boolean DEBUG_MODE = true;
	
	public static final int HALF_UNIT = 4;
	public static final int UNIT = 2*HALF_UNIT;
	
	//GameBox
	public static final int UNITS_PER_TILE = 10;
	public static final int TILE_SIZE = UNITS_PER_TILE*UNIT;
	public static final int HORIZONTAL_NUMBER_OF_TILES = 16;
	public static final int VERTICAL_NUMBER_OF_TILES = 9;
	public static final int IMAGE_WIDTH = TILE_SIZE * HORIZONTAL_NUMBER_OF_TILES;
	public static final int IMAGE_HEIGTH = TILE_SIZE * VERTICAL_NUMBER_OF_TILES;
	
	//Screen
	public static final double ZOOM_FACTOR = 1;
	public static final int SCREEN_WIDTH = (int)(IMAGE_WIDTH * ZOOM_FACTOR);
	public static final int SCREEN_HEIGTH = (int)(IMAGE_HEIGTH * ZOOM_FACTOR);
	
	//GameObject Config
	public static final int PANZER_HITBOX_RADIUS = 4*UNIT;
	public static final int RAKETE_HITBOX_RADIUS = HALF_UNIT;
	public static final int MAX_VELOCITY = UNIT;
	
	//GameDriver
	public static final int FPS = 50;
	public static final long MILLIS_PER_FRAME = 20;

}
