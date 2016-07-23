/**
   This class sorts an array, using the merge sort 
   algorithm nonrecursively.
*/
public class MergeSorter
{
	/**
	 * 
	 * @param a: the initial array 
	 * @param debug: The boolean variable
	 */
   public static void sort(int[] a, boolean debug)
   {
	   int length = 1; // The size of the sorted regions; a power of 2
	   while(length <= (a.length / 2 + 1))
	   {		
		   // sorting block size for entire array
	        int start = length;
	        while (start < a.length)
	        {
	        	// we are doing merge sort for the block size
	        	int mid = start-1;
	            merge(start - length, mid, Math.min(mid + length, (a.length-1)), a, debug);
	            start = start + 2 * length;
	        }
			length *= 2; // 1, 2, 4, 8, 16....length of the block
	   }
	   /// dealing with the extra element left after 2^n distribution
	   if(a.length > length)
	   {
	       merge(0, length - 1, a.length-1, a, debug);
	   }
   }

/**
 * We will be using in-place merging to solve this problem
 * @param from: left side
 * @param mid: right side
 * @param to: 
 * @param a: the newly merged array
 * @param debug: checking to see if method occurs?
 */
   public static void merge(int from, int mid, int to, int[] a, boolean debug)
   {
	   // draft
      if (debug)
         System.out.println("Merging " + from + "..." + mid 
            + " and " + (mid + 1) + "..." + to);
     
      // final
      
      // create an array for copying
      int[] merge = new int[to - from + 1];
      int l = 0;
      int r = 0;
      int i = 0;
      int midSt = mid + 1; // next block starting point

      // merge begins here 
      while ((l <= midSt - from) && 
    		  (r <= to - mid) && /// we are inbound between first and second block
    		  (i < merge.length) && // we cannot exceed size of the merge array 
    		  ((from + l) <= mid) && // if first block is finished comparing 
    		  ((midSt + r) <= to)) // if the second block is finished comparing
      {    	  
    	  // if the element in the first block is smaller than the element in the second block
    	  // 	then we take the smaller element in the corresponding block into the incremented merge array
    	  merge[i++] = (a[from + l] < a[midSt + r]) ? a[from + l++] : a[midSt + r++];
      }
      
      // remaining second block
      while (r <= to - midSt && i < merge.length)
      {
    	  merge[i++] = a[midSt + r++];
      }
   
      // remaining first block
      while (l <= midSt - from && i < merge.length)
      {
    	  merge[i++] = a[from + l++];
      }
      
      // copying merged array into input array
      System.arraycopy(merge, 0, a, from, merge.length);     
   }
}