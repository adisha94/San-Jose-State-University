
public class TestGetSet
{

	public static void main(String[] args)
	{
		LinkedList myList = new LinkedList();
		myList.addFirst("adish");
		myList.addFirst(34);
		myList.addFirst(23);
		myList.addFirst(12);
		myList.addFirst("adish23");
		myList.addFirst("fggt");
		myList.get(4);
		myList.set(4, 456);
		System.out.println(myList);
	}

}
