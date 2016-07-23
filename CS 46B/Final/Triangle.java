import java.awt.Point;
import java.util.HashSet;
import java.util.Set;

/**
   A triangle has three distinct corner points.
*/
public class Triangle
{
   private Set<Point> corners;;

   public Triangle(Point p1, Point p2, Point p3)
   {
      Set<Point> corners = new HashSet<>();
      corners.add(p1);
      corners.add(p2);
      corners.add(p3);
      if (corners.size() != 3) 
         throw new IllegalArgumentException("Points must be distinct");
   }

   public Set<Point> getCorners()
   {
      return new HashSet<>(corners); 
   }

   /**
      Two triangles are equal if the points are the same in some order.
      For example, new Triangle(a, b, c) is equal to new Triangle(b, c, a),
      new Triangle(c, a, b), new Triangle(a, c, b), and so on.
   */
   public boolean equals(Object otherObject)
   {
	  if (this.corners == otherObject)
	  {		  
		  return true;
	  }
      return true;
   }
   /**
      Make sure that your definition of hashCode is compatible with the
      definition of equals. But don't return the same value for all triangles.
   */
   public int hashCode()
   {
	    int cornershash = corners.hashCode();
	   int cornersHash = 47 + (cornershash);
	   return cornersHash;
   }
}
