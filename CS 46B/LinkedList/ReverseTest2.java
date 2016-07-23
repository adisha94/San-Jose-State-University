import org.junit.*;
import static org.junit.Assert.*;
import java.util.*;

public class ReverseTest2
{  
   public static void test(int n, String expected)
   {
      LinkedList names = new LinkedList();
      names.addFirst("Tom");
      names.addFirst("Romeo");
      names.addFirst("Harry");
      names.addFirst("Dick");
      names.addFirst("Bill");

      names.reverseFirstN(n);
      ListIterator iter = names.listIterator();
      String[] expecteds = expected.split(" ");
      int i = 0;
      while (iter.hasNext()) 
      {
         assertEquals(expecteds[i], iter.next());
         i++;
      }
   }

   @Test public void test0()
   { 
      test(0, "Bill Dick Harry Romeo Tom");
   }

   @Test public void test1()
   { 
      test(1, "Bill Dick Harry Romeo Tom");
   }

   @Test public void test3()
   { 
      test(3, "Harry Dick Bill Romeo Tom");
   }

   @Test public void test4()
   {
      test(4, "Romeo Harry Dick Bill Tom");
   }


   @Test public void test5()
   {
      test(5, "Tom Romeo Harry Dick Bill");
   }

   @Test public void test6()
   {
      test(6, "Tom Romeo Harry Dick Bill");
   }
}
