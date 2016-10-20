import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JComponent;

public class Display extends JComponent{
	
	private Ellipse2D s;
	
	private Queue<Pinball> pinballDrawings;
	private Shape[] interfaceDrawings;
	private Shape[] chartBars;
	
	public Display(){ 
		pinballDrawings = new Queue<>();
		interfaceDrawings = new Shape[100];
		chartBars = new Shape[11];
 }
	

	
	public Queue<Pinball> getpinballDrawings(){ return pinballDrawings; }
	
	public void drawinterfaceDrawings(){}
	
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
		
		g2.draw( new Rectangle2D.Double(915 , 110 , 20 , 30 ) );//
		System.out.println("drawing");
	}
	
	public void drawCircle( Graphics g ){
		Graphics2D g2 = (Graphics2D) g;
		if (s!=null) g2.draw(s);
		
	}
	
	public void transmitCircle( Pinball c ){
		s = c.getDrawing();
		
	}

}