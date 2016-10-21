import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.util.Random;

public class Pinball implements Runnable{
	private final int STARTINGX = 900;
	private final int STARTINGY = 50;
	
	private int currentX;
	private int currentY;
	
	private final int MAX_MOVES = 10;
	private int moves;
	
	private Random r = new Random();
	private Color c;
	
	/**
	 * Circle needs to know the display it's drawing on. 
	 * @param cc
	 */
	
	public Color getC() {
		return c;
	}
	
	
	public Pinball( Display cc ){
		currentX = STARTINGX;
		currentY = STARTINGY;
		moves = 0;
		c = new Color( r.nextInt(256) , r.nextInt(256) , r.nextInt(256) );
		
	}
	
	public void increaseX( int value ){
		currentX = currentX + value;
	}
	
	public void increaseY( int value ){
		currentY = currentY + value;
	}
	
	
	public Ellipse2D.Double getDrawing(){
		return new Ellipse2D.Double(currentX, currentY, 45, 45);
	}
	
	/**
	 * Changes x and y coordinates of this object, and then returns this object. 
	 * @return
	 */
	public void moveDown(){
		for ( int x = 0 ; x < 150 ; x++ ){
			increaseY(1);
			Simulation.getDisplay().repaint();
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	public Pinball move(){
		int i = r.nextInt(2);
		if ( i == 0 ){
			/*increaseX(50);
			increaseY(50);*/
			for ( int x = 0 ; x < 50 ; x++ ){
				increaseX(1);
				increaseY(1);
				Simulation.getDisplay().repaint();
				try {
					Thread.sleep(5);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
		else if ( i == 1 ){
			/*increaseX(-50);
			increaseY(50);*/
			for ( int x = 0 ; x < 50 ; x++ ){
				increaseX(-1);
				increaseY(1);
				Simulation.getDisplay().repaint();
				try {
					Thread.sleep(5);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		moves++;
		//Simulation.getDisplay().transmitCircle(this);
		Simulation.getDisplay().repaint();
		return this;
		
	}
	
	public void paint( Graphics g ){
		Graphics2D g2 = (Graphics2D) g;
		g2.draw( getDrawing() );
	}
	

	
	
	
	

	public int getX() {
		return currentX;
	}

	public void setX(int x) {
		this.currentX = x;
	}

	public int getY() {
		return currentY;
	}

	public void setY(int y) {
		this.currentY = y;
	}
	
	public boolean isFinished(){
		return moves == MAX_MOVES;
	}
	
	
	public void run() {
		
		while( ! isFinished() ){
		
			//move();
			// transmitCircle takes this circle object and paints it on the main display.
			/*Simulation.getDisplay().transmitCircle(this);
			Simulation.getDisplay().repaint();*/
			//System.out.println("moving");
			try {
				
				Thread.sleep(5);
				
				move();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("Final coordinate: X: " + currentX + " Y: " + currentY);
		moveDown();
		// TODO Auto-generated method stub
		
	}
	
	

}
