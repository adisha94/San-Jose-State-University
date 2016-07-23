/**
   A bag is an unordered collection of possibly repeated elements.
*/
import java.util.Iterator;
import java.util.ConcurrentModificationException;
import java.util.NoSuchElementException;

public class Bag
{
   Node first;
   int modCountBag;

   /**
      A node holds an elements in this bag.
   */
   class Node
   {
      Object data;
      int count;
      Node next;
   }

   /**
      Constructs an empty bag.
   */
   public Bag()
   {
      first = null;
   }

   public int getModCount()
   {
	   return modCountBag;
   }
   /**
      Adds an object to this bag.
      @param obj the object to add
   */
   public void add(Object obj)
   {
      Node n = find(obj);
      if (n == null)
      {
         n = new Node();
         n.data = obj;
         n.count = 1;
         n.next = first;
         first = n;
      }
      else
      {
         n.count++;
      }
      modCountBag++; // incrementing in bag
   }

   /**
      Removes an object from this bag.
      @param obj the object to remove
   */
   public void remove(Object obj)
   {
      if (first == null) return;
      if (first.data.equals(obj))
      {
         if (first.count > 1) first.count--;
         else first = first.next;
      }
      else
      {
         Node n = first;
         while (n != null)
         {
            if (n.next != null && n.next.data.equals(obj))
            {
               if (n.next.count > 1) n.next.count--;
               else n.next = n.next.next;
               return;
            }
            else n = n.next;
         }
      }
      modCountBag--; // decrementing in bag
   }

   /**
      Counts how many times a particular object is in this bag.
      @param obj the object to find
      @return the number of times obj is in the bag
   */
   public int contains(Object obj)
   {
      Node n = find(obj);
      if (n == null) return 0;
      else return n.count;
   }

   /**
      Finds an object in this bag.
      @param obj the node containing obj or null
   */
   private Node find(Object obj)
   {
      Node n = first;
      while (n != null)
      {
         if (n.data.equals(obj)) return n;
         n = n.next;
      }
      return n;
   }

   /**
      Yields a string representation of this bag
      @return object the string representation
   */   
   public String toString()
   {
      String result = "[";
      Node n = first;
      while (n != null)
      {
         for (int i = 0; i < n.count; i++)
         {
            if (result.length() > 1) result += ", ";
            result += n.data;
         }
         n = n.next;
      }
      return result + "]";
   }

   /**
    * Constructor for the bag iterator
    * @return an iterator object for traversing through the bag
    */
   public Iterator iterator()
   {
	   return new BagIterator();
   }

   /**
    * an iterator that will go through the elements in the bag.
    * @author Adish
    */
   class BagIterator implements Iterator
   {
      private Node previous;
      private Node current;
      private int count;
      private boolean isAfterNext;
      private int modCountBagIterator; 
      
      /**
       * iterator constructor
       */
      public BagIterator()
      {
    	  current = first;
    	  modCountBagIterator = modCountBag; // default modCount counter
      }

      /**
       * checks to see if the next node exists 
       * @return a boolean value
       */
      public boolean hasNext()
      {
    	  return (current!= null) ? true : false;
      }

      /**
       * returns current position to which the iterator is pointer is pointing to and advances the iterator
       * @return returns the data of the current position pointed by the iterator
       */
      public Object next()
      {    	  
    	  count = current.count;
    	  if (!hasNext())
    		  throw new NoSuchElementException();
    	  if (getModCount() != modCountBagIterator)
    		  throw new ConcurrentModificationException();
    	  previous = current;    	  
		  Object currentData = current.data;
    	  if (current == null)
    	  {
    		  current = first;
    	  }
    	  else
    	  {    	
    		  // need to go as far as the frequency of the current data element is
    		  current.count--;
    		  if (current.count == 0)
    		  {    			
        		  current = current.next;
    		  }
    		  else // proceed on to next node
    		  {
    			  // standard proceed
    			  return currentData;
    		  }
    	  }    	  
    	  isAfterNext = true;
    	  return currentData;
      }
      
      /**
       * remove element from the bag. Then decrements the count.
       */
      public void remove()
      {
    	  modCountBagIterator--; // increment for iterator modCount for bag
    	  if (!isAfterNext)
    	  {
    		  throw new IllegalStateException();
    	  }    	  
    	  if( getModCount() != modCountBagIterator )
    	  {
    		  throw new ConcurrentModificationException();
    	  }
    	  else
    	  {
    		  if (current != null && current.next != null)
    		  {
    			   if (current.count > 1)
    				   current.count--;
    			   else
    			   {
    				   if (previous == null)
    					   first = first.next;
    				   else
    					   previous.next = current.next;
    				   current = current.next;
    			   }
    		  }
    		  else
    			  previous.next = null;
    	  }
    	  isAfterNext = false;
      }
   }
}