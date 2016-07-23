import java.lang.*;
import java.util.*;

public class ThreaddedBinaryTree<AnyType extends Comparable <? super AnyType>> 
{
	private Node root;
	
	public ThreaddedBinaryTree()
	{
		root = null;
	}
	/**
	 * This is an updated version of the Node class
	 * @author Adish
	 *
	 */
	class Node<AnyType>
	{
		AnyType data;
		Node left;
		boolean leftFlag = false; // initial is null
		Node right;
		boolean rightFlag = false; // initial is null

		public Node()
		{
			this(null,  null, null, false, false);
		}
		
		public Node(AnyType value, Node leftChild, Node rightChild, boolean leftSideFlag, boolean rightSideFlag)
		{
			this.data = value;
			this.left = leftChild;
			this.leftFlag = leftSideFlag;
			this.right = rightChild;
			this.rightFlag = rightSideFlag;
		}
	}
	
	
	
	public Node<AnyType> insert(AnyType value, Node<AnyType> t)
	{
		int compareResult = value.compareTo(t.data);
		if (t == null)
		{
			Node newNode = new Node<AnyType>(value, null, null, true, true);
			if (compareResult < 0)
			{
			}
			return newNode;
		}
		
		
		if (compareResult < 0)
			t.left = insert(value, t.left);
		else if (compareResult > 0)
			t.right = insert(value, t.right);
		else 
			; // the value is the same so we do not do anything
		return t;
	}
	
}