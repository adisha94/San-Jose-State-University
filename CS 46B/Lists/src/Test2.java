import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.Collections;

public class Test2 
{

   @Test
   public void length3()
   {
      ArrayList<String> result = Lists.permutations("SJU");
      Collections.sort(result);
      assertEquals("[JSU, JUS, SJU, SUJ, UJS, USJ]", result.toString());
   }

   @Test
   public void length4()
   {        
      ArrayList<String> result = Lists.permutations("Fred");
      Collections.sort(result);
      assertEquals("[Fder, Fdre, Fedr, Ferd, Frde, Fred, dFer, dFre, deFr, derF, drFe, dreF, eFdr, eFrd, edFr, edrF, erFd, erdF, rFde, rFed, rdFe, rdeF, reFd, redF]", result.toString());
   }

   @Test
   public void length10()
   {
      ArrayList<String> result = Lists.permutations("1234567890");
      assertEquals(2*3*4*5*6*7*8*9*10, result.size());
   }
}