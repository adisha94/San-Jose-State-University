import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

public class BulgarianSortTest2
{

   @Test
   public void testLength9()
   {
      int[] nums = { 1, 2, 3, 6, 5, 4, 8, 9, 7 };
      BulgarianSorter.sort(nums);
      for (int i = 0; i < nums.length; i++)
         assertEquals(i + 1, nums[i]);
   }

   @Test
   public void testLength10()
   {
      int[] nums = { 1, 2, 3, 6, 5, 4, 10, 8, 9, 7 };
      BulgarianSorter.sort(nums);
      for (int i = 0; i < nums.length; i++)
         assertEquals(i + 1, nums[i]);
   }
   
   @Test
   public void testSortedAgain()
   {
	    int[] nums = { 1, 2, 3, 6, 5, 4, 10, 8, 9, 7 };
	    assertEquals(false, BulgarianSorter.isSorted(nums));
   }
   @Test
   public void testLength11()
   {
      int[] nums = { 1, 2, 11, 3, 6, 5, 4, 10, 8, 9, 7 };
      BulgarianSorter.sort(nums);
      for (int i = 0; i < nums.length; i++)
         assertEquals(i + 1, nums[i]);
   }

   @Test
   public void testOtherValues()
   {
      int[] nums = new int[101];
      for (int i = 1; i < nums.length; i++) 
         nums[(31 * i) % nums.length] = i * i;
      BulgarianSorter.sort(nums);
      for (int i = 0; i < nums.length; i++)
         assertEquals(i * i, nums[i]);
   }
}