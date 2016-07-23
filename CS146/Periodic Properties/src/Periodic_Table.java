import java.util.Comparator;
import java.util.Stack;
/**
 * @author Adish
 *
 */
public class Periodic_Table
{
	// global required but still in thought
	int GROUP = 0;
	int PERIOD = 0;
	Element[][] periodic_Table; // case statement somewhere for group classification required
	
	
	//Specific GROUP or PERIOD names
	Element[] Alkali_metals;
	Element[] Alkaline_metals;
	Element[] Transition_metals;
	Element[] Halogens;
	Element[] Lanthanides;
	Element[] Actinides;
	
	
	private class Element extends Periodic_Table implements Comparator<Element> 
	{
		String name; // long form of the name of an element
		String chemical_Symbol; // chemical symbol of atomic element
		
		int atomic_Number; // number of protons in atom
		Stack<String> known_Isotopes;
		float atomic_Mass;
		// LinkedList like implementation
//		Element next_Element;
//		Element previous_Element;
		
		
		
		
		/**
		 * 
		 * @return name
		 */
		String get_Name()
		{
			return name;
		}
		
		/** @return chemical symbol **/
		String get_Chemical_Symbol(String name)
		{
			return chemical_Symbol;
		}
		
		/** @return atomic number**/		
		int get_Atomic_Number()
		{
			return atomic_Number;
		}
		
		
		/**
		 * Sorts the stack when we add in the isotopes
		 * @param s
		 */
		void sortStack(Stack<String> s)
		{
			if(!known_Isotopes.isEmpty())
			{
				String temp = s.pop();
				sortStack(s);
				sortedInsert(temp);
			}
		}

		/**
		 * Helper method for when we insert isotopes of an element into the Stack 
		 * @param element_Isotope: the element isotope that you are looking at
		 * @param isotope_Number: the number as extracted by the element name
		 * 
		 * 
		 * 
		 * CARBON-12
		 * CARBON-14
		 * URANIUM-228
		 */
		void sortedInsert(String element_Isotope)
		{
			int isotope_Number = find_IsotopeNumber(element_Isotope);
			if (known_Isotopes.isEmpty() || element_Isotope.compareTo(known_Isotopes.pop()) > 0)
			{
				known_Isotopes.push(element_Isotope);
			}
		}		
		
		/**
		 * Finds the isotope of an element in the name of the isotope such as Carbon-12, or URANIUM-238
		 * @param element_Isotope
		 * @return the number of the isotope
		 */
		private int find_IsotopeNumber(String element_Isotope) 
		{
			String truncated_Name = element_Isotope.substring(element_Isotope.indexOf('-') + 1);
			System.out.println("in method Result: " + truncated_Name);
			int result = Integer.parseInt(truncated_Name);
			return result;
		}

		@Override
		public int compare(Element e1, Element e2)
		{
			if (e1.atomic_Number > e2.atomic_Number)
			{
				return 1;
			}
			else if (e1.atomic_Number < e2.atomic_Number)
			{
				return -1;
			}
			else
				return 0;
		}
		
		
		
		
	}
	
	// implement sort by atomic number
	// when you sort, you sort one group and group them into 
	
	/**
	 * The entire  periodic table will consist of all elements consolidated into their groups. This will make the concept easier.
	 * We should be able to access all elements via stack, hybridLinkedList. WHat will end up happenng in the ultimate goal is that we should be able to  
	 */
	
	
	public Element get_Element_From_Group(int group_Number)
	{
		return null;
	}
	
	public Element get_Element_From_Period(int period_Number)
	{
		return null;
	}
	
	
	
	/**
	 * Stores a new elemenet into the periodic table;
	 * @return
	 */
	public Element Insert_New_Element()
	{
		return null;
	}
	
}