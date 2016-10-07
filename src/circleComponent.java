import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.geom.Ellipse2D;

import javax.swing.JComponent;

public class circleComponent extends JComponent{
	
	/**
	 * Circle objects enter this queue one by one. Each time a new circle enters the 
	 * queue, it is initialized and drawn at the starting position, and all circles already 
	 * inside of the queue moves. 
	 */
	private final int DEFAULT_NUM_OF_CIRCLES = 10;
	private circleQueue cq;
	private int numOfCircles;
	private int numOfCirclesLeft;
	
	
	public circleComponent(){ 
		
		cq = new circleQueue(); 
		numOfCircles = DEFAULT_NUM_OF_CIRCLES;
		numOfCirclesLeft = numOfCircles;
		
	}
	
	public circleComponent( int numOfCircles ){
		
		cq = new circleQueue(); 
		this.numOfCircles = numOfCircles;
		numOfCirclesLeft = numOfCircles;
		

	}
	
	

	public void paintComponent( Graphics g ){
	
		super.paintComponent(g);
		drawCircle(g);
		
	}
	
	public void drawCircle( Graphics g ){
		Graphics2D g2 = (Graphics2D) g;
		circle c1 = new circle();
		circle c2 = new circle(88,88);
		g2.draw(c1.getDrawing());
	}
	
	
	public void move(){
		
		
		
		repaint();
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
