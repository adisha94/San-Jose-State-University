//import java.util.Comparator;

public class Employee
{
	private String name;
	private double salary;
	private int seniority;
	private int employee_hash; // computed the hash for the class

	public Employee(String person)
	{
		this.name = person;
		salary = 0.00;
		seniority = 1;
		employee_hash = -1; // initialized with an invalid hashCode
	}

	
	public boolean equals(Employee rhs)
	{
		//  using the hashCode function instead of the employee name
		return (hashCode() == rhs.hashCode());
	}
	
	/**
	 * Each object has its own hashValue
	 * if hashCode not initialized
	 * 	we compute hashCode based on name 
	 * 		otherwise, we return the hash member employee_hash as is
	 */
	public int hashCode()
	{
		// check for uninitialized value
		if (employee_hash == -1)
		{
			employee_hash = name.hashCode();
			System.out.println("Calculating hash for " + name);
		}
		System.out.println("Returning hash for " + name + ": " + employee_hash);
		return employee_hash;
	}
	
	@Override
	public String toString()
	{
		return name;
	}
}