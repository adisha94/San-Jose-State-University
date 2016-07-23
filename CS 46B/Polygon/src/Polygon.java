import java.awt.geom.Point2D;
import java.util.ArrayList;

/**
   A polygon with a number of Point2D.Double corners
*/
// because i dont like to waste tie saying saying System.out.println()
public class Polygon
{
   private ArrayList<Point2D.Double> corners;
   private int calOffset = 0;

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
   
   
	private double TriangleArea(double x1, double y1, double x2, double y2, double x3, double y3) 
	{
		double area = 0;
		// calculating triangle formula
		double addSum = (x1 * y2) + (x2 * y3) + (x3 * y1);
		double subDiff = (y1 * x2) + (y2 * x3) + (y3 * x1);

		// area current iteration
		area = (subDiff - addSum) / 2;
		return area;
	}   

	private double getArea(ArrayList<Point2D.Double> remainingCorners) 
	{
		int size = remainingCorners.size();
		if (size < 3) {
			calOffset = 0;
			return 0;
		} 
		// point 1
		double pointX1 = remainingCorners.get(0).getX();
		double pointY1 = remainingCorners.get(0).getY();

		// point 2
		double pointX2 = remainingCorners.get(1).getX();
		double pointY2 = remainingCorners.get(1).getY();

		// point 3
		double pointX3 = remainingCorners.get(2).getX();
		double pointY3 = remainingCorners.get(2).getY();
		double area = TriangleArea(pointX1, pointY1, pointX2, pointY2, pointX3, pointY3);
		if (size == 3)
			return area;
		remainingCorners.remove(1); // to get to next triangle
		return area + getArea(remainingCorners);
	}
   
   /**
      Computes the area of a polygon.
      @return area of a polygon
   */
   public double getArea()
   {	   
	   ArrayList<Point2D.Double> newList = new ArrayList<Point2D.Double>(corners.size()); // clones into new with defined size
	   newList.addAll(corners);
	  return getArea(newList);	  
   }

}