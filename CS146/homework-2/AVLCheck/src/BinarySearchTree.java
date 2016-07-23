import java.util.*;
import java.util.Comparator;
import java.lang.Comparable;
/**
 * 
 * @author Adish Betawar
 *
 */
public class BinarySearchTree<Anytype extends Comparable<? super Anytype>>
{
	public Node root;
	private Comparator<? super Anytype> cmp;
	// this is a node class for our code 'XP'
	class Node
	{
		Anytype data = null;
		Node left = null;
		Node right = null;
		Node previous = null; // 'mini doubly link tree'
	    public List<Node> children;

	    public  Node(Anytype data)
	    {
	    	this.data = data;
	    }
	    
	    
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
				for (Node child : children)
				{
					sum = sum + child.interiorNodes();
				}
			return sum;
		  }
		
	      
	    /**
	     * searches for the parent of the target node.
	     * We perform this search for looking for its data type. 
	     * @return
	     */
	    public Node getParent()
		{
			// little complex process to retrieve the parent nojde
			// start from root and go until either left or right equals to the targetNode
			Node rightSide = root.right; // searches from the right subtree
			Node leftSide = root.left; // searches from the left subtree
			Node parentNode = null; // set the target to this object when found the item
			
			boolean foundParent = false;
			
			/*
			 * Will result in infinite loop for sure
			 */
			while(root != this)
			{
				if(root.left == this || root.right == this)
				{
					foundParent = true;
					
//					return parentNode;
				}
				/*
				 * If the root is not the parent of the node, then 
				 * we implement a 'implement a spliterator' from both the left and the right side to get the parent
				 */
				else
				{
					// try to accomplish both left and right in the same loop
					if(leftSide.left == this.data || leftSide.right == this.data)
					{
						foundParent = true;						
					}
					/*
					 * If we reach the end of the left subtree
					 */
					else if(leftSide == findMin(leftSide) || leftSide == findMax(leftSide))
					{
						foundParent = false;
						
						// stop here
					}
					/*
					 * Normal false circumstance
					 */
					else
					{
						// is this really necessary??
//						Node left_LeftSide = leftSide.left;
						
//						Node left_RightSide = leftSide.right;
					}
					
					if ( (leftSide.left == this.data) || (leftSide.right == this.data) )
					{
						foundParent = true;
						if(rightSide.left == this)
						{
							parentNode = rightSide.left;
						}
						else if(rightSide.right == this)
						{
							parentNode = rightSide.right;
						}
					}

					if ( (rightSide.left == this.data) || (rightSide.right == this.data) )
					{
						foundParent = true;
						if(rightSide.left == this)
						{
							parentNode = rightSide.left;
						}
						else if(rightSide.right == this)
						{
							parentNode = rightSide.right;
						}
					}
					
				}
			}
			
			
			return previous; // left side or rightside
		}
	}
	
	/*
	 * returns whether or not a node exists within a tree
	 */
	public boolean Contain(Anytype x, Node t)
	{
		if(t == null)
			return false;
		
		int compareResult = x.compareTo(t.data);
		
		if(compareResult < 0)
		{
			return Contain(x, t.left);
		}
		else if(compareResult > 0)
		{
			return Contain(x, t.right);
		}
		else
		{
			return true;
		}
	}
	
	
	/**
	 * Calculates recursively the sum of the number of interior nodes in the
	 * tree
	 * 
	 * @return
	 */
	public int interiorNodes() 
	{
		int sum = (root.children.size() > 0) ? 1 : 0;
		for (Node child : root.children) 
		{
			sum = sum + child.interiorNodes();
		}
		return sum;
	}
	
	private int myCompare(Anytype lhs, Anytype rhs)
	{
		if(cmp != null)
		{
			return cmp.compare(lhs, rhs);
		}
		else
			return ((Comparable)lhs).compareTo(rhs);
	}
	
	/**
	 * Homework #2d
	 * @param targetTree
	 */
	public void deletePrintTree(Node targetNode)
	{
		TreePrinter printer = new TreePrinter<>();
		int numberOfNodes = targetNode.interiorNodes(); // calculate how many nodes are there for an arbitrary node in the tree
		if(numberOfNodes > 1)
		{
			// loop until false
			while(targetNode.leftExists() && targetNode.rightExists())
			{
				
				Node traversedNode = targetNode; // to protect the interest of the paramatized Node
				if (targetNode.leftExists())
				{
					// proceed on
					// go to the leaf on the minimum side (left side)
					// delete the leaf
					// continue upwards
					Node minimumPosition = findMin(targetNode); // first go to the left most to delete that leaf
					printer.PrintTreeFromNode(minimumPosition, targetNode); // print out the node before removing from the tree structure
					removeNode(minimumPosition.data, targetNode);
				}
				if (targetNode.rightExists())
				{
					// proceed on
					// go to the leaf on the maximum side (right side)
					// delete the leaf
					// continue upwards			
					Node maximumPosition = findMax(targetNode); // first go to the left most to delete that leaf
					printer.PrintTreeFromNode(maximumPosition, targetNode); // print out the node before removing from the tree structure
					removeNode(maximumPosition.data, targetNode);				
				}	
			}
		}
		else
			;
	}
	
	/**
	 * starting from a arbitrary node, we delete the pathway from one side to the other.
	 * @param x
	 * @param e
	 * @return
	 */
	public Node Remove(Anytype x, Node e)
	{
		if (Contain(x,e))
		{
			if (e.leftExists())
			{
				// ???
				e = e.left;
				removeNode(e.data ,e.getParent());
			}
			else
				;
			if(e.rightExists())
			{
				// ???
				e = e.right;
				removeNode(e.data , e.getParent());
			}
			else
				;
		}
		return e;
	}

	
	private Node removeNode(Anytype x, Node nodeToStart)
	{
		if (nodeToStart == null)
		{
			return nodeToStart;
		}
		int compareResult = x.compareTo(nodeToStart.data);
		
		if (compareResult < 0)
		{
			nodeToStart.left = removeNode(x, nodeToStart.left);
		}
		else if(compareResult > 0)
		{
			nodeToStart.right = removeNode(x, nodeToStart.right);
		}
		else if (nodeToStart.left != null && nodeToStart.right != null)
		{
			nodeToStart.data = findMin(nodeToStart.right).data;
			nodeToStart.right = removeNode(nodeToStart.data, nodeToStart.right);
		}
		else
			nodeToStart = (nodeToStart.left != null) ? nodeToStart.left : nodeToStart.right;
		return nodeToStart;
	}
	
	/**
	 * finding the minimum item leave in the subtree
	 * @param t
	 * @return
	 */
	public Node findMin(Node t) 
	{
		if(t == null)
			return null;
		else if(t.left == null)
		{
			return t;
		}
		return findMin(t.left);
	}

	/**
	 * finding the maximum item in the subtree
	 * @param t
	 * @return
	 */
	public Node findMax(Node t)
	{
		if(t != null);
		while (t.right != null)
		{
			t = t.right;
		}
		return t;
	}	
}