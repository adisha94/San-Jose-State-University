import java.util.*;
import java.io.*;

public class Words
{
   public static void main(String[] args) throws FileNotFoundException
   {
      System.out.print("File name: ");
//      String filename = new Scanner(System.in).nextLine() + ".txt";
      String filename = new Scanner(System.in).nextLine();
//      String pathway = "/users/adish/desktop/storage/";
      String pathway = "./";
      Scanner in = new Scanner(new File (pathway + filename), "UTF-8"); // opens input stream to target file in specified folder
      int words = 0;
      int sentences = 0;
      while (in.hasNext())
      {
         String next = in.next();
         int length = next.length();
         words += length - (length - 1);
    	 if(next.contains(".."))
    	 {
    		 // if dashes are present in the word
    		 if (next.contains("--"))
    		 {
    			 words++;
    		 }
    		words++;
    	 } 
         

         if (next.contains(".") || next.contains("?") || next.contains("!"))
         {
        	 // "making sure not to count ..
        	 if(next.contains(".."))
        	 {
        		 sentences--;
        	 } 
        	 sentences++;
         }
         
         if (in.hasNext() == false)
         {
        	 break;
         }
      }
      
      
      System.out.println("Words: " + words);
      System.out.println("Sentences: " + sentences);
   }
}