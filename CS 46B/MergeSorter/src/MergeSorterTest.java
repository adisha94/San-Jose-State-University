import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
public class MergeSorterTest
{
	@Test
	public void main(String[] args)
	 {
		System.out.println("Array of length 4: ");
		MergeSorter.sort(new int[4], true);
		System.out.println("Array of length 16: ");
		MergeSorter.sort(new int[16], true);
	}

}
