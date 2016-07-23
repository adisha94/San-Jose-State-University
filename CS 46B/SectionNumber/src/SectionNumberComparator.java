import java.io.File;
import java.io.FileNotFoundException;
import java.util.Comparator;
import java.util.Scanner;

public class SectionNumberComparator implements Comparator<String>
{	
	public SectionNumberComparator() 
	{
		
	}

	@Override
	public int compare(String arg0, String arg1)
	{
		String[] arg0Parts = arg0.split("[\\.]"); // split by parts
		String[] arg1Parts = arg1.split("[\\.]"); // split by parts
		int i = 0;
		// 1. compare sections by section in the array
				// i.) compare by using the index locations .
		// 2.move index to which sections are dissimilar
		// 1.2.12.0
		// 1.2.3
		//
		// as long as our tracker variable is less than the total length of the array AND the entries are the same, proceed searching
		while (i < arg0Parts.length && i < arg1Parts.length && arg0Parts[i].equals(arg1Parts[i]))
		{
			i++;
		}
		// now the sections are dissimilar, begin comparing 
		int diff = Integer.valueOf(arg0Parts.length - arg1Parts.length);
		if (i < arg0Parts.length && i < arg1Parts.length)
		{
			diff = Integer.valueOf(arg0Parts[i]).compareTo(Integer.valueOf(arg1Parts[i]));
		}
		if(diff > 0)
			return 1;
		else if (diff < 0)
			return -1;
		return 0;
	}
}
