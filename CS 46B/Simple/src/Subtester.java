// subclass
public class Subtester extends Tester
{
//	public void PrintHello()
//	{
//		System.out.println("I am tester from PrintHello from subclass Subtester"); // calling from child
//		super.PrintHello(); // calling from parent
//	}
	
	public void PrintHello(int data)
	{
		System.out.println(data + " data");
	}
	public void Test2()
	{
		super.PrintHello();
		this.PrintHello();
	}
}
