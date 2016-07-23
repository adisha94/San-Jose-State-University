import java.util.*;
public class Print
{

	public Print(){}
	
	public void print(int result)
	{
		System.out.println(result);
	}
	public void print(long result) // overload
	{
		System.out.println(result);
	}
	public void print(String message) // overload
	{
		System.out.println(message);
	}
	public void print(Object result) // should print any general object
	{
		System.out.println("Your result is: " + result);
	}	
	
	public void print (boolean testingValue)// overload
	{
		System.out.println("Value of testingValue: " + testingValue);
	}
	public void print(Object[] result_Array)
	{
		for (int i = 0; i < result_Array.length; i++)
		{
			System.out.print(result_Array[i] + ", ");
			if (i == result_Array.length)
			{			
				print("Testing complete");
			}
		}
	}
		
//	public void print(ArrayList<Object> result_Array)
//	{
//		for (int i = 0; i < result_Array.size(); i++)
//		{
//			System.out.print(result_Array.get(i) + ", ");
//			if ( i == result_Array.size() )
//			{			
//				print("Testing complete");
//			}
//		}
//	}
	
}
