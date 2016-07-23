import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

// P 11.5
public class Coin 
{
	private String aName;
	private double aValue;
	public Coin()
	{
		aName = "";
		aValue = 0.0;
	}
	
	public Coin (String iName, double iValue)
	{
		aName = iName;
		aValue = iValue;
	}
	
	public double getValue()
	{
		return aValue;
	}

	public String getName()
	{
		return aName;
	}

	public void read(Scanner in) throws IllegalStateException, FileNotFoundException
	{
		try
		{
			this.aName = in.next();
			this.aValue = in.nextDouble();
		}
		catch (Exception e)
		{
			throw new IllegalStateException();
		}
//		String formattedString = String.format("%-12s%-12s\n", aName, aValue);
	}

	public String toString()
	{
		return this.getName() + " " + this.getValue();
	}
}
