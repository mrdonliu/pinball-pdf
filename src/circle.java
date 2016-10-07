import java.awt.geom.Ellipse2D;

public class circle {
	private int STARTINGX = 50;
	private int STARTINGY = 50;
	private int currentX;
	private int currentY;
	
	
	
	public circle(){
		currentX = STARTINGX;
		currentY = STARTINGY;
	}
	
	public circle( int x , int y ){
		this.currentX = x;
		this.currentY = y;
	}
	
	public void incrementX( int value ){
		currentX = currentX + value;
	}
	
	public void incrementY( int value ){
		currentX = currentX + value;
	}
	
	
	public Ellipse2D.Double getDrawing(){
		return new Ellipse2D.Double(currentX, currentY, 50, 50);
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
	
	

}
