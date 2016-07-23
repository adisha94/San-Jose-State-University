public class Daily extends Appointment
{
	/**
	 * returns a daily appointment notification
	 * @param description
	 */
	public Daily(String description)
	{
		super.setDescription(description);
	}
	
	@Override
	public boolean occursOn(int year, int month, int day)
	{
		return true;
	}
		
}
