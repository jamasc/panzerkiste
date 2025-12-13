package main;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.function.Consumer;
import java.util.function.Predicate;

import GameObjects.GameObject;
import GameObjects.GameObjectType;
import GameObjects.Panzer;
import GameObjects.Rakete;
import GameObjects.Wall;

public class CategorizedArrayList {
	
	private ArrayList<ArrayList<? extends GameObject>> lists;
	
	private ArrayList<GameObject> rest;
	private ArrayList<Panzer> panzer;
	private ArrayList<Rakete> raketen;
	private ArrayList<Wall> walls;
	
	public CategorizedArrayList() {
		init();
	}
	
	private void init() {
		lists = new ArrayList<ArrayList<? extends GameObject>>();
		
		rest = new ArrayList<GameObject>();
		panzer = new ArrayList<Panzer>();
		raketen = new ArrayList<Rakete>();
		walls = new ArrayList<Wall>();
		
		lists.add(rest);
		lists.add(panzer);
		lists.add(raketen);
		lists.add(walls);
	}

	public void add(GameObject e) {
		if (e instanceof Panzer) {
			panzer.add((Panzer)e);
		} else if (e instanceof Rakete) {
			raketen.add((Rakete)e);
		} else if (e instanceof Wall) {
			walls.add((Wall)e);
		} else {
			rest.add(e);
		}
	}
	
	public void forEach(Consumer<? super GameObject> action) {
		lists.forEach(l -> l.forEach(action));
	}
	
	public void removeIf(Predicate<? super GameObject> filter) {
		lists.forEach(l -> l.removeIf(filter));
	}
	
	public ArrayList<? extends GameObject> getAll(GameObjectType type) {
		switch (type) {
		case NOTYPE:
			return rest;
		case PANZER:
			return panzer;
		case RAKETE:
			return raketen;
		case WALL:
			return walls;
		default:
			System.out.println("CategorizedArrayList.getAll(GameObjectType): Für diesen GameObjectType ist keine case vorhanden");
			return null;
		}
	}
	
}
