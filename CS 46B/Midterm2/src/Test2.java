import org.junit.*;
import static org.junit.Assert.*;

public class Test2
{
   @Test public void test1()
   {
      int[] values = { 1, 2, 1, 1, 2, 3, 2, 3, 2, 4  };
      int result = ArrayAlg.mostFrequentElement(values);
      assertEquals(2, result);
   }
}