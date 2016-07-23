import java.util.Iterator;


public class BinarySearchTreeTester2
{
   public static void main(String[] args) 
   {
      BinarySearchTree t = new BinarySearchTree();
      t.add("D");
      t.add("B");
      t.add("A");
      t.add("C");
      t.add("F");
      t.add("E");
      t.add("I");
      t.add("G");
      t.add("H");
      t.add("J");
	    
      Iterator iter = t.iterator();
      while (iter.hasNext()) 
      {
         Object data = iter.next();
         System.out.print(data + " ");
      }
      System.out.println();
      System.out.println("Expected: A B C D E F G H I J");
		
      BinarySearchTree t2 = new BinarySearchTree();
		
      iter = t2.iterator();
      System.out.println(iter.hasNext());
      System.out.println("Expected: false");
		
      try 
      {
         iter.next();
         System.out.println("Shouldn't be here");
      }
      catch (IllegalStateException e) 
      {
         System.out.println("IllegalStateException thrown.");
      }
      catch (Throwable e)
      {
         System.out.println("Shouldn't be here");
      }

      System.out.println("Expected: IllegalStateException thrown.");
   }
}