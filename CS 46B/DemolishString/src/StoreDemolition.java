public class StoreDemolition
{

   public int cost(String s)
   {
	   if(s.length() == 0) return 0;
	   if(s.length() == 1) return 0;
	   //
	   // getting cost from left side character
	   String letterLeft = s.substring(0,1);
	   String restLeft = s.substring(1);
	   int stepCostLeft = stepCost(letterLeft, restLeft);
	   if (stepCostLeft == 0)
	   {
//		   System.out.println("Left step cost: letter = " + letterLeft + ", restLeft = " + restLeft);
		   return stepCostLeft + cost(restLeft);
	   }
	   //
	   // getting costs from the right side character
	   String letterRight = s.substring(s.length() -1);
	   String restRight = s.substring(0, s.length() - 1);
	   int stepCostRight = stepCost(letterRight, restRight);	   
	   if (stepCostRight == 0)
	   {
//		   System.out.println("Right step cost: letter = " + letterRight + ", restRight = " + restRight);
		   return stepCostRight + cost(restRight);
	   }
	   if (stepCostLeft == stepCostRight)
	   {
//		   System.out.println("Right step is better: Left = " + stepCostLeft + " Right = " + stepCostRight + " letter = " + letterRight + " restRight = " + restRight);	   
		   int costRight =  stepCostRight + cost(restRight);
		   int costLeft =  stepCostLeft + cost(restLeft);
		   return (costRight > costLeft) ? costLeft : costRight;
	   }
	   if (stepCostLeft > stepCostRight)
	   {
//		   System.out.println("Right step is better: Left = " + stepCostLeft + " Right = " + stepCostRight + " letter = " + letterRight + " restRight = " + restRight);	   
		   return stepCostRight + cost(restRight);
	   }
//	   System.out.println("Left step is better: Left = " + stepCostLeft + ", Right = " + stepCostRight + " letter = " + letterLeft + " restLeft = " + restLeft);
	   return stepCostLeft + cost(restLeft);
   }

   public static int stepCost(String letter, String rest)
   {
      return "aeiou".contains(letter) ? 0 : rest.length();
   }

}