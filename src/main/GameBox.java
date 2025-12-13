package main;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.function.Consumer;

import javax.swing.JPanel;

import GameObjects.DynamicObject;
import GameObjects.GameObject;

/**
 * 
 * Hält viele GameObjects und kann diese um einen Zeitschritt bewegen,
 * befolgt dabei aber Regeln und löst in den Objekten Events aus.
 * 
 * @author Arne
 *
 */
public class GameBox {
	
	private ArrayList<DynamicObject> dynamics;
	private ArrayList<GameObject> statics;

	
	public GameBox() {
		init();
	}
	
	
	/**
	 * Führt genau einen Zeitschritt aus.
	 * Alle dynamischen Objekte werden im Idealfall gleichzeitig bewegt (bzw. entfernt),
	 * befolgen dabei den Bewegungsregeln und
	 * reagieren auf seriöse Berührungen.
	 * 
	 * Tote Objekte werden zuerst entfernt.
	 * Jedes Objekt muss am Ende einmal den Aufruf move() bekommen
	 * und mit allen anderen relevanten Objekten verglichen worden sein
	 * und entsprechene Reaktionen ausgelöst haben
	 */
	public void update() {
		disposeDead();
		this.forEach(o -> {
			if (o instanceof DynamicObject) {
				((DynamicObject) o).move();
			}
		});
	}
	
	/**
	 * Zeichnet alles
	 * @param g
	 */
	public void draw(Graphics2D g) {
		this.forEach(o -> o.draw(g));
	}
	
	public void add(GameObject obj) {
		if (obj instanceof DynamicObject) {
			dynamics.add((DynamicObject) obj);
		} else {
			statics.add(obj);
		}
	}
	
	
	private void init() {
		this.dynamics = new ArrayList<DynamicObject>();
		this.statics = new ArrayList<GameObject>();
	}
	
	private void disposeDead() {
		dynamics.removeIf(o -> o.isDead());
		statics.removeIf(o -> o.isDead());
	}
	
	private void forEach(Consumer<GameObject> action) {
		dynamics.forEach(action);
		statics.forEach(action);
	}

}
