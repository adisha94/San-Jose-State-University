import static org.junit.Assert.*;

import org.junit.Test;

public class MinMaxHeapTest 
{

	@Test
	public void test() 
	{
		TreePrinter<Integer> myHeap = new TreePrinter<>();
		myHeap.insert(6);
		myHeap.insert(81);
		myHeap.insert(87);
		myHeap.insert(14);
		myHeap.insert(17);
		myHeap.insert(12);
		myHeap.insert(28);
		myHeap.insert(71);
		myHeap.insert(25);
		myHeap.insert(80);
		myHeap.insert(20);
		myHeap.insert(52);
		myHeap.insert(78);
		myHeap.insert(31);
		myHeap.insert(42);
		myHeap.insert(31);
		myHeap.insert(59);
		myHeap.insert(16);
		myHeap.insert(24);
		myHeap.insert(79);
		myHeap.insert(63);
		myHeap.insert(15);
		myHeap.insert(48);

		myHeap.PrintTree();
	}

}
