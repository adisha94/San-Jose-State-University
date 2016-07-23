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
	public Node root = null;
	private Comparator<? super Anytype> cmp;
	// this is a node class for our code 'XP'
	
	public class Node extends BinarySearchTree
	{
		Anytype data = null;
		Node left = null;
		Node right = null;

	    public  Node(Anytype data)
	    {
	    	this.data = data;
	    }
	    
		public Node() 
		{
			// TODO Auto-generated constructor stub
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
	     * searches for the parent of the target node.
	     * We perform this search for looking for its data type. 
	     * @return
	     */
	    public Node getParent()
		{
			// little complex process to retrieve the parent node
			// start from root and go until either left or right equals to the targetNode
			Node rightSide = root.right; // searches from the right subtree
			Node leftSide = root.left; // searches from the left subtree
			Node parentNode = null; // set the target to this object when found the item
			
			boolean foundParent = false; // indicator for found parent Node or not inside the code
			if(root.left == this || root.right == this)
			{
				foundParent = true;
				parentNode = root;
				return parentNode;
			}			
			/*
			 * Will result in infinite loop for sure
			 */
			else
				while (root != this || foundParent == false)

				{
					leftSide = leftSide.left;
					rightSide = rightSide.right;
					/*
					 * If the root is not the parent of the node, then we
					 * implement a 'implement a spliterator' from both the left
					 * and the right side to get the parent
					 */
					{
						// try to accomplish both left and right in the same
						// loop
						if (leftSide.left == this.data || leftSide.right == this.data) 
						{
							foundParent = true;
						}
						/*
						 * If we reach the end of the left subtree
						 */
						else if (leftSide == findMin(leftSide) || leftSide == findMax(leftSide)) 
						{
							foundParent = false;
							// stop here
						}
						if (rightSide.left == this.data || rightSide.right == this.data) 
						{
							foundParent = true;
						}
						/*
						 * If we reach the end of the left subtree
						 */
						else if (rightSide == findMin(rightSide) || rightSide == findMax(rightSide)) 
						{
							foundParent = false;
							// stop here
							break;
						}

						/*
						 * Normal false circumstance
						 */
						if ((leftSide.left == this) || (leftSide.right == this))
						{
							foundParent = true;
							if (leftSide.left == this) 
							{
								foundParent = true;
								parentNode = leftSide;
								return parentNode;
							}
							else if (leftSide.right == this) 
							{
								foundParent = true;
								parentNode = leftSide;
								return parentNode;
							}
						}

						if ((rightSide.left == this) || (rightSide.right == this)) 
						{
							foundParent = true;
							if (rightSide.left == this) 
							{
								foundParent = true;
								parentNode = rightSide;
							}
							else if (rightSide.right == this) 
							{
								foundParent = true;
								parentNode = rightSide;
							}
						}

					}
				}
			return null; // left side or right side
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
	
	
	private int myCompare(Anytype lhs, Anytype rhs)
	{
		if(cmp != null)
		{
			return cmp.compare(lhs, rhs);
		}
		else
			return ((Comparable)lhs).compareTo(rhs);
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
	
	
	public int height(Node targetNode)
	{
		// check the target Node location
		if(targetNode == null)
			return 0;
		
		int leftHeight = height(targetNode.left);
		int rightHeight = height(targetNode.right);
		
		if(leftHeight >= rightHeight)
		{
			return leftHeight + 1;
		}
		return rightHeight + 1;
	}


	public void insert(Anytype value)
	{
		root = insert(root, value);
	}
	
	public Node insert(Node node, Anytype value)
	{
		if(node == null){
			System.out.println("Inserting " + value);
			node = new Node();
			node.data = value;
			node.left = null;
			node.right = null;
		}
		else
		{
			int compareResult = 0;
			if(cmp != null)
				compareResult = cmp.compare(node.data, value);
			else
				compareResult = value.compareTo(node.data);
			
			if(compareResult < 0)
			{
				System.out.println("Traversing left");
				node.left = insert(node.left, value);
			}
			else if (compareResult > 0)
			{
				System.out.println("Traversing right");
				node.right = insert(node.right, value);
			}
			else
				;
		}
		return node;
	}


	/**
	 * helper method for deleteRoot
	 * @param value
	 */
	public void delete(Anytype value)
	{
		System.out.println("Deleting " + value);
		if(root == null)
			return;
		Node parent = root;
		Node curr = root;
		boolean foundNode = false; // finding the node to remove
		while(curr != null)
		{
			int compareResult = 0;
			if(cmp != null)
				compareResult = cmp.compare(curr.data, value);
			else
				compareResult = value.compareTo(curr.data);
			
			if(compareResult < 0)
			{
				parent = curr;
				curr = curr.left;
			}
			else if(compareResult > 0)
			{
				parent = curr;
				curr = curr.right;
			}
			else
			{
				foundNode = true;
				break;
			}
		}
		if(!foundNode) // node is not found 
			return;
		
		boolean rSide = false; 
		if(parent.right == curr) rSide = true;
		//Deletion cases
		if(curr.left == null && curr.right == null)
		{ //is a leaf
			System.out.println("Has no subtree");
			if(!rSide)
			{ //is of parent's left
				parent.left = null;
			}
			else
			{
				parent.right = null;
			}
			curr = null;
			if(parent == root)
				root = null;
		}
		else if (curr.left == null && curr.right != null)
		{ // has a right subtree
			System.out.println("Has right subtree");
			if(curr == root)
			{
				root = curr.right;
			}
			else
			{
				if(!rSide)
				{
					parent.left = curr.right;
				}
				else
				{
					parent.right = curr.right;
				}
			}
		}
		else if (curr.left != null && curr.right == null)
		{ //has a left subtree
			System.out.println("Has left subtree");
			if(curr == root)
			{
				root = curr.left;
			}
			else
			{
				if(!rSide)
				{
					parent.left = curr.left;
				}
				else
				{
					parent.right = curr.left;
				}
			}
		}
		else
		{ // have both subtrees
			System.out.println("Has both subtrees");
			System.out.println(curr.right.data);
			Node leftMost = curr.right;
			Node leftMostParent = curr.right;
			while(leftMost.left != null)
			{
				leftMostParent = leftMost;
				leftMost = leftMost.left;
			}
			curr.data = leftMost.data;
			if(curr.right == leftMost)
			{
				curr.right = null;
				if(leftMost.right != null)
					curr.right = leftMost.right;
			}
			if(leftMostParent != leftMost)
			{
				if(leftMost.right != null)
				{
					leftMostParent.left = leftMost.right;
				}
				else
				{
					leftMostParent.left = null;
				}
			}
		
		}
		
	}
	/**
	 * deleting root of the tree
	 */
	public void deleteRoot()
	{
		System.out.println("Deleting root " + root.data);
		delete(root.data);
		if(isEmpty() == false)
		{
			System.out.println("Root is now " + root.data);
		}
		else
		{
			System.out.println("ROOT equals Null, Tree is clean");
		}
	}
	public boolean isEmpty()
	{
		if(root != null)
			return false;
		return true;
	}
}