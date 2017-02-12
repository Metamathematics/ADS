package datenstrukturen;
import datenstrukturen.List;

public class Queue {
	
	private List content = null;
	
	
	public Queue (double key) {
		content = new List(key);   	
	}
	

	/*
	public Queue () {
		content = new List();   	
	}
	*/
	
	public void enqueue(Double k){ 
		content.insert(k);
	}
	
	
	public Double dequeue(){
		
		ListItem b = content.returnHead();
		
		if (content.returnHead().next == null) {System.out.println("underflow");}//throw illegalArgumentException("underflow");
		else {
			boolean a = true;
			while (a){
				if (b.next != null) b = b.next;
				else a = false;
			}
			b.prev.next = null;
			b.prev = null;
		}
		
		return b.key; 
	}
	
	
	public int getSize (){
		boolean a = true;
		int counter = 0;
		ListItem b = content.returnHead();
		
		while (a){
			if (b.next != null) {counter++; b = b.next;}
			else a = false;
		}
		
		return counter;
	}
	
	public ListItem returnHead(){
		return content.returnHead();
	}
	
}

