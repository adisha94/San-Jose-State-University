import org.junit.Test;
import static org.junit.Assert.*;

public class CacheTest
{
   @Test public void testSimpleInsertion()
   {
      Cache c = new Cache(5);
      addAll(c, "ABCDE");
      cacheCheck(c, "EDCBA");
   }

   @Test public void testMultipleInsertions()
   {
      Cache c = new Cache(5);
      addAll(c, "ABCDEAB");
      cacheCheck(c, "BAEDC"); // The most recently used AB reappear at the front 
   }
   
   @Test public void testDroppingLesserUsedElements()
   {
       Cache c = new Cache(5);
       addAll(c, "ABCDEFG");
       cacheCheck(c, "GFEDC"); // The least recently used AB drop off
   }

   @Test public void testExample()
   {
       Cache c = new Cache(5);
       addAll(c, "ABCDEFC");
       cacheCheck(c, "CFEDB"); 
   }

   public static void addAll(Cache c, String str)
   {
      for (int i = 0; i < str.length(); i++)
         c.add(str.substring(i, i + 1));
   }

   public static void cacheCheck(Cache c, String expected)
   {
      // Check forward links
      int i = 0;
      for (Cache.Node n = c.first; n != null; n = n.next)
      {
         assertTrue(i < expected.length());
         assertEquals(n.data, expected.substring(i, i + 1));
         i++;
      }
      assertEquals(expected.length(), i);
      assertEquals(expected.length(), c.size);
      
      // Check backwards links
      for (Cache.Node n = c.last; n != null; n = n.previous)
      {
         assertTrue(i > 0);
         assertEquals(n.data, expected.substring(i - 1, i));
         i--;
      }
      assertEquals(0, i);
   }

}
