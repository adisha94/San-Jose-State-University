import java.util.*;

/**
 * @author Adish
 *
 */
public class EightQueensPartialSolution implements PartialSolution 
{
	public final int ABANDON = -1;
	public final int CONTINUE = -2;
	public final int NQUEENS = 8;
	public final int ACCEPT= 1;
	private Queen[] queens;
	
	@Override
	public int examine() 
	{
		for (int i = 0; i < queens.length; i++) 
		{
			for (int j = i + 1; j < queens.length; j++) 
			{
				if (queens[i].attacks(queens[j]))
				{
					return ABANDON;
				} 
			}
		}
			if (queens.length == NQUEENS)
			{
				return ACCEPT;
			}
			else
			{
				return CONTINUE;
			}
	}

	@Override
	public PartialSolution[] extend() 
	{
		// Generate a new solution for each column
		PartialSolution[] result = new PartialSolution[NQUEENS];
		for (int i = 0; i < result.length; i++)
		{
			int size = queens.length;
			// The new solution has one more row than this one
			// Copy this solution into the new one
			for (int j = 0; j < size; j++)
			{
//				result[i].queens[j] = queens[j]; 
			}
				// Append the new queen into the ith column
//				result[i].queens[size] = new Queen(size, i); 
		}
		return result;	
		}
	
	@Override
	public String solve() 
	{
		// TODO Auto-generated method stub
		return null;
	}

}