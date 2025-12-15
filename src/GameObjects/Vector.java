package GameObjects;

public class Vector {

	public final double x;
	public final double y;
	
	public Vector(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public Vector multiplyBy(double factor) {
		return new Vector(x*factor,y*factor);
	}
	
	public Vector add(Vector v) {
		return new Vector(x+v.x,y+v.y);
	}
	
	public double length() {
		return Math.sqrt(x*x + y*y);
	}
	
	public double getDirection() {
		return getDirection(this);
	}
	
	public static double getDirection(Vector v) {
		double x = v.x;
		double y = v.y;
		double phi = 0;
		double pi = Math.PI;
		if (y < 0) {
			if (x < 0) {
				//oben links, phi=pi..3pi/2
				phi = Math.atan(y/x) + pi;
			}else if (x == 0) {
				//über dem Ursprung, phi=3pi/2
				phi = 3*pi/2;
			}else if (x > 0) {
				//oben rechts, phi=3pi/2..2pi
				phi = Math.atan(x/-y) + 3*pi/2;
			}
		}else if (y == 0) {
			if (x < 0) {
				//links vom Ursprung, phi=pi
				phi = pi;
			}else if (x == 0) {
				//Ursprung
				phi = 0;
			}else if (x > 0) {
				//rechts vom Ursprung, phi=0
				phi = 0;
			}
		}else if (y > 0) {
			if (x < 0) {
				//links unten, phi=pi/2..pi
				phi = Math.atan(-x/y) + pi/2;
			}else if (x == 0) {
				//unterm Ursprung, phi=pi/2
				phi = pi/2;
			}else if (x > 0) {
				//unten rechts, phi=0..pi/2
				phi = Math.atan(y/x);
			}
		}
		return phi;
	}
	
	public static double scalarProduct(Vector u, Vector v) {
		return u.x*v.x + u.y*v.y;
	}
	
	public static Vector getPartFacing(Vector base, double direction) {
		Vector n = normVector(direction);
		double factor = scalarProduct(base, n);
		n.multiplyBy(factor);
		return n;
	}
	
	public static Vector with(double x, double y) {
		return new Vector(x,y);
	}
	
	public static Vector normVector(double direction) {
		return new Vector(Math.cos(direction), Math.sin(direction));
	}
	
	public static Vector normVector(Vector v) {
		Vector retour = Vector.with(v.x, v.y);
		retour.multiplyBy(1/v.length());
		return retour;
	}

}
