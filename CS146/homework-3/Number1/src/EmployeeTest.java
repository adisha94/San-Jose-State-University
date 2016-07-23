import static org.junit.Assert.*;
import java.util.*;
import org.junit.Test;

public class EmployeeTest 
{
	@Test
	public void test() 
	{		

	SeperateChainHashMap<Employee> map = new SeperateChainHashMap<Employee>(); // constructing the table
	// insserting into table
		map.insert(new Employee("Adish"));
		map.insert(new Employee("Hammad"));
		map.insert(new Employee("Tuan"));
		map.insert(new Employee("Kevin"));
		map.insert(new Employee("Bob"));
		map.PrintMap(); // printing out list
		System.out.println();
		System.out.println();
		
		map.rehash(); // performing rehashing
		map.PrintMap(); // reprinting the table
		System.out.println();
		System.out.println();		
	}	
}