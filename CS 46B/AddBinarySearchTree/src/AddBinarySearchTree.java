import java.util.*;

/**
   This class implements a binary search tree whose
   nodes hold objects that implement the Comparable
   interface.
*/
public class AddBinarySearchTree
{  
   private Node root;

   /**
      Constructs an empty tree.
   */
   public AddBinarySearchTree()
   {  
      root = null;
   }
   
   /**
      Inserts a new node into the tree.
        Node will go to the right if object data is bigger than parent object data
      	Node will go to the left if object data smaller than parent object data
      @param obj the object to insert
   */
   public void add(Comparable obj) 
   {  
      Node newNode = new Node();
      newNode.data = obj;
      newNode.left = null;
      newNode.right = null;
      root = addNode(root, newNode);
   }

   /**
      Add the given new node to the given parent node.
      @param parent The parent node to be added to.
      	Node will go to the right if bigger than parent
      	Node will go to the left if smaller than parent
      @param newNode The node to be added.
   */
   public static Node addNode(Node parent, Node newNode)
   {
      if (parent == null) 
      {    	 
         return newNode;
      }
      // conditional adding for binary tree pathway
      int compa =  newNode.data.compareTo(parent.data);
      if (compa < 0) // left side
      {
    	  parent.left = addNode(parent.left, newNode);
      }
      else if (compa > 0) // right side
      {
    	  parent.right = addNode(parent.right, newNode);
      }
      return parent;
   }

   public String toString()
   {  
      return toString(root);
   }  

   /**
      Produces a string of a node and all of its descendants in sorted order.
      @param parent the root of the subtree to process
   */
   private static String toString(Node parent)
   {  
      if (parent == null) { return ". "; }
      else 
      { 
         return "( " + toString(parent.left) 
            + parent.data + " " 
            + toString(parent.right) + ") "; 
      }
   }

   /**
      A node of a tree stores a data item and references
      to the left and right child nodes.
   */
   class Node
   {  
      public Comparable data;
      public Node left;
      public Node right;
   }
}