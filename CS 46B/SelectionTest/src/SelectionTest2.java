import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

public class SelectionTest2
{
   @Test
   public void testStringSort()
   {
      String[] names = { "Peter", "Pauline", "Sue" };
      Comparator<String> comp = (s, t) -> s.compareTo(t); 
      SelectionSorter.sort(names, comp);
      assertArrayEquals(names, new String[] { "Pauline", "Peter", "Sue" });
   }

   @Test
   public void testStringByLengthSort()
   {
      String[] names = { "Peter", "Pauline", "Sue" };
      Comparator<String> comp = (s, t) -> s.length() - t.length(); 
      SelectionSorter.sort(names, comp);
      assertArrayEquals(names, new String[] { "Sue", "Peter", "Pauline" });

   }

   @Test
   public void testIntSort()
   {
      Integer[] values = { 
         new Integer(9), new Integer(7), new Integer(1), new Integer(2)};
      Comparator<Integer> comp = (m, n) -> Integer.compare(m, n);
      SelectionSorter.sort(values, comp);
      assertEquals("[1, 2, 7, 9]", Arrays.toString(values));
   }
}