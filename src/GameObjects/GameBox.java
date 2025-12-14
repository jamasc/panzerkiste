package GameObjects;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

import javax.swing.JPanel;

import main.CategorizedArrayList;

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
	
	private CategorizedArrayList objects;

	
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
	 * Panzer und Raketen müssen genau einmal bewegt werden (move)
	 * Folgende Berührungen müssen gecheckt werden (vor oder nach move):
	 * Panzer mit Panzer: (vor) Panzer.move blocken
	 * Panzer mit Rakete: (nach) beide zerstören
	 * Panzer mit Wall: (vor) Panzer.move blocken
	 * Rakete mit Rakete: (nach) beide zerstören
	 * Rakete mit Wall: (egal) Rakete soll bouncen
	 * Wall mit Wall: ---
	 * 
	 */
	public void update() {
		disposeDead();
		doPanzerPanzer();
		doPanzerWalls();
		doRaketenWalls();
		move();
		doRaketenPanzer();
		doRaketenRaketen();
	}


	/**
	 * Zeichnet alles
	 * @param g
	 */
	public void draw(Graphics2D g) {
		objects.forEach(o -> o.draw(g));
	}
	
	public void add(GameObject obj) {
		objects.add(obj);
	}
	
	
	private void init() {
		this.objects = new CategorizedArrayList();
	}
	
	private void disposeDead() {
		objects.removeIf(o -> o.isDead());
	}
	
	private void move() {
		for (GameObject o : objects.getAll(GameObjectType.PANZER)) {
			Panzer p = (Panzer)o;
			p.move();
		}
		for (GameObject o : objects.getAll(GameObjectType.RAKETE)) {
			Rakete r = (Rakete)o;
			r.move();
		}
	}
	
	private void doPanzerPanzer() {
		
	}
	
	private void doPanzerWalls() {
		
	}
	
	private void doRaketenRaketen() {
		
	}
	
	private void doRaketenPanzer() {
		
	}
	
	private void doRaketenWalls() {
		
	}
	
	private boolean areColliding(DynamicObject o1, DynamicObject o2) {
		int a2 = (o1.getX()-o2.getX())^2;
		int b2 = (o1.getY()-o2.getY())^2;
		double distance = Math.sqrt(a2+b2);
		int minDistance = o1.getHitboxRadius()+o2.getHitboxRadius();
		return (distance <= minDistance);
	}
	
	private boolean areColliding(DynamicObject o, Wall w) {
		int x;
		int y;
		int r = o.getHitboxRadius();
		int wx;
		int wy;
		int wr = w.getRadius();
		if (w.isHorizontal()) {
			x = o.getX();
			y = o.getY();
			wx = w.getX();
			wy = w.getY();
		} else {
			x = o.getY();
			y = o.getX();
			wx = w.getY();
			wy = w.getX();
		}
		//senkrechte Wand
		if (x >= wx-r && x <= wx+r) {
			if (y >= wy-wr-r && y <= wy+wr+r) {
				return true;
			}
		}
		return false;
	}

}
