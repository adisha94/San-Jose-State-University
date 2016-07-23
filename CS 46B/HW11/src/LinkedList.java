import java.util.NoSuchElementException;

/**
   An implementation of a doubly linked list.
*/
public class LinkedList
{  
   Node first = null; // first location
   Node last = null; // last location
   
   /**
    * This class acts like a "pointer", or itereator for linkedlists
    *
    */
   class Pointer
   {  
      Node position;

      /**
         Constructs a pointer that points to the front
         of the linked list.
      */
      public Pointer()
      {  
         position = first;
      }
      
      /**
         Moves the pointer to the next element.
         @throws NoSuchElementException when the pointer is at
         the past-the-end position.
      */
      public void next()
      {
    	  if (position == null)
    	  {
    		  position = first;
    	  }
    	  else
    	  {
    		  position = position.next;
    	  }
      }
      
      /**
         Tests if one can call next on the pointer.
         @return true if there is an element or the past-the-end position
         after the pointer position
      */
      public boolean hasNext()
      {    	  
    	  return (position != null) ? true : false;
      }

      /**
         Gets the object at the pointer.
         @throws NoSuchElementException when the pointer is at
         the past-the-end position.
      */
      public Object get()
      {
    	 if (position == null)
    	 {
    		 return new NoSuchElementException();
    	 }
         return position.data;
      }
      
      /**
         Sets the pointer element to a different value. 
         @param element the element to set
         @throws NoSuchElementException when the pointer is at
         the past-the-end position.
      */
      public void set(Object element)
      {
    	  if (position == null)
    	  {
    		  throw new NoSuchElementException();
    	  }
    	  position.data = element;
      }

      /**
         Moves the pointer before the previous element.
         @throws NoSuchElementException when trying to move before the
         first element
      */
      public void previous()
      {  
    	  if (position == null)
    	  {
    		  position = last;
    	  }
    	  else
    	  {
    		  position = position.previous;
    	  }
      }
      
      /**
         Tests if there is an element before the pointer position.
         @return true if there is an element before the pointer position
      */
      public boolean hasPrevious()
      {  
    	  return ((position != null) && (position.previous != null)) ? true : false;
      }

      /**
         Adds an element before the pointer position
         @param element the element to add
      */
      public void add(Object element)
      {  
          Node newNode = new Node();
          newNode.data = element;
          newNode.next = position;
          if (position == null)
          {
        	  addLast(element);
          }
          else if (position.previous == null)
          {
        	  // first node
        	  newNode.previous = null;
        	  position.previous = newNode;
        	  first = newNode;
          }
          else
          {
        	  newNode.previous = position.previous;
        	  position.previous = newNode;
        	  newNode.previous.next = newNode; 
          }
      }
      
      /**
         Removes the element at the pointer and moves the pointer
         to the next element.
         @throws NoSuchElementException when the pointer is at
         the past-the-end position.
      */
      public void remove()
      {      	  
    	  if ((position.previous != null) && (position.next != null))
    	  {
    		  // normal case
    		  position.previous.next = position.next;    		  
    		  position.next.previous = position.previous;
    	  }
    	  else if (position.previous == null)
    	  {
    		  // first node
    		  position.next.previous = null;
    		  Node newPosition = position.next;    		  
    		  position.next = null; // making the position node free for garbage collector
    		  position = newPosition;
    		  first = newPosition;
    	  }
    	  else
    	  {
    		  // last node
    		  position.previous.next= null;
    		  Node newPosition = position.previous;    		  
    		  position.previous = null; // making the position node free for garbage collector
    		  position = newPosition;
    		  last = newPosition;
    	  }
    	  
    	  
      }
   }
   /**
    * ...
    *
    */
   class Node
   {  
      Object data;
      Node next;
      Node previous;
   }

   /** 
      Constructs an empty linked list.
   */
   public LinkedList()
   {  
      first = null;
      last = null;
   }
   
   /**
      Returns a pointer for iterating through this list.
      @return a pointer for iterating through this list
   */
   public Pointer listPointer()
   {  
      return new Pointer();
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

   /**
      Removes the first element in the linked list.
      @return the removed element
   */
   public Object removeFirst()
   {  
      if (first == null) { throw new NoSuchElementException(); }
      Object element = first.data;
      first = first.next;
      if (first == null) { last = null; } // List is now empty
      else { first.previous = null; }
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
      newNode.previous = null;
      if (first == null) { last = newNode; }
      else { first.previous = newNode; }
      first = newNode;
   }
   
   /**
      Returns the last element in the linked list.
      @return the last element in the linked list
   */
   public Object getLast()
   {  
      if (last == null) { throw new NoSuchElementException(); }
      return last.data;
   }

   /**
      Removes the last element in the linked list.
      @return the removed element
   */
   public Object removeLast()
   {  
      if (last == null) { throw new NoSuchElementException(); }
      Object element = last.data;
      last = last.previous;
      if (last == null) { first = null; } // List is now empty
      else { last.next = null; }
      return element;
   }

   /**
      Adds an element to the back of the linked list.
      @param element the element to add
   */
   public void addLast(Object element)
   {  
      Node newNode = new Node();
      newNode.data = element;
      newNode.next = null;
      newNode.previous = last;
      if (last == null) { first = newNode; }
      else { last.next = newNode; }
      last = newNode;
   }
}