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
	
	private Finish finish;

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
	
	public Finish getFinish() {
		return finish;
	}
	
	
	private void init() {
		this.objects = new CategorizedArrayList();
		this.finish = Finish.NOTFINISHED;
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
		ArrayList<Panzer> list = (ArrayList<Panzer>)objects.getAll(GameObjectType.PANZER);
		for (int i = 0; i < list.size(); i++) {
			for (int j = i+1; j < list.size(); j++) {
				Panzer p1 = list.get(i);
				Panzer p2 = list.get(j);
				if (areColliding(p1, p2)) {
					p1.blockDirection(p1.getDirectionTo(p2));
					p2.blockDirection(p2.getDirectionTo(p1));
				}
			}
		}
	}
	
	private void doPanzerWalls() {
		ArrayList<Panzer> panzer = (ArrayList<Panzer>)objects.getAll(GameObjectType.PANZER);
		ArrayList<Wall> walls = (ArrayList<Wall>)objects.getAll(GameObjectType.WALL);
		for (Panzer p : panzer) {
			for (Wall w : walls) {
				if (this.areColliding(p, w)) {
					p.blockDirection(w.getBlockedDirection());
				}
			}
		}
	}
	
	private void doRaketenRaketen() {
		ArrayList<Rakete> list = (ArrayList<Rakete>)objects.getAll(GameObjectType.RAKETE);
		for (int i = 0; i < list.size(); i++) {
			for (int j = i+1; j < list.size(); j++) {
				Rakete p1 = list.get(i);
				Rakete p2 = list.get(j);
				if (areColliding(p1, p2)) {
					p1.die();
					p2.die();
				}
			}
		}
	}
	
	private void doRaketenPanzer() {
		ArrayList<Panzer> panzer = (ArrayList<Panzer>)objects.getAll(GameObjectType.PANZER);
		ArrayList<Rakete> raketen = (ArrayList<Rakete>)objects.getAll(GameObjectType.RAKETE);
		for (Panzer p : panzer) {
			for (Rakete r : raketen) {
				if (this.areColliding(p, r)) {
					p.die();
					r.die();
				}
			}
		}
	}
	
	private void doRaketenWalls() {
		ArrayList<Rakete> raketen = (ArrayList<Rakete>)objects.getAll(GameObjectType.RAKETE);
		ArrayList<Wall> walls = (ArrayList<Wall>)objects.getAll(GameObjectType.WALL);
		for (Rakete r : raketen) {
			for (Wall w : walls) {
				if (this.areColliding(r, w)) {
					r.bounce(w.getBlockedDirection());
				}
			}
		}
	}
	
	private boolean areColliding(DynamicObject o1, DynamicObject o2) {
		double a2 = Math.pow(o1.getX()-o2.getX(),2);
		double b2 = Math.pow(o1.getY()-o2.getY(),2);
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
		//waagrechte Wand
		if (y >= wy-r && y <= wy+r) {
			if (x >= wx-wr-r && x <= wx+wr+r) {
				return true;
			}
		}
		return false;
	}

}
