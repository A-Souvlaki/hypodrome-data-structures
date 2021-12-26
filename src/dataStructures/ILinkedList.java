package dataStructures;


import dataStructures.Exception.ListException;
import dataStructures.GenericsClasses.Node;

public interface ILinkedList<T>{
	/**
	 * Add an element into the LinkedList
	 * @param Element The element to be added
	 * @throws LinkedListException if the element could not be added
	 * @throws ListException 
	 */
	void addElement(T Element)throws ListException;
	/**
	 * This element check if the linked list is empty
	 */
	boolean isEmpty();
	/**
	 * This method delete the element given as parameter
	 * @param Element The element to be deleted
	 */
	Node<T> deleteLast();
	/**
	 * This methods delete ALL the element in the linked list
	 */
	void deleteAll();
	/**
	 * This method returns the linked list size
	 * @return The size of the linked list
	 */
	int size();
	/**
	 * 
	 * @param n
	 * @return
	 * @throws NullPointerException
	 */
	T getElement(int n) throws NullPointerException;
	/**
	 * 
	 * @return
	 */
	Node<T>deleteWithoutRemove();
	/**
	 */
	void delete();
}
