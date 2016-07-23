import java.util.*;
public class PackageName implements Comparable<PackageName>
{
   private String[] parts;
   public PackageName(String name)
   {
      parts = name.split("\\.");
          // for example, ["java", "util", "Collections"]
          // or ["java", "util", "*"]
   }
   
   public static void main(String[] args)
   {
//	   Scanner in = new Scanner(System.in);
//	   String dividedParts= in.nextLine();
	   String dividedParts1 = "java.util.scanner.tester";
	   String dividedParts2 = "java.test.pie";
	   String dividedParts3 = "java.test.radical.pie.pi";
	   String dividedParts4 = "java.io.PrintWriter";
	   String dividedParts5 = "java.io.*";
	   String dividedParts6 = "java.io.pie.*";
	   String dividedParts7 = "java.awt.util.color.*";
	   
	   PackageName p1 = new  PackageName(dividedParts1);
	   PackageName p2 = new  PackageName(dividedParts2);
	   PackageName p3 = new  PackageName(dividedParts3);
	   PackageName p4 = new  PackageName(dividedParts4);
	   PackageName p5 = new  PackageName(dividedParts5);
	   PackageName p6 = new  PackageName(dividedParts6);
	   PackageName p7 = new  PackageName(dividedParts7);
	   
	   comparePrint(p1, p2);
	   comparePrint(p2, p3); 
	   comparePrint(p3, p4);
	   comparePrint(p4, p5);
	   comparePrint(p1, p5);
	   comparePrint(p5, p6);
	   comparePrint(p6, p7);
	   //reverse
	   
	   comparePrint(p2, p1);
	   comparePrint(p3, p2);
	   comparePrint(p4, p3);
	   comparePrint(p5, p4);
	   comparePrint(p5, p1);
	   comparePrint(p6, p5);
	   comparePrint(p7, p6);
   }
   
   private static void comparePrint(PackageName p1, PackageName p2)
   {
	   int compareResult = p1.compareTo(p2);
	   if (compareResult == -1)
	   {
		   System.out.println("Second is bigger");
	   }
	   else if (compareResult == 1)
	   {
		   System.out.println("First is bigger");
	   }
	   else if (compareResult == 0)
	   {
		   System.out.println("Objects are the same");
	   }
   }
public int compareTo(PackageName others)
{
	// initial comparision for sorting
	// if part 1 of the attached object is smaller than the other object
	
	if (this.parts.length > others.parts.length)
	{
		for (int i = 0; i < others.parts.length; i++)
		{
			int compareResult = this.parts[i].compareTo(others.parts[i]); 
			if ( compareResult < 0)
			{
				return -1;
			}
			else if ( compareResult > 0)
			{
				if (others.parts.length == i+1)
					if (others.parts[i] == "*")
						return 0;
				return 1;
			}
		}		
		return 1;
	}
	
	if (this.parts.length <= others.parts.length)
	{
		for (int i = 0; i < this.parts.length; i++)
		{
			int compareResult = this.parts[i].compareTo(others.parts[i]);
			if ( compareResult < 0)
			{
				if (others.parts.length == i+1)
					if (others.parts[i] == "*")
						return 0;
				return -1;
			}
			else if ( compareResult > 0)
			{
				return 1;
			}				
		}	
		if (this.parts.length == others.parts.length)
			return 0;
		return -1;
	}
	return 0;
}

}