import java.util.Scanner;

public class TreeReader 
{
   private String previousToken;
   private Scanner in;

   public TreeReader(Scanner in) 
   {
      this.in = in;
      in.useDelimiter("");
   }

   public Tree read() 
   {
      String token = nextToken();
      if (!token.equals("(")) 
      {
         previousToken = token;
         return null;
      } 
      else 
      {
         previousToken = null;
      }
      token = nextToken();
      Tree t = new Tree(token);
      Tree s = null;
      while ((s = read()) != null) 
      {
         t.addSubtree(s);
      }
      token = nextToken();
      if (!token.equals(")")) 
      {
         return null;
      }
      return t;
   }

   private String nextToken() 
   {
      if (previousToken != null) 
      {
         String r = previousToken;
         previousToken = null;
         return r;
      }
      String s = skipWhitespace();
      if ("()".contains(s)) 
      {
         return s;
      }
      while (in.hasNext()) 
      {
         String next = in.next();
         if (!Character.isLetter(next.charAt(0))) 
         {
            if (!Character.isWhitespace(next.charAt(0))) 
            {
               previousToken = next;
            } 
            else 
            {
               previousToken = null;
            }
            return s;
         }
         s += next;
      }
      return s;
   }

   private String skipWhitespace() 
   {
      while (in.hasNext()) 
      {
         String next = in.next();
         if (!Character.isWhitespace(next.charAt(0))) 
         {
            return next;
         }
      }
      return "";
   }
}