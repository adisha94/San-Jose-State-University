import static org.junit.Assert.*;
import java.util.Random;
import org.junit.Test;


/**
 * @author Tuan
 *
 */

public class AVLTreeTest2
{

	@Test
	public void test() 
	{
		TreePrinter myTree = AVLTreeTest2.CreateSampleTree(35);
		// delete the root
		// print out the tree
		// while there is still a tree to print
		while(!myTree.isEmpty())
		{
			// delete the root
			myTree.deleteRoot();
			// print out the tree to verify balence
			myTree.PrintTree();
			// while there is still a tree to print
		}
		assertNull(myTree.root);
	}

	/**
	 * this methods helps to generate a sample tree for testing puropose
	 * @param numberOfNodes
	 * @return
	 */
	public static TreePrinter CreateSampleTree(int numberOfNodes)
			{
			/* Creating object of TreePrinter */
			TreePrinter avlt = new TreePrinter();
			System.out.println("AVLTree\n");
			int[] integers = new int[35];
			int nos = 0;
			boolean flag = false;
			Random rand = new Random();
			//
			// create and init tree with numberOfNodes
			for (int i = 0; i < numberOfNodes; i++)
			{
				int num = rand.nextInt(89) + 10;
				for (int j = 0; j <= nos; j++) // checking for duplication
				{
					if (integers[j] == num)
					{
						flag = true;
						break;
					}
				}

				if (flag == false)

				{
					avlt.insert(num);
					System.out.print("\nTree - after inserting " + num + ":");
					System.out.println();
					/* Display tree in In-order */
					avlt.inorder();
					nos++;
				}
			}
			return avlt;
}
}
