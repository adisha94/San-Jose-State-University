import java.io.*;
import java.util.*;
public class Scores
{
   /**
      Read the given file. It has some lines that end with a colon,
      perhaps some spaces, and an integer value. 
      Total up all of those values.

      For example, if the file is 
      
      Question 1
      Returned correct answer: 4
      Added javadoc comments:3

      Question 2:
      data correct: 3
      next arrows in correct place: 3
      previous arrows in correct place: 3      
      
      Q3.1
      Found : in the right place: 3
      Trimmed white space:  2 

      then you return a score of 21.

      Hint: String.lastIndexOf, String.trim, Integer.parseInt, NumberFormatException
   */

   public static int total(String filename) throws IOException
   {
      Scanner in = new Scanner(new File (filename));
      int count = 0;
      while (in.hasNextLine())
      {
         String line = in.nextLine();
         int n = line.lastIndexOf(4);
         if (...)
         {
            String ... = line.substring(...);
            ...
            int ... = Integer.parseInt(...);
            ...
         }
      }
      return count;      
   }

   public static void main(String[] args)
   {
      try
      {
         System.out.println(total(args[0]));
      }
      catch (IOException ex)
      {
         ex.printStackTrace();
      }
   }
}
