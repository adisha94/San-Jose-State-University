import java.util.TreeSet;
import java.math.*;
import java.util.Comparator;
import java.util.List;
import java.lang.Comparable;

public class AVLCheck<Anytype extends Comparator<? super Anytype>>
{
	private Node root;
	class Node
	{
		// properties of Node
		Object data;
		int height;
		Node left;
		Node right;
	    public List<Node> children;
		
	    // inner methods for Node
		public boolean leftExists()
		{
			if (this.left != null)
				return true;
			return false;
		}
		public boolean rightExists()
		{
			if (this.right != null)
				return true;
			return false;
		}
	      /**
	       * calculates the number of interior nodes for one particular parent node
	       * @return
	       */
	      public int interiorNodes()
	      {
				int sum = (children.size() > 0) ? 1 : 0;
			
	    	    // first time for left nodes
				for (Node traverseNode = root; traverseNode != null; traverseNode = traverseNode.left)
				{
					children.add(traverseNode);
				}
				// second time for right nodes
				for (Node traverseNode = root; traverseNode != null; traverseNode = traverseNode.right)
				{
					children.add(traverseNode);
				}
				
				for (Node child : children)
				{
					sum = sum + child.interiorNodes();
				}
			return sum;
		  }

	}
	
	/**
	 * Checks the height of the left and right subtree and returns wether or not the tree is balenced or not
	 * @return
	 */
	private boolean checkBalence()
	{
		int heightDifference = Math.abs(root.left.height - root.right.height);		
		// if height difference is greater than 1, then we know that the AVl tree is false
		
		// check the left and right node if they exist
		if(heightDifference <= 1) // between 0 and 1
			return true;
		else
			return false;
	}
	
	
	/**
	 * Referring to problem #2 in the midterm
	 * @return
	 */
	public boolean AvlVerifier()
	{
		//checks every node in the tree
		// checks the left Nodes
		for (Node leftSide = root; leftSide != null; leftSide= leftSide.left)
		{
			// checks the right side
			for (Node rightSide = root; rightSide != null; rightSide = rightSide.right)
			{
				// checks to see if the balence differs by at most 1
				// if the condition is true
				if (checkBalence())
				{
					// proceed on traversal
					continue;
				}
				else
				{
					// otherwise return falsse
					return false;
				}
			}
		}
		// if we reach the end of the tree, we and condition of balance returns true.
		return true;
	}
	
	
}
