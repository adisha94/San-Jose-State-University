import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class MethodTesting 
{

	@Test
	public void test() 
	{
		int twenty_22 = 24;
//		assertTrue(isPrime(twenty_22));
//		assertEquals(23, nextPrime(twenty_22));
		int next_Number = nextPrime(twenty_22);
		System.out.println(next_Number);
	}
	
	/**
	 * goes to the next prime number
	 * @param size2
	 * @return
	 */
	private int nextPrime(int size2) 
	{
		// check if prime
		while (!isPrime(size2))
		{
			// increment the number
			size2++;			
		}
		return size2;
	}
	/**
	 * This method checks if the given number is a prime number
	 * @param number
	 * @return
	 */
	public static boolean isPrime(int number)
	{
		ArrayList<Integer> factors = new ArrayList<>();
 		boolean isAFactor = false; // this is a check switch
		// Dealing with the standard factors 1 and the number inputed itself
		
		factors.add(1);
		factors.add(number);
		int numberOfFactors = factors.size(); // assuming 1 and number itself is a factor
		int i = 2;
		for (; i < number; i++)
		{			
			// Assuming we DO count the first two factors
			numberOfFactors = factors.size();
			long tempStorage = number % i;
			if ( tempStorage == 0 )
			{
				isAFactor = true;
				if (factors.contains(i))
					break;
				else
				{
					factors.add(i);
					if (factors.contains(number / i)) // dealing with the partner number to prevent duplicates
						continue;
					factors.add(number / i);					
				}
			}			
			isAFactor = false; // switch boolean checker off
		}
		if (numberOfFactors == 2)
		{
			return true;
		}
		else if (numberOfFactors > 2)
		{
			return false;
		}
		return false;
	}	
}
