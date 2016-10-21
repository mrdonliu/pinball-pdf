import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

import javax.swing.JComponent;

public class Display extends JComponent{
	
	private Ellipse2D s;
	
	private Queue<Pinball> pinballDrawings;
	private ArrayList<Rectangle2D.Double> al; //
	private int[] numbInEndXPosition;
	
	
	public Display(){ 
		pinballDrawings = new Queue<>();
		al = Chart.getChart(); // 
		numbInEndXPosition = new int[15];
		
		for ( int i = 0 ; i < 15 ; i++ ) numbInEndXPosition[i] = 0;
 }
	
	/**
	 * End X Positions are 400, 500, ... 1400. End Y position is always 550.
	 * Thereby this method takes X positions of completed pinballs, divides it by 100, 
	 * and stores it in its respective array of size 15. 
	 */
	public synchronized int getNumbInEndXPosition( int x ){ return numbInEndXPosition[ x / 100 ]; }
	public synchronized void setEndXPosition( int x ){ numbInEndXPosition[x/100] ++ ;}
	

	
	public Queue<Pinball> getpinballDrawings(){ return pinballDrawings; }
	
	public void drawChartDrawings( Graphics2D g2 ){
		g2.setColor(Color.BLACK);
		for ( int i = 0 ; i < al.size() ; i++ ){
			
			g2.fill(al.get(i));
		}
		
	}
	
	public void drawcharBars(){}
	
	public void drawPinballs( Graphics2D g2 ){
		for ( int i = 0 ; i < pinballDrawings.size(); i++ ){
			Pinball currPinball = pinballDrawings.get(i);
			g2.setColor(currPinball.getC());
			g2.fill(currPinball.getDrawing());
		}
		
		
	}
	
	public void addPinball( Pinball p ){
		pinballDrawings.enqueue(p);
	}
	
	
    public void paintComponent( Graphics g ){
	
		super.paintComponent(g);
		//drawCircle(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		drawPinballs(g2);
		drawChartDrawings(g2);
		//System.out.println("drawing");
	}
	
	public void drawCircle( Graphics g ){
		Graphics2D g2 = (Graphics2D) g;
		if (s!=null) g2.draw(s);
		
	}
	
	public void transmitCircle( Pinball c ){
		s = c.getDrawing();
		
	}

}