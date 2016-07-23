
/**
 * This is the tower of hanoi implementation
 * @author Adish Betawar
 *
 */

public class TowersOfHanoi 
{
	public void solve(int numberOfDisks, String initial, String spare, String dest) 
	{
		if (numberOfDisks == 1) 
		{
			// base case
			// Move the disc from start pole to dest pole
			System.out.println(initial + " -> " + dest);
		}
		else
		{
			// Step 1: Move (numberOfDisks-1) discs from start pole to spare pole.
			solve(numberOfDisks - 1, initial, dest, spare);
			System.out.println(initial + " -> " + dest);
			// Step 2: Move the last disc from start pole to dest pole.
			// Step 3: Move the (numberOfDisks-1) discs from spare pole to dest
			// pole.
			solve(numberOfDisks - 1, spare, initial, dest);

			// Steps 1 and 3 are recursive steps
		}
	}
}