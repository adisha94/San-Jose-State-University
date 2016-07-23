import org.junit.*;
import static org.junit.Assert.*;

public class RingTest1
{
   public void verifyLinks(Ring ring, int size)
   {
      Ring.Node n = ring.start;
      Ring.Node p = ring.start;
      for (int i = 0; i < size; i++)
      {
         if (n.next == null) throw new IllegalStateException("next is null");
         if (p.previous == null) throw new IllegalStateException("previous is null");    
         if (i < size - 1)
         {
            if (n.next == ring.start || p.previous == ring.start) throw new IllegalStateException("size < " + size);
         }
         else
         {
            if (n.next != ring.start || p.previous != ring.start) throw new IllegalStateException("size > " + size);
         }
         n = n.next;
         p = p.previous;
      }
   }

   @Test public void testSetGet()
   {
      Ring ring = new Ring(3);
      verifyLinks(ring, 3);
      ring.set("Fred");
      ring.forward();
      ring.set("Wilma");
      ring.backward();
      assertEquals("Fred", ring.get());
      ring.forward();
      assertEquals("Wilma", ring.get());
      ring.forward();
      assertNull(ring.get());
   }
}
