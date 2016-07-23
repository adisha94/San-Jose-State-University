import java.util.logging.Logger;

/**
 * 
 * @author Adish
 *
 */
public class Bag
{
   Node first;
   /**
    * ...
    * @author Adish
    *
    */
   class Node
   {
      Object data;
      int count;
      Node next;
   }
   /**
    * ...
    */
   public Bag()
   {
      first = null;
   }
   
   /**
    * adds an item to the bag and then increments the counter for that item
    * @param obj object to add
    */
   public void add(Object obj)
   {
		Node foundNode = null;
		Node i = first;
		// loop through exiting Nodes to find obj
		while(i != null)
		{
			if (i.data.equals(obj))
			{
				foundNode = i;
				break;
			}
			i = i.next;
		}
		if(foundNode != null)
		{
			// as found increment counter
			foundNode.count++;
		}
		else
		{
			// not found, create Node
			Node newNode = new Node();
			newNode.data = obj;
			newNode.count = 1;			
			// add at the head/first
			newNode.next = this.first;
			this.first = newNode;
		}
   }
   
   /**
    * 
    * removes an item to the bag and then decrement the counter for that item
    * @param obj object to remove
    */
   public void remove(Object obj)
   {	  
	   boolean found = false;
	   Node i = first;
	   Node previous = i;
	   // deals with counter
	   while(i != null)
	   {		
		   if (i.data.equals(obj))
		   {
			   found = true;
			   break;
		   }		   
		   previous = i;
		   i = i.next;
	   }

	   if (found == true)
	   {
		   i.count--;		   
		   if (i.count <= 0)
		   {
			   previous.next = i.next;
		   }
	   }			

   }
   
   
   /**
    * 
    * @param obj object to find
    * @return the quantity of the particular object that you area trying to find
    */
   public int contains(Object obj)
   {
	  boolean itemIsThere = false;
	  Node current = this.first;
		for (Node n = current; n != null; n = n.next)
		{
			itemIsThere = n.data.equals(obj) ? true : false;
			if (itemIsThere == true)
			{
				return n.count;
			}
		}
		return 0;
   }
   
/**
 * @return string representation
 */
   public String toString()
   {
	  Node i = first;
      String result = "[";
      while (i != null)
      {
    	  
    	 if (i.next != null)
    	 {
    		 for (int count = 1; count <= i.count; count++)
    		 {
            	 result = result + i.data + ", ";
    		 }
    	 }
    	 else
    	 {
    		 result = result + i.data + "";
    	 }
    	 i = i.next; // proceed onto next node
      }
      
      result = result + "]";
      return result;
   }
}