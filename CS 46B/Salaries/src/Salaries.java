import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.Scanner;
import java.io.*;


public class Salaries
{
	public static void main(String[] args)
	{
		String filename = args[0];
		// go into the file and add the three total amounts together and get
		// Scanner in = new Scanner (new File (filename + ".txt"));
		try(Scanner in =  new Scanner(new File("./" + filename)))
		{			
			String processor;
			// in.useDelimiter("[^$0-9 ]+");
			boolean firstLine = false;
			while (in.hasNextLine())
			{
				processor = in.nextLine();
				if (firstLine == false)
				{
					firstLine = true; // skipping column names
					continue;
				}
				
				String[] tokens = processor.split(" ");
				
				String professorName = GetProfessorName(tokens);				
				if (tokens.length < 5)
				{
					continue;
				}
				double autoAllowance = GetParsedCurrency(tokens, 1);
				// Double.parseDouble(tokens[tokens.length - 1].substring(1).replace(",", "")); // auto
				double housingAllowance = GetParsedCurrency(tokens, 2);
				// Double.parseDouble(tokens[tokens.length -
				// 2.) .substring(1).replace(",", "")); // housing
				double officerSalary = GetParsedCurrency(tokens, 3);
				// Double.parseDouble(tokens[tokens.length -
				// 3.) substring(1).replace(",", ""));

				double total = autoAllowance + housingAllowance + officerSalary;
				DecimalFormat doubleF = new DecimalFormat("$###,###,###");
				
				System.out.println(professorName + " " +  doubleF.format(total));
			}
		}
		catch (IOException e)
		{
			System.out.println("File not found: " + filename);
		}
	}

	public static String GetProfessorName(String tokens[])
	{
		boolean reachedDollarSign = false;
		String name = "";
		int nameCounter = 2;
		
		for (int i = tokens.length - 1; i > 0; i--) // begin taking into account the first names
		{
			if (tokens[i].contains("$"))
			{
				reachedDollarSign = true; // reach the dollar sign
			}
			else if (tokens[i].contains(".") && reachedDollarSign == true)
			{
			
					name = tokens[i] + " " + name;
			
			}
			else
			{
				if (nameCounter > 0 && reachedDollarSign == true)
				{
					if (tokens[i].compareTo("Provided") != 0)
					{
						if(tokens[i].compareTo("provided") != 0)
						{
							name = tokens[i] + " " + name;
							nameCounter = nameCounter - 1;				
						}
											
					}
				}
			}
			
		}
		return name;
	}
	public static double GetParsedCurrency(String tokens[], int backwardIndex)
	{
		int foundNumber = 0;
		for (int i = tokens.length - 1; i >= 0; i--) 
		{
			String token = tokens[i].substring(1).replace(",", "");

			double d = 0;
			boolean parseSucceed = false;			
			try
			{
				d = Double.parseDouble(token); // this is to check wether the input is a wordÖ
				parseSucceed = true;
			}
			catch (NumberFormatException exception) // if the captured input is not a word
			{
			}
			if (parseSucceed == true)
			{
				if (foundNumber == 0)
				{
					foundNumber = 1;
				}
				else
				{
					foundNumber++;
				}
				if (foundNumber == backwardIndex)
				{
					return d;
				}
			} 
			else 
			{
				if (foundNumber > 0) // take care for the 'provided' lines in
										// the file
				{
					foundNumber++;
					if (foundNumber == backwardIndex)
					{
						return 0;
					}
				}
			}
		}
		return 0;
	}
}