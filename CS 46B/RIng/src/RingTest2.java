import org.junit.*;
import static org.junit.Assert.*;

public class RingTest2
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

   @Test 
   public void testSetGet()
   {
      Ring ring = new Ring(10);
      verifyLinks(ring, 10);
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

   @Test public void testAdd()
   {
      Ring ring = new Ring(20);
      ring.set("Fred");
      ring.forward();
      ring.set("Wilma");
      ring.add("Barney");
      ring.backward();
      ring.backward();
      verifyLinks(ring, 21);
      assertEquals("Fred", ring.get());
      ring.forward();
      assertEquals("Barney", ring.get());
      ring.forward();
      assertEquals("Wilma", ring.get());
      ring.forward();
      assertNull(ring.get());
   }

   @Test public void testRemove()
   {
      Ring ring = new Ring(20);
      ring.set("Fred");
      ring.forward();
      ring.set("Wilma");
      ring.forward();
      ring.set("Barney");
      ring.backward();
      assertEquals("Wilma", ring.remove());
      ring.backward();
      verifyLinks(ring, 19);
      assertEquals("Fred", ring.get());
      ring.forward();
      assertEquals("Barney", ring.get());
      ring.forward();
      assertNull(ring.get());
   }

   @Test(expected=IllegalStateException.class)
   public void testRemoveLast() 
   {
      Ring ring = new Ring(2);
      ring.set("Fred");
      ring.forward();
      ring.set("Wilma");
      ring.remove();
      ring.remove();
   }

   @Test(expected=IllegalArgumentException.class)
   public void testEmpty()
   {
      Ring ring = new Ring(0);
   }
}