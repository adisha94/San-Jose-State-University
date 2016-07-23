import java.util.ArrayList;
import java.util.List;

public class Tree
{  
   private Node root;
   
   /**
      Constructs a tree with one node and no children.
      @param rootData the data for the root
   */
   public Tree(Object rootData)
   {
      root = new Node();
      root.data = rootData;
      root.children = new ArrayList<>();
   }
   
   /**
      Adds a subtree as the last child of the root.
   */
   public void addSubtree(Tree subtree)
   {
      root.children.add(subtree.root);
   }
   
   public void print()
   {
      if (root != null) root.print("");      
   }
      
   class Node
   {
      public Object data;
      public List<Node> children;
      // prints out the tree structure hierarchy
      public void print(Node parent, int idx, String prefix) 
      {
		  System.out.println(prefix + "+--"+ data.toString());
    	  int index = 0;
          for (Node child : children)
          {
         	 index++;
         	 if(parent.children.size() == idx)
         	 {
             	 child.print(this, index, prefix + "   ");         		 
         	 }else
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
			  System.out.println(prefix + data.toString());    			  
		  }
    	  int index = 0;
         for (Node child : children)
         {
        	 index++;
  			child.print(this, index, prefix);
         }
      }
   }
}