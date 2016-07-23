import java.io.FileNotFoundException;
import java.util.*;
import java.io.*;
public class LongestWord
{	
	public static void main(String[] args) throws FileNotFoundException
	{		
		String pathway = "//users//adish//desktop//";
		Scanner in = new Scanner(System.in);
		System.out.println("Input name of file: ");
		String filename = in.next();
		// close for user input
		in.close();
		
		// open again for extracting information from file
		in = new Scanner( new File( pathway + filename + ".txt"));
		
		// get whole line for string reading and analysing;		
		

		while (in.hasNextLine())
		{			
			String stringForExamination = in.nextLine();
			LongestString(stringForExamination);
			// if we reach end of file, stop the method
		}
	}
	
	//helper method
	public static String LongestString(String examinedString)
	{
		String[] dividedString = examinedString.split(" ");
		String longestWord = " ";
		// we begin by comparing the first word of the String's length 
		int comparedStringLength = dividedString[0].length(); 
		for (int i = 1; i < dividedString.length; i++ )
		{
			int result = compare(comparedStringLength, dividedString[i]);
			if (result == 1)
			{
				System.out.println("First is bigger. Moving on");
				continue;
			}
			else if (result == -1)
			{
				// the new longest size for the given file is
				comparedStringLength = dividedString[i].length();
				longestWord = dividedString[i];
				System.out.println("Second is bigger. longestWord changed to: " + longestWord);				
				continue;
			}
			else if (result == 0)
			{
				System.out.println("Same length. Moving on");
				continue;
			}			
		}
		
		System.out.println(longestWord);
		System.out.println("The length of the longest word is: " + comparedStringLength);
		return longestWord;
	}

	// helper method for comparing the strings
	public static int compare(int target, String realString)
	{   
		if (target > realString.length())
		{
			return 1;
		}
		else if (target < realString.length())
		{
			return -1;
		}
		else
		{
			return 0;	
		}
	}

}