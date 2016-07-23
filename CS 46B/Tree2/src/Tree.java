import java.util.ArrayList;
import java.util.List;

public class Tree
{  
   private Node root; // first node of the tree structure
   
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
   
  /**
    * Calculates recursively the sum of the number of interior nodes in the tree
    * @return
    */
   public int interiorNodes()
   {
	   int sum = (root.children.size() > 0) ? 1 : 0;
	   for (Node child: root.children)
	   {
		   sum = sum + child.interiorNodes();
	   }
	   return sum;
   }
   
   class Node
   {
      public Object data;
      public List<Node> children;
       
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
   }
}