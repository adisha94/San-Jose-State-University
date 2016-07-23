import java.util.List;
import java.util.ArrayList;

public class Removel
{
   public static void main(String[] args)
   {
      int n = Integer.parseInt(args[0]);
      List<Integer> lst = new ArrayList<Integer>(n);
      for (int i = 1; i <= n; i++) lst.add(i);
      for (int i = 1; i < n; i++) lst.remove(0);
      System.out.println("Last element remaining: " + lst.get(0));
   }
}