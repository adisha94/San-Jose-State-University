public class Puzzle 
{
   private String add1;
   private String add2;
   private String result;

   /**
      Constructs a puzzle.
      @param add1 a string containing digits 0 - 9 and letters
      @param add2 a string containing digits 0 - 9 and letters
      @param result a string containing digits 0 - 9 and letters
   */
   public Puzzle(String add1, String add2, String result) 
   {
      this.add1 = add1;
      this.add2 = add2;
      this.result = result;
   }
   
   /**
      Makes a new puzzle by replacing a letter with a digit.
      @param letter the letter to be replaced
      @param digit the digit to replace it with
      @return the new puzzle
   */
   public Puzzle replace(String letter, int digit)
   {
	  String newAdd1 = add1.replace(letter, String.valueOf( Character.forDigit(digit, 10) ) );
	  String newAdd2 = add2.replace(letter, String.valueOf( Character.forDigit(digit, 10) ) );
	  String newResult = result.replace(letter, String.valueOf( Character.forDigit(digit, 10) ) );
	  Puzzle newPuzzle = new Puzzle(newAdd1, newAdd2, newResult);
		   
      return newPuzzle;
   }

   /**
      Gets the first letter in this puzzle.
      @return the first letter, or "" if there are no letters.
   */
   public String firstLetter()
   {
	   for (int index1 = 0; index1 < add1.length(); index1++)
	   {
		   if ( Character.isDigit(add1.charAt(index1)) == false) 
		   {			   			   
			   return String.valueOf(add1.charAt(index1));			   
		   }
	   }
	   for (int index2 = 0; index2 < add2.length(); index2++)
	   {
		   if ( Character.isDigit(add2.charAt(index2)) == false) 
		   {			   			   
			   return String.valueOf(add2.charAt(index2));			   
		   }
	   }
	   for (int index3 = 0; index3 < result.length(); index3++)
	   {
		   if ( Character.isDigit(result.charAt(index3)) == false) 
		   {			   			   
			   return String.valueOf(result.charAt(index3));			   
		   }
	   }
	   return "";
   }

   /**
      Returns true if the puzzle is solved.
      @return true if the puzzle has no letters, no number starts
      with zero, and the first two numbers add up to the third
   */
   public boolean isSolved()
   {
	  try
	  {
	      if (Integer.parseInt(add1) + Integer.parseInt(add2) == Integer.parseInt(result))
	      {
	    	  return true;
	      }
	      
	      return false;	      
	  }
	  catch (NumberFormatException e)
	  {
		  return false;
	  }      
   }

   /**
      Checks whether this puzzle contains a given digit.
      @param digit a digit
      @return true if this puzzle returns digit
   */
   public boolean contains(int digit)
   {
	   // check all three string for the digit	   
	   // checking first string
	   if (add1.contains( String.valueOf(Character.forDigit(digit, 10) )  ) == true)		   
		   return true;	   
	   
	   if (add2.contains( String.valueOf(Character.forDigit(digit, 10) )  ) == true)
		   return true;
	   
	   if (result.contains( String.valueOf(Character.forDigit(digit, 10) )  ) == true)
		   return true;
	   
	   return false;
   }
   
   /**
    * Converts the result into a string represented
    *  format for the Puzzle object.
    */
   public String toString()
   {
      return add1 + "+" + add2 + "=" + result;
   }    
}