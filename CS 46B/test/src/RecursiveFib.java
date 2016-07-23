import java.util.Scanner;
import java.util.*;

public class RecursiveFib
{
	static HashMap<Integer, Integer> fibList = new HashMap<Integer, Integer>();
	
   public static void main(String[] args)
   {  
      Scanner in = new Scanner(System.in);
      System.out.print("Enter n: ");
      int n = in.nextInt();
      for (int i = 1; i <= n; i++)
      {
         Integer f = fib(i);        
         System.out.println("fib(" + i + ") = " + f);
      }
   }

   /**
      Computes a Fibonacci number.
      @param n an integer
      @return the nth Fibonacci number
   */
   public static Integer fib(int n)
   {
      Integer result;
      if (fibList.containsKey(n))
      {
    	  return fibList.get(n).intValue();
      }
      if (n <= 2) 
      {
    	result = 1; 
      }
      else
      {
    	Integer first = fib(n - 1);
	 	Integer second = fib(n - 2);
	 	result = first + second;
      }
      if (!fibList.containsKey(n))
      {
    	  fibList.put(n, result);
      }
      return result;
   }

}