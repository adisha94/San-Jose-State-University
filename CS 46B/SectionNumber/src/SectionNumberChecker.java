import java.io.File;
import java.io.FileNotFoundException;
import java.util.Comparator;
import java.util.Scanner;

public class SectionNumberChecker
{
   public static void main(String[] args) throws FileNotFoundException
   {
	//String pathway = "/users/adish/desktop/hw3/";
	String pathway = "./";
	 // creating a file for reading the input
     System.out.print("File: ");
     Scanner in = new Scanner(System.in);
     String filename = in.nextLine(); // automatically assume .txt file
//     String filename = in.nextLine() + ".txt"; // automatically assume .txt file
     
     in.close();
     //
     Comparator<String> comp = new SectionNumberComparator();
     File inputFile = new File(pathway + filename);
   
     in = new Scanner(inputFile);
     // two objects that will be compared
     in.useDelimiter("[^0-9.]+");
     String previous = in.next();
     //System.out.println("value of previous is: " + previous);
     
      // while reading the file for section numbers, we need to compare them by using the section numbers
     if(in.hasNext() == true)
     {
      while(in.hasNextLine())
      {
    	 String section = in.next();
    	 int compResult = comp.compare(previous, section);
         if (compResult == 1 || compResult == 0) // if the two sections are not in order, then we display a warning message
         {
            System.out.println(section + " should not come after " + previous);
            previous = section;
         }
         else
         {
             previous = section; 
         }
         if (in.hasNext() == false)
         {
        	 break;
         }
      }
     }
      in.close();
   }
}
