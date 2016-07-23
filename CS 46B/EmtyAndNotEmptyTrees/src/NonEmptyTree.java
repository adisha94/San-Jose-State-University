public class NonEmptyTree implements LispTree
{

	LispTree leftTree;
	LispTree rightTree;
	Object treeData;

	public NonEmptyTree(Object dataIn, LispTree leftIn, LispTree rightIn) 
	{
		treeData = dataIn;
		leftTree = leftIn;
		rightTree = rightIn;		
	}
	
	@Override
	public boolean empty()
	{
		return false;
	}

	@Override
	public Object data()
	{
		return treeData;
	}

	@Override
	public LispTree left()
	{
		return leftTree;
	}

	// helper function
	private static int HeightHelper(LispTree node)
	{
	    if(node.empty() == true)
	        return 0;
	    else
	    {	    	
	        return 1 + Math.max(HeightHelper(node.left()), HeightHelper(node.right()));
	    }
	}
	
	@Override
	public LispTree right()
	{
		return rightTree;
	}
	
	@Override
	public int height()
	{
		return HeightHelper(this);
		
	}

	 /** function to check if operator **/
    private boolean isOperator(String ch)
    {
        return ch == "+" || ch == "-" || ch == "*" || ch == "/" || ch == "%";
    }
    
    
	   /** function to convert character to digit **/
    private int toInteger (String str)
    {
        return Integer.parseInt(str);
    }
    
    /** helper function for evaluate
     * @throws Exception */
    private int evaluateExpression(LispTree ptr)
    {
    	// test for exceptions
        if (ptr.left().empty() == true && ptr.right().empty() == true)
            return toInteger(ptr.data().toString());
        else
        {
            int result = 0;
            int leftInt = evaluateExpression(ptr.left());
            int rightInt = evaluateExpression(ptr.right());
            String operator = ptr.data().toString();
            if (isOperator(operator) == false)
            {
            	throw new UnsupportedOperationException();
            }
            else
            {
                switch (operator)
                {
                	case "+": result = leftInt + rightInt; break;
                	case "-" : result = leftInt - rightInt; break;
                	case "*" : result = leftInt * rightInt; break;
                	case "/" : result = leftInt / rightInt; break;
                	case "%" : result = leftInt % rightInt; break;
                	default  : result = leftInt + rightInt; break;
                }
            }
            return result;
        }
    }
	
	
	@Override
	public Object eval()
	{
		return evaluateExpression(this);
	}
	

	@Override
	public String toString()
	{
		if( (left().empty() == true ) && (right().empty() == true))
			return "t(" + treeData.toString() + ")";
		return "t(" + treeData.toString() + ", " + left().toString() + ", " + right().toString() + ")";
	}
}