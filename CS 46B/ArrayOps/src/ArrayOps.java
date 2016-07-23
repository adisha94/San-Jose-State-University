import java.util.ArrayList;

public class ArrayOps
{
   /**
       This method goes through the given array of integers,
       yielding a new ArrayList from the array that contains the
       elements of the original array, with duplicates removed.
       @param theArray, an array of integer
       @return the new ArrayList

   */
   public static ArrayList<Integer> copyArray(int[] anArray)
   {
	   // create unique element list from input anArray
	   ArrayList<Integer> result = new ArrayList<Integer>();    
	   for (int i = 0; i < anArray.length; i++)
	   {
		   if (result.indexOf(anArray[i]) == -1)
		   {
			   result.add(anArray[i]);			   
		   }
	   }
      return result;
   }

   /**
       This method goes through the given array list of integers,
       yielding a new array from the array list that contains the
       elements of the original array list, with duplicates removed.
       @param theArrayList, an array list of integer
       @return the new array

   */
   public static int[] copyArrayList(ArrayList<Integer> anArrayList)
   {
      // create unique element list from input anArrayList
	   ArrayList<Integer> result = new ArrayList<Integer>();    
	   for (int i = 0; i < anArrayList.size(); i++)
	   {
		   if (result.indexOf(anArrayList.get(i)) == -1)
		   {
			   result.add(anArrayList.get(i));			   
		   }
	   }
	   // Converting from dynamic Arraylist to int Array
	   int[] resultInt = new int[result.size()];
	   for (int i = 0; i < resultInt.length; i++)
	   {
		   // converts from Integer object to primitive int		   
		   resultInt[i] = result.get(i).intValue();
	   }
      return resultInt;
   }
}
