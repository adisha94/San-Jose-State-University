public class PointTester
{
   public static void main(String[] args)
   {
      Measurable p1 = new Point( 0, 0);

      System.out.println(p1.getMeasure());
      System.out.println("Expected: 0");
      
      p1 = new Point(3, 4);
      Point p2 = new Point(13, 84);
      Measurable p3 = new Point(65, 72);

      System.out.println(p1.getMeasure());
      System.out.println("Expected: 5");
      System.out.println(p2.getMeasure());
      System.out.println("Expected: 85");
      System.out.println(p3.getMeasure());
      System.out.println("Expected: 97");
   }
}
