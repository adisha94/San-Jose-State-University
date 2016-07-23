import java.util.NoSuchElementException;

/**
   A linked list is a sequence of nodes with efficient
   element insertion and removal. This class 
   contains a subset of the methods of the standard
   java.util.LinkedList class.
*/
public class LinkedList
{  
   private Node first;
   private Node last;
   /** 
      Constructs an empty linked list.
   */
   public LinkedList()
   {  
      first = null;
      last = null;
   }
   
   /**
      Returns the first element in the linked list.
      @return the first element in the linked list
   */
   public Object getFirst()
   {  
      if (first == null) { throw new NoSuchElementException(); }
      return first.data;
   }
   
   Node currentNode = null;
   int indexvar = -1; // current index   
   /**
    * Iterating through the node to the nth index.
    * Then returning the nth index Node. 
    * @param n target index location
    * @return
    */
   private Node getNode(int n) throws ArrayIndexOutOfBoundsException
   {
	   if ( (indexvar == -1) || (indexvar < n) )
	   {
		   currentNode = first;
		   indexvar = 0;
	   }
	   for (; currentNode!= null; currentNode = currentNode.next, indexvar++)
	   {
		   if (indexvar == n)
		   {
			   return currentNode;
		   }
	   }
	   throw new ArrayIndexOutOfBoundsException();
   }
   
   /**
    * Gets the data at the particular point
    * @param n
    * @return
    */
   public Object get(int n)
   {
	  Node acquiredNode = getNode(n);
	  return acquiredNode;
   }
   
   
   /**
    * changes the data in a particular node
    * Obect sets the data for the current element
    * @param n
    * @param newElement
    */
   public void set(int n, Object newElement)
   {
	   Node acquiredNode = getNode(n);
	   acquiredNode.data = newElement;
   }

   /**
      Removes the first element in the linked list.
      @return the removed element
   */
   public Object removeFirst()
   {  
      if (first == null) { throw new NoSuchElementException(); }
      Object element = first.data;
      first = first.next;
      if (last != null)
    	  last.next = first;
      indexvar = -1;
      return element;
   }

   /**
      Adds an element to the front of the linked list.
      @param element the element to add
   */
   public void addFirst(Object element)
   {  
      Node newNode = new Node();
      newNode.data = element;
      newNode.next = first;
      first = newNode;
      if (last != null)
    	  last.next = first;
      indexvar = -1;
   }
   
   /**
    * adds element to end of LinkedList
    * @param element
    */
   public void addLast(Object element)
   {
	   Node newNode = new Node();
	   newNode.data = element;
	   newNode.next = first;
	   if (last != null)		   
		   last.next = newNode;		   
	   last = newNode;
	   indexvar = -1;
   }
   
   /**
      Returns an iterator for iterating through this list.
      @return an iterator for iterating through this list
   */
   public ListIterator listIterator()
   {  
      return new LinkedListIterator();
   }
   
   class Node
   {  
      public Object data;
      public Node next;
      // public Node previous; // will convert to doubly
   }

   class LinkedListIterator implements ListIterator
   {  
      private Node position;
      private Node previous;
      private boolean isAfterNext;

      /**
         Constructs an iterator that points to the front
         of the linked list.
      */
      public LinkedListIterator()
      {  
         position = null;
         previous = null;
         isAfterNext = false;
      }
      
      /**
         Moves the iterator past the next element.
         @return the traversed element
      */
      public Object next()
      {  
         if (!hasNext()) { throw new NoSuchElementException(); }
         previous = position; // Remember for remove
         isAfterNext = true;

         if (position == null)
         {
            position = first;
         }
         else
         {
            position = position.next;
         }

         return position.data;
      }
      
      /**
         Tests if there is an element after the iterator position.
         @return true if there is an element after the iterator position
      */
      public boolean hasNext()
      {  
         if (position == null)
         {
            return first != null;
         }
         else
         {
            return position.next != null;
         }
      }
      
      /**
         Adds an element before the iterator position
         and moves the iterator past the inserted element.
         @param element the element to add
      */
      public void add(Object element)
      {  
         if (position == null)
         {
            addFirst(element);
            position = first;
         }
         else
         {  
            Node newNode = new Node();
            newNode.data = element;
            newNode.next = position.next;
            position.next = newNode;
            position = newNode;
         }

         isAfterNext = false;
      }
      
      /**
         Removes the last traversed element. This method may
         only be called after a call to the next() method.
      */
      public void remove()
      {  
         if (!isAfterNext) { throw new IllegalStateException(); }

         if (position == first)
         {
            removeFirst();
         }
         else 
         {  
            previous.next = position.next;
         }
         position = previous;
         isAfterNext = false;
      }

      /**
         Sets the last traversed element to a different value. 
         @param element the element to set
      */
      public void set(Object element)
      {
         if (!isAfterNext) { throw new IllegalStateException(); }
         position.data = element;
      }
   }
}