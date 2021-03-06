import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Simulation {
	
	
	private final int DEFAULT_NUM_OF_CIRCLES = 10;
	private int numOfCircles;
	private int numOfCirclesLeft;
	private Queue<Pinball> q;
	private Runnable r;
	private static Display display = new Display();
	

public Simulation( int numOfCircles ){
	
	this.numOfCircles = numOfCircles;
	numOfCirclesLeft = this.numOfCircles;
	initQueue();
}

public static Display getDisplay(){
	return display;
}

public void initQueue(){
	q = new Queue<>();
	
	/**
	 * Based on numOfCircles, that number of pinballs are added to this queue.
	 * Think of this as loading pinballs into the top of the machine, each ready to be 
	 * dequeued ( released and ran ) .
	 */
	for ( int i = 0 ; i < numOfCircles ; i++ ){ 
		q.enqueue( new Pinball() );
	}
	
}

public void start(){
	ScheduledExecutorService exec = Executors.newSingleThreadScheduledExecutor();
	exec.scheduleAtFixedRate(new Runnable(){
		

		@Override
		public void run() {
			// TODO Auto-generated method stub
			if ( q.isEmpty() ) exec.shutdown();
			Pinball currPinball = q.dequeue();
			display.addPinball(currPinball);
			r = currPinball;
			new Thread(r).start();
			
		}

	}, 0, 300, TimeUnit.MILLISECONDS);
	
}

}