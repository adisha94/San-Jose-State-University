import java.util.*;
public class TestingMain
{
	public static void main(String[] args)
	{
		System.out.println("Are you able to see all projects in eclipse? And are they working?");
		Scanner in = new Scanner(System.in);
		String response = in.nextLine();
		 if (response.equals("yes"))
		 {
			 print("Are you able to see all your files on the project explorer?");
			 response = in.nextLine();
			 if (response.equals("yes"))
				 print("Confirm these choices that you have made on the application.");
			 response = in.nextLine();
			 if (response.equals("yes") || response.equals("confirm"))
				 System.out.println("Yay eclipse is working again. wooooooooooooooooo");			 
		 }
		 else
			 System.out.println("You suck eclipse!!!");
		 in.close();
	}
	
	
	public static void print(String message)
	{
		System.out.println(message);
	}
}


