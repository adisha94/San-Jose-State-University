import java.util.*;

/**
 * This is a test class for this problem
 * @author Adish Betawar
 *
 */
public class test 
{
	/*
	 * globals
	 */
	static Object answer = null;	

	
	public static void main(String[] args)
	{
		Analysis ana = null;
		System.out.println("Answer: " + Analysis.bad1(23));
		System.out.println("Answer: " + Analysis.bad2(4));
		
		
		ArrayList<Integer> numberList = new ArrayList<>();
		for (int i = 0; i < 14; i++)
		{
			numberList.add(i);
		}
		answer = 1;
//		System.out.println(Analysis.pow(2, 2));
		System.out.println(Analysis.gcd(0, 1));
//		System.out.println("The answer is: " + ana.maxSubSum4(numberList));
	}

}