package dataStructures;

import dataStructures.Exception.ListException;

public interface IStack<E> {
	/**
	 * This method check if the stack structure is empty
	 * 
	 * @return True if is empty, false if not
	 */
	public boolean isEmpty();

	/**
	 * Remove the top element in the stack
	 * 
	 * @return True if is successfully removed , false if not
	 */
	public E pop();

	/**
	 * Add an element into the top of the Stack data structure
	 * 
	 * @return True if is successfully added,False if is not
	 * @param Element the Element to be added into the data structure
	 * @throws ListException 
	 */
	public void push(E Element) throws ListException;

	/**
	 * Returns the top element from the stack but without changing the stack itself
	 * 
	 * @return The top element from the stack but it lefts the elements in the Stack
	 */
	public E top();
	
	public boolean isFull();
}
