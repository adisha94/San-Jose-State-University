
public class Onetime extends Appointment
{

	private int month;
	private int day;
	private int year;

	/**
	    * This method sends a appointment message for one time only.
	    * @param year
	    * @param month
	    * @param date
	    * @param description 
	    * @return
	    */
	   public Onetime(int year, int month, int day, String description)
	   {
		   this.day = day;
		   this.month = month;
		   this.year = year;
		   super.setDescription(description);
	   }
	   
		@Override
		public boolean occursOn(int year, int month, int day)
		{
			if ((this.year == year) && (this.month == month) && (this.day == day))
			{
				return true;
			}
			return false;
		}

	   
}
