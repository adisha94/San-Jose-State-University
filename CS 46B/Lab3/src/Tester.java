import java.io.IOException;


public class Tester
{

	public static void main(String[] args) throws IOException
	{
		CPIConverter conv = new CPIConverter();
		conv.read("http://sjsucs.bitbucket.org/cs46b/lab3/cpiai2.txt");
		double amount = 100000;
		double adjusted = conv.equivalentAmount(amount, 1961, 2003);
		System.out.printf("Adjusted amount: %10.0f\n", adjusted);
	}
}
