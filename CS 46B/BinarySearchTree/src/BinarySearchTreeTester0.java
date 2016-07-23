import java.util.Iterator;

public class BinarySearchTreeTester0
{
   
   public static void main(String[] args) 
   {
      BinarySearchTree t = new BinarySearchTree();
      t.add("D");
	
      Iterator iter = t.iterator();
      while (iter.hasNext()) 
      {
         Object data = iter.next();
         System.out.print(data + " ");
      }
      System.out.println();
      System.out.println("Expected: D");
      
      BinarySearchTree t2 = new BinarySearchTree();
      t2.add(1);
      t2.add(5);
      t2.add(7);
      t2.add(4);
		
      Iterator iter2 = t2.iterator();
      while (iter2.hasNext()) 
      {
         Object data = iter2.next();
         System.out.print(data + " ");
      }
      System.out.println();
      System.out.println("Expected: 1 4 5 7");		
   }
}
