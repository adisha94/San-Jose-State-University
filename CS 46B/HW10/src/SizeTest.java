import java.org.junit.*;
import static java.org.junit.Assert.*;

import java.util.ListIterator;

public class SizeTest
{  
	@Test
	public void test1() 
	{
		LinkedList names = new LinkedList();
		names.addFirst("Tom");
		names.addFirst("Romeo");
		names.addFirst("Harry");
		names.addFirst("Dick");

		ListIterator iterator = names.listIterator();
		iterator.next();
		iterator.next();
		iterator.remove();
		assertEquals(3, names.size1());
		assertEquals(3, names.size2());
		assertEquals(3, names.size3());
	}

   //@Test 
	public void test3()
   { 
      LinkedList names = new LinkedList();
      names.addFirst("Peter");
      names.addFirst("Paul");
      names.addFirst("Mary");
      assertEquals(3, names.size1());
      assertEquals(0, names.size2());
      assertEquals(0, names.size3());
   }

   //@Test 
	public void test0()
   { 
      LinkedList names = new LinkedList();
      assertEquals(0, names.size1());
      assertEquals(0, names.size2());
      assertEquals(0, names.size3());
   }
}