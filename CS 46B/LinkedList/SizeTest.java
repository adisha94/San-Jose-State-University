import org.junit.*;
import static org.junit.Assert.*;
//import java.util.*;

public class SizeTest
{  
   @Test public void test1()
   { 
      LinkedList names = new LinkedList();
      names.addFirst("Tom");
      names.addFirst("Romeo");
      names.addFirst("Harry");
      names.addFirst("Dick");

      ListIterator iterator = names.listIterator();
      iterator.next();
      iterator.next();
      iterator.remove();
      assertEquals(3, names.size1());
      assertEquals(3, names.size2());
      assertEquals(3, names.size3());
   }

   @Test public void test2()
   {
      LinkedList names = new LinkedList();
      names.addFirst("Tom");
      names.addFirst("Romeo");
      names.addFirst("Dick");
      
      ListIterator iterator = names.listIterator();
      iterator.next();
      iterator.remove();
      iterator.add("Juliet");
      iterator.next();
      iterator.set("Emily");

      assertEquals(3, names.size1());
      assertEquals(3, names.size2());
      assertEquals(3, names.size3());
   }      

   @Test public void test3()
   {
      LinkedList names = new LinkedList();
      names.addFirst("Tom");
      names.addFirst("Romeo");
      names.addFirst("Dick");
      names.removeFirst();
      
      assertEquals(2, names.size1());
      assertEquals(2, names.size2());
      assertEquals(2, names.size3());
   }

   @Test public void test4()
   {
      LinkedList nums = new LinkedList();
      for (int i = 1; i <= 1000; i++)
      {
         nums.addFirst("" + i);
      } // 1000

      ListIterator iterator = nums.listIterator(); 

      for (int i = 1; i <= 500; i++) { iterator.next(); iterator.remove(); }
      // 500

      for (int i = 1; i <= 100; i++) { iterator.add("" + i); } // 600
      

      for (int i = 1; i <= 200; i++) { nums.removeFirst();  } // 400
      assertEquals(400, nums.size1());
      assertEquals(400, nums.size2());
      assertEquals(400, nums.size3());
   }

}
