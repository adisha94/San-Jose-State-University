import java.util.*;

public class ArrayAlg
{
	
   public static int mostFrequentElement(int[] inputs)
   {
	      Arrays.sort(inputs);

	      int[] frequency = new int[inputs.length];

	      int i = 0; 
	      while (i < inputs.length)
	      {
	         // Find sequence with the same value
	         int otherElement = i;
	         while (otherElement < inputs.length && inputs[i]== inputs[otherElement]) otherElement++;
	         for (int k = i; k < otherElement; k++)
	            frequency[inputs[k]] = otherElement - i;
	         i = otherElement;
	      }

	      return mostFrequentElement; // out of time
	   }

   }