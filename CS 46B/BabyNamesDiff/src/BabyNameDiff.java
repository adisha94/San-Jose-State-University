import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Collections;

public class BabyNameDiff
{
   public static void main(String[] args) throws FileNotFoundException
   {
      String filename1 = args[0];
      String filename2 = args[1];
      // compare the two files
      // print out the names present in one file but not present in other file
      // logical statement = p ^ ~q
      
      ArrayList<ArrayList <String>> file1BabyNameList = read(filename1);
      ArrayList<ArrayList <String>> file2BabyNameList = read(filename2);
      
	  ArrayList<String> file1BoyNameList = file1BabyNameList.get(0);
	  ArrayList<String> file1GirlNameList = file1BabyNameList.get(1);
	  ArrayList<String> file2BoyNameList = file2BabyNameList.get(0);
	  ArrayList<String> file2GirlNameList = file2BabyNameList.get(1);
      
	  printList(file1BoyNameList, file1GirlNameList, file2BoyNameList, file2GirlNameList);
	  System.out.println("");
	  printList(file2BoyNameList, file2GirlNameList, file1BoyNameList, file1GirlNameList);
   }

   private static void printList(ArrayList<String> boyNameList, ArrayList<String> girlNameList, ArrayList<String> noBoyNameList, ArrayList<String> noGirlNameList)
   {
	   ArrayList<String> boyNameListToPrint = new ArrayList<String>();
	   ArrayList<String> girlNameListToPrint = new ArrayList<String>();
	   
	   int len = boyNameList.size();
	   if(boyNameList.size() < girlNameList.size())
	   {
		   len = girlNameList.size();
	   }
	   for(int i = 0; i< len; i++)
	   {
		   String boyName = "";
		   String girlName = "";
		   if(i < boyNameList.size())
		   {
			   boyName = boyNameList.get(i);
		   }
		   if(i < girlNameList.size())
		   {
			   girlName = girlNameList.get(i);
		   }
		   if(boyName.length() > 0)
		   {
			   if(noBoyNameList.contains(boyName) == false)
			   {
				   boyNameListToPrint.add(boyName);
			   }
		   }
		   if(girlName.length() > 0)
		   {
			   if(noGirlNameList.contains(girlName) == false)
			   {
				   girlNameListToPrint.add(girlName);
			   }
		   }
	   }
	   len = boyNameListToPrint.size();
	   if(boyNameListToPrint.size() < girlNameListToPrint.size())
	   {
		   len = girlNameListToPrint.size();
	   }
	   for(int i = 0; i< len; i++)
	   {
		   String boyName = "";
		   String girlName = "";
		   if(i < boyNameListToPrint.size())
		   {
			   boyName = boyNameListToPrint.get(i);
		   }
		   if(i < girlNameListToPrint.size())
		   {
			   girlName = girlNameListToPrint.get(i);
		   }
		   if((boyName.length() == 0) && (girlName.length() == 0))
		   {
			   continue;
		   }
		   String str = String.format("%-30s%-30s", boyName, girlName);
	       System.out.println(str);
	   }
   }
   private static ArrayList< ArrayList <String> >  read(String filename) throws FileNotFoundException
   {
	  ArrayList< ArrayList <String> > babyNameList = new ArrayList< ArrayList <String> >();
	  ArrayList<String> boyNameList = new ArrayList<String>();
	  ArrayList<String> girlNameList = new ArrayList<String>();
      Scanner in = new Scanner(new File(filename));
		while (in.hasNextLine())
		{
		    int lineNumber = in.nextInt();
		    String boyName = in.next();
		    int birthTime = in.nextInt();
		    String GirlName = in.next();
//		    birthTime = in.nextInt();
			String fileLine = in.nextLine();
		    
		    boyNameList.add(boyName);
		    girlNameList.add(GirlName);
		    
		}
		// sort all boy and ggirls names
	    Collections.sort(boyNameList);
	    Collections.sort(girlNameList);
	    //
	    // oreoare boy name list and girl naame list to be returned	    
	    babyNameList.add(boyNameList);
	    babyNameList.add(girlNameList);
	    
      return babyNameList;
   }      
}