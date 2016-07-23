import java.util.*;

/**
   A test program for the smallest method of the SmallestsBinarySearchTree class.
*/
public class SmallestTester
{  
   public static void main(String[] args)
   {  
      SmallestBinarySearchTree names = new SmallestBinarySearchTree();
      names.add("Romeo");
      names.add("Juliet");
      names.add("Tom");

      System.out.println(names.smallest());
      System.out.println("Expected: Juliet");
   }
}