import java.awt.Point;
import java.awt.Polygon;

/**
 * Contains support for rotating a polygon around a point at a specific
 * rate.
 * @author Benjamin Hetherington
 */
public class Rotator {
	private Polygon polygon;
	private Point center;
	private double angle;
	private double speed;
	
	/**
	 * Constructs a rotator with an empty polygon and a center at 
	 * (0, 0).
	 */
	public Rotator() {
		polygon = new Polygon();
		center = new Point();
	}
	
	/**
	 * Constructs a rotator with a specified polygon, center point, and
	 * rotation speed.
	 * @param polygon The polygon to rotate
	 * @param center The point around which to rotate
	 * @param speed The number of radians to rotate per rotation
	 */
	public Rotator(Polygon polygon, Point center, double speed) {
		this.polygon = polygon;
		this.center = center;
		this.speed = speed;
	}
	
	/**
	 * Increments the angle by the speed.
	 */
	public void rotate() {
		angle = Util.normalizeAngle(angle + speed);
	}
	
	/**
	 * Sets the polygon to rotate.
	 * @param polygon The new polygon
	 */
	public void setPolygon(Polygon polygon) {
		this.polygon = polygon;
	}
	
	/**
	 * Sets the speed at which to rotate the polygon.
	 * @param speed The number of radians per rotation to rotate
	 */
	public void setSpeed(double speed) {
		this.speed = speed;
	}
	
	/**
	 * Sets the center around which to rotate the polygon.
	 * @param center The point around which to rotate
	 */
	public void setCenter(Point center) {
		this.center = center;
	}
	
	/**
	 * Returns the polygon rotated to the current angle.
	 * @return The current polygon
	 */
	public Polygon getCurrent() {
		return Util.rotatePolygon(polygon, center, angle);
	}
}
