import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.LinkedList;

public class Chart {
	private static LinkedList<Rectangle2D.Double> [] grids = new LinkedList[10];
	
	public static ArrayList<Rectangle2D.Double> getChart(){
		initGrids();
	}
	
	private static void initGrids() {
		// TODO Auto-generated method stub
		for ( LinkedList <Rectangle2D.Double> ll : grids ){
			ll = new LinkedList<>();
		}
		
		grids[0].add( new Rectangle2D.Double(915 , 110 , 20 , 30 ) );
		grids[1].add( new Rectangle2D.Double(965 , 160 , 20 , 30 ) );
		grids[1].add( new Rectangle2D.Double(865 , 160 , 20 , 30 ) );
		
	}
	
	private static ArrayList<Rectangle2D.Double> getArrayListOfGrids(){
		ArrayList<Rectangle2D.Double> al = new ArrayList<>(); 
		
	}

	
	

}
