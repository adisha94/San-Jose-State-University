import java.util.*;

public class PuzzleSolver
{ 
	private boolean isSolved = false;
   /**
      Returns all solutions to a puzzle.
      @param p a puzzle
      @return the list of solutions
   */
	private static ArrayList<Puzzle> resultingAnswers = new ArrayList<Puzzle>();
   public static ArrayList<Puzzle> solvePuzzle (Puzzle p)
   {
	   if (p.isSolved() == true)
	   {
		   resultingAnswers.add(p);
	   }
	   else
	   {
		   String letter = p.firstLetter();
		   if (letter.length() > 0)
		   {
			   ArrayList<Puzzle> answers = null;
			   for (int i = 0; i <= 9; i++)
			   {
				   Puzzle newPuzzle =  p.replace(letter, i);
				   answers = solvePuzzle(newPuzzle);
			   }
		   }
	   }
	   return resultingAnswers;
   }
   public static void mainStackQuese(String[] args)
   {
      Puzzle puzzle = new Puzzle(args[0], args[1], args[2]);
      Queue<Puzzle> q = new LinkedList<>();
      q.add(puzzle);
      ArrayList<Puzzle> solutions = new ArrayList<Puzzle>();
      while (!q.isEmpty())
      {
    	  Puzzle p = q.remove();
    	  if(p.isSolved()){
    		  solutions.add(p);
    	  }
    	  else
    	  {
    		  for(int i=0; i<10; i++)
    		  {
    			  if(!p.contains(i))
    			  {
    				  Puzzle newPuzzle = p.replace(p.firstLetter(), i);
    				  q.add(newPuzzle);
    			  }
    		  }
    	  }
      }
   }
   public static void main(String[] args) 
   {
      Scanner in = new Scanner(System.in);
//      String line = "3A6+36B=71C"; 
      String line = in.nextLine();
      int n1 = line.indexOf("+");
      int n2 = line.indexOf("=");
      Puzzle p = new Puzzle(
         line.substring(0, n1).trim(), 
         line.substring(n1 + 1, n2).trim(),
         line.substring(n2 + 1).trim());
      ArrayList<Puzzle> solutions = solvePuzzle(p);
      // Sorted so that the order in which the solutions were arrived
      // does not matter for testing
      Collections.sort(solutions,
         (p1, p2) -> p1.toString().compareTo(p2.toString()));
      System.out.println(solutions);
   }
}
