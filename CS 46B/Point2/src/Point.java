public class Point implements Comparable
{
   private double x;
   private double y;
   
   /**
      Constructs a point with given x- and y-components.
      @param x the x-component
      @param y the y-component
   */
   public Point(double x, double y)
   {
      this.x = x;
      this.y = y;
   }

   /**
      Returns the x-component of this point.
      @return the x-component
   */
   public double getX()
   {
	   return x;
   }

   /**
      Returns the y-component of this point.
      @return the y-component
   */
   public double getY()
   { 
	   return y;
   }

   
/**
 *  To compare two points, first compare their x-coordinates.
 *  If they differ, the point with the smaller x is deemed the smaller.
 *  If the x-coordinates are the same, compare the y-coordinates.
 *  If the x-coordinates are the same, then we compare the y-coordinates
 *  The point with the smaller y-coordinate is then deemed the smaller.
 *  If the x-coordinates and y-coordinates are the same, the points are equal (duh).
 */
   @Override
   public int compareTo(Object o)
   {
	   // converting o to Point type
	   Point inO = (Point)o; 
	   // compare x coordinates
	   if (this.x < inO.x)
	   {
		   return -1;
	   }
	   else if (this.x > inO.x)
	   {
		   return 1;
	   }
	   // both x coordinates are same.
	   if (this.y < inO.y)
	   {
		   return -1;
	   }
	   else if (this.y > inO.y)
	   {
		   return 1;
	   }
	   // now we have x and y same for both points.
	   return 0;

	   
	   // if the x coordinates are the same then we compare the y coordinates
   }
}
