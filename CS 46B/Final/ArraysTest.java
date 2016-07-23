import org.junit.Test;
import static org.junit.Assert.*;

public class ArraysTest
{
   @Test public void test1()
   {
      int[] a = { 3, 5, 8, 11, 7, 5, 2 };
      int[] b = { 2, 5, 9, 4, 1 };
      System.out.println(java.util.Arrays.toString(Arrays.mergeZigZag(a, b)));
      assertArrayEquals(new int[] { 2, 3, 5, 5, 8, 9, 11, 7, 5, 4, 2, 1 },
         Arrays.mergeZigZag(a, b));
   }
}
