import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

public class circle implements Runnable{
	private final int STARTINGX = 50;
	private final int STARTINGY = 50;
	
	private int currentX;
	private int currentY;
	
	private final int MAX_MOVES = 10;
	private int moves;
	
	private circleComponent cc;
	
	
	
	public circle(){
		currentX = STARTINGX;
		currentY = STARTINGY;
		moves = 0;
	}
	
	public circle( int x , int y ){
		this.currentX = x;
		this.currentY = y;
	}
	
	public circle( circleComponent cc ){
		this.cc = cc;
		currentX = STARTINGX;
		currentY = STARTINGY;
		moves = 0;
		
	}
	
	public void increaseX( int value ){
		currentX = currentX + value;
	}
	
	public void increaseY( int value ){
		currentX = currentX + value;
	}
	
	
	public Ellipse2D.Double getDrawing(){
		return new Ellipse2D.Double(currentX, currentY, 50, 50);
	}
	
	/**
	 * Changes x and y coordinates of this object, and then returns this object. 
	 * @return
	 */
	
	public circle move(){
		increaseX(50);
		increaseY(50);
		return this;
		
	}
	
	public void paint( Graphics g ){
		Graphics2D g2 = (Graphics2D) g;
		g2.draw( getDrawing() );
	}
	
	public circle moveDown(){
		increaseY(100);
		return this;
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
	
	public void draw( Graphics g ){
		Graphics2D g2 = (Graphics2D) g;
		g2.draw(getDrawing());
	}

	@Override
	public void run() {
		
		while( true ){
		
			move();
			cc.repaint();
			System.out.println("moving");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// TODO Auto-generated method stub
		
	}
	
	

}
