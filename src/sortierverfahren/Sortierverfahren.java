package sortierverfahren;
import java.lang.Integer;

//ADS Gruppe 1
//Sergey Gerodes 192 73 70 
//Bastian Häuser 2150 145
//Lazaros Dimitriadis 192 84 96


public class Sortierverfahren {
	//Durch Praktische Versuche festgestellt
	static int COMBINED_SORT_T = 109;
	
	
//InsertionSort----------------------------------------
	
	public static void insertionSort (int[] A){
		for (int j=1;j<A.length;j++){
			int key = A[j];
			int i=j-1;
			while ((i>=0) && (A[i]>key)){
				A[i+1]=A[i];
				i=i-1;
			}
			A[i+1]=key;
		}
	}
	
	
	//Sortiert ein TeilFeld von den index l bis index r.
	//genau wie normales insertionSort
	public static void insertionSort (int[] A, int l, int r){
		for (int j=l;j<=r;j++){
			int key = A[j];
			int i=j-1;
			
			while ((i>=l) && (A[i]>key)){
				A[i+1]=A[i];
				i=i-1;
			}
			A[i+1]=key;
		}
	}
	
//MergeSortOld---------------------------------------------
	
		public static void mergeSortOld (int[] A){
			int l = 0;
			int r = A.length-1;
			mergeSortOld (A,l,r);
		}
		
		public static void mergeSortOld (int[] A,int l, int r){
			if (l<r){
				int m=(l+r)/2;
				mergeSortOld (A,l,m);
				mergeSortOld (A,m+1,r);
				mergeOld (A,l,m,r);
			}
		}
		
		public static void mergeOld (int[] A,int l,int m, int r){
			int n1 = m-l+1;
			int n2 = r-m;
			
			int[] L = new int [n1];
			int[] R = new int [n2];
			
			for (int a=0;a<n1;a++){
				L[a]=A[l+a];
			}
			
			for (int a=0;a<n2;a++){
				R[a]=A[m+1+a];
			}
			
			int i=1,j=1;
			
			for (int k=l;k<=r;++k){
				if (L[i] <= R[j]) i++;
				else j++;
			}
		}
	
//MergeSort---------------------------------------------
		
		public static void mergeSort (int[] A){
	        mergeSort(A,0,A.length-1);
	    }

	    public static void mergeSort (int[] A,int l, int r){
	        if ( l < r) {
	            int m = (l + r) / 2;
	            mergeSort(A, l, m);
	            mergeSort(A, m + 1, r);
	            merge(A, l, m, r);
	        }
	    }

	    public static void merge(int[] A,int l, int m, int r){
	        int n1 = m-l+1, n2 = r-m; //ìîæåò áûòü îøèáêà, ïðîâåðèòü
	        int[] L = new int[n1+1];
	        int[] R = new int[n2+1];
	        copyArray(A,l,m,L);
	        copyArray(A,m+1,r,R);

	        int i=0, j=0;

	        for (int k=l; k <= r; ++k){
	            if (L[i] <= R[j]){
	                A[k] = L[i];
	                ++i;
	            }
	            else {
	                A[k] = R[j];
	                ++j;
	            }
	        }
	    }

	    public static void copyArray (int[] A,int l, int r, int[] B){

	        for (int i = 0;i <= r-l;++i){
	            B[i]=A[l+i];
	        }
	        B[B.length-1]=Integer.MAX_VALUE;
	    }
	
//EasySort----------------------------------------
	
	public static void easySort (int[] A){
		
		for (int i = 0; i<A.length-1; ++i){
			int min = A[i];
			int indexMin = i;
			
			for (int j = i+1; j < A.length;++j){
				if (A[j] < min){
					min = A[j];
					indexMin = j;
				}
			}
			A[indexMin] = A[i];
			A[i] = min;
		}
	}
	
//QuickSort----------------------------------------
	
	public static void quickSort (int[] A){
		quickSort (A,0,A.length-1);
	}
	
	//Abgeändertevariante von quicksort. Anstatt sich selber
	//aufzurufen prüfft es in combinedSort ob das Teilfeld
	//"bereit" für insertionSort ist
	public static void quickSort (int[] A, int l, int r){
		if (l<r) {
			int m = partition (A,l,r);
			//quickSort (A,r-l,l,m-1);
			//quickSort (A,r-l,m+1,r);
			combinedSort (A,r-l,l,m-1);
			combinedSort (A,r-l,m+1,r);
		}
	}
	
	public static int partition (int[] A, int l, int r){
		
		int pivot = A[r];
		int i = l;
		
		for ( int j = l; j <= r-1; ++j){
			
			if ( A[j] <= pivot){ 
				swap (A,i,j);
				++i;
			}
		}
		
		swap (A,i,r);
		return i;
	}
	
	public static void swap (int[] A, int a, int b){
		int key = A[a];
		A[a] = A[b];
		A[b] = key;
	}
	
//quickSortInSitu-----------------------------------
	

    public static void quickSortInSitu(int[] arr) {
        quickSortInSitu(arr,arr.length);
    }

    public static void quickSortInSitu(int[] arr,final int size) {
        int l = 0;
        int r = size - 1;
        int q, i = 0;
        int tmpr = r;
        while (true) {
            i--;
            while (l < tmpr) {
                q = partitionQSIS(arr,l, tmpr);
                arr[tmpr] = -arr[tmpr];
                tmpr = q - 1;
                ++i;
            }
            if (i < 0)
                break;
            l++;
            tmpr = findNextR(arr,l, size);
            arr[tmpr] = -arr[tmpr];
        }
    }

    private static int findNextR(int [] arr,final int l, final int size) {
        for (int i = l; i < size; ++i) {
            if (arr[i] < 0)
                return i;
        }
        return size - 1;
    }

    private static int partitionQSIS(int [] arr,int l, int r) {
        int pivot = arr[(l + r) / 2];
        while (l <= r) {
            while (arr[r] > pivot)
                r--;
            while (arr[l] < pivot)
                l++;
            if (l <= r) {
                int tmp = arr[r];
                arr[r] = arr[l];
                arr[l] = tmp;
                l++;
                r--;
            }
        }
        return l;
    }
	
//LinearSort----------------------------------------
	
	public static void linearSort (int[] A){
		
		linearSort (A, maximum(A) );
	}
	
	public static int maximum(int[] A){
		int max = A[0];
		
		for(int i = 1; i<A.length; ++i){
			if (A[i]>max){ 
				max = A[i];
			}
		}
		return max;
	}
	
	public static void linearSort (int[] A, int k){
		
		int[] B = new int[A.length];
		countingSort (A,B,k);
		
		copy (A,B);
	}
	
	public static void copy (int[] A, int[] B){
		for(int i=0 ; i< A.length; ++i){
			A[i]=B[i];
		}
	}
	
	public static void countingSort (int[] A, int[] B, int k){
		
		++k; int[] C = new int[k];
		
		for (int j = 0; j < A.length; ++j) ++C[ A[j] ];
		
		for (int i = 1; i < k; ++i)	C[i] += C[i-1];
		
		for (int l = A.length-1; l >= 0; --l){
			B[ C[A[l]] -1 ] = A[l];
			--C[ A[l] ]; 
		}
		
	}
	
//CombinedSort-------------------------------------------
	
	//Erste Wariante des Aufrufs ohne dem Wert t
	public static void combinedSort (int[] A){
		combinedSort (A,A.length);
	}
	
	//Erste Wariante des Aufrufs mit dem Wert t
	public static void combinedSort (int[] A, int t){
		combinedSort (A, t, 0, A.length-1);//
	}
	
	//das eigentliche Vegleichsprogramm. Ist rekursiv, da quickSort
	//wieder combinedSort aufruft bis die Felder klein genug für 
	//insertionSort sind
	public static void combinedSort (int[] A, int t, int l, int r){
		if (t < COMBINED_SORT_T) insertionSort (A,l,r);
		else quickSort (A,l,r);
	}
	
}
