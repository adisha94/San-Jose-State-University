import java.awt.geom.Point2D;
import java.util.*;

/**
   A polygon with a number of Point2D.Double corners. As you know from midterms 1 
   and 2, a polygon can be decomposed into two smaller polygons with the same 
   (or almost the same) number of vertices.  Assume the polygon has corners 
   c[0] ... c[n - 1]. Decompose it into two polygons with corners c[0] ...c[k] and 
   c[k] ... c[n - 1] c[0]. If n is odd, then the first one has one more corner
   than the second one.

   Have this class implement the Decomposable interface. Triangles are not
   decomposable. Polygons with > 3 corners can be decomposed as described.
*/
public class Polygon implements Decomposable
{
   private ArrayList<Point2D.Double> corners;

   /**
      Constructs a Polygon object with no corners
   */
   public Polygon()
   {
      corners = new ArrayList<Point2D.Double>();
   }
   
   /**
      Adds a point to the list.
      @param p the point to add
   */
   public void add(Point2D.Double p)
   {
      corners.add(p);   
   }
   
   public Point2D.Double get(int i)
   {
      return corners.get(i);
   }

   public int size()
   {
      return corners.size();
   }

	/**
	 * Checks whether this object can be broken down into two smaller objects of
	 * the same type.
	 * 
	 * @return true if this object can be further decomposed.
	 */
	@Override
	public boolean isDecomposable()
	{
		// running triangle test		
		if (this.corners.size() > 3)
		{
			return true;
		}
		return false;
	}

	/**
	 * Breaks down this object into two smaller objects of the same type.
	 * 
	 * @return an array of length 2, containing the two smaller objects.
	 */
	@Override
	public Decomposable[] decompose()
	{
		Decomposable[] decomposedPolygon[corners.size()];
		return decomposedPolygon[2];
	}
}
