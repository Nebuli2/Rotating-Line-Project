import java.awt.Point;
import java.awt.Polygon;

/**
 * Contains a variety of helpful utility functions. 
 * @author Benjamin Hetherington
 */
public class Util {
	/**
	 * Returns the specified angle normalized between [-pi, +pi).
	 * @param angle The angle to normalize
	 * @return The normalized angle
	 */
	public static double normalizeAngle(double angle) {
		return angle - (2 * Math.PI) * Math.floor((angle + Math.PI) / (2 * Math.PI));
	}
	
	/**
	 * Returns a point offset from a specified point with at a specified
	 * angle and with a specified distance.
	 * @param p Point from which to start
	 * @param d Distance from the point
	 * @param a Angle of the offset
	 * @return Point offset from another point at a specified distance
	 * angle angle
	 */
	public static Point polarPoint(Point p, double d, double a) {
		double x = p.x + d * Math.cos(a);
		double y = p.y + d * Math.sin(a);
		return new Point((int)x, (int)y);
	}

	/**
	 * Rotates a point around another point at a specified angle.
	 * @param px X coordinate of the point to rotate
	 * @param py Y coordinate of the point to rotate
	 * @param cx X coordinate of the point around which to rotate
	 * @param cy Y coordinate of the point around which to rotate
	 * @param sin The sine of the angle at which to rotate
	 * @param cos The cosine of the angle at which to rotate
	 * @return The rotated point
	 */
	private static Point rotatePoint(int px, int py, int cx, int cy, double sin, double cos) {
		double dx = px - cx, dy = py - cy;
		double newX = cx + dx * cos - dy * sin;
		double newY = cy + dx * sin + dy * cos;
		return new Point((int)newX, (int)newY);
	}
	
	/**
	 * Rotates a point around another point at a specified angle.
	 * @param px X coordinate of the point to rotate
	 * @param py Y coordinate of the point to rotate
	 * @param cx X coordinate of the point around which to rotate
	 * @param cy Y coordinate of the point around which to rotate
	 * @param a Angle at which to rotate
	 * @return The rotated point
	 */
	public static Point rotatePoint(int px, int py, int cx, int cy, double a) {
		return rotatePoint(px, py, cx, cy, Math.sin(a), Math.cos(a));
	}
	
	/**
	 * Rotates a point around another point at a specified angle.
	 * @param p The point to rotate
	 * @param c The point around which to rotate
	 * @param a The angle at which to rotate
	 * @return The rotated point
	 */
	public static Point rotatePoint(Point p, Point c, double a) {
		return rotatePoint(p.x, p.y, c.x, c.y, a);
	}
	
	/**
	 * Rotates a polygon around a point at a specified angle.
	 * @param p The polygon to rotate
	 * @param c The point around which to rotate
	 * @param a The angle at which to rotate
	 * @return The rotated polygon
	 */
	public static Polygon rotatePolygon(Polygon p, Point c, double a) {
		int[] xpoints = new int[p.npoints], ypoints = new int[p.npoints];
		Point vertex;
		double sin = Math.sin(a), cos = Math.cos(a);
		for(int i = 0; i < p.npoints; i++) {
			vertex = rotatePoint(p.xpoints[i], p.ypoints[i], c.x, c.y, sin, cos);
			xpoints[i] = vertex.x;
			ypoints[i] = vertex.y;
		}
		return new Polygon(xpoints, ypoints, p.npoints);
	}
}
