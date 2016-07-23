import java.util.*;

public class Sort<AnyType> 
{
	/*
	 * This is a class that will be used for keeping track of all kinds of sorting methods
	 */
	
	public void Swap(AnyType any1, AnyType any2)
	{
		AnyType temp = any1;
		any1 = any2;
		any2 = temp;
	}
	
	
	public void Swap(AnyType[] arr, int i, int j)
	{
		AnyType temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	public AnyType findMax(AnyType [] arr, Comparator<? super AnyType> cmp)
	{
		int maxIndex = 0;
		
		for (int i = 0; i < arr.length; i++)
		{
			if (cmp.compare(arr[i], arr[maxIndex]) > 0)
			{
				maxIndex = i;
			}
		}
		
		return arr[maxIndex];
	}
	
	
	
	
}
