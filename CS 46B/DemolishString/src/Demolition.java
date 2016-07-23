public class Demolition
{
   private int cost;
   private String description;
   private Demolition restDemolition;
   private String letter;
   private boolean leftSide;
   private String remaining;
   public Demolition(String s)
   {
     cost = 0;
	 description = s;	 
	 letter = "";
	 leftSide = false;
	 remaining = "";
  	 restDemolition = getNextStep(); 
  			 
   }
   private Demolition getNextStep()
   {
	   if(description.length() == 0) return null;
	   if(description.length() == 1) return null;
	   //
	   // getting cost from left side character
	   String letterLeft = description.substring(0,1);
	   String restLeft = description.substring(1);
	   int stepCostLeft = stepCost(letterLeft, restLeft);
	   
	   if (stepCostLeft == 0)
	   {		   
		   Demolition left = new Demolition(restLeft);
		   leftSide = true;
		   cost = stepCostLeft + left.getCost();
		   letter = letterLeft;
		   remaining = restLeft;
		   return left;
	   }
	   //
	   // getting costs from the right side character
	   String letterRight = description.substring(description.length() -1);
	   String restRight = description.substring(0, description.length() - 1);
	   int stepCostRight = stepCost(letterRight, restRight);	   
	   if (stepCostRight == 0)
	   {
		   Demolition right = new Demolition(restRight);
		   leftSide = false;
		   cost = stepCostRight + right.getCost();
		   letter = letterRight;
		   remaining = restRight;		   		   
		   return right;
	   }
	   
	   if (stepCostLeft == stepCostRight)	   
	   {
		   Demolition remainingLeft = new Demolition(restLeft);
		   Demolition remainingRight = new Demolition(restRight);
		   int costRight =  stepCostRight + remainingRight.getCost();
		   int costLeft =  stepCostLeft + remainingLeft.getCost();;		   
		   if (remainingRight.getCost() >= remainingLeft.getCost())
		   {
			   leftSide = true;
			   letter = letterLeft;
			   cost = costLeft;
			   remaining = restLeft;
			   return remainingLeft;
		   }
		   leftSide = false;
		   letter = letterRight;
		   cost = costRight;
		   remaining = restRight;
		   return remainingRight;
	   }
	   if (stepCostLeft > stepCostRight)
	   {	   
		   Demolition right = new Demolition(restRight);		   
		   cost = stepCostRight + right.getCost();
		   letter = letterRight;
		   leftSide = false;
		   remaining = restRight;
		   return right;
	   }
	   Demolition left = new Demolition(restLeft); 
	   cost = stepCostLeft + left.getCost();
	   letter = letterLeft;
	   leftSide = true;
	   remaining = restLeft;
	   return left;
   }
   public int getCost()
   {
      return cost;
   }

   public static int stepCost(String letter, String rest) 
   {
      return "aeiou".contains(letter) ? 0 : rest.length();
   }

   
   public String toString()
   {
      if (restDemolition == null)
      {
    	  	return description;
      }
      else
      {
    	  if (leftSide == true)
    	  {
        	  return letter + " " + remaining + " -> " + restDemolition.toString();    	      		  
    	  }
    	  else
    	  {
        	  return remaining + " " + letter + " -> " + restDemolition.toString();		  
    	  }
      }
   }
}
