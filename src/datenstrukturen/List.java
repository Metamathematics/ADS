package datenstrukturen;

public class List {

	private ListItem head = null;
	
	public List (Double key){
		
		ListItem item = new ListItem();
		
		item.key = key;
		item.prev = null;
		item.next = null;
		
		head = new ListItem();
		
		head.next = item;
	}
	
	
	public ListItem insert(Double k) {
		
		ListItem item = new ListItem(); 
		
		item.key = k; 
		item.prev = null ;
		
		item.next = head.next ;

		head.next.prev = item;
		
		head.next = item;
			
		return item; 
	}
	
	public ListItem returnHead(){
		return head;
	}
	 
}
