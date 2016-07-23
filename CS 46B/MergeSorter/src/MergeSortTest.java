import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

public class MergeSortTest
{
//   @Test
   public void mergeTest()
   {
      int[] nums = { 1, 4, 1, 2, 7, 0, 4, 6, 7, 5, 8 };
      MergeSorter.merge(2, 4, 8, nums, false);
      assertArrayEquals(nums, new int[] { 1, 4, 0, 1, 2, 4, 6, 7, 7, 5, 8});                                          
   }

   @Test
   public void testLength15()
   {
      int[] nums = { 1, 2, 11, 3, 12, 15, 6, 13, 5, 14, 4, 10, 8, 9, 7 };
      MergeSorter.sort(nums, false);
      for (int i = 0; i < nums.length; i++)
         assertEquals(i + 1, nums[i]);
   }

   @Test
   public void testLength16()
   {
      int[] nums = { 1, 2, 11, 16, 3, 12, 6, 13, 5, 14, 15, 4, 10, 8, 9, 7 };
      MergeSorter.sort(nums, false);
      for (int i = 0; i < nums.length; i++)
         assertEquals(i + 1, nums[i]);
   }

   @Test
   public void testLength17()
   {
      int[] nums = { 1, 17, 2, 11, 3, 16, 12, 6, 13, 5, 14, 15, 4, 10, 8, 9, 7 };
//      int[] nums = { 1, 2, 3, 6, 5, 4, 8, 9, 7 };
      MergeSorter.sort(nums, false);
      for (int i = 0; i < nums.length; i++)
         assertEquals(i + 1, nums[i]);
   }

   @Test
   public void testOtherValues()
   {
      int[] nums = new int[101];
      for (int i = 1; i < nums.length; i++) 
         nums[(31 * i) % nums.length] = i * i;
      MergeSorter.sort(nums, false);
      for (int i = 0; i < nums.length; i++)
         assertEquals(i * i, nums[i]);
   }
}
