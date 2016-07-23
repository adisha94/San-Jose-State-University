public class PointTester
{
   public static void main(String[] args)
   {
      Point p1 = new Point(3, 4);
      Point p2 = new Point(2, 4);
      Comparable<Point> p3 = new Point(3, 2);

      System.out.println(p1.compareTo(p2) < 0);
      System.out.println("Expected: false\n");
      
      System.out.println(p2.compareTo(p1) < 0);
      System.out.println("Expected: true\n");
      
      System.out.println(p1.compareTo((Point) p3) < 0);
      System.out.println("Expected: false\n");
      
      System.out.println(p3.compareTo(p1) < 0);
      System.out.println("Expected: true\n");
      
      System.out.println(p1.compareTo(new Point(3, 4)) == 0);
      System.out.println("Expected: true");
   }
}