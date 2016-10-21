import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.LinkedList;

public class Chart {
	private static LinkedList<Rectangle2D.Double> [] grids = new LinkedList[10];
	
	public static ArrayList<Rectangle2D.Double> getChart(){
		initGrids();
		return getArrayListOfGrids();
		
	}
	
	private static void initGrids() {
		// TODO Auto-generated method stub
		for ( int i = 0 ; i < 10 ; i++  ){
			grids[i] = new LinkedList<Rectangle2D.Double>();
		}
		int gridLength = 18;
		/**
		 * We initialize the first two rows of the chart
		 */
		grids[0].add( new Rectangle2D.Double(915 , 110 , 20 , gridLength ) ); //row 1
		grids[1].add( new Rectangle2D.Double(865 , 160 , 20 , gridLength ) ); //first element of row 2
		grids[1].add( new Rectangle2D.Double(965 , 160 , 20 , gridLength ) ); //second element of row 2
		
		/**
		 * Each subsequent row has the following property:
		 * 1. The Y distance between each row is 50
		 * 2. Each row's middle components are identical to that of the row two rows up
		 * 3. Each row's outer components are 50 away from the outer components of the row directly on top
		 */
		for ( int x = 2  ; x < 10 ; x++ ){ // for each row
			int twoRowsUp = x - 2;
			int oneRowUp = x - 1;
			
			for ( int y = 0 ; y < grids[twoRowsUp].size() ; y++ ){ // copy all middle components of the row two rows above
				
				grids[x].add( new Rectangle2D.Double(grids[twoRowsUp].get(y).getX(), grids[twoRowsUp].get(y).getY() + 100, 20, gridLength) );
				
			}
			
			grids[x].addFirst( new Rectangle2D.Double(grids[oneRowUp].getFirst().getX()-50, grids[twoRowsUp].getFirst().getY() + 100, 20, gridLength) );
			grids[x].addLast( new Rectangle2D.Double(grids[oneRowUp].getLast().getX()+50, grids[twoRowsUp].getLast().getY() + 100, 20, gridLength) );
			
			
			
		}
		
		for( int i = 0 ; i < grids[9].size(); i++ ){
			System.out.println( "x: " + grids[9].get(i).getX() + " y: " + grids[9].get(i).getY());
		}
		
	}
	
	/**
	 * Convert the Array of LinkedLists storing the chart components to just a single ArrayList
	 * @return
	 */
	private static ArrayList<Rectangle2D.Double> getArrayListOfGrids(){
		ArrayList<Rectangle2D.Double> al = new ArrayList<>(); 
		for ( int i = 0 ; i < 10 ; i++ ){
			for ( int x = 0 ; x < grids[i].size(); x++ ){
				al.add( grids[i].get(x) );
		
		}
		}
		
		/**
		 * Chart Grid initialization, hard coded
		 */
		for ( int x = 365 ; x <= 1465 ; x += 100 ){
			al.add( new Rectangle2D.Double(x, 550, 20, 700) );
		}
		
		al.add( new Rectangle2D.Double(365, 1250, 1120, 20));
		
		return al;
		
		
	}

	
	

}
