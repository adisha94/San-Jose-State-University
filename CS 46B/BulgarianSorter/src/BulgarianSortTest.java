//import java.util.*;
//import org.junit.*;
//import static org.junit.Assert.*;
//
//public class BulgarianSortTest
//{
//   @Test
//   public void testSort3()
//   {
//      int[] nums = { 1, 2, 3, 1, 3, 2, 2, 1, 3, 2, 3, 1, 3, 1, 2, 3, 2, 1 };
//      for (int i = 0; i < nums.length; i = i + 3)
//         BulgarianSorter.sortThree(nums, i);
//
//      // Now nums should be 1 2 3 1 2 3 1 2 3 ...
//      for (int i = 0; i < nums.length; i = i + 3)
//         for (int j = 1; j <= 3; j++)
//            assertEquals(j, nums[i + j - 1]);
//   }
//
//   @Test
//   public void testSort2()
//   {
//      int[] nums = { 1, 3, 2 };
//      BulgarianSorter.sortThree(nums, 1);
//      assertArrayEquals(new int[] { 1, 2, 3 }, nums);
//      BulgarianSorter.sortThree(nums, 1);
//      assertArrayEquals(new int[] { 1, 2, 3 }, nums);
//   }
//
//   @Test
//   public void testSort1()
//   {
//      int[] nums = { 1, 3, 2 };
//      BulgarianSorter.sortThree(nums, 2);
//      assertArrayEquals(new int[] { 1, 3, 2 }, nums);
//   }
//}