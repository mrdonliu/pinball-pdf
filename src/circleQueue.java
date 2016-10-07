import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

public class circleQueue{
	
	private LinkedList<circle> ll;
	
	public circleQueue(){
		ll = new LinkedList<>();
		
	}
	
	public circle enqueue( circle c ){
		ll.add(c);
		return c;
	}
	
	public circle dequeue(){
		return ll.removeFirst();
		
	}
	
	public Iterator<circle> getIterator(){
		return ll.iterator();
	}

	
}
