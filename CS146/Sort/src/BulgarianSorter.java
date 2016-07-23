
public class BulgarianSorter extends Sort
{
    public BulgarianSorter()
    {
    	super();
    }
    /*
     * This is the main sort location
     */
   public static void sort(int[] a)
   {
	   
	   if (!isSorted(a))
	   {
		   
		for (int i = 0; i < a.length; i++)
		{
			for (int j = 0; j < a.length; j++)
			{
				sortThree(a, j);
			}
		
		}
	   }

   }

   /**
      Sorts the three elements a[start], a[start + 1], a[start + 2].
      If start > a.length - 3, sorts the one or two remaining elements.
   */
   public static void sortThree(int[] a, int start)
   {
	   /// need minimum three elements in the array
	   if( (a.length - start ) < 3 )
	   {
		   if ((a.length - start ) == 1)
		   {
			   return;
		   }
		   // it has two elements
		   sortTwo(a, start);
		   return;
	   }
	   // a[start]     1st element
	   // a[start + 1] 2nd element
	   // a[start + 2] 3rd element
	   // 
	   sortTwo(a, start); 	  // sorting 1st and 2nd element
	   sortTwo(a, start + 1); // sorting 2nd and third element
	   sortTwo(a, start);     // now sort 1st and 2nd element again. This will sort the first and third element
	}
   
   
   /**
    * 
    * @param a the array that we will use in this method
    * @param start the index that will help to sort out the entries in the array
    */
   public static void sortTwo(int[] a, int start)
   {
	   if( (a.length - start ) < 2 )
	   {
		   return;
	   }
	   if (a[start] > a[start + 1])
	   {
		   swap(a, start, start + 1);
	   }
   }
   
   
   /**
      Checks whether the given array is sorted.
      @param a an array
      @return true if the array is sorted
   */
   public static boolean isSorted(int[] a)
   {
	   for(int i=0; i<a.length - 1; i++)
	   {
		   if(a[i] > a[i+1])
			   return false;
	   }
	   return true;
   }

   /**
      Swaps two entries of the array.
      @param a an array
      @param i the first position to swap
      @param j the second position to swap
   */
   private static void swap(int[] a, int i, int j)
   {
      int temp = a[i];
      a[i] = a[j];
      a[j] = temp;      
   }
}
