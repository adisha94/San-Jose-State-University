import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

public class StringMergeSorterTest
{
   @Test
   public void mergeTest()
   {
      String[] nums = { "1", "4", "1", "2", "7", "0", "4", "6", "7", "5", "8" };
      StringMergeSorter.merge(2, 4, 8, nums, false);
      assertArrayEquals(nums, new String[] { "1", "4", "0", "1", "2", "4", "6", "7", "7", "5", "8"});                                         
   }

   @Test
   public void testLength15()
   {
      String[] nums = { "1", "2", "11", "3", "12", "15", "6", "13", "5", "14", "4", "10", "8", "9", "7" };
      StringMergeSorter.sort(nums, false);
      for (int i = 0; i < nums.length; i++)
         assertEquals(Integer.toString(i + 1), nums[i]);
   }

   @Test
   public void testLength16()
   {
      String[] nums = { "1", "2", "11", "16", "3", "12", "6", "13", "5", "14", "15", "4", "10", "8", "9", "7" };
      StringMergeSorter.sort(nums, false);
      for (int i = 0; i < nums.length; i++)
         assertEquals(Integer.toString(i + 1), nums[i]);
   }

   @Test
   public void testLength17()
   {
      String[] nums = { "1", "17", "2", "11", "3", "16", "12", "6", "13", "5", "14", "15", "4", "10", "8", "9", "7"};
      StringMergeSorter.sort(nums, false);
      for (int i = 0; i < nums.length; i++)
         assertEquals(Integer.toString(i + 1), nums[i]);
   }

   @Test
   public void testOtherValues()
   {
      String[] nums = new String[101];
      for (int i = 1; i < nums.length; i++) 
         nums[(31 * i) % nums.length] = Integer.toString(i * i);
      StringMergeSorter.sort(nums, false);
      for (int i = 0; i < nums.length; i++)
         assertEquals(Integer.toString(i * i), nums[i]);
   }
}
