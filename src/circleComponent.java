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
	circle c = new circle();//
	Thread t; // 
	Runnable r;
	
	public circleComponent(){ 
		
		cq = new circleQueue(); 
		numOfCircles = DEFAULT_NUM_OF_CIRCLES;
		numOfCirclesLeft = numOfCircles;
		
		
		c = new circle(this);
		r = c;
		cq.enqueue(c); //
		/*Thread t = new Thread(c);
		t.start();*/
		
		new Thread(r).start();
	}
	
	public circleComponent( int numOfCircles ){
		
		cq = new circleQueue(); 
		this.numOfCircles = numOfCircles;
		numOfCirclesLeft = numOfCircles;
		

	}
	
	

	public void paintComponent( Graphics g ){
	
		super.paintComponent(g);
		drawCircles(g);
		System.out.println("drawing");
	}
	
	public void drawCircles( Graphics g ){
		Graphics2D g2 = (Graphics2D) g;
		
		if ( ! cq.isEmpty() ){
			for( int i = 0 ; i < cq.size(); i++ ){
				g2.draw(cq.get(i).getDrawing());
			}
		}
		
	}

}
