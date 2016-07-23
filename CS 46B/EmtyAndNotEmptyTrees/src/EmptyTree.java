public class EmptyTree implements LispTree
{
	public EmptyTree()
	{
	}
	// methods from LispTree interface
	@Override
	public boolean empty() 
	{
		return true;
	}

	@Override
	public Object data()
	{
		return null;
	}

	@Override
	public LispTree left() 
	{
		throw new UnsupportedOperationException();
	}

	@Override
	public LispTree right()
	{
		throw new UnsupportedOperationException();
	}
	
	@Override
	public int height()
	{
		
		return 0;
	}
	
	@Override
	public Object eval()
	{
		// TODO Auto-generated method stub
		return null;
	}

	public String toString()
	{
		return "NIL";
	}
}