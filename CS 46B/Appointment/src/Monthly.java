
public class Monthly extends Appointment
{
	private int day;
	
	/**
	 * This method returns a monthly notification
	 * @param month
	 * @param description
	 */
	public Monthly(int day, String description)
	{
		this.day = day;
		super.setDescription(description);
	}
	
	@Override
	public boolean occursOn(int year, int month, int day)
	{
		if (this.day == day)
		{
			return true;
		}
		return false;
	}
	
}