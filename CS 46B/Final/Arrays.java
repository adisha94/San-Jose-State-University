public class Arrays
{
   /**
      A sequence is a zigzag sequence if it is first ascending, then
      descending. For example, 1 2 4 6 5 3 2 is a zigzag sequence, but
      1 2 4 6 5 7 8 is not. 

      The zigZagPeak method below finds the index of the peak, where the 
      sequence stops increasing and starts decreasing.

      This method merges two zigzag sequences. 
      
      Find the peaks, extract the ascending and descending subsequences,
      merge them separately, and then concatenate them. Reverse the descending
      subsequences before and after merging.

      A number of helper methods are given to you. The merge method is identical
      to that of the textbook.
      
      @param a a zigzag sequence
      @param b another zigzag sequence
      @return the merged sequence
   */
   public static int[] mergeZigZag(int[] a, int[] b)
   {
      int p1 = zigZagPeak(a);    
      int p2 = zigZagPeak(b);    
      if (p1 < 0 || p2 < 0) throw new IllegalArgumentException();
      int[] a1 = copy(a, ..., ...); // Up to peak
      int[] a2 = copy(a, ..., ...); // After peak
      reverse(...);
      ...
      ...
      ...
      int[] r1 = new int[...];
      int[] r2 = new int[...];
      merge(..., ..., ...);
      merge(..., ..., ...);      
      ...
      return concat(..., ...);
   }

   /**
      Returns the peak index of a zigzag sequence, or -1 if the
      sequence is not a zigzag sequence.
   */
   public static int zigZagPeak(int[] a)
   {
      int i = 0;
      while (i < a.length - 1 && a[i] <= a[i + 1]) i++;
      if (i == a.length - 1) return -1; // no zag
      int peak = i;
      while (i < a.length - 1 && a[i] >= a[i + 1]) i++;
      if (i < a.length - 1) return -1; // more zig
      return peak;
   }

   /**
      Copies a range of an array into a new array.
      @param a an array
      @param from the first index of the range
      @param to the last index of the range
      @return a new array containing a[from]...a[to]
   */
   public static int[] copy(int[] a, int from, int to)
   {
      int[] result = new int[to - from + 1];
      for (int i = 0; i < result.length; i++) result[i] = a[from + i];
      return result;
   }

   /**
      Concatenates two given arrays.
      @param a an array
      @param b another array
      @return a new array consisting of all elements of a followe
      by all elements of b
   */
   public static int[] concat(int[] a, int[] b)
   {
      int[] r = new int[a.length + b.length];
      for (int i = 0; i < a.length; i++) r[i] = a[i];
      for (int i = 0; i < b.length; i++) r[a.length + i] = b[i];
      return r;
   }

   /**
      Reverses an array.
      @param a the array
   */
   public static void reverse(int[] a)
   {
      int i = 0;
      int j = a.length - 1;
      while (i < j)
      {
         swap(a, i, j);
         i++;
         j--;
      }
   }

   /**
      Swaps two entries of an array.
      @param a the array
      @param i the first position to swap
      @param j the second position to swap
   */
   public static void swap(int[] a, int i, int j)
   {
      int temp = a[i];
      a[i] = a[j];
      a[j] = temp;
   }
   
   /**
      Merges two sorted arrays into an array
      @param first the first sorted array
      @param second the second sorted array
      @param a the array into which to merge first and second
   */
   public static void merge(int[] first, int[] second, int[] a)
   {  
      int iFirst = 0; // Next element to consider in the first array
      int iSecond = 0; // Next element to consider in the second array
      int j = 0; // Next open position in a

      // As long as neither iFirst nor iSecond is past the end, move
      // the smaller element into a
      while (iFirst < first.length && iSecond < second.length)
      {  
         if (first[iFirst] < second[iSecond])
         {  
            a[j] = first[iFirst];
            iFirst++;
         }
         else
         {  
            a[j] = second[iSecond];
            iSecond++;
         }
         j++;
      }

      // Note that only one of the two loops below copies entries
      // Copy any remaining entries of the first array
      while (iFirst < first.length) 
      { 
         a[j] = first[iFirst]; 
         iFirst++; j++;
      }
      // Copy any remaining entries of the second half
      while (iSecond < second.length) 
      { 
         a[j] = second[iSecond]; 
         iSecond++; j++;
      }
   }
}
