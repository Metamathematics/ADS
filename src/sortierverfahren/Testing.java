package sortierverfahren;

public class Testing {
	
	static int n = 9;
	static int[] WERTEBEREICH = {10,10000,10000000,200000000};
	static int wertebereich = WERTEBEREICH[0];
	
	public static void main (String[] args){
		int[] A = new int[n];
		random(A);
		
		printArray(A);
		Sortierverfahren.combinedSort(A);
		printArray(A);
		
		
	}
	
	public static void printArray (int[] A,String s){
		System.out.print (s + ":");
		for (int i=0;i<A.length;i++){
			System.out.print (A[i]+" ");
			}
		System.out.println ();
	}
	
	public static void printArray (int[] A){
		for (int i=0;i<A.length;i++){
			System.out.print (A[i]+" ");
			}
		System.out.println ();
	}
	
	public static void random (int[] A){
		for(int i = 0; i<A.length; i++) {
		     A[i] = (int)( Math.random() * wertebereich );
		}
	}
}
