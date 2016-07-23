public class StringBreaker
{
	private int cost;
	
	public StringBreaker()
	{
		cost = 0;
		
	}
   public static void main(String[] args)
   {
      System.out.println(cost(args[0]));      
   }

   public static int cost(String s)
   {
      if (s.length() <= 2)
      {
         
      }
      else
      {
         String first1 = s.substring(0, 1);
         String first2 = s.substring(0, 2);
         
         String rest1 = s.substring(1);
         String rest2 = s.substring(2);
         
         
      }
	return 0;
   }
   
   public int getCost()
   {
      return cost;
   }
}