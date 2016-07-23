import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.Collections;

public class Test1
{
   @Test
   public void length2()
   {
      ArrayList<String> result = Lists.permutations("Is");
      Collections.sort(result);
      assertEquals("[Is, sI]", result.toString());
   }

   @Test
   public void length1()
   {
      ArrayList<String> result = Lists.permutations("I");
      Collections.sort(result);
      assertEquals("[I]", result.toString());
   }

   @Test
   public void length0()
   {
      ArrayList<String> result = Lists.permutations("");
      Collections.sort(result);
      assertEquals(Collections.singletonList(""), result);      
   }
}
