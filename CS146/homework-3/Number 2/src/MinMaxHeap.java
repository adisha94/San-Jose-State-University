
/**
 * This structure is identitcal to a Binary Heap 
 * but the Heap order property for any node at an even depth,
 * the element that is stored is less than the parent but larger than the grandparent
 * and for any node at an odd depth
 * is larger than the parent but smaller than the grandparent
 * @author Adish
 *
 */
public class MinMaxHeap<Anytype extends Comparable <? super Anytype>> 
{
	/**
	 * private variables
	 */
	private int currentSize;
	private Anytype[] array;
	private static final int DEFAULT_CAPACITY = 10; // constant for the max size of a Heap
//	public Node root;
	
	class Node
	{
		Anytype data;
//		int level;
		Node right;
		Node left;
		
		public Node()
		{
			data = null; 
			left = null; 
			right = null;
		}
		
		public Node(Anytype n)
		{
			data = n;
			right = left = null; // in line initialization
		}
	}
	
	/**
	 * Default constructor
	 */
	public MinMaxHeap()
	{
		this (DEFAULT_CAPACITY);
	}
	
	
    /**
     * Construct the binary heap given an array of items.
     */
    public MinMaxHeap( Anytype [ ] items )
    {
            currentSize = items.length;
            array = (Anytype[]) new Comparable[ ( currentSize + 2 ) * 11 / 10 ];

            int i = 1;
            for( Anytype item : items )
                array[ i++ ] = item;
            buildHeap( );
    }
    
	/**
	 * Paramatized
	 * @param capacity
	 */
	public MinMaxHeap(int capacity)
	{
       currentSize = 0;
       array = (Anytype[]) new Comparable[ capacity + 1 ];		
	}
//	
//	public MinMaxHeap(Anytype[] items)
//	{
//		currentSize = items.length;
//		array = (Anytype[]) new Comparable[ ( currentSize + 2 ) * 11 / 10];
//		
//		int i = 1;
//		for(Anytype item : items )
//		{
//			array[ i++ ] = item;
//		}
//		buildHeap();
//	}
	
	
	public void insert(Anytype x)
	{
		if (currentSize == array.length - 1)
			enlargeArray(array.length * 2 + 1);
		
		// percolating upwards
		
		int hole = ++currentSize;	
		for(array[0] = x; x.compareTo( array[ hole / 2 ] ) < 0; hole /= 2)
		{
			array[hole] = array[hole / 2];
		}
		array[hole] = x;
	}
	
	private void enlargeArray(int newSize)
	{
        Anytype [] old = array;
        array = (Anytype []) new Comparable[ newSize ];
        for( int i = 0; i < old.length; i++ )
            array[ i ] = old[ i ];        		
	}

	public Anytype deleteMin()
	{
		if (isEmpty())
			return null;
		
		Anytype minItem = findMin();
		array[1] = array[currentSize--];
        percolateDown( 1 );
		return minItem;
	}
	
	public Anytype findMin()
	{
        if( isEmpty( ) )
//          throw new UnderflowException( );
      	return null;
      return array[ 1 ];	
    }
	
//	private Anytype findMax()
//	{
//		return null;
//	}

	public boolean isEmpty()
	{
        return currentSize == 0;
	}
	
	private void makeEmpty()
	{
		
	}
	
	private void percolateDown(int hole)
	{
		int child;
		Anytype temp = array[hole];
		
		for( ; hole * 2 <= currentSize; hole = child)
		{
			child = hole * 2;
			if (child != currentSize && array[child + 1].compareTo(array[child]) < 0)
					child++;
			if (array[child].compareTo(temp) < 0)
				array[hole] = array[child];
			else
				break;
		}
		array[hole] = temp;
	}
	
	private void buildHeap()
	{
		for (int i = currentSize / 2; i > 0; i--)
			percolateDown(i);
	}
	
	/**
	 * Need to edit later
	 * @param targetNode
	 * @return
	 */
//	public int height(Anytype targetNode)
//	{
//		// check the target Node location
//		if(targetNode == null)
//			return 0;
//		
////		int leftHeight = height(targetNode.left);
////		int rightHeight = height(targetNode.right);
//		
//		if(leftHeight >= rightHeight)
//		{
//			return leftHeight + 1;
//		}
//		return rightHeight + 1;
//	}

    public static void main( String [ ] args )
    {
        int numItems = 20;
        MinMaxHeap<Integer> h = new MinMaxHeap<>( );
        int i = 37;

        for( i = 37; i != 0; i = ( i + 37 ) % numItems )
            h.insert( i );
//        for( i = 1; i < numItems; i++ )
//        {
//        	int x = h.deleteMin();
//        	if( x != i )
//        		System.out.println( "Oops! " + i );
//        	else
//        		System.out.println(x);        		
//        }
        h.print();
    }
    
    public void print()
    {
        for (int i = 1; i <= currentSize / 2; i++ )
        {
            System.out.print(" PARENT : " + array[i] + " LEFT CHILD : " + array[2*i]
                  + " RIGHT CHILD : " + array[2 * i  + 1]);
            System.out.println();
        }
    }
}
