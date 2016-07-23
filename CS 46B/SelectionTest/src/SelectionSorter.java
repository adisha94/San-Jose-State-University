import java.util.Comparator;

/**
   The sort method of this class sorts an array, using the selection 
   sort algorithm.
*/
public class SelectionSorter
{
   /**
      Sorts an array, using selection sort.
      @param a the array to sort
      @param c the comparator
   */
   public static void sort(Object[] a, Comparator c)
   {
	   for (int i = 0; i < a.length; i++)
	   {
		   int minPos = minimumPosition(a, i, c);
		   ArrayUtil.swap(a, minPos, i);
	   }
   }

   /**
      Finds the smallest element in a tail range of the array.
      @param a the array to sort
      @param from the first position in a to compare
      @param c the comparator
      @return the position of the smallest element in the
      range a[from] . . . a[a.length - 1]
   */
   public static int minimumPosition(Object[] a, int from, Comparator c)
   {  
      int minPos = from;
      for (int i = from; i < a.length; i++)
      {
    	  if (c.compare(a[i], a[minPos]) < 0)
    	  {
    		  minPos = i;
    	  }    	  
      }
      return minPos;
   }
}