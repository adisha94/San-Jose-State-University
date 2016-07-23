import org.junit.*;
import static org.junit.Assert.*;

public class Test1
{  
   @Test public void test1()
   {
      LinkedList names = new LinkedList();
      names.addLast("Fred");
      names.addLast("Wilma");
      Iterator iter = names.iterator();
      assertEquals("Fred", iter.get());
      assertFalse(iter.atEnd());
      iter.next();
      assertEquals("Wilma", iter.get());
      assertEquals("Wilma", iter.get());
      iter.next();
      assertTrue(iter.atEnd());      
   }

   @Test public void test0()
   {
      LinkedList names = new LinkedList();
      Iterator iter = names.iterator();
      assertTrue(iter.atEnd());      
   }
}
