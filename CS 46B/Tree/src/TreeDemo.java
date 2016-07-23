import java.util.Scanner;

public class TreeDemo 
{
   public static void main(String[] args) 
   {
      TreeReader r = new TreeReader(new Scanner(System.in));
      Tree t = r.read();
      t.print();
    }
}