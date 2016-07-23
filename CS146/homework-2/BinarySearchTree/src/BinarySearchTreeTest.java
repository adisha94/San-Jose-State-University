import static org.junit.Assert.*;
import java.util.*;

import org.junit.Test;

public class BinarySearchTreeTest
{

//	@Test
	public void Inserttest()
	{
		System.out.println("Test 1 for Insertion");
		TreePrinter<Integer> myTree = new TreePrinter<Integer>();
		myTree.insert(5);
		myTree.insert(7);
		myTree.insert(8);
		myTree.insert(6);
		myTree.insert(3);
		myTree.insert(4);
		myTree.insert(2);
		myTree.insert(1);
		myTree.PrintTree();
	}
	
	@Test
	public void Problem2B()
	{
		makeSpace(4);
		System.out.println("Answering number 2B in homework 2");
		TreePrinter<Integer> myTree = new TreePrinter<Integer>();
		// adding numbers like a boss
		myTree.insert(21);
		myTree.insert(15);
		myTree.insert(11);
		myTree.insert(12);
		myTree.insert(7);
		myTree.insert(26);
		myTree.insert(27);
		myTree.insert(24);
		myTree.insert(25);	
		myTree.insert(16);
		myTree.insert(17);
		myTree.insert(31);
		myTree.insert(8);
		myTree.insert(6);
		myTree.insert(13);
		myTree.insert(18);
		myTree.insert(23);
		myTree.insert(32);
		makeSpace(44);
		myTree.PrintTree();
	}
	
	@Test
	public void Problem2C()
	{
		Random generator = new Random();
		TreePrinter myTree = new TreePrinter<>();
		while(myTree.height(myTree.root) != 5)
		{
			myTree.insert(generator.nextInt(89) + 10); // adding random numbers from 10 to 99
		}
		myTree.PrintTree();
	}
	
	

	public void makeSpace(int number)
	{
		for (int i = 0; i <= number; i++)
		{
			System.out.println("");
		}
	}
	
	@Test
	public void deleteTest()
	{
		System.out.println("Test 2 for deletion");
		TreePrinter<Integer> myTree = new TreePrinter<Integer>();
		myTree.insert(5);
		myTree.insert(7);
		myTree.insert(8);
		myTree.insert(6);
		myTree.insert(3);
		myTree.insert(4);
		myTree.PrintTree();
		makeSpace(2);
		//
		//deleting root of the tree till tree is empty
		while(myTree.isEmpty() == false)
		{
			//deleting root of the tree
			myTree.deleteRoot();
			//
			//printing tree
			myTree.PrintTree();
			makeSpace(1);
		}
	}
}