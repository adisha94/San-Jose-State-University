import java.util.TreeSet;
import java.util.Comparator;
import java.util.NoSuchElementException;
import java.util.Stack;
import java.lang.Comparable;

public class BinaryExpressionTree implements Operator
{
	
	private BinaryExpressionNode root;
	TreeSet myTree;
	
	public BinaryExpressionTree()
	{
		root = null;
	}
	
	public BinaryExpressionTree( BinaryExpressionNode start )
	{
		root = start;
	}
	
	public BinaryExpressionTree(char c) 
	{
		root = new BinaryExpressionNode(c);
	}

	private String expression;
	
	public class BinaryExpressionNode implements Comparable<BinaryExpressionNode>
	{
		char data;
		BinaryExpressionNode left;
		BinaryExpressionNode right;
		
		BinaryExpressionNode(char ch, BinaryExpressionNode left, BinaryExpressionNode right)
		{
			this.data = ch;
			this.left = left;
			this.right = right;
		}

		@Override
		public String toString()
		{
			return (right == null && left == null) ? Character.toString(data) : "(" + left.toString() + data + right.toString() + ")";
		}
		
		public BinaryExpressionNode(char name) 
		{
			data = name;
		}

		@Override
		public int compareTo(BinaryExpressionNode o1) 
		{
			if (this.data > o1.data)
			{
				return 1;
			}
			else if (this.data < o1.data)
			{
				return -1;
			}
			return 0;
		}


	}
	
	
/**
 * Determines whether the input is an operator or not 
 * @return
 */
	public boolean isOperator(char c)
	{
		return c == '+' || c == '-' || c == '*' || c == '/';
	}	

	
	/**
	 * Creates an expression tree based on the postfix traversal.
	 * Postfix aka postorder traversal
	 * As this code was taken from a website please do make the necessary changes 
	 */
	public void createExpressionTree()
	{
		Stack<BinaryExpressionNode> children = new Stack<>();
		for (int i = 0; i < expression.length(); i++)
		{
			char ch = expression.charAt(i);
			if (isOperator(ch))
			{
				BinaryExpressionNode rightNode = children.pop();
				BinaryExpressionNode leftNode = children.pop();
				// push a subtree onto the stack for storage
				children.push(new BinaryExpressionNode(ch, leftNode, rightNode));
			}
			else
			{
				// add the operand into the stack
				children.add(new BinaryExpressionNode(ch, null, null));
			}
		}
		root = children.pop();
	}
	
	
	
	public String prefix()
	{
		if (root == null)
			throw new NoSuchElementException("Value is empty");
		StringBuilder prefix = new StringBuilder();
		preOrder(root, prefix);
		return prefix.toString();
	}
	
/**
 * 	
 * @param node: The node that is being effected by this expression
 * @param prefix
 */
	private void preOrder(BinaryExpressionNode node, StringBuilder prefix)
	{
		if (node != null)
		{
			prefix.append(node.data);
			preOrder(node.left, prefix);
			preOrder(node.right, prefix);
		}
	}
	
	/**
	 * Convert from postfix to infix traversal to get expression in the infix formation
	 */
	public void Postfix_Infix_Converstion()
	{
		
	}
	
	Stack<Object> mainStack;
	
	public void Algorithm3Postfix()
	{
		String postfix_Expression = "abc*de*f+g*+";
		char[] variableExpression = postfix_Expression.toCharArray();

		for (int i = 0; i < variableExpression.length; i++) // iterating through every character of the expression
		{
			if ( isOperator(variableExpression[i])) // three cheese trees x3s. free points right here
			{
				BinaryExpressionNode first = (BinaryExpressionNode) mainStack.pop();
				BinaryExpressionNode second = (BinaryExpressionNode) mainStack.pop();
				//
				BinaryExpressionTree T = new BinaryExpressionTree(variableExpression[i]);
				T.root.right = first;
				T.root.left = second;
				mainStack.push(T);
			}
			else
			{
				mainStack.push(new BinaryExpressionNode(variableExpression[i]));
			}
		}	
	}
}