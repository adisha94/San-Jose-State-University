import org.junit.*;
import static org.junit.Assert.*;

public class Test2
{  
   @Test
   public void addFirst()
   {
      LinkedList names = new LinkedList();
      names.addLast("Fred");
      names.addLast("Wilma");
      Iterator iter = names.iterator();
      iter.add("Barney");
      Iterator iter2 = names.iterator();
      assertEquals("Barney", iter2.get());
      iter2.next();
      assertEquals("Fred", iter2.get());
      iter2.next();
      assertEquals("Wilma", iter2.get());
      iter2.next();
      assertTrue(iter2.atEnd());      
   }

   @Test
   public void addBeforeLast()
   {
      LinkedList names = new LinkedList();
      names.addLast("Fred");
      names.addLast("Wilma");
      Iterator iter = names.iterator();
      iter.next();
      iter.add("Barney");
      Iterator iter2 = names.iterator();
      assertEquals("Fred", iter2.get());
      iter2.next();
      assertEquals("Barney", iter2.get());
      iter2.next();
      assertEquals("Wilma", iter2.get());
      iter2.next();
      assertTrue(iter2.atEnd());      
   }

   @Test
   public void addLast()
   {
      LinkedList names = new LinkedList();
      names.addLast("Fred");
      names.addLast("Wilma");
      Iterator iter = names.iterator();
      iter.next();
      iter.next();
      iter.add("Barney");
      Iterator iter2 = names.iterator();
      assertEquals("Fred", iter2.get());
      iter2.next();
      assertEquals("Wilma", iter2.get());
      iter2.next();
      assertEquals("Barney", iter2.get());
      iter2.next();
      assertTrue(iter2.atEnd());      
   }

   @Test
   public void removeFirst()
   {
      LinkedList words = new LinkedList();
      words.addLast("Mary");
      words.addLast("had");
      words.addLast("a");
      words.addLast("little");
      words.addLast("lamb");
      Iterator iter = words.iterator();
      iter.remove();
      Iterator iter2 = words.iterator();
      assertEquals("had", iter2.get());
      iter2.next();
      assertEquals("a", iter2.get());
      iter2.next();
      assertEquals("little", iter2.get());
      iter2.next();
      assertEquals("lamb", iter2.get());
      iter2.next();
      assertTrue(iter2.atEnd());      
   }

   @Test
   public void removeLast()
   {
      LinkedList words = new LinkedList();
      words.addLast("Mary");
      words.addLast("had");
      words.addLast("a");
      words.addLast("little");
      words.addLast("lamb");
      Iterator iter = words.iterator();
      iter.next();
      iter.next();
      iter.next();
      iter.next();
      iter.remove();
      Iterator iter2 = words.iterator();
      assertEquals("Mary", iter2.get());
      iter2.next();
      assertEquals("had", iter2.get());
      iter2.next();
      assertEquals("a", iter2.get());
      iter2.next();
      assertEquals("little", iter2.get());
      iter2.next();
      assertTrue(iter2.atEnd());
   }

   @Test
   public void removeBeforeLast()
   {
      LinkedList words = new LinkedList();
      words.addLast("Mary");
      words.addLast("had");
      words.addLast("a");
      words.addLast("little");
      words.addLast("lamb");
      Iterator iter = words.iterator();
      iter.next();
      iter.next();
      iter.next();
      iter.remove();
      Iterator iter2 = words.iterator();
      assertEquals("Mary", iter2.get());
      iter2.next();
      assertEquals("had", iter2.get());
      iter2.next();
      assertEquals("a", iter2.get());
      iter2.next();
      assertEquals("lamb", iter2.get());
      iter2.next();
      assertTrue(iter2.atEnd());      
   }

   @Test
   public void removeTwo()
   {
      LinkedList words = new LinkedList();
      words.addLast("Mary");
      words.addLast("had");
      words.addLast("a");
      words.addLast("little");
      words.addLast("lamb");
      Iterator iter = words.iterator();
      iter.next();
      iter.remove();
      iter.remove();
      iter.remove();
      Iterator iter2 = words.iterator();
      assertEquals("Mary", iter2.get());
      iter2.next();
      assertEquals("lamb", iter2.get());
      iter2.next();
      assertTrue(iter2.atEnd());      
   }
}
