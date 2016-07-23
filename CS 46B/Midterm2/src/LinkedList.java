import java.util.NoSuchElementException;

/**
   An implementation of a doubly linked list.
*/
public class LinkedList
{  
   Node first;
   Node last;
   
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
      Returns a pointer for iterating through this list.
      @return a pointer for iterating through this list
   */
   public Pointer listPointer()
   {  
      return new Pointer();
   }
   
   class Node
   {  
      Object data;
      Node next;
      Node previous;
   }

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
      */
      public void next()
      {  
         if (position == null) { throw new NoSuchElementException(); }
         position = position.next;
      }
      
      /**
         Tests if there is an element after the pointer position.
         @return true if there is an element after the pointer position
      */
      public boolean hasNext()
      {  
         return position != null;
      }

      /**
         Moves the pointer before the previous element.
      */
      public void previous()
      {  
         if (position == first) { throw new NoSuchElementException(); }
         if (position == null) position = last;
         else position = position.previous;
      }
      
      /**
         Tests if there is an element before the pointer position.
         @return true if there is an element before the pointer position
      */
      public boolean hasPrevious()
      {  
         return position != first;
      }

      public Object get()
      {
         if (position == null) { throw new NoSuchElementException(); }
         return position.data;
      }
      
      /**
         Adds an element before the pointer position
         @param element the element to add
      */
      public void add(Object element)
      {  
         if (position == first)
         {
            addFirst(element);
         }
         else if (position == null)
         {
            addLast(element);
         }
         else
         {  
            Node newNode = new Node();
            newNode.data = element;
            newNode.next = position;
              newNode.next.previous = newNode;
            newNode.previous = position.previous;
            position.previous.next = newNode;
         }
      }

      public void remove()
      {  
         if (position == null) { throw new NoSuchElementException(); }
         if (position == first)
         {
            removeFirst();
            position = first;
         }
         else 
         {
            position.previous.next = position.next;
            if (position.next != null)
               position.next.previous = position.previous;
            position = position.next;
         }
      }

      /**
         Sets the pointer element to a different value. 
         @param element the element to set
      */
      public void set(Object element)
      {
         if (position == null) { throw new NoSuchElementException(); }
         position.data = element; 
      }
   }
}