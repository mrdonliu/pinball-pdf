import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

public class Queue<T>{
	
	private LinkedList<T> ll;
	
	public Queue(){ ll = new LinkedList<>(); }
	
	public boolean isEmpty(){ return ll.size() == 0; }
	
	public int size(){ return ll.size(); }
	
	public T get( int i ){ return ll.get(i); }
	
	public T getlastIn(){ return ll.getFirst(); }
	
	public T getfirstIn(){ return ll.getLast(); }

	public T dequeue(){ return ll.removeLast(); }

    public T enqueue( T t ){
		ll.addFirst(t);
		return t;
	}
}
