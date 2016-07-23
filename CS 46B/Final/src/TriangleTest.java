import org.junit.Test;
import static org.junit.Assert.*;
import java.awt.Point;

public class TriangleTest
{
   @Test public void testIdenticalTriangles()
   {
      Triangle t1 = new Triangle(new Point(0, 0), new Point(3, 4), new Point(4, 2));
      Triangle t2 = new Triangle(new Point(0, 0), new Point(3, 4), new Point(4, 2));
      assertTrue(t1.equals(t2));
      assertTrue(t1.hashCode() == t2.hashCode());
   }

   @Test public void testDifferentTriangles()
   {
      Triangle t1 = new Triangle(new Point(0, 0), new Point(3, 4), new Point(4, 2));
      Triangle t2 = new Triangle(new Point(0, 0), new Point(3, 4), new Point(5, 5));
      assertFalse(t1.equals(t2));
      assertFalse(t1.hashCode() == t2.hashCode());
         // Strictly speaking, the hash codes might be the same. But if they
         // are, tweak your hash function so that they aren't.
   }

   @Test public void testPermutedTriangles()
   {
      Point p1 = new Point(0, 0);
      Point p2 = new Point(3, 4);
      Point p3 = new Point(4, 2);

      Triangle t1 = new Triangle(p1, p2, p3);
      Triangle t2 = new Triangle(p1, p3, p2);
      Triangle t3 = new Triangle(p2, p1, p3);
      Triangle t4 = new Triangle(p2, p3, p1);
      Triangle t5 = new Triangle(p3, p1, p2);
      Triangle t6 = new Triangle(p3, p2, p1);

      assertTrue(t1.equals(t2));
      assertTrue(t1.equals(t3));
      assertTrue(t1.equals(t4));
      assertTrue(t1.equals(t5));
      assertTrue(t1.equals(t6));
      assertTrue(t1.hashCode() == t2.hashCode());
      assertTrue(t1.hashCode() == t3.hashCode());
      assertTrue(t1.hashCode() == t4.hashCode());
      assertTrue(t1.hashCode() == t5.hashCode());
      assertTrue(t1.hashCode() == t6.hashCode());
   }
}
