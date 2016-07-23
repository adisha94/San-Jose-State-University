import org.junit.Test;
import static org.junit.Assert.*;

public class DecomposerTest
{
   class Word implements Decomposable
   {
      private String text;

      public Word(String text) { this.text = text; }
      public String toString() { return text; }
      public boolean equals(Object otherObject) { return text.equals(((Word) otherObject).text); }
      public int hashCode() { return text.hashCode(); }
      public boolean isDecomposable() { return text.length() > 2; }
      public Decomposable[] decompose()
      {
         int n = (text.length() + 1) / 2;
         return new Word[] { new Word(text.substring(0, n)), 
                             new Word(text.substring(n)) };
      }
   }

   class Number implements Decomposable
   {
      private int value;
     
      public Number(int value) { this.value = Math.abs(value); }
      public String toString() { return "" + value; }
      public boolean equals(Object otherObject) { return value == ((Number) otherObject).value; }
      public int hashCode() { return value; }
      public boolean isDecomposable() { return value >= 10; }
      public Decomposable[] decompose() 
      {
         return new Number[] { new Number(value / 10), new Number(value % 10) };
      }
   }

   @Test public void test1()
   {
      assertEquals(java.util.Arrays.<Decomposable>asList(
            new Word("Mi"), new Word("s"), 
            new Word("si"), new Word("s"), new Word("si"), 
            new Word("p"), new Word("pi")),         
         Decomposer.decomposeFully(new Word("Mississippi")));
   }

   @Test public void test2()
   {
      assertEquals(java.util.Arrays.<Decomposable>asList(
            new Number(1), new Number(2), new Number(3), 
            new Number(4), new Number(5)),         
         Decomposer.decomposeFully(new Number(12345)));
   }
}
