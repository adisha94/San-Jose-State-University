import org.junit.*;
import static org.junit.Assert.*;

public class ReverseTest
{  
   @Test public void test()
   {
      LinkedList names = new LinkedList();
      names.addFirst("Tom");
      names.addFirst("Romeo");
      names.addFirst("Harry");
      names.addFirst("Dick");
      names.addFirst("Bill");

      names.reverseFirstN(2);
      ListIterator iter = names.listIterator();
      String[] expecteds = "Dick Bill Harry Romeo Tom".split(" ");
      int i = 0;
      while (iter.hasNext())
      {
         assertEquals(expecteds[i], iter.next());
         i++;
      }
   }
}