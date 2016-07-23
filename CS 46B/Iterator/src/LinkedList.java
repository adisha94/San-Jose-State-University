import java.util.NoSuchElementException;

/**
   An implementation of a doubly linked list.
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
   
   /**
      Returns an iterator for iterating through this list.
      @return an iterator for iterating through this list
   */
   public Iterator iterator()
   {  
      return new LinkedListIterator();
   }
   
   class Node
   {  
      public Object data;
      public Node next;
      public Node previous;
   }

   class LinkedListIterator implements Iterator
   {  
      private Node position;

      /**
         Constructs an iterator that points to the front
         of the linked list.
      */
      public LinkedListIterator()
      {  
         position = first;
      }
      
      /**
         Moves the iterator to the next element.
      */
      public void next()
      {  
         ...
      }

      /**
         Gets the element at the iterator position.
         @return the element
      */
      public Object get()
      {  
         ...
      }
      
      /**
         Tests if the iterator is at the end of the list.
         @return true if the iterator is at the end of the list.
      */
      public boolean hasNext()
      {  
         ...
      }
   }
}
