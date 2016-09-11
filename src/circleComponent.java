import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

import javax.swing.JComponent;

public class circleComponent extends JComponent{
	public void paintComponent( Graphics g ){
		Graphics2D g2 = (Graphics2D) g;
		
		Ellipse2D.Double circle = new Ellipse2D.Double(5, 5, 50, 50);
	
		g2.draw(circle);
	}

}
