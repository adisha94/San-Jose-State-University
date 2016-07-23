import java.io.*;
import java.util.*;
public class Write
{
	public static void main(String[] args) throws IOException
	{
//		String filename = "";
		File file1  = new File("//users//adish//desktop//Fil1.txt");
		File file2  = new File("//users//adish//desktop//Fil2.txt");
		
		Scanner in  = new Scanner(file1);
		String message = in.nextLine();
		print(message);
		
		PrintWriter out = new PrintWriter(file2);
		out.println(message);
		out.append("\nThere is more to append to this file");
		out.close();		
		in.close();
		
		in = new Scanner(System.in);
		String filename = in.nextLine();
		File file = new File("//users//adish//desktop//" + filename);
		if (file.createNewFile())
		{
			print("created new file named: " + filename);
		}
		else
		{
			print("File already exists");
		}
		in.close();
		
		in = new  Scanner(file2);		
		message = in.nextLine();				
		int numberOfWords = 0;

		String [] dividedMessage = message.split(" ");
		for (int i = 0; i < dividedMessage.length; i++)
		{
			numberOfWords++;
		}
		print("There are " + numberOfWords + " words.");
		in.close();
		
		out = new PrintWriter(file);		
		for (int i = 0; i < 2; i++)
		{
			if (i == 0)
			{
				out.println(dividedMessage[i] + " ");
			}
			else if (i != 0)
			{
				out.append(dividedMessage[i] + " ");
			}
		}
		out.flush();
		out.close();
		
	}
	
	public static void print(int result)
	{
		System.out.println(result);
	}
	public static void print(long result) // overload
	{
		System.out.println(result);
	}
	public static void print(String message) // overload
	{
		System.out.println(message);
	}
	public static void print(Object result) // should print any general object
	{
		System.out.println("Your result is: " + result);
	}	
	public static void print(double result) // overload
	{
		System.out.println(result);
	}

}
