import java.util.List;
import java.util.ArrayList;

public class Decomposer
{
   /**
      Decomposes the object into indecomposable parts.
      @param obj a decomposable object
      @return a list of decomposable objects that cannot be further
      decomposed.

      If an object is decomposable, decompose it and add the decompositions
      to the result. Hint: addAll.
      
      If an object is not decomposable, return a list containing that object.

      For example, if a word is decomposable into two halves as long as its length
      is > 2, then decomposeFully(new Word("Mississippi")) would yield
      a list of words "Mi", "s", "si", "s" "si", "p", "pi"
      ("Mississippi" -> "Missis", "sippi" -> "Mis", "sis", "sip", "pi"
      -> "Mi", "s", "si", "s" "si", "p", "pi")      
   */
   public static List<Decomposable> decomposeFully(Decomposable obj)
   {
      List<Decomposable> result = new ArrayList<>();
      if (...)
      {
         ...
         ...
         ...
      }
      else
      {
         ...
      }
      return result;
   }
}
