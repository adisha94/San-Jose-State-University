import java.util.*;
import java.lang.Comparable;
/**
 * @author Adish Betawar
 *
 */
public class RandomTree
{
	private TreeNode root;
	
	public RandomTree()
	{
		root = null;
	}

	/**
	 * Adds a subtree as the last child of the root.
	 */
	public void addSubtree(RandomTree subtree) 
	{
		root.children.add(subtree.root);
	}
	
	class TreeNode
	{
		public Comparable<Object> value;
		// all the children subtrees
		public List<TreeNode> children;
		TreeNode left;
		TreeNode right;
		
	      public void print(TreeNode parent, int idx, String prefix) 
	      {
			  System.out.println(prefix + "+--"+ value.toString());
	    	  int index = 0;
	          for (TreeNode child : children)
	          {
	         	 index++;
	         	 if(parent.children.size() == idx)
	         	 {
	             	 child.print(this, index, prefix + "   ");         		 
	         	 }
	         	 else
	         	     child.print(this, index, prefix + "|  ");
	          }
	      }
	      
	      /**
	       * helps to deal with the child nodes in the tree data structure
	       * @param prefix
	       */
	      public void print(String prefix) 
	      {
			  if (prefix.length() == 0)
			  {
				  System.out.println(prefix + value.toString());    			  
			  }
	    	  int index = 0;
	         for (TreeNode child : children)
	         {
	        	 index++;
	  			child.print(this, index, prefix);
	         }
	      }
	      
	  	/**
	  	 * This method adds a new tree nodes and adjusts the tree structure as we add the new node
	  	 * @param val
	  	 */
	  	public void addTreeNode(TreeNode newTreeNode)
	  	{  		
	  		int comp = root.value.compareTo(value);
	  		
	  		// adding to the tree based on current status
	  		if (comp < 0)
	  		{
	  			if (left == null)
	  			{
	  				left = newTreeNode;
	  			}
	  			else
	  				left.addTreeNode(newTreeNode);
	  		}
	  		else if (comp > 0)
	  		{
	  			if(right == null)
	  			{
	  				right = newTreeNode;
	  			}
	  			else
	  				right.addTreeNode(newTreeNode);
	  		}
	  		
	  	}      
	}
	
	/**
	 * Adds a node into the tree and adjusts the tree accordingly
	 * @param val
	 */
	public void add(Object val)
	{
		TreeNode newTreeNode = new TreeNode();
		newTreeNode.left = null;
		newTreeNode.right = null;
		if (root == null)
		{
			root = newTreeNode;
		}
		else
			root.addTreeNode(newTreeNode);
	}
	
	
	/**
	 * Returns wether a given node is a leaf or not
	 * @return
	 */
	public boolean searchForLeaf(Object given)
	{
		// check to see if the value exists within the tree
		return false;
	}
	
	
	/**
	 * Turns the tree to the right on one of the subtrees
	 * @param Node
	 */
	public void postTraversal(TreeNode Node)
	{
		
	}
	
	/**
	 * Turns the tree to the left on one of the subtrees
	 * @param Node
	 */
	public void preTraversal(TreeNode Node)
	{
	}

}