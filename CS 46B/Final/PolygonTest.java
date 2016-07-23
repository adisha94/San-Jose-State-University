import java.awt.geom.Point2D;
import org.junit.Test;
import static org.junit.Assert.*;

public class PolygonTest
{
   @Test public void test1()
   {
      Polygon triangle = new Polygon();
      triangle.add(new Point2D.Double(2, 3));
      triangle.add(new Point2D.Double(3, 2));
      triangle.add(new Point2D.Double(0, 0));
      assertFalse(triangle.isDecomposable());
   }

   @Test public void test2()
   {
      Polygon poly = new Polygon(); // A 7-gon
      poly.add(new Point2D.Double(7, 2.5));
      poly.add(new Point2D.Double(10, 2));
      poly.add(new Point2D.Double(11, 5.5));
      poly.add(new Point2D.Double(10, 8.5));
      poly.add(new Point2D.Double(7.5, 9.5));
      poly.add(new Point2D.Double(5, 10));
      poly.add(new Point2D.Double(2.5, 7));
      Decomposable[] result = poly.decompose(); 
      // Decomposed into a 5-gon and a 4-gon
      Polygon p1 = (Polygon) result[0];
      Polygon p2 = (Polygon) result[1];
      assertEquals(p1.get(0), poly.get(0));
      assertEquals(p1.get(1), poly.get(1));
      assertEquals(p1.get(2), poly.get(2));
      assertEquals(p1.get(3), poly.get(3));
      assertEquals(p1.get(4), poly.get(4));
      assertEquals(p2.get(0), poly.get(4));
      assertEquals(p2.get(1), poly.get(5));
      assertEquals(p2.get(2), poly.get(6));
      assertEquals(p2.get(3), poly.get(0));
   }
}
