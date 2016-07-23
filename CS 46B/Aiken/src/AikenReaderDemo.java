import java.io.FileNotFoundException;
import java.util.Scanner;

public class AikenReaderDemo
{
   public static void main(String[] args) throws FileNotFoundException
   {
      String filename = args[0];
      try (AikenReader reader = new AikenReader(filename))
      {         
         for (Question q : reader.readQuestions())
         {
            q.display();
            System.out.println(q.checkAnswer("1") + " " + q.checkAnswer("4"));
         }
      }
      catch (SyntaxException ex)
      {
         System.out.println("Caught " + ex);
      }
   }
}