import java.util.List;
import java.util.ArrayList;

/**
   A tree in which each node has an arbitrary number of children.
*/
public class Tree
{
   private Node root;

   class Node
   {
      public Object data;
      public List<Node> children;

      /**
         Computes the size of the subtree whose root is this node.
         @return the number of nodes in the subtree
      */
      public int size()
      {
         int sum = 0;
         for (Node child : children) { sum = sum + child.size(); }
         return 1 + sum;
      }
      
      public int LeafSize()
      {
         int leafCount = 0;
         if (isLeaf())
         {
        	 return 1;
         }         
         for (Node child : children)
         {
        	 leafCount = leafCount + child.LeafSize();
         }
         return leafCount;
      }
      
      public boolean isLeaf()
      {
    	  if (children.isEmpty())
    	  {
    		  return true;
    	  }
    	  return false;
      }
   }

   /**
      Constructs an empty tree.
   */
   public Tree()
   {
      root = null;
   }

   /**
      Constructs a tree with one node and no children.
      @param rootData the data for the root
   */
   public Tree(Object rootData)
   {
      root = new Node();
      root.data = rootData;
      root.children = new ArrayList<Node>();
   }

   /**
      Adds a subtree as the last child of the root.
   */
   public void addSubtree(Tree subtree)
   {
      root.children.add(subtree.root);
   }

   /**
      Computes the size of this tree.
      @return the number of nodes in the tree
   */
   public int size() 
   {
      if (root == null) { return 0; }
      else { return root.size(); }
   }
   
   
   /**
    * Calculates the number of leaves within the tree
    * @return
    */
   public int LeafSize()
   {
	   int leafSize = root.LeafSize();
	   return leafSize;
   }
}