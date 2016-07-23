import java.util.*;
/**
 * 
 * @author Adish Betawar
 *
 */

/*
 * This is for Problem #1 on Homework 2
 */
public class TreePrinter<Anytype> extends BinarySearchTree
{
	
	public TreePrinter()
	{
		// initialize somehow
	}
	//2.)
	public void PrintTreeFromNode(Anytype x, Node e)
	{
		//process:
		//isolate
		//print left and right at the same time
		if(super.Contain((Comparable) x, e))
		{
			// organiza tree printing here for left and right hand roots
			System.out.print(e.data); // prints out target node			
			// recursively print out all the child nodes of selected arbitrary node
			if (e.leftExists())
			{
				PrintTreeFromNode(x, e.left);
			}
			else
				;
			if(e.rightExists())
			{
				PrintTreeFromNode(x, e.right);
			}
			else
				;
		}
		else
		{
			return;
		}
		
	}
	
}