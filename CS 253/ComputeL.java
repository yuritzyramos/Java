import java.io.*;
public class ComputeL
{
	static public void merge (int[] a, int[] aux, int[] indices, int lo,int mid, int hi) {
        //Assign indices from lo to hi

        for(int g = 0; g < indices.length; g++){
        	System.out.print(indices[g]);
        }
                	System.out.println();


        for(int p = lo; p < hi; p++){
            aux[p] = indices[p];
        }

        System.out.println("The Aux values are...");
         for(int h = lo; h < hi; h++){
        	System.out.print(aux[h]);
        }
                	System.out.println();


        
        int i = lo, j = mid+1;
        for (int k = lo; k <= hi; k++) {
            if      (i > mid)           indices[k] = aux[j++];
            else if (j > hi)            indices[k] = aux[i++];
            else if (a[indices[j]] < a[indices[j]]) { 
            	indices[k] = aux[j++]; 
            }
            else                        indices[k] = aux[i++];
        }

       
    }

    // Sort the subarray a[lo..hi], and also return the number
    // of inversions that were in the array before sorting.
    private static void sort(int[] a, int[] aux, int[] indices, int lo, int hi) {
        if (hi <= lo) return;
        int mid = lo + (hi - lo) / 2;
        sort(a, aux, indices, lo, mid);
        sort(a, aux, indices, mid+1, hi);
        merge(a, aux, indices, lo, mid, hi);
    }

    // Sort the array a, and also return the number of inversions
    // that were in the array before sorting.
    public static void mergeSort(int[] a) {
        int n = a.length;

        int[] indices = new int[n];
        for(int i = 0; i < n; i++){
        	indices[i] = i;
        }

        sort(a, new int[n], indices, 0, n-1);
    }

    public static void main(String[] args){
    	 int[] a1 = {7, 5, 4, 2, 2};  

    	 mergeSort(a1);

    	 // for(int i = 0; i < a1.length; i++){
      //       System.out.print(a1[i] + " ");
      //   }    

    }
}