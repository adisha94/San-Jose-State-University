import java.util.*;
import java.awt.geom.Point2D;
public class Polygon
{
	private ArrayList<Point2D.Double> vertices;
	public Polygon()
	{
		vertices = new ArrayList<Point2D.Double>();
	}
	
	private double TriangleArea(double x0,  double y0, double x1,  double y1, double x2, double y2)
	{
		double area = 0;
		double addSum = (x0 * y1) + (x1 * y2) + (x2 * y0);
		double subDiff = (y0 * x1) + (y1 * x2) + (y2 * x0);

		// area current iteration
		area = (subDiff - addSum) / 2;
		return area;
	}
	
	private double PolygonArea(ArrayList<Point2D.Double> remainingVertices)
	{
		double area = 0; // this gets the total area in the loop
		int numPoints = remainingVertices.size();
		int j = numPoints - 1; // last vertex before the first one
		for (int i = 0; i < numPoints; i++)
		{
			area = area +  ( remainingVertices.get(j).getX() +  remainingVertices.get(i).getX()) * ( remainingVertices.get(j).getY() -  remainingVertices.get(i).getX());
			j = i; // j is the previous vertex	
		}
		return area / 2;
	}
	
	public double getArea(ArrayList<Point2D.Double> remainingCorners)
	{
		int size = remainingCorners.size();
		// point 1
		double pointX0 = remainingCorners.get(0).getX();
		double pointY0 = remainingCorners.get(0).getY();

		// point 2
		double pointX1 = remainingCorners.get(1).getX();
		double pointY1 = remainingCorners.get(1).getY();

		// point 3
		double pointX2 = remainingCorners.get(2).getX();
		double pointY2 = remainingCorners.get(2).getY();
		
		if (size == 3)
		{	
			TriangleArea(pointX0, pointY0, pointX1, pointY1, pointX2, pointY2);
			return 0;
		} 
		else if (size > 3)
		{
			PolygonArea(remainingCorners);
		}
		return 0;		
	}
}
