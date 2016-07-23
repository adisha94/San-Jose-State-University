import java.util.*;

public class Set
{
   TreeMap<Integer, LinkedList<Object>> buckets;

   /**
      Constructs an empty set.
   */
   public Set()
   {
      buckets = new TreeMap<Integer, LinkedList<Object>>();
   }

   /**
      Tests for set membership.
      @param x an object
      @return true if x is an element of this set
   */
   public boolean contains(Object x)
   {
	   for (LinkedList<Object> bucket : buckets.values())
	   {
		   if (bucket.contains(x) == true)
		   {
			   return true;
		   }
	   }
	   return false;
   }

   /**
      Adds an element to this set.
      @param x an object
      @return true if x is a new object, false if x was
      already in the set
   */
   public boolean add(Object x)
   {	   
	   if (contains(x) == true)
	   {
		   return false;
	   }
	   else
	   {
		   LinkedList<Object> current = buckets.get(x.hashCode());
		   // checking for existing key
		   if (current == null)
		   {
			   current = new LinkedList<Object>();
			   buckets.put(x.hashCode(), current);
		   }
		   current.addFirst(x);
	   }
	   return true;
   }

   /**
      Gets the number of elements in this set.
      @return the number of elements
   */
   public int size()
   {
	   int sizeOfEntries = 0;
	   for (LinkedList<Object> bucket : buckets.values())
	   {
		   sizeOfEntries = sizeOfEntries+ bucket.size();
	   }
		   
	   return sizeOfEntries;
   }

   /**
      Removes an object from this set.
      @param x an object
      @return true if x was removed from this set, false
      if x was not an element of this set
   */
   public boolean remove(Object x)
   {
	    int h = x.hashCode();
	    if (buckets.containsKey(h))
	    {
	    	LinkedList<Object> linkedlist =  buckets.get(h);
	    	
	    	if ( linkedlist.isEmpty() )
	    	{
	    		// remove h from bucket
	    		buckets.remove(h);
	    	}
	    	else
	    	{
	    		buckets.put(h, linkedlist);
	    	}	    	
	    	return true;
	    }
	    return false;
   }

   /**
      Returns an iterator that traverses the elements of this set.
      @return a hash set iterator
   */
   public Iterator iterator()
   {
      return new SetIterator();
   }

   class SetIterator implements Iterator
   {
      private Iterator<LinkedList<Object>> bucketIterator; // iterates through the keys
      private LinkedList<Object> currentBucket; // current Linkedlist value object
      private ListIterator<Object> current; // iterates through the values 

      /**
         Constructs an iterator that points to the
         first element of the set.
      */
      public SetIterator()
      {
    	  bucketIterator = buckets.values().iterator(); // iterates through the keys
    	  currentBucket = null; /// current LinkedList value object
    	  current = null; // iterates through the values
    	  if (bucketIterator.hasNext() == true)
    	  {    		  
    		  currentBucket = bucketIterator.next();
    		  current = currentBucket.listIterator();
    	  }
      }

      /**
       * 
       * @return boolean value if found
       */
      public boolean hasNext()
      {
    	  return ((current != null) && (current.hasNext() == true)) ? true : bucketIterator.hasNext(); 
      }
      
      /**
       * @return object at current key-value position
       */
      public Object next()
      {
    	  // if there is a value in the list
    	 if (hasNext() == true)
    	 {
    		 if ((current != null) && (current.hasNext() == true))
    		 {
    			 return current.next();
    		 }
       	  	currentBucket = null; /// current LinkedList value object
       	  	current = null; // iterates through the values
       	  	if (bucketIterator.hasNext() == true)
       	  	{    		  
       	  		currentBucket = bucketIterator.next();
       	  		current = currentBucket.listIterator();
       	  		if (current != null)
       	  			return current.next();       	  			
       	  	}
    	 }    	  
         return null;
      }

      /**
       * disconnect the current key-value pair
       */
      public void remove()
      {
		if (current != null)
		{
			Object obj = currentBucket.getFirst();
			int key = obj.hashCode();
			current.remove();
			if (current.hasNext() == false)
			{
				buckets.remove(key);
			}
		}

	 }
   }
}