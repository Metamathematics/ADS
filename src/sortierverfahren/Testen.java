package sortierverfahren;
import java.util.Arrays;

public class Testen {

	//constants------------------------------------
	static int n = 100000;
	static int[] ANZAHL = {1,2,3,4,5,6,7,8,9,10,20,30,40,50,60,70,80,90,100};
	static int[] WERTEBEREICH = {10000,10000000,200000000,10};
	static int wertebereich = WERTEBEREICH[1];
	
	
	public static void main (String[] args){
		
		//variables--------------------------------------
		int MAL = 5;
		//int a = ANZAHL[0];
		
		
		for (int a2 = 0; a2 < ANZAHL.length;++a2){
		int a = ANZAHL[a2];

		System.out.println ("------------------------------------");
		System.out.println ("Anzahl:" + n*a);
		System.out.println ("Wertebereich:" + wertebereich);
		System.out.println ("");
		
		int[] A = new int[n*a];
		random(A);
		
		
		
		
		
@SuppressWarnings("unused")
		int[] LS ;
		int[] CS ;
@SuppressWarnings("unused")
		int[] ES ;
@SuppressWarnings("unused")
		long stimeLS, stimeCS, stimeES;
@SuppressWarnings("unused")
		long timeLS=0, timeCS=0, timeES=0;
		
		/*
		for(int i = 0; i < MAL; ++i){
			
			stimeLS = System.currentTimeMillis();
			LS = Sortierverfahren.linearSort(A,wertebereich);
			timeLS += (System.currentTimeMillis() - stimeLS)/MAL;
		}
		System.out.println ("linearSort Time: " + timeLS);
		*/
		
		for(int i = 0; i < MAL; ++i){
			CS = Arrays.copyOf(A,A.length);
			
			stimeCS = System.currentTimeMillis();
			Sortierverfahren.combinedSort(CS);
			timeCS += (System.currentTimeMillis() - stimeCS)/MAL;
		}
		System.out.println ("combinedSort Time: " + timeCS);
		
		
		/*
		for(int i = 0; i < MAL; ++i){	
			ES = Arrays.copyOf(A,A.length);
			
			stimeES = System.currentTimeMillis();
			Sortierverfahren.easySort(ES);
			timeES += (System.currentTimeMillis() - stimeES)/MAL;
		}
		System.out.println ("easySort Time: " + timeES);
		*/
		
		
		
		
		
		
		
		
		/*
		int[] IS ;
		int[] MS ;
		int[] QS ;
		int[] QSis ;
		long stimeIS, stimeMS, stimeQS, stimeQSis;
		long timeIS=0, timeMS=0, timeQS=0, timeQSis=0;
		
		
		for(int i = 0; i < MAL; ++i){
			IS = Arrays.copyOf(A,A.length);
			
			stimeIS = System.currentTimeMillis();
			Sortierverfahren.insertionSort(IS);
			timeIS += (System.currentTimeMillis() - stimeIS)/MAL;
		}
		System.out.println ("insertionSort Time: " + timeIS);
		
		
		for(int i = 0; i < MAL; ++i){
			MS = Arrays.copyOf(A,A.length);
			
			stimeMS = System.currentTimeMillis();
			Sortierverfahren.mergeSort(MS);
			timeMS += (System.currentTimeMillis() - stimeMS)/MAL;
		}
		System.out.println ("mergeSort Time: " + timeMS);
		
		
		for(int i = 0; i < MAL; ++i){	
			QS = Arrays.copyOf(A,A.length);
			
			stimeQS = System.currentTimeMillis();
			Sortierverfahren.quickSort(QS);
			timeQS += (System.currentTimeMillis() - stimeQS)/MAL;
		}
		System.out.println ("quickSort Time: " + timeQS);
		
		
		for(int i = 0; i < MAL; ++i){
			QSis = Arrays.copyOf(A,A.length);
			
			stimeQSis = System.currentTimeMillis();
			Sortierverfahren.quickSortInSitu(QSis);
			timeQSis += (System.currentTimeMillis() - stimeQSis)/MAL;
		}
		System.out.println ("quickSortInSitu Time:" + timeQSis);
		*/
		
		
		
	
		
		}
	}
	
	public static void mainquickinsertion (String[] args){
		
		//variables--------------------------------------
		int MAL = 500;
		//int a = ANZAHL[0];
				
				
		for (int a2 = 0; a2 < ANZAHL.length;++a2){
			int a = ANZAHL[a2];
	
			System.out.println ("------------------------------------");
			System.out.println ("Anzahl:" + n*a);
			System.out.println ("Wertebereich:" + wertebereich);
			System.out.println ("");
			
			int[] A = new int[n*a];
			random(A);
			
			int[] IS ;
			int[] QS ;
			long stimeIS, stimeQS;
			long timeIS=0, timeQS=0;
			
			
			for(int i = 0; i < MAL; ++i){
					
				random(A);
				IS = Arrays.copyOf(A,A.length);
				QS = Arrays.copyOf(A,A.length);
				
				
				stimeIS = System.nanoTime();
				Sortierverfahren.insertionSort(IS);
				timeIS += (System.nanoTime() - stimeIS)/MAL;
				
				stimeQS = System.nanoTime();
				Sortierverfahren.quickSort(QS);
				timeQS += (System.nanoTime() - stimeQS)/MAL;
					
			}
				System.out.println ("insertionSort Time: " + timeIS);
				System.out.println ("quickSort Time: " + timeQS);
				
			
		}
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
