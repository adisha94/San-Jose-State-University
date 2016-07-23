
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.NoSuchElementException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class ArrayLIstAddressBookTest
{

	private ArrayList<Item> items;
	private String source;
	private boolean modified;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception
	{
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception
	{
		
	}

	@Before
	public void setUp() throws Exception
	{
		items = new ArrayList<Item>();
		source = "";
		modified = false;
	}

	@After
	public void tearDown() throws Exception
	{
		
	}

	public String get(String name, String key)
	{
		for (Item it : items) 
		{
			if (name.equals(it.getName()) && key.equals(it.getKey()))
			{
				return it.getValue();
			}
		}
		return null;
	}
	
	@Test
	public void anEmptyDirectoryHasNoFred()
	{
		AddressBook dir = new ArrayListAddressBook();
		assertNull(dir.get("Fred", "Phone"));
	}
	
	@Test
	   public void remove() throws NoSuchElementException
	   {
//	      String value = get(name, key);
//	      if (value == null)
//	      {
//	      }
//	      else
//	      {
//	    	  return "Entry has been removed";
//	      }
		try
		{
			
		}
		catch (NoSuchElementException e)
		{
			System.out.println("Our exception message");
		}
		
	   }  
}
