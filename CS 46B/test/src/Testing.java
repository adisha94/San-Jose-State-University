import java.util.*;
import java.util.Set;

public class Testing
{

	public static void main(String args[])
	{
		Print printer = new Print();
		ArrayList<Object> objList = new ArrayList();
		objList.add("Adish");
		objList.add("Adish1");
		objList.add("Adish2");
		objList.add("Adish3");
		objList.add(34);
		printer.print(objList.contains(34));
	}
}


