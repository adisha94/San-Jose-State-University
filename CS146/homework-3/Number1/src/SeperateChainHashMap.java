import java.util.*;

/**
 * This is an implementation of the seperate hash table portion of part A of number 1 of homework 2
 * @author Adish
 *
 */
public class SeperateChainHashMap<Anytype>
{
	private List<Anytype>[] theLists; // the main table to become hashmap
	private int currentSize; // keeps track of current size of table
	private static final int DEFAULT_TABLE_SIZE = 101;
	
	/**
	 * Takes default value in consideration
	 */
	public SeperateChainHashMap()
	{
		this(DEFAULT_TABLE_SIZE);
	}
	
	/**
	 * paramatized constructoer for seperate chaining hash table
	 * @param size
	 */
	public SeperateChainHashMap (int size)
	{
		theLists = new LinkedList[ nextPrime(size)];
		for (int i = 0; i < theLists.length; i++)
		{
			theLists[i] = new LinkedList<>(); // assigning  each entry to its own linkedlist 
		}
		
	}
	
	/**
	 * creating new hash entries
	 * @author Adish
	 *
	 * @param <Anytype>
	 */
	private class HashEntry<Anytype>
	{
		public Anytype element;
		public boolean isActive;
		public HashEntry(Anytype e)
		{
			this(e, true);
		}
		public HashEntry(Anytype e, boolean b) 
		{
			element = e;
			isActive = b;
		}
	}
	

	/**
	 * inserts hash into list
	 * @param x
	 */
	public void insert(Anytype x)
	{
		List<Anytype> whichList = theLists[MyHash(x)];
		if (!whichList.contains(x))
		{
			whichList.add(x);
			// rehashing here
			if(++currentSize > theLists.length)
				rehash();
		}
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

	public void remove(Anytype x)
	{
		List<Anytype> whichList = theLists[MyHash(x)];
		if (whichList.contains(x))
		{
			whichList.remove(x);
			currentSize--;
		}
	}
	
//	/**
//	 * search either through the 
//	 * linear
//	 * quadratic
//	 * double
//	 * @param item
//	 */
//	public void search(Object item)
//	{
//		
//	}
	
	/**
	 * will hand this method to someone else
	 */
	public void sort()
	{
		for (int i = 0; i < theLists.length; i++)
		{
			// at position [i]
			//sorting the lists at i in ascending order
			Collections.sort(theLists[i], Collections.reverseOrder(Collections.reverseOrder()));
		}
	}
	
	/**
	 * Gets an object of a particular hash code
	 * @param item
	 * @return
	 */
	public Object get(Anytype item)
	{
		return item;
	}
	
	/**
	 * Sets an element to a hash
	 * @param item
	 */
	public void set(Anytype item)
	{
		List<Anytype> whichList = theLists[MyHash(item)];
		if(!whichList.contains(item))
		{
			whichList.add(item);
			
			// rehashing over here in case we go overboard on size of table or reaching full amonunt
			if(++currentSize > theLists.length)
				rehash();
		}
	}

	/**
	 * rehashing method for separate chaining table
	 */
	public void rehash()
	{
		List<Anytype>[] oldLists = theLists; // 
		
		theLists = new List[ nextPrime(2 * theLists.length)]; // reallocating and creating duplicate but double size hash table
		
		for (int j = 0; j < theLists.length; j++)
		{
			theLists[j] = new LinkedList<>();
		}
		currentSize = 0;
		
		for (int i = 0; i < oldLists.length; i++)
		{
			for (Anytype item : oldLists[i])
			{
				insert(item);
			}
		}

	}

	/**
	 * Possible replacement for search()
	 * Checks to see if an  particular item exists within the hash table
	 * @param item
	 * @return
	 */
	public boolean contains(Anytype item)
	{
		List<Anytype> whichList = theLists[MyHash(item)];
		return whichList.contains(item);
	}
	
	/**
	 * Creating a custom hashCode for an object in this class
	 * @param element
	 * @return
	 */
	private int MyHash(Anytype element)
	{
		int hasVal = element.hashCode();
		hasVal %= theLists.length;
		if (hasVal < 0)
		{
			hasVal += theLists.length;
		}
		return hasVal; // returns a custom hashcode for data protection
	}
	
	
	public void PrintMap()
	{
		for (int i = 0; i < theLists.length; i++)
		{
			List<Anytype> whichList = theLists[i];
			for(Anytype temp: whichList)
			{
				System.out.println(temp.toString());
			}
		}
	}
}