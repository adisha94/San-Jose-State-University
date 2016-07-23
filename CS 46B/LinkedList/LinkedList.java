import java.util.NoSuchElementException;
import java.util.*;

/**
   A linked list is a sequence of nodes with efficient
   element insertion and removal. This class 
   contains a subset of the methods of the standard
   java.util.LinkedList class.
*/
public class LinkedList
{  
   Node first;
   
   /** 
      Constructs an empty linked list.
   */
   public LinkedList()
   {  
      first = null;
   }

   /**
      Reverses the first n elements in a linked list.
      @param the number of elements to be reversed.
      If it is bigger than the length of the linked list,
      the whole list will be reversed.
   */
   public void reverseFirstN(int n)
   { 
	   // next - Tracks the pointer to the next item in the list.
	   // head - Initially contains the original head of the list but will then be set to 
	   //        the pointer to the next item in the list until the NULL pointer is encountered.
	   // cursor - Initially is set to NULL but then tracks the new head of the list. 
	   //          At the end of the list, head equals NULL and the value of cursor is returned to the caller.
	   
	   Node cursor = null;
	   Node head = this.first;
	   int nodeCount = 0;
	   while(head != null) // iteratiing through the list
	   {
		   if(nodeCount == (n+1))
			   break;
		   nodeCount++;
		   cursor = head; // moves one up
		   head = head.next; // moves one up
	   }
	   head = this.first;
	   Node next = null;
	   while(head != null) // swapping all desired entries
	   {
		   nodeCount--;
		   if(nodeCount == 0)
			   break;
		   
		   // initiating swap for desired entries
		   next = head.next;
		   head.next = cursor;
		   cursor = head;
		   head = next;
	   }
	   this.first = cursor;
   }

   
   /**
    * iterative approach to finding size of LinkedList
    * @return
    */
   public int size1()
   {
		Node start = this.first;
		int length = 0;
		while(start != null)
		{
			length++;
			start = start.next;
		}
		return length;
   }

   /**
    * recursive approach to finding size of LinkedList
    * @return
    */
   public int size2()
   {
	   int size = sizeHelper(first);
	   return size;
   }
   
   private int currentSize = 0;
   
   /**
    * helper method for helping to calculate the size of the LinkedList using recursion.
    * @param start
    * @return
    */
   private static int sizeHelper(Node start)
   {
	   int size;
	   if (start == null)
	   {
		   size = 0;
	   }
	   else
	   {
		   size = 1 + sizeHelper(start.next);
	   }
	   return size;
   }
   
   /**
    * recursive approach to finding size of LinkedList
    * @return
    */
   public int size3()
   {
	   return currentSize;
   }
   
   /**
      Returns the first element in the linked list.
      @return the first element in the linked list
   */
   public Object getFirst()
   {  
      if (first == null) 
         throw new NoSuchElementException();
      return first.data;
   }

   /**
      Removes the first element in the linked list.
      @return the removed element
   */
   public Object removeFirst()
   {  
      if (first == null) 
         throw new NoSuchElementException();
      Object element = first.data;
      first = first.next;
      currentSize--;
      if(currentSize < 0)
    	  currentSize = 0;
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
      currentSize++;
   }
   
   /**
      Returns an iterator for iterating through this list.
      @return an iterator for iterating through this list
   */
   public ListIterator listIterator()
   {  
      return new LinkedList.LinkedListIterator();
   }
   
   class Node
   {  
      public Object data;
      public Node next;
   }

   private class LinkedListIterator implements ListIterator
   {              
      Node position;
      Node previous;

      /**
         Constructs an iterator that points to the front
         of the linked list.
      */
      public LinkedListIterator()
      {  
         position = null;
         previous = null;
      }
      
      /**
         Moves the iterator past the next element.
         @return the traversed element
      */
      public Object next()
      {  
         if (!hasNext())
            throw new NoSuchElementException();
         previous = position; // Remember for remove

         if (position == null)
            position = first;
         else
            position = position.next;

         return position.data;
      }
      
      /**
         Tests if there is an element after the iterator 
         position.
         @return true if there is an element after the iterator 
         position
      */
      public boolean hasNext()
      {  
         if (position == null)
            return first != null;
         else
            return position.next != null;
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
            currentSize++;
         }
         previous = position;
      }
      
      /**
         Removes the last traversed element. This method may
         only be called after a call to the next() method.
      */
      public void remove()
      {  
         if (previous == position)
            throw new IllegalStateException();

         if (position == first)
         {
            removeFirst();
         }
         else 
         {  
            previous.next = position.next;
            currentSize--;
         }
         position = previous;
      }

      /**
         Sets the last traversed element to a different 
         value. 
         @param element the element to set
      */
      public void set(Object element)
      {
         if (position == null)
            throw new NoSuchElementException();
         position.data = element;
      }
   }
}