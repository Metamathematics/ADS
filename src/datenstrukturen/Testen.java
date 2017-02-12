package datenstrukturen;

public class Testen {
	
	public static void main (String[] args){
		
		
		List liste = new List(2.5758);
		
		liste.insert(5.663);
		liste.insert(3.687663);
		liste.insert(7.634663);
		liste.insert(1.61613);
		liste.insert(1.61613);
		
		
		
		for ( ListItem l = liste.returnHead().next; l != null; l=l.next){
		System.out.println(l.key);
		}
		
	
	}
	
}