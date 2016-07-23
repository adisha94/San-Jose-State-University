import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestingAddFirst
{

	@BeforeClass
	public static void setUpBeforeClass() throws Exception
	{
		
	}
	
	@Test
	public void addFirstTest()
	{
		LinkedList myList = new LinkedList();
		addFirst("bob");
		boolean checker =  (myList.first.next == myList.first);
		assertTrue( false, checker);
		
	}
	
	
	public void addFirst(Object element)
	{
		Node newNode = new Node;
		first = newNode;
		newNode.data = element;
		newNode.next = first;
	}
}
