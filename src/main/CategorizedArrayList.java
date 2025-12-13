package main;

import java.util.ArrayList;
import java.util.EnumMap;

public class CategorizedArrayList extends ArrayList<GameObject> {
	
	private ArrayList<Panzer> panzer;
	private ArrayList<Rakete> raketen;
	private ArrayList<Wall> walls;
	
	public CategorizedArrayList() {
		init();
	}
	
	private void init() {
		panzer = new ArrayList<Panzer>();
		raketen = new ArrayList<Rakete>();
		walls = new ArrayList<Wall>();
	}

	@Override
	public boolean add(GameObject e) {
		if (e instanceof Panzer) {
			panzer.add((Panzer)e);
		} else if (e instanceof Rakete) {
			raketen.add((Rakete)e);
		} else if (e instanceof Wall) {
			walls.add((Wall)e);
		}
		return super.add(e);
	}
	
}
