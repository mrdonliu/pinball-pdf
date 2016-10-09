import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

public class circleQueue{
	
	private LinkedList<circle> ll; // reverse queue
	
	public boolean isEmpty(){
		return ll.size() == 0;
	}
	
	public int size(){
		return ll.size();
	}
	
	public circleQueue(){
		ll = new LinkedList<>();
		
	}
	
	public circle get( int i ){
		return ll.get(i);
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
	
	public circle getLast(){
		return ll.getFirst();
	}
	
	public circle getFirst(){
		return ll.getLast();
	}

	
}
