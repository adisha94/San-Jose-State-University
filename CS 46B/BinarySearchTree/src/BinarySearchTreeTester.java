import java.util.Iterator;

public class BinarySearchTreeTester 
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
   }
}