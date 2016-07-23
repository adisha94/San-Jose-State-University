import java.io.*;
import java.util.*;
// E15.10
public class TextTreeMain 
{
	public static void main(String[] args) 
	{
	    System.out.print("File name: ");
		Scanner in = new Scanner(System.in); // read from a file of your choosing
		String filename = in.nextLine() + ".txt";
		File inputFile = new File(filename);
		in.close();
		try
		{
			in = new Scanner(inputFile, "UTF-8");			
		}
		catch(FileNotFoundException e)
		{
			System.out.println("File not found.\n Terminating program");
			return;
		}
		
		// assignment declaration
		String[] words = null;
		TreeSet<String> textTree = new TreeSet<String>();		
		while(in.hasNextLine())
		{
			words = in.nextLine().split("[. ]");			
			
			// iterate through file and add in the the Tree-set
			for (int i = 0; i < words.length; i++)
			{
				textTree.add(words[i]);
			}
		}
		
		for (String entry : textTree)
		{
			System.out.println(entry);
		}
		System.out.println("\nSize of final tree: " + textTree.size());
		in.close();
	}
		
		
	
}