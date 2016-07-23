import java.util.ArrayList;
public class FirstDigitDistribution implements Sequence
{
	private ArrayList<Integer> list = new ArrayList<Integer>();
	
	public void process(Sequence seq, int numbers) 
	{
		int num = seq.next();
		for (int i = 0; i <= i; i++)
		{
			// 1 take care of the negative numbers to positive using abs()
			num = Math.abs(num/10);
			//2. store this new variable into a new variable
			int firstDigit = num;
			// 3. increase the counter in a dynamic array aka arraylist
			list.add(firstDigit);
		}
	}

	public void display()
	{	
		for (int i = 0; i < list.size(); i++)
		{
			System.out.println(i + ": " + list.toArray());
		}
	}

	@Override
	public int next()
	{
		return 0;
	}

}
