/**
   A "cache" stores frequently used objects and forgets less frequently used
   ones. 
   
   Complete the add method of the Cache class below so that new elements are
   added to the front, and elements that already exist in the cache are "promoted"
   to the front. The cache size should never exceed maxSize. If it does, 
   remove the last element.

   For example, assume the cache size is 5.

   If you add A B C D E F C, then the cache contains C F E D B

   Note that A was lost when F was inserted. Inserting C again promotes it to 
   the front.
*/

public class Cache
{
   class Node
   {
      Object data;
      Node next;
      Node previous;
   }

   Node first;
   Node last;
   int size;
   int maxSize;

   public Cache(int maxSize)
   {
      this.maxSize = maxSize;
      first = null;
      last = null;
      size = 0;
   }

   public void add(Object obj)
   {
      Node n = find(obj);
      if (n == null)
      {
         n = new Node();
         n.data = obj;
         if (last == null)
         {
            last = n;
         }
      } 
      else
      {
         // Remove n from the list
         if (n.previous != null) 
        {
        	 n.previous = n;
        }
        if (n.next != null)
         {
        	 n.previous = n.next;
        	 
        	 // connect the other link to complete this portion
         }
         if (n == last)
         {
        	n.previous = null;
         }
         size--;
      }
      // Add n before the first element of the list
      n.next = first;
      n.previous = null;
      if (first != null)
      {
    	  n.next = first;
      }
      first = n.next;
      size++;
      if (size > maxSize)
      {
         // Remove the last node
         last = n;
         last.next = null;
         size--;
      }
   }

   private Node find(Object obj)
   {
      for (Node n = first; n != null; n = n.next)
         if (n.data.equals(obj)) return n;
      return null;
   }
}