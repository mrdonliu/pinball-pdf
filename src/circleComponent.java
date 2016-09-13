import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.geom.Ellipse2D;

import javax.swing.JComponent;

public class circleComponent extends JComponent{
	private final int STARTINGX;;
	private final int STARTINGY = 30;
	
	private int currentX;
	private int currentY;
	
	
	
	
	public circleComponent(){
		Dimension screen;
		screen = Toolkit.getDefaultToolkit().getScreenSize();
		STARTINGX = (int) screen.getWidth() / 2;
		currentX = STARTINGX;
		currentY = STARTINGY;
	}

	public void paintComponent( Graphics g ){
	
		Graphics2D g2 = (Graphics2D) g;
		Ellipse2D.Double circle = new Ellipse2D.Double(currentX, currentY, 20, 20);
		
	
		g2.draw(circle);
		
	}
	
	public void move(){
		currentX += 50;
		currentY += 50;
	}

}
