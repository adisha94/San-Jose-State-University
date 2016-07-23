import java.util.Iterator;
import java.util.NoSuchElementException;

/**
   This class implements a hash set using separate chaining.
*/
public class HashSet
{
   Node[] buckets;
   int currentSize;

   /**
      Constructs a hash table.
      @param bucketsLength the length of the buckets array
   */
   public HashSet(int bucketsLength)
   {
      buckets = new Node[bucketsLength];
      currentSize = 0;
   }

   /**
      Tests for set membership.
      @param x an object
      @return true if x is an element of this set
   */
   public boolean contains(Object x)
   {
      int h = x.hashCode();
      if (h < 0) { h = -h; }
      h = h % buckets.length;
      
      Node current = buckets[h];
      while (current != null)
      {
         if (current.data.equals(x)) { return true; }
         current = current.next;
      }
      return false;
   }

   
   /**
    * helper method for fully initializing index location h in Hashset
    * @param x
    * @return
    */
   private int compressForIndex(Object x)
   {
	   int h = x.hashCode(); // getting hashcode for a given object
	   if (h < 0)
	   {
		  h = -h;
	   }
	   h = h % buckets.length; // compressed for index location of object
	   return h;
   }
   
   /**
      Adds an element to this set.
      @param x an object
      @return the set with this element added
   */
   public HashSet add(Object x)
   {   
	  int h = compressForIndex(x);
	  HashSet result = new HashSet(buckets.length);
	  Node current = buckets[h];
		while (current != null)
		{
			if (current.data.equals(x) == true)
			{
				return this;
			}
			current = current.next;
		}
		// assuming value was not found true (aka false)
		Node newNode = new Node();
		newNode.data = x;
		result.currentSize++;
		newNode.next = buckets[h];
		for (int i = 0; i < buckets.length; i++) 
		{
			result.buckets[i] = this.buckets[i];
			result.currentSize = currentSize + 1;
		}
		result.buckets[h] = newNode;
		return result;		
	  }

   /**
      Removes an object from this set.
      @param x an object
      @return the set with this element removed
   */
   public HashSet remove(Object x)
   {
	   HashSet result = new HashSet(buckets.length);
	   int h = compressForIndex(x);   
		Node current = buckets[h];
		Node previous = null;
	  while (current != null)
	  {
		  if (!current.equals(x))
		  {
			  Node n = new Node();
			  n.data = x;
			  n.next = current.next;
			  result.add(x);
		  }
		  else
		  {
			  return result;
		  }
	  }
      
	  return result;
   }

   /**
      Returns an iterator that traverses the elements of this set.
      @return a hash set iterator
   */
   public Iterator iterator()
   {
      return new HashSetIterator();
   }

   /**
      Gets the number of elements in this set.
      @return the number of elements
   */
   public int size()
   {
      return currentSize;
   }

   class Node
   {
      public Object data;
      public Node next;
   }

   class HashSetIterator implements Iterator
   {
      private int bucketIndex;
      private Node current;

      /**
         Constructs a hash set iterator that points to the
         first element of the hash set.
      */
      public HashSetIterator()
      {
         current = null;
         bucketIndex = -1;
      }
      
      public boolean hasNext()
      {
         if (current != null && current.next != null) { return true; }
         for (int b = bucketIndex + 1; b < buckets.length; b++)
         {
            if (buckets[b] != null) { return true; }
         }
         return false;
      }
       
      public Object next()
      {
         if (current != null && current.next != null) 
         {            
            current = current.next; // Move to next element in bucket
         }
         else // Move to next bucket
         {            
            do
            {
               bucketIndex++;
               if (bucketIndex == buckets.length) 
               {
                  throw new NoSuchElementException();
               }
               current = buckets[bucketIndex];
            }
            while (current == null);            
         }
         return current.data;
      }

      public void remove()
      {
         throw new UnsupportedOperationException();
      }
   }
}