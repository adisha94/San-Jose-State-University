import java.util.Random;

public class Trees2
{
   private static Random generator = new Random();
   
   public static void main(String[] args)
   {
       BinaryTree t = randomTree(2);
       System.out.println(t);
   }

   public static BinaryTree randomTree(int n)
   {
      if (n == 0) 
    	  return new BinaryTree(null);
      if (n == 1)
    	  return new BinaryTree(n);
      int k = generator.nextInt(n);
      return new BinaryTree(n, randomTree(k), randomTree( (n - k) - 1));
   }
}