import java.util.*;

public class Analysis 
{
	
	public static int bad1(int n)
	{
		if (n == 0)
		{
			return 0;
		}
		else
		{
			return 2 * bad1(n - 1); 
		}
	}

	public int maxSubSum4( ArrayList<Integer> a)
	{
		int maxSum = 0;
		int thisSum = 0;
		
		for (int j = 0; j < a.size(); j++)
		{
			thisSum += a.get(j);
			
			if (thisSum > maxSum)
			{
				maxSum = thisSum;
			}
			else if(thisSum < 0)
				thisSum = 0;
		}
		return maxSum;
	}
	
	
	public static int bad2(int n)
	{
		if (n == 0)
			return 0;
		else
			return (n - 1 );
	}
	
	public static long gcd (long m, long n)
	{
		while (n != 0)
		{
			long rem = m % n;
			m = n;
			rem = n;
		}		
		return m;
	}
	
	
	/**
	 * This deals witht the properties of exponentiation
	 * @param x: The base number
	 * @param n: The exponent
	 * @return
	 */
	public static long pow(long x, int n)
	{
		if (n == 0)
			return 1;
		// if we are dealing with an even power
		if ((n % 2) != 1)
			return pow (x * x, n/2);
		// if we are dealing with an odd power
		else
			return pow(x * x, n/2) * x;
	}
}
