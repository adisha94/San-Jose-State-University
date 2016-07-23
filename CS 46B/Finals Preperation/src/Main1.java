import java.io.*;
import java.util.*;

public class Main1
{
	// P 11.5
	public static void main(String[] args) throws FileNotFoundException
	{
		Scanner in = new Scanner(System.in);
		ArrayList<Coin> coinList;
		while(true)
		{
			System.out.println("Enter coin file name: ");
			String filename = in.nextLine();
			try
			{
				coinList = readFile(filename); // Array in readFile already contains existing values
				break; // successfully read
			}
			catch (FileNotFoundException e)
			{
				System.out.println("File not found --> choose another file");
			}
		}		
		in.close();

		double resultingValue = 0; 
		System.out.println("These are the coins as read from the file");
		for (int i = 0; i < coinList.size(); i++)
		{
			System.out.println(coinList.get(i).toString());
			resultingValue += coinList.get(i).getValue();			
		}
		System.out.println("Total value: " + resultingValue);
	}
	
	public static ArrayList<Coin> readFile(String filename) throws FileNotFoundException
	{
		ArrayList<Coin> coinList = new ArrayList<>();
		File coinFile = new File(filename);		
		if (!coinFile.exists()) // if file does not exist
		{
			throw new FileNotFoundException();
		}
		
		Scanner coinFileReader = new Scanner(coinFile);
		while(coinFileReader.hasNextLine()) // checking for input in file
		{
			Coin sampleCoin =  new Coin(); // create new coin and add to the list
			try
			{
				sampleCoin.read(coinFileReader); // read in values for parameters
			}
			catch(FileNotFoundException e)
			{
				System.out.println("File not found. You suck XD.");
				break;
			}
			catch(IllegalStateException e)
			{
				System.out.println("Current line not formatted correctly. Your weird.");
				break;
			}
			coinList.add(sampleCoin);			
		}
		coinFileReader.close();
		
		return coinList;
	}
}