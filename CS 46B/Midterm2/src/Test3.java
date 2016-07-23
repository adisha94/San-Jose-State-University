import org.junit.*;
import static org.junit.Assert.*;

public class Test3
{
   @Test public void test1()
   {
      LinkedList names = new LinkedList();
      names.addLast("Peter");
      names.addLast("Paul");
      names.addLast("8973432");

      LinkedList.Pointer p = names.listPointer();
      p.next(); // Skips Peter
      p.remove(); // Removes Paul
      p.remove(); // Removes 8973432
      names.addLast("Mary");
      p = names.listPointer();
      assertEquals("Peter", p.get());
      assertTrue(p.hasNext());
      p.next();
      assertEquals("Mary", p.get());
      assertFalse(p.hasNext());
   }
}