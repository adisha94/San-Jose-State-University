import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;
import java.io.*;

public class CPIConverter
{
	private double[] cpi;
	private static final int FIRST_YEAR = 1913;
	private static final int LAST_YEAR = 2003;
	
	
//	public void read(String location) throws IOException 
//	{
//		URL cpiURL = new URL(location);
//		BufferedReader cpiIn = new BufferedReader( new InputStreamReader( cpiURL.openStream() ) );		
//		int inputline = 0;
//		while ((inputline == cpiIn.read()))
//		{
//			System.out.println(inputline);
//		}
//	}

	public double equivalentAmount(double amount, int fromYear, int toYear) 
	{
		fromYear = FIRST_YEAR;
		toYear = LAST_YEAR;
		cpi[fromYear, amount];
		amount = amount * fromYear / toYear;
	   return amount; 
	}
	public void read(String location)
	{
	   cpi = new double[LAST_YEAR - FIRST_YEAR +1];
	   URL cpiURL = new URL(location);
	   InputStream cpiIn = cpiURL.openStream();
	}	
}