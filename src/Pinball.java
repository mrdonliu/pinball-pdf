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
	
	
	public Pinball(){
		currentX = STARTINGX;
		currentY = STARTINGY;
		moves = 0;
		c = new Color( r.nextInt(256) , r.nextInt(256) , r.nextInt(256) );
	}
	
	public Color getC() { return c; }
	public void increaseX( int value ){ currentX = currentX + value; }
	public void increaseY( int value ){ currentY = currentY + value; }
	public Ellipse2D.Double getDrawing(){ return new Ellipse2D.Double(currentX, currentY, 45, 45); }
	public int getX() {	return currentX; }
	public void setX(int x) { this.currentX = x; }
	public int getY() { return currentY; }
	public void setY(int y) { this.currentY = y; }
	public boolean isFinished(){ return moves == MAX_MOVES; }

	
	public void moveDown( int i , int finalXPosition ){
		
		Simulation.getDisplay().setEndXPosition(finalXPosition);
		for ( int x = 0 ; x < 650 - i * 50 ; x++ ){
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
	public void move(){
		int i = r.nextInt(2);
		int xDeviation = (i == 0) ? 1 : -1; // Determines whether pinball deviates left or right based on random int i
		
			for ( int x = 0 ; x < 50 ; x++ ){ // Animation: moves and sleeps for 5 microseconds, repaint, and repeat for 50 times
				increaseX(xDeviation);
				increaseY(1);
				Simulation.getDisplay().repaint();
				try {
					Thread.sleep(5);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		
		moves++;
		Simulation.getDisplay().repaint();
		
	}
	
	public void run() {
		
		while( ! isFinished() ){
			try {
				
				Thread.sleep(5);
				
				move();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Final coordinate: X: " + currentX + " Y: " + currentY);
		int finalXPosition = currentX;
		moveDown( Simulation.getDisplay().getNumbInEndXPosition(finalXPosition) , finalXPosition );
	}
	
	

}
