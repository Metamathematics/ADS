package datenstrukturen;

public class Heap {
	
	// Maximal Heap
	
	
	
	public static void BuildMaxHeap (int[] A)
	{
		for (int i = A.length / 2; i>=0; --i){ 
			MaxHeapify (A,i);
		}
	}
	
	public static void MaxHeapify (int[] A,int i)
	{
		int l = left(i),r = right (i),largest;
		
		if (lex(A,i) && (A[l] > A[i]))
			largest = l;
		else largest = i;
		
		if (rex(A,i) && (A[r] > A[largest]))
			largest = r;
		
		if (largest != i){
			swap (A,i,largest); 
			MaxHeapify(A,largest);
			}
	}
	
	public static boolean isMaxHeap (int[] A){
		
		for (int i = 0;i<A.length;++i){
			if ( lex(A,i) && (A[left(i)] > A[i]) || rex(A,i) && (A[right(i)] > A[i]) ){
				return false;
			}
		}
		return true;
	}
	
	
	
	//help methods---------------
	
	
	public static void swap (int[] A,int i,int largest){
		int key = A[i];
		A[i] = A[largest];
		A[largest] = key;
	}
	
	
	
	//parent-child methods-----------------
	
	public static int left (int i){
		return 2*i;
	}
	
	public static int right (int i){
		return 2*i+1;
	}
	
	public static int parent (int i){
		return i/2;
	}
	
	// Does the parent heap member exist?
	public static boolean pex (int[] A,int i){
		return parent(i+1)>0;
	}
	
	// Does the left heap member exist?
	public static boolean lex (int[] A,int i){
		return left(i)<A.length;
	}

	// Does the right heap member exist?
	public static boolean rex (int[] A,int i){
		return right(i)<A.length;
	}
	
	// print methods------------------------------------
	
	
	
}
