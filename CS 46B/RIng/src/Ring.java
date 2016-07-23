import java.util.NoSuchElementException;
// Adish Solution

/**
 * class for ring
 * @author Adish Betawar
 *
 */
public class Ring
{
   Node start = null; // The current position

   /**
    * 
    * @author Adish
    *
    */
   class Node
   {
      Node next;
      Node previous;
      Object data;
   }

   /**
      Construct a ring with the given initial size, and all data set to null.
      @param initialSize the initial size of the ring
   */
   public Ring(int initialSize)
   {
      if (initialSize <= 0) throw new IllegalArgumentException();      
      for (int i = 0; i < initialSize; i++)
      {
    	  add(null);
      }
   }

   /**
      Moves the current position forward.
   */
   public void forward()
   {
 	  if (start == null)
 	  {
 		  throw new IllegalStateException();
 	  }
 	  start = start.next;
   }

   /**
      Moves the current position backward.
   */
   public void backward()
   {
	   if (start == null)
	   {
		   throw new IllegalStateException();
	   }
	   start = start.previous;
   }

   /**
      Gets the current element.
      @return the value
   */
   public Object get()
   {
      return start.data;
   }

   /**
      Sets the current element.
      @param newValue the new value
      @return the old value
   */
   public Object set(Object newValue)
   {	   
	   Object oldData = start.data;
	   start.data = newValue;
	   return oldData;
   }

   /**
      Adds an element before the current element.
      @param newValue the value to add 
   */
   public void add(Object newValue) // FOCUS
   {
	   Node newNode = new Node();
	   newNode.data = newValue;
	   if (start == null)
	   {
		   newNode.next = newNode;
		   newNode.previous = newNode;
		   start = newNode;
	   }
	   else
	   {
		   newNode.next = start;
		   newNode.previous = start.previous;
		   start.previous = newNode;
		   if (newNode.previous != null)
		   {
			   newNode.previous.next = newNode; 
		   }		   		   
	   }	   
	}
	   

   /**
    * Removes the current element and makes the next element the current one. 
      @return the old value
    */
   public Object remove()
   {
      if (start.next == start) throw new IllegalStateException();      
      Object removed = start.data;
       start.next.previous = start.previous;
       start.previous.next = start.next;
       start = start.next;
      return removed;
   }
}