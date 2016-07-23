import java.util.ArrayList;


/**
 * 
 * @author Kevin Trinh
 * This is a hybrid of a LinkedList and a ArrayList so that we can work on the other stuff.
 * @param <T>: made this a generic list type
 */
public class HybridList<T>
{
	private Node root;
	private int maxElements;

	private class Node
	{
		Node next;
		int numElements;
		ArrayList<T> elements;
	}


	public HybridList(int maxElements)
	{
		if(maxElements < 1) maxElements = 1;
		this.maxElements = maxElements;
	}
	
	/**
	 * Searches for the element in the list.
	 * @param  element the element which is to be added.
	 * @return returns the index of the element if found, -1 if not.
	 */
	public T search(T element)
	{
		Node traverse = root;
		while(traverse.next != null)
		{
			for(int i=0; i<traverse.numElements; i++)
			{
				if(traverse.elements.get(i) == element)
					return traverse.elements.get(i);
			}
			traverse = traverse.next;
		}
		return null;
	}
	
	/**
	 * Adds an element to the list.
	 * @param  element the element which is to be added.
	 */
	public void add(T element)
	{
		if(root == null)
		{
			root = createNode();
			addToNode(root, element);
		}
		else
		{
			Node traverse = root;
			//This way, it will check whether the current node is FULL and if there is no next.
			//The method addToNode(Node node, T element) will properly handle both. It will
			//fill in the empty spaces.
			while(traverse.next != null && traverse.numElements >= maxElements)
			{
				traverse = traverse.next;
			}
			//This is the case if it is full and there is no next node.
			if(!addToNode(traverse, element)){
				traverse.next = createNode();
				addToNode(traverse.next, element);
			}
		}
	}
	
	private boolean addToNode(Node node, T element)
	{
		if(node.numElements < maxElements)
		{
			node.elements.add(element);
			node.numElements++;
			return true;
		}
		return false;
	}
	
	/**
	 * Creates a new node for the list
	 * @return
	 */
	private Node createNode()
	{
		Node r = new Node();
		r.elements = new ArrayList<T>();
		r.next = null;
		r.numElements = 0;
		return r;
	}
	
	/**
	 * Removes element from the list.
	 * @param  element the element that matches the one in the list.
	 */
	public void remove(T element)
	{
		Node traverse = root;
		boolean foundElement = false;
		while(traverse.next != null && !foundElement)
		{
			for(int i=0; i<traverse.numElements; i++)
			{
				if(traverse.elements.get(i) == element)
				{
					traverse.elements.remove(i);
					traverse.numElements--;
					foundElement = true;	//When we reach this point, we will stop iterating	
				}
			}
			traverse = traverse.next;
		}
	}
	
	/**
	 * Sorts the list
	 */
	public void sort()
	{

	}

}