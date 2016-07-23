
public class TestClasses
{

	public static void main(String[] args)
	{
		Subtester sub = new Subtester();
		Subtester sub1 = new Subtester();		
		Tester tes = new Tester();
		sub.PrintHello();
		sub.PrintHello(33);
		//sub = sub1;
		
		System.out.println("this is sub to string : [" + sub.toString() + "].");
		System.out.println("this is tes to string : [" + tes.toString() + "].");
		System.out.println("this is sub1 to string : [" + sub1.toString() + "].");
		
		System.out.println("this is sub1 to string : [" + sub.equals(sub) + "].");
		System.out.println("this is comparing sub to sub1 to string : [" + sub.equals(sub1) + "].");
		System.out.println("this is sub1 to string : [" + sub.equals(tes) + "].");
	}

}
