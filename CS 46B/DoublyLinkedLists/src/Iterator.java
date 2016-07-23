
public interface Iterator 
{
	/**
	 * Moves the iterator to the next element.
	 */
	void next();

	/**
	 * Gets the element at the iterator position.
	 * 
	 * @return the element
	 */
	Object get();

	/**
	 * Tests if the iterator is at the end of the list.
	 * 
	 * @return true if the iterator is at the end of the list.
	 */
	boolean atEnd();
	
	/**
	 * Adds an element before the iterator position.
	 * 
	 * @param element
	 *            the element to add
	 */
	void add(Object obj);

	/**
	 * Removes the element at the iterator position and moves the iterator to
	 * the next element.
	 */
	void remove();
 
}
