public class Occur
{
   /**
      Implement an O(n) algorithm that counts how many values occur 
      at most three times.
      @param values an array of n integers
      @return the count of repeated values
   */

   public static int count(int[] values)
   {
	   boolean matchedValue = false;
	   int foundValues = 0;
	   int valueOccurs = 0;
	   int valueI = 1;
	   for (int i = 0; i < values.length; i++, valueI++)
	   {		  
		   // find the the current target value of valueI with index location i
		   if (values[i] == valueI)
		   {
			   matchedValue = true;
			   valueOccurs++;
			   if (valueOccurs <= 3)
			   {
				   foundValues++;
			   }
			   
		   }
		   if (valueI == 9)
		   {
			   valueI = 1;
		   }
	   }
	   return foundValues;
   }

   public static void main(String[] args)
   {
      System.out.println(count(new int[] 
         { 1, 2, 3, 4, 5, 6, 7, 8, 9, 
           2, 3, 4, 5, 6, 7, 8, 9, 
           3, 4, 5, 6, 7, 8, 9, 
           4, 5, 6, 7, 8, 9, 
           5, 6, 7, 8, 9, 
           6, 7, 8, 9, 
           7, 8, 9, 
           8, 9, 
           9 }));         
      System.out.println(count(new int[] 
         { 1, 2, 3, 4, 5, 6, 7, 8, 9, 
           1, 2, 3, 4, 5, 6, 7, 8, 
           1, 2, 3, 4, 5, 6, 7,
           1, 2, 3, 4, 5, 6, 
           1, 2, 3, 4, 5, 
           1, 2, 3, 4,
           1, 2, 3, 
           1, 2, 
           1 }));         
   }
}
