package GameObjects;

/**
 * 
 * Eine HitBox ist ein fertiges Konstrukt aus primitiven geometrischen Formen
 * nicht veränderbar
 * 
 * @author Arne
 *
 */
public class HitBox {
	
	public Shape[] construct;

	public HitBox(PhysicalObject root) {
		
	}
	
	public HitBox(DynamicObject root) {
		construct = new Shape[1];
		construct[0] = new Circle(root.getX(), root.getY(), root.getHitboxRadius());
	}
	
	
	
	public boolean hits(HitBox that) {
		for (Shape a : this.construct) {
			for (Shape b : that.construct) {
				if (hitting(a,b)) {
					return true;
				};
			}
		}
		return false;
	}
	
	private boolean hitting(Shape a, Shape b) {
		System.out.println("HitBox.hitting(Shape, Shape): Sollte nicht aufgerufen werden!");
		return false;
	}
	
	private boolean hitting(Circle a, Circle b) {
		double a2 = Math.pow(a.x-b.x, 2);
		double b2 = Math.pow(a.y-b.y, 2);
		double dist = Math.sqrt(a2+b2);
		double minDist = a.radius + b.radius;
		return dist <= minDist;
	}
	
	private boolean hitting(Circle c, Line l) {
		Vector v = Vector.with(c.x-l.x, c.y-l.y);
		double dist = v.length();
		Vector n = Vector.normVector(v.getDirection()-l.direction);
		n.multiplyBy(dist);
		double x = n.x;
		double y = n.y;
		if (Math.abs(x) <= c.radius && Math.abs(y) <= l.radius) {
			return true;
		}
		return false;
	}
	
	private boolean hitting(Line l, Circle c) {
		return hitting(c,l);
	}

}
