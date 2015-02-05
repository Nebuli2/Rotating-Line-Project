import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;

import javax.swing.JPanel;


public class NewPanel extends JPanel{
	
	Rotator rotator;
	
	public NewPanel(){
		super();
		Point point = new Point(0,0);
		int[] xArray = {0,0};
		int[] yArray = {0,0};
		Polygon poly = new Polygon(xArray,yArray,2);
		rotator = new Rotator(poly,point,.05);
		
	}
	
	
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		int[] xArray = {0,getWidth()};
		int[] yArray = {getHeight()/2,getHeight()/2};
		Polygon poly = new Polygon(xArray,yArray,2);
		rotator.setPolygon(poly);
		rotator.setCenter(new Point(getWidth()/2,getHeight()/2));
		g.drawPolygon(rotator.getCurrent());
		
	}
	
	public void setSpeed(double speed) {
		rotator.setSpeed(speed);
	}
	
	public void rotate(){
		rotator.rotate();
	}
}
